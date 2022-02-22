package com.orlandolorenzosviluppo.fraud.repository;

import com.orlandolorenzosviluppo.fraud.model.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FraudCheckHistoryRepository extends JpaRepository<FraudCheckHistory, Integer> {

}
