package com.orlandolorenzosviluppo.fraud.service;

import com.orlandolorenzosviluppo.fraud.model.FraudCheckHistory;
import com.orlandolorenzosviluppo.fraud.repository.FraudCheckHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FraudCheckService {
    @Autowired
    private FraudCheckHistoryRepository repository;

    public boolean isFraudulentCustomer(Integer customerId) {
        repository.save(
            FraudCheckHistory
                    .builder()
                    .customerId(customerId)
                    .isFraudster(false)
                    .createdAt(LocalDateTime.now())
                    .build()
        );

        return false;
    }
}
