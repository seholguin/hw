package eu.nimble.service.bp.impl;

import eu.nimble.service.bp.hyperjaxb.model.DocumentType;
import eu.nimble.service.bp.hyperjaxb.model.ProcessInstanceDAO;
import eu.nimble.service.bp.hyperjaxb.model.ProcessInstanceStatus;
import eu.nimble.service.bp.impl.model.dashboard.DashboardProcessInstanceDetails;
import eu.nimble.service.bp.impl.util.camunda.CamundaEngine;
import eu.nimble.service.bp.impl.util.persistence.bp.HibernateSwaggerObjectMapper;
import eu.nimble.service.bp.impl.util.persistence.bp.ProcessDocumentMetadataDAOUtility;
import eu.nimble.service.bp.impl.util.persistence.bp.ProcessInstanceDAOUtility;
import eu.nimble.service.bp.impl.util.persistence.catalogue.DocumentPersistenceUtility;
import eu.nimble.service.bp.impl.util.persistence.catalogue.TrustPersistenceUtility;
import eu.nimble.service.bp.impl.util.spring.SpringBridge;
import eu.nimble.service.bp.processor.BusinessProcessContext;
import eu.nimble.service.bp.processor.BusinessProcessContextHandler;
import eu.nimble.service.bp.swagger.model.ProcessDocumentMetadata;
import eu.nimble.service.model.ubl.commonaggregatecomponents.CompletedTaskType;
import eu.nimble.service.model.ubl.commonaggregatecomponents.PersonType;
import eu.nimble.utility.Configuration;
import eu.nimble.utility.HttpResponseUtil;
import eu.nimble.utility.JsonSerializationUtility;
import eu.nimble.utility.persistence.JPARepositoryFactory;
import eu.nimble.utility.persistence.resource.ResourceValidationUtility;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.logging.LogLevel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dogukan on 09.08.2018.
 */

