package com.cooksys.number_project.tx;

public class TXResponse<T> {
	String fieldType;
	T field;
	
	public TXResponse() {
	}
	public TXResponse(String transactionType) {
		this.fieldType = transactionType;
	}	
	public TXResponse(String transactionType, T field) {
		this.fieldType = transactionType;
		this.field = field;
	}
	
	public String getTransactionType() {
		return fieldType;
	}
	public void setTransactionType(String transactionType) {
		this.fieldType = transactionType;
	}
	
	public T getField() {
		return field;
	}
	public void setField(T field) {
		this.field = field;
	}
	
}
