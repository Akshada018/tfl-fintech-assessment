package com.server.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.dao.TransactionRequest;
import com.server.dao.TransactionResponse;
import com.server.entity.TransactionLog;
import com.server.repository.TransactionLogRepository;
import com.server.service.TransactionProcessor;
import com.server.service.TransactionService;
import com.server.util.TransactionRegistry;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionProcessor processor;

	@Autowired
	private TransactionRegistry transactionRegistry;
	
	@Autowired
	private TransactionLogRepository transactionLogRepository;
	
	public TransactionResponse process(TransactionRequest request) {

        long start = System.currentTimeMillis();
        
        if (transactionRegistry.isDuplicate(request.getTrxId())) {
            return new TransactionResponse(
                    request.getTrxId(),
                    "FAILED",
                    "Duplicate Transaction",
                    System.currentTimeMillis() - start
            );
        }
        
        processor.submit(() -> {
            try {
            	 long processingTime = System.currentTimeMillis() - start;

            	    TransactionLog log = new TransactionLog();
            	    log.setTrxId(request.getTrxId());
            	    log.setBankId(request.getBankId());
            	    log.setStatus("SUCCESS");
            	    log.setProcessingTimeMs(processingTime);

            	    transactionLogRepository.save(log);
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        if (request.getAmount() <= 0) {
            return new TransactionResponse(
                    request.getTrxId(),
                    "FAILED",
                    "Invalid Amount",
                    System.currentTimeMillis() - start
            );
        }

        return new TransactionResponse(
                request.getTrxId(),
                "SUCCESS",
                "Completed",
                System.currentTimeMillis() - start
        );
    }
	
}
