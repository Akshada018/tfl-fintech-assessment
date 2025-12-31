package com.server.dao;

import lombok.Data;

@Data
public class TransactionResponse {
	
	 private String trxId;
	    private String status;
	    private String reason;
	    private long processingTimeMs;

	    public TransactionResponse(String trxId, String status, String reason, long processingTimeMs) {
	        this.trxId = trxId;
	        this.status = status;
	        this.reason = reason;
	        this.processingTimeMs = processingTimeMs;
	    }

}
