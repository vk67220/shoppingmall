package com.shoppingmall.exception;

import java.util.Date;

/**
 * @author muralinutalapati
 */
public class ErrorResponseBean {
	private int status;
	private Date timestamp;
	private String message;
	private String details;

	public ErrorResponseBean(int status, Date timestamp, String message, String details) {
		this.status = status;
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
