package com.server.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.dao.TransactionRequest;
import com.server.dao.TransactionResponse;
import com.server.service.TransactionService;

@RestController
@RequestMapping("/server/transaction")
public class TransactionController {
	
	 private final TransactionService service;

	    public TransactionController(TransactionService service) {
	        this.service = service;
	    }

		@PostMapping(value = "/process", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<TransactionResponse> process(@RequestBody TransactionRequest request) {

			return ResponseEntity.ok(service.process(request));
		}

}
