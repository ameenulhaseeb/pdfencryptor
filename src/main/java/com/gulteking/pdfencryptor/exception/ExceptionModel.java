package com.gulteking.pdfencryptor.exception;




public class ExceptionModel {

    
	private String error;
    private String errorDescription;
    private String internalError;
    private String internalErrorDescription;
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getErrorDescription() {
		return errorDescription;
	}
	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
	public String getInternalError() {
		return internalError;
	}
	public void setInternalError(String internalError) {
		this.internalError = internalError;
	}
	public String getInternalErrorDescription() {
		return internalErrorDescription;
	}
	public void setInternalErrorDescription(String internalErrorDescription) {
		this.internalErrorDescription = internalErrorDescription;
	}
	public ExceptionModel(String error, String errorDescription, String internalError,
			String internalErrorDescription) {
		super();
		this.error = error;
		this.errorDescription = errorDescription;
		this.internalError = internalError;
		this.internalErrorDescription = internalErrorDescription;
	}
    
    
}
