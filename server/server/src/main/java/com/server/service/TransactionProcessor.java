package com.server.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

@Component
public class TransactionProcessor {

	private final ExecutorService executorService = Executors.newFixedThreadPool(50);
	
	public void submit(Runnable runnable) {
		executorService.submit(runnable);
	}
}
