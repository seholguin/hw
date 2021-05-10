package eu.nimble.service.bp.exception;

public enum NimbleExceptionMessageCode {
    BAD_REQUEST_ALREADY_CANCELLED("BAD_REQUEST.alreadyCancelled"),
    BAD_REQUEST_ALREADY_COMPLETED("BAD_REQUEST.alreadyCompleted"),
    BAD_REQUEST_ALREADY_FINISHED("BAD_REQUEST.alreadyFinished"),
    BAD_REQUEST_HJID_FIELDS_FOUND("BAD_REQUEST.hjidFieldsFound"),
    BAD_REQUEST_INVALID_BUSINESS_PROCESS_TYPE("BAD_REQUEST.invalidBusinessProcessType"),
    BAD_REQUEST_INVALID_DATE("BAD_REQUEST.invalidDate"),
    BAD_REQUEST_INVALID_DOCUMENT_TYPE("BAD_REQUEST.invalidDocumentType"),
    BAD_REQUEST_INVALID_IDENTIFIERS("BAD_REQUEST.invalidIdentifiers"),
    BAD_REQUEST_INVALID_ROLE("BAD_REQUEST.invalidRole"),
    BAD_REQUEST_INVALID_STATUS("BAD_REQUEST.invalidStatus"),
    BAD_REQUEST_MISSING_PARTY_PARAMETERS("BAD_REQUEST.missingPartyParameters"),
    BAD_REQUEST_MISSING_RATING_PARAMETER("BAD_REQUEST.missingRatingParameter"),
    BAD_REQUEST_NOT_INCLUDED_IN_WORKFLOW("BAD_REQUEST.notIncludedInWorkflow"),
    BAD_REQUEST_NOT_USED_IN_ANY_ORDER("BAD_REQUEST.notUsedInAnyOrder"),
    BAD_REQUEST_NO_COMPLETED_TASK("BAD_REQUEST.noCompletedTask"),
    BAD_REQUEST_NO_PARTY("BAD_REQUEST.noParty"),
    BAD_REQUEST_NO_PROCESS_DOCUMENT_METADATA("BAD_REQUEST.noProcessDocumentMetadata"),
    BAD_REQUEST_NO_PRODUCT("BAD_REQUEST.noProduct"),
    BAD_REQUEST_NO_STRIPE_ACCOUNT("BAD_REQUEST.noStripeAccount"),
    BAD_REQUEST_NO_QUALIFYING_PARTY("BAD_REQUEST.noQualifyingParty"),
    BAD_REQUEST_NO_VALID_REFERENCE("BAD_REQUEST.noValidReference"),
    BAD_REQUEST_PARTY_NOT_INCLUDED_IN_PROCESS("BAD_REQUEST.partyNotIncludedInProcess"),
    BAD_REQUEST_PAYMENT_DONE("BAD_REQUEST.paymentDone"),
    BAD_REQUEST_SAME_PARTIES_TO_START_PROCESS("BAD_REQUEST.samePartiesToStartProcess"),
    GATEWAY_TIMEOUT_WAITING_FOR_ANOTHER_SERVER("GATEWAY_TIMEOUT.waitingForAnotherServer"),
    INTERNAL_SERVER_ERROR_ADD_DATA_MONITORING_CLAUSE_TO_CONTRACT("INTERNAL_SERVER_ERROR.addDataMonitoringClauseToContract"),
    INTERNAL_SERVER_ERROR_ADD_DOCUMENT_CLAUSE_TO_CONTRACT("INTERNAL_SERVER_ERROR.addDocumentClauseToContract"),
    INTERNAL_SERVER_ERROR_ADD_PRODUCT_TO_SHOPPING_CART("INTERNAL_SERVER_ERROR.addProductToShoppingCart"),
    INTERNAL_SERVER_ERROR_ARCHIVE_COLLABORATION_GROUP("INTERNAL_SERVER_ERROR.archiveCollaborationGroup"),
    INTERNAL_SERVER_ERROR_CANCEL_COLLABORATION("INTERNAL_SERVER_ERROR.cancelCollaboration"),
    INTERNAL_SERVER_ERROR_CANCEL_PROCESS("INTERNAL_SERVER_ERROR.cancelProcess"),
    INTERNAL_SERVER_ERROR_COMPLETE_PROCESS("INTERNAL_SERVER_ERROR.completeProcess"),
    INTERNAL_SERVER_ERROR_CONSTRUCT_CONTRACT_FOR_PROCESS_INSTANCES("INTERNAL_SERVER_ERROR.constructContractForProcessInstances"),
    INTERNAL_SERVER_ERROR_CONTINUE_PROCESS("INTERNAL_SERVER_ERROR.continueProcess"),
    INTERNAL_SERVER_ERROR_CREATE_NEGOTIATIONS_FOR_BOM("INTERNAL_SERVER_ERROR.createNegotiationsForBOM"),
    INTERNAL_SERVER_ERROR_CREATE_ORDER("INTERNAL_SERVER_ERROR.createOrder"),
    INTERNAL_SERVER_ERROR_CREATE_PAYMENT_INTENT("INTERNAL_SERVER_ERROR.createPaymentIntent"),
    INTERNAL_SERVER_ERROR_CREATE_RATING_AND_REVIEW("INTERNAL_SERVER_ERROR.createRatingAndReview"),
    INTERNAL_SERVER_ERROR_CREATE_RFQ("INTERNAL_SERVER_ERROR.createRfq"),
    INTERNAL_SERVER_ERROR_DELETE_CATALOGUE("INTERNAL_SERVER_ERROR.deleteCatalogue"),
    INTERNAL_SERVER_ERROR_DELETE_DIGITAL_AGREEMENT("INTERNAL_SERVER_ERROR.deleteDigitalAgreement"),
    INTERNAL_SERVER_ERROR_EXPORT_TRANSACTION("INTERNAL_SERVER_ERROR.exportTransactions"),
    INTERNAL_SERVER_ERROR_FAILED_TO_ADD_CLAUSE("INTERNAL_SERVER_ERROR.failedToAddClause"),
    INTERNAL_SERVER_ERROR_FAILED_TO_ADD_DATA_MONITORING_CLAUSE_TO_CONTRACT("INTERNAL_SERVER_ERROR.failedToAddDataMonitoringClauseToContract"),
    INTERNAL_SERVER_ERROR_FAILED_TO_CREATE_PROCESS_INSTANCE_INPUT_MESSAGE("INTERNAL_SERVER_ERROR.failedToCreateProcessInstanceInputMessage"),
    INTERNAL_SERVER_ERROR_FAILED_TO_CREATE_SHOPPING_CART("INTERNAL_SERVER_ERROR.failedToCreateShoppingCart"),
    INTERNAL_SERVER_ERROR_FAILED_TO_DESERIALIZE_DOCUMENT("INTERNAL_SERVER_ERROR.failedToDeserializeDocument"),
    INTERNAL_SERVER_ERROR_FAILED_TO_DESERIALIZE_FEDERATED_METADATA("INTERNAL_SERVER_ERROR.failedToDeserializeFederatedMetadata"),
    INTERNAL_SERVER_ERROR_FAILED_TO_EXTRACT_PARTY_INFO("INTERNAL_SERVER_ERROR.failedToExtractPartyInfo"),
    INTERNAL_SERVER_ERROR_FAILED_TO_GENERATE_ORDER_TERMS("INTERNAL_SERVER_ERROR.failedToGenerateOrderTerms"),
    INTERNAL_SERVER_ERROR_FAILED_TO_GET_GROUP_ID_TUPLE("INTERNAL_SERVER_ERROR.failedToGetGroupIdTuple"),
    INTERNAL_SERVER_ERROR_FAILED_TO_GET_PARTY("INTERNAL_SERVER_ERROR.failedToGetParty"),
    INTERNAL_SERVER_ERROR_FAILED_TO_GET_PARTY_INFO("INTERNAL_SERVER_ERROR.failedToGetPartyInfo"),
    INTERNAL_SERVER_ERROR_FAILED_TO_GET_PERSON("INTERNAL_SERVER_ERROR.failedToGetPerson"),
    INTERNAL_SERVER_ERROR_FAILED_TO_GET_SHOPPING_CART("INTERNAL_SERVER_ERROR.failedToGetShoppingCart"),
    INTERNAL_SERVER_ERROR_FAILED_TO_MERGE_TRANSPORT_GROUP_TO_ORDER_GROUP("INTERNAL_SERVER_ERROR.failedToMergeTransportGroupToOrderGroup"),
    INTERNAL_SERVER_ERROR_FAILED_TO_RETRIEVE_EPC("INTERNAL_SERVER_ERROR.failedToRetrieveEPC"),
    INTERNAL_SERVER_ERROR_FAILED_TO_SEND_DOCUMENT_TO_INITIATOR_PARTY("INTERNAL_SERVER_ERROR.failedToSendDocumentToInitiatorParty"),
    INTERNAL_SERVER_ERROR_FAILED_TO_SERIALIZE_RFQ_SUMMARY("INTERNAL_SERVER_ERROR.failedToSerializeRFQSummary"),
    INTERNAL_SERVER_ERROR_FAILED_TO_SERIALIZE_INVOICE("INTERNAL_SERVER_ERROR.failedToSerializeInvoice"),
    INTERNAL_SERVER_ERROR_FAILED_TO_WRITE_AUXILIARY_FILE_TO_ZIP("INTERNAL_SERVER_ERROR.failedToWriteAuxiliaryFileToZip"),
    INTERNAL_SERVER_ERROR_FAILED_TO_WRITE_DOCUMENT_TO_ZIP("INTERNAL_SERVER_ERROR.failedToWriteDocumentToZip"),
    INTERNAL_SERVER_ERROR_FAILED_TO_WRITE_TRANSACTION_SUMMARY("INTERNAL_SERVER_ERROR.failedToWriteTransactionSummary"),
    INTERNAL_SERVER_ERROR_FINISH_COLLABORATION("INTERNAL_SERVER_ERROR.finishCollaboration"),
    INTERNAL_SERVER_ERROR_GENERATE_CONTRACT("INTERNAL_SERVER_ERROR.generateContract"),
    INTERNAL_SERVER_ERROR_GET_ALL_DIGITAL_AGREEMENTS_FOR_PARTIES_AND_PRODUCTS("INTERNAL_SERVER_ERROR.getAllDigitalAgreementsForPartiesAndProduct"),
    INTERNAL_SERVER_ERROR_GET_ASSOCIATED_COLLABORATION_GROUP("INTERNAL_SERVER_ERROR.getAssociatedCollaborationGroup"),
    INTERNAL_SERVER_ERROR_GET_AVERAGE_RESPONSE_TIME("INTERNAL_SERVER_ERROR.getAverageResponseTime"),
    INTERNAL_SERVER_ERROR_GET_COLLABORATION_TIME_IN_MONTHS("INTERNAL_SERVER_ERROR.getCollaborationTimeInMonths"),
    INTERNAL_SERVER_ERROR_GET_CATALOGUE_LINE_FOR_EPC("INTERNAL_SERVER_ERROR.getCatalogueLineForEPCCode"),
    INTERNAL_SERVER_ERROR_GET_CLAUSES_FOR_PROCESS_INSTANCES("INTERNAL_SERVER_ERROR.getClausesOfContract"),
    INTERNAL_SERVER_ERROR_GET_CLAUSE_DETAILS("INTERNAL_SERVER_ERROR.getClauseDetails"),
    INTERNAL_SERVER_ERROR_GET_COLLABORATION_GROUP("INTERNAL_SERVER_ERROR.getCollaborationGroup"),
    INTERNAL_SERVER_ERROR_GET_COLLABORATION_GROUPS("INTERNAL_SERVER_ERROR.getCollaborationGroups"),
    INTERNAL_SERVER_ERROR_GET_DASHBOARD_PROCESS_INSTANCE_DETAILS("INTERNAL_SERVER_ERROR.getDashboardProcessInstanceDetails"),
    INTERNAL_SERVER_ERROR_GET_DIGITAL_AGREEMENT_FOR_PARTIES_AND_PRODUCT("INTERNAL_SERVER_ERROR.getDigitalAgreementForPartiesAndProduct"),
    INTERNAL_SERVER_ERROR_GET_DIGITAL_AGREEMENT_FOR_PARTIES_AND_PRODUCTS("INTERNAL_SERVER_ERROR.getDigitalAgreementForPartiesAndProducts"),
    INTERNAL_SERVER_ERROR_GET_DOCUMENT_JSON_CONTENT("INTERNAL_SERVER_ERROR.getDocumentJsonContent"),
    INTERNAL_SERVER_ERROR_GET_EPC_BELONGS_TO_PRODUCT("INTERNAL_SERVER_ERROR.getEPCCodesBelongsToProduct"),
    INTERNAL_SERVER_ERROR_GET_EXPECTED_ORDERS("INTERNAL_SERVER_ERROR.getExpectedOrders"),
    INTERNAL_SERVER_ERROR_GET_FEDERATED_METADATA("INTERNAL_SERVER_ERROR.getFederatedMetadata"),
    INTERNAL_SERVER_ERROR_GET_FULFILMENT_STATISTICS("INTERNAL_SERVER_ERROR.getFulfilmentStatistics"),
    INTERNAL_SERVER_ERROR_GET_INACTIVE_COMPANIES("INTERNAL_SERVER_ERROR.getInactiveCompanies"),
    INTERNAL_SERVER_ERROR_GET_NEGOTIATION_SETTINGS("INTERNAL_SERVER_ERROR.getNegotiationSettings"),
    INTERNAL_SERVER_ERROR_GET_NON_ORDERED_PRODUCTS("INTERNAL_SERVER_ERROR.getNonOrderedProducts"),
    INTERNAL_SERVER_ERROR_GET_ORDER_DOCUMENT("INTERNAL_SERVER_ERROR.getOrderDocument"),
    INTERNAL_SERVER_ERROR_GET_PROCESS_COUNT("INTERNAL_SERVER_ERROR.getProcessCount"),
    INTERNAL_SERVER_ERROR_GET_PROCESS_COUNT_BREAKDOWN_BY_ROLE("INTERNAL_SERVER_ERROR.getProcessCountBreakDownByRole"),
    INTERNAL_SERVER_ERROR_GET_PROCESS_COUNT_BREAK_DOWN("INTERNAL_SERVER_ERROR.getProcessCountBreakDown"),
    INTERNAL_SERVER_ERROR_GET_PROCESS_DOCUMENT_METADATA_SUMMARIES("INTERNAL_SERVER_ERROR.getProcessDocumentMetadataSummaries"),
    INTERNAL_SERVER_ERROR_GET_PROCESS_INSTANCE_GROUP_FILTERS("INTERNAL_SERVER_ERROR.getProcessInstanceGroupFilters"),
    INTERNAL_SERVER_ERROR_GET_PROCESS_INSTANCE_GROUPS("INTERNAL_SERVER_ERROR.getProcessInstanceGroups"),
    INTERNAL_SERVER_ERROR_GET_PROCESS_INSTANCE_ID_FOR_DOCUMENT("INTERNAL_SERVER_ERROR.getProcessInstanceIdForDocument"),
    INTERNAL_SERVER_ERROR_GET_RATINGS_SUMMARY("INTERNAL_SERVER_ERROR.getRatingsSummary"),
    INTERNAL_SERVER_ERROR_GET_STATISTICS("INTERNAL_SERVER_ERROR.getStatistics"),
    INTERNAL_SERVER_ERROR_GET_TRADING_VOLUME("INTERNAL_SERVER_ERROR.getTradingVolume"),
    INTERNAL_SERVER_ERROR_IS_RATED("INTERNAL_SERVER_ERROR.isRated"),
    INTERNAL_SERVER_ERROR_LIST_ALL_INDIVIDUAL_RATINGS_AND_REVIEWS("INTERNAL_SERVER_ERROR.listAllIndividualRatingsAndReviews"),
    INTERNAL_SERVER_ERROR_NO_AVAILABLE_RESOURCE("INTERNAL_SERVER_ERROR.noAvailableResource"),
    INTERNAL_SERVER_ERROR_REMOVE_PRODUCTS_FROM_SHOPPING_CART("INTERNAL_SERVER_ERROR.removeProductsFromShoppingCart"),
    INTERNAL_SERVER_ERROR_SEND_PAYMENT_LOG("INTERNAL_SERVER_ERROR.sendPaymentLog"),
    INTERNAL_SERVER_ERROR_SERIALIZATION_ERROR("INTERNAL_SERVER_ERROR.serializationError"),
    INTERNAL_SERVER_ERROR_SERIALIZE_ORDER("INTERNAL_SERVER_ERROR.serializeOrder"),
    INTERNAL_SERVER_ERROR_SERIALIZE_RFQ("INTERNAL_SERVER_ERROR.serializeRFQ"),
    INTERNAL_SERVER_ERROR_START_PROCESS("INTERNAL_SERVER_ERROR.startProcess"),
    INTERNAL_SERVER_ERROR_START_PROCESS_WITH_DOCUMENT("INTERNAL_SERVER_ERROR.startProcessWithDocument"),
    INTERNAL_SERVER_ERROR_UNMERGE_GROUPS("INTERNAL_SERVER_ERROR.unmergeGroups"),
    INTERNAL_SERVER_ERROR_UPDATE_DOCUMENT("INTERNAL_SERVER_ERROR.updateDocument"),
    INTERNAL_SERVER_ERROR_UPDATE_INSTANCE("INTERNAL_SERVER_ERROR.updateInstance"),
    NOT_ACCEPTABLE_NOT_ARCHIVABLE("NOT_ACCEPTABLE.notArchivable"),
    NOT_FOUND_INVALID_BOUNDED_DOCUMENT_TYPE("NOT_FOUND.invalidBoundedDocumentType"),
    NOT_FOUND_INVALID_PROCESS_INSTANCE("NOT_FOUND.invalidProcessInstance"),
    NOT_FOUND_NO_CATALOGUE_LINE_FOR_HJID("NOT_FOUND.noCatalogueLineForHjid"),
    NOT_FOUND_NO_CLASS("NOT_FOUND.noClass"),
    NOT_FOUND_NO_COLLABORATION_GROUP("NOT_FOUND.noCollaborationGroup"),
    NOT_FOUND_NO_COLLABORATION_GROUP_FOR_PROCESS("NOT_FOUND.noCollaborationGroupForProcess"),
    NOT_FOUND_NO_CONTRACT("NOT_FOUND.noContract"),
    NOT_FOUND_NO_CONTRACT_FOR_DOCUMENT_TYPE("NOT_FOUND.noContractForDocumentType"),
    NOT_FOUND_NO_DIGITAL_AGREEMENT("NOT_FOUND.noDigitalAgreement"),
    NOT_FOUND_NO_DIGITAL_AGREEMENT_FOR_PARAMETERS("NOT_FOUND.noDigitalAgreementForParameters"),
    NOT_FOUND_NO_DOCUMENT("NOT_FOUND.noDocument"),
    NOT_FOUND_NO_METADATA_FOR_ORDER_RESPONSE("NOT_FOUND.noMetadataForOrderResponse"),
    NOT_FOUND_NO_PROCESS_DOCUMENT_METADATA("NOT_FOUND.noProcessDocumentMetadata"),
    NOT_FOUND_NO_PROCESS_ID("NOT_FOUND.noProcessId"),
    NOT_FOUND_NO_PROCESS_INSTANCE("NOT_FOUND.noProcessInstance"),
    NOT_FOUND_NO_PROCESS_INSTANCE_GROUP("NOT_FOUND.noProcessInstanceGroup"),
    NOT_FOUND_NO_PRODUCT("NOT_FOUND.noProduct"),
    NOT_FOUND_ORDER("NOT_FOUND.order"),
    NOT_FOUND_INVOICE("NOT_FOUND.invoice"),
    NO_CONTENT_NO_CLAUSE("NO_CONTENT.noClause"),
    PRECONDITION_FAILED_NO_SHOPPING_CART("PRECONDITION_FAILED.noShoppingCart"),
    UNAUTHORIZED_FAILED_TO_CREATE_SHOPPING_CART("UNAUTHORIZED.failedToCreateShoppingCart"),
    UNAUTHORIZED_DELETE_TRANSACTIONS("UNAUTHORIZED.deleteTransactions"),
    UNAUTHORIZED_INVALID_ROLE("UNAUTHORIZED.invalidRole"),
    UNAUTHORIZED_NO_USER_FOR_TOKEN("UNAUTHORIZED.noUserForToken"),
    UNAUTHORIZED_UPDATE_CATEGORY_FILTER("UNAUTHORIZED.updateCategoryFilter"),
    MAIL_SUBJECT_BUSINESS_PROCESS_FINISHED("MAIL_SUBJECT.business_process_finished"),
    MAIL_SUBJECT_TRUST_SCORE_UPDATED("MAIL_SUBJECT.trust_score_updated"),
    MAIL_SUBJECT_BUSINESS_PROCESS_CANCELLED("MAIL_SUBJECT.business_process_cancelled"),
    MAIL_SUBJECT_INFORMATION_REQUESTED("MAIL_SUBJECT.information_requested"),
    MAIL_SUBJECT_QUOTATION_REQUESTED("MAIL_SUBJECT.quotation_requested"),
    MAIL_SUBJECT_ORDER_RECEIVED("MAIL_SUBJECT.order_received"),
    MAIL_SUBJECT_RECEIPT_ADVICE_RECEIVED("MAIL_SUBJECT.receipt_advice_received"),
    MAIL_SUBJECT_INFORMATION_RECEIVED("MAIL_SUBJECT.information_received"),
    MAIL_SUBJECT_QUOTATION_RECEIVED("MAIL_SUBJECT.quotation_received"),
    MAIL_SUBJECT_ORDER_RESPONSE("MAIL_SUBJECT.order_response"),
    MAIL_SUBJECT_DISPATCH_ADVICE_RECEIVED("MAIL_SUBJECT.dispatch_advice_received"),
    MAIL_SUBJECT_ACTION_REQUIRED("MAIL_SUBJECT.action_required"),
    MAIL_SUBJECT_BUSINESS_PROCESS_TRANSITION("MAIL_SUBJECT.business_process_transition"),
    MAIL_SUBJECT_DELIVERY_DATE("MAIL_SUBJECT.delivery_date")
    ;

    private String value;

    NimbleExceptionMessageCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
