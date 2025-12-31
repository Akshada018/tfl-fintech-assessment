package com.server.service;

import com.server.dao.TransactionRequest;
import com.server.dao.TransactionResponse;

public interface TransactionService {

	TransactionResponse process(TransactionRequest request);
}
