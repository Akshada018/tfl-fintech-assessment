package com.bankB.service;

import java.util.Map;

import com.bankB.dao.TransactionRequestDao;

public interface BankService {

	
	public Map<String, Object> process(TransactionRequestDao dto);
	
}
