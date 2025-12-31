package com.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.entity.TransactionLog;

public interface TransactionLogRepository extends JpaRepository<TransactionLog, Long>{

}
