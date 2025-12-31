package com.server.util;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class TransactionRegistry {

	 private final Set<String> processedTrxIds =
	            ConcurrentHashMap.newKeySet();

	    public boolean isDuplicate(String trxId) {
	        return !processedTrxIds.add(trxId);
	    }
}
