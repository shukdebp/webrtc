package com.pwc.r2p2.common.exception;

public interface IExceptionConstants {
	public String DATA_MESSAGE_D001="Unable to fetch data";
	public String DATA_MESSAGE_D002="Unable to save data";
	public String DATA_MESSAGE_D003="Unable to update data";
	
	public String APPLICATION_MESSAGE_A001="Unable to retrive CMS id from database";
	public String APPLICATION_MESSAGE_A002="Unable to fetch file";
	public String APPLICATION_MESSAGE_A003="Unable to read file";
	public String APPLICATION_MESSAGE_A004="Unable to download document from CMS";
	public String APPLICATION_MESSAGE_A005="Unable to fetch information or data";
	public String APPLICATION_MESSAGE_A006="Unable to update file";
	public String APPLICATION_MESSAGE_A007="Unable to create file";
	public String APPLICATION_MESSAGE_A008="Unable to move file";
	public String APPLICATION_MESSAGE_A009="Some unexpected error occurred. Please contact Administrator or try again.";
	public String APPLICATION_MESSAGE_A010="Upload file count must be two for the folder :";
	public String APPLICATION_MESSAGE_A011="Upload file type not supported";
	public String APPLICATION_MESSAGE_A012="Folder Already Exist.Try Later.";
	public String APPLICATION_MESSAGE_A014="Upload folder must contains one pdf and one excel file. Got error for the folder";

	/*****PO and Non PO save message for all users*****/
	
	public String INVOICE_CODE="Vendor Invoice Number ";
	public String INVOICE_INDEXED_SUCCESSFUL = " indexed successfully";
	public String INVOICE_INDEXED_ERROR = " has not been indexed due to some problem.";	
	public String INVOICE_SUCCESSFUL = " successfully.";
	public String INVOICE_ERROR = " has not been ";
	public String INVOICE_ERROR_LAST = " due to some problem.";
	
	public String INVOICE_RESOLVED_SUCCESSFUL = "processed successfully.";
	public String INVOICE_RESOLVED_ERROR = "has not been processed due to some problem.";
	public String INVOICE_VALIDATED_SUCCESSFUL = "processed successfully.";
	public String INVOICE_VALIDATED_ERROR = "has not been processed due to some problem.";
	
	public String INVOICE_APPROVED_SUCCESSFUL = "Invoice has been approved successfully.";
	public String INVOICE_APPROVED_ERROR = "Invoice has not been approved due to some problem!";
	
	public String INV_SAVED_DONE = "Invoice has been saved successfully.";
	public String INV_SAVED_ERROR = "Invoice has not been saved due to some problem.";
	public String INV_VALIDATED_SCC_DONE = "Invoice has been validated successfully.";
	public String INV_VALIDATED_SCC_ERROR = "Invoice has not been validated due to some problem.";
	public String INV_SEND_IRT_SCC_DONE = "Invoice has been sent to Issue Resolution team.";
	public String INV_SEND_IRT_SCC_ERROR = "Invoice has not been to Issue Resolution Team due to some problem.";
	public String INV_SEND_INDEXER_SCC_DONE = "Invoice has been sent to Indexer team.";
	public String INV_SEND_INDEXER_SCC_ERROR = "Invoice has not been sent to Indexer team due to some problem.";
	public String INV_SEEK_SUCCESS = "Seek Clarification  done successfully.";
	public String INV_SEEK_ERROR = "Error occured while processing your action.";
	
	public String INV_RESOLVED_IRT_DONE = "Invoice has been resolved successfully.";
	public String INV_RESOLVED_IRT_ERROR = "Invoice has not been resolved due to some problem.";
	public String SOP_UPLOADED_SUCCESSFULLY="The SOP Document has been uploaded successfully.";
	public String SOP_UPLOADED_ERROR="The SOP Document could not be saved.";
	public String SOP_VALIDATION_SUCCESS="The SOP detail is correct.";
	public String SOP_VALIDATION_ERROR="The SOP detail is not correct.Kindly send to Issue Resolution Team for correction.";
	public String SOP_IRT_SENT="The SOP has been sent to IRT successfully.";
	public String SOP_COMPLETE_TRANSACTION="The SOP transaction has been completed";
	
	
	
	
	
	/**----------------------------------------------------------------------------------------**/
}