@Controller
public class ProcessInstanceController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ResourceValidationUtility resourceValidationUtil;

    @ApiOperation(value = "",notes = "Cancels the process instance with the given id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Cancelled the process instance successfully"),
            @ApiResponse(code = 401, message = "Invalid token. No user was found for the provided token"),
            @ApiResponse(code = 404, message = "There does not exist a process instance with the given id"),
            @ApiResponse(code = 500, message = "Unexpected error while cancelling the process instance with the given id")
    })
    @RequestMapping(value = "/processInstance/{processInstanceId}/cancel",
            method = RequestMethod.POST)
    public ResponseEntity cancelProcessInstance(@ApiParam(value = "The identifier of the process instance to be cancelled", required = true) @PathVariable(value = "processInstanceId", required = true) String processInstanceId,
                                                @ApiParam(value = "The Bearer token provided by the identity service" ,required=true ) @RequestHeader(value="Authorization", required=true) String bearerToken) {
        logger.debug("Cancelling process instance with id: {}",processInstanceId);

        try {
            // check token
            ResponseEntity tokenCheck = eu.nimble.service.bp.impl.util.HttpResponseUtil.checkToken(bearerToken);
            if (tokenCheck != null) {
                return tokenCheck;
            }

            ProcessInstanceDAO instanceDAO = ProcessInstanceDAOUtility.getById(processInstanceId);
            // check whether the process instance with the given id exists or not
            if(instanceDAO == null){
                logger.error("There does not exist a process instance with id:{}",processInstanceId);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There does not exist a process instance with the given id");
            }
            // cancel the process
            CamundaEngine.cancelProcessInstance(processInstanceId);
            // change status of the process
            instanceDAO.setStatus(ProcessInstanceStatus.CANCELLED);
            new JPARepositoryFactory().forBpRepository().updateEntity(instanceDAO);
        }
        catch (Exception e) {
            logger.error("Failed to cancel the process instance with id:{}",processInstanceId,e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to cancel the process instance with the given id");
        }

        logger.debug("Cancelled process instance with id: {}",processInstanceId);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "",notes = "Updates the process instance with the given id by replacing the exchanged document with" +
            " given document")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Updated the process instance successfully"),
            @ApiResponse(code = 401, message = "Invalid token. No user was found for the provided token"),
            @ApiResponse(code = 404, message = "There does not exist a process instance with the given id"),
            @ApiResponse(code = 500, message = "Unexpected error while updating the process instance with the given id")
    })
    @RequestMapping(value = "/processInstance",
            method = RequestMethod.PATCH)
    public ResponseEntity updateProcessInstance(@ApiParam(value = "Serialized form of the document exchanged in the updated step of the business process", required = true) @RequestBody String content,
                                                @ApiParam(value = "Type of the process instance document to be updated", required = true) @RequestParam(value = "processID") DocumentType documentType,
                                                @ApiParam(value = "Identifier of the process instance to be updated", required = true) @RequestParam(value = "processInstanceID") String processInstanceID,
                                                @ApiParam(value = "Identifier of the user who updated the process instance", required = true) @RequestParam(value = "creatorUserID") String creatorUserID,
                                                @ApiParam(value = "The Bearer token provided by the identity service" ,required=true ) @RequestHeader(value="Authorization", required=true) String bearerToken) {


        logger.debug("Updating process instance with id: {}",processInstanceID);

        BusinessProcessContext businessProcessContext = BusinessProcessContextHandler.getBusinessProcessContextHandler().getBusinessProcessContext(null);

        try {
            // check token
            ResponseEntity tokenCheck = eu.nimble.service.bp.impl.util.HttpResponseUtil.checkToken(bearerToken);
            if (tokenCheck != null) {
                return tokenCheck;
            }

            ProcessDocumentMetadata processDocumentMetadata = ProcessDocumentMetadataDAOUtility.getRequestMetadata(processInstanceID);
            Object document = DocumentPersistenceUtility.readDocument(documentType, content);
            // validate the entity ids
            boolean hjidsBelongToCompany = resourceValidationUtil.hjidsBelongsToParty(document, processDocumentMetadata.getInitiatorID(), Configuration.Standard.UBL.toString());
            if(!hjidsBelongToCompany) {
                return HttpResponseUtil.createResponseEntityAndLog(String.format("Some of the identifiers (hjid fields) do not belong to the party in the passed catalogue: %s", content), null, HttpStatus.BAD_REQUEST, LogLevel.INFO);
            }

            ProcessInstanceDAO instanceDAO = ProcessInstanceDAOUtility.getById(processInstanceID);
            // check whether the process instance with the given id exists or not
            if(instanceDAO == null){
                logger.error("There does not exist a process instance with id:{}",processInstanceID);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("There does not exist a process instance with the given id");
            }
            // update creator user id of metadata
            processDocumentMetadata.setCreatorUserID(creatorUserID);
            ProcessDocumentMetadataDAOUtility.updateDocumentMetadata(businessProcessContext.getId(),processDocumentMetadata);
            // update the corresponding document
            DocumentPersistenceUtility.updateDocument(businessProcessContext.getId(), document, processDocumentMetadata.getDocumentID(), documentType, processDocumentMetadata.getInitiatorID());
        }
        catch (Exception e) {
            logger.error("Failed to update the process instance with id:{}",processInstanceID,e);
            businessProcessContext.handleExceptions();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update the process instance with the given id");
        }
        finally {
            BusinessProcessContextHandler.getBusinessProcessContextHandler().deleteBusinessProcessContext(businessProcessContext.getId());
        }

        logger.debug("Updated process instance with id: {}",processInstanceID);
        return ResponseEntity.ok(null);
    }

    @ApiOperation(value = "",notes = "Gets rating status for the specified process instance")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved rating status successfully"),
            @ApiResponse(code = 401, message = "Invalid token. No user was found for the provided token"),
            @ApiResponse(code = 500, message = "Unexpected error while getting the rating status")
    })
    @RequestMapping(value = "/processInstance/{processInstanceId}/isRated",
            produces = {MediaType.TEXT_PLAIN_VALUE},
            method = RequestMethod.GET)
    public ResponseEntity isRated(@ApiParam(value = "Identifier of the process instance", required = true) @PathVariable(value = "processInstanceId", required = true) String processInstanceId,
                                  @ApiParam(value = "Identifier of the party (the rated) for which the existence of a rating to be checked", required = true) @RequestParam(value = "partyId", required = true) String partyId,
                                  @ApiParam(value = "The Bearer token provided by the identity service", required = true) @RequestHeader(value = "Authorization", required = true) String bearerToken) {
        try {
            logger.info("Getting rating status for process instance: {}, party: {}", processInstanceId, partyId);
            // check token
            ResponseEntity tokenCheck = eu.nimble.service.bp.impl.util.HttpResponseUtil.checkToken(bearerToken);
            if (tokenCheck != null) {
                return tokenCheck;
            }

            Boolean rated = TrustPersistenceUtility.processInstanceIsRated(partyId,processInstanceId);

            logger.info("Retrieved rating status for process instance: {}, party: {}", processInstanceId, partyId);
            return ResponseEntity.ok(rated.toString());

        } catch (Exception e) {
            return HttpResponseUtil.createResponseEntityAndLog(String.format("Unexpected error while getting the order content for process instance id: %s, party: %s", processInstanceId, partyId), e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ApiOperation(value = "",notes = "Gets details of the specified process instance")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retrieved process instance details successfully",response = DashboardProcessInstanceDetails.class),
            @ApiResponse(code = 401, message = "Invalid token. No user was found for the provided token"),
            @ApiResponse(code = 500, message = "Unexpected error while getting the details of process instance")
    })
    @RequestMapping(value = "/processInstance/{processInstanceId}/details",
            produces = {MediaType.APPLICATION_JSON_VALUE},
            method = RequestMethod.GET)
    public ResponseEntity getDashboardProcessInstanceDetails(@ApiParam(value = "Identifier of the process instance", required = true) @PathVariable(value = "processInstanceId", required = true) String processInstanceId,
                                                             @ApiParam(value = "The Bearer token provided by the identity service", required = true) @RequestHeader(value = "Authorization", required = true) String bearerToken) {
        try {
            logger.info("Getting the details for process instance: {}", processInstanceId);
            // check token
            ResponseEntity tokenCheck = eu.nimble.service.bp.impl.util.HttpResponseUtil.checkToken(bearerToken);
            if (tokenCheck != null) {
                return tokenCheck;
            }

            DashboardProcessInstanceDetails dashboardProcessInstanceDetails = new DashboardProcessInstanceDetails();

            // set variableInstance,lastActivityInstance and processInstance
            CamundaEngine.getProcessDetails(dashboardProcessInstanceDetails,processInstanceId);

            // get request and response document
            // get request and response metadata as well
            Object requestDocument = null;
            Object responseDocument = null;
            ProcessDocumentMetadata requestMetadata = null;
            ProcessDocumentMetadata responseMetadata = null;
            for(HistoricVariableInstance variableInstance:dashboardProcessInstanceDetails.getVariableInstance()){
                // request document
                if(variableInstance.getName().contentEquals("initialDocumentID")){
                    String documentId =  variableInstance.getValue().toString();
                    // request document
                    requestDocument = DocumentPersistenceUtility.getUBLDocument(documentId);
                    // request metadata
                    requestMetadata = HibernateSwaggerObjectMapper.createProcessDocumentMetadata(ProcessDocumentMetadataDAOUtility.findByDocumentID(documentId));
                }
                // response document
                else if(variableInstance.getName().contentEquals("responseDocumentID")){
                    String documentId =  variableInstance.getValue().toString();
                    // response document
                    responseDocument = DocumentPersistenceUtility.getUBLDocument(documentId);
                    // response metadata
                    responseMetadata = HibernateSwaggerObjectMapper.createProcessDocumentMetadata(ProcessDocumentMetadataDAOUtility.findByDocumentID(documentId));
                }
            }
            dashboardProcessInstanceDetails.setRequestDocument(requestDocument);
            dashboardProcessInstanceDetails.setResponseDocument(responseDocument);
            dashboardProcessInstanceDetails.setRequestMetadata(requestMetadata);
            dashboardProcessInstanceDetails.setResponseMetadata(responseMetadata);
            // get request creator and response creator user info
            PersonType requestCreatorUser = null;
            PersonType responseCreatorUser = null;
            if(requestMetadata != null){
                requestCreatorUser = SpringBridge.getInstance().getiIdentityClientTyped().getPerson(bearerToken,requestMetadata.getCreatorUserID());
            }
            if(responseMetadata != null){
                responseCreatorUser = SpringBridge.getInstance().getiIdentityClientTyped().getPerson(bearerToken,responseMetadata.getCreatorUserID());
            }
            dashboardProcessInstanceDetails.setRequestCreatorUser(requestCreatorUser);
            dashboardProcessInstanceDetails.setResponseCreatorUser(responseCreatorUser);

            logger.info("Retrieved the details for process instance: {}", processInstanceId);
            return ResponseEntity.ok(JsonSerializationUtility.getObjectMapper().writeValueAsString(dashboardProcessInstanceDetails));
        } catch (Exception e) {
            return HttpResponseUtil.createResponseEntityAndLog(String.format("Unexpected error while getting the details for process instance id: %s", processInstanceId), e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
