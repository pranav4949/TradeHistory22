package com.tradehistory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tradehistory.model.TradeHistory;
@Repository
public interface TradeRepository extends MongoRepository<TradeHistory ,String>{

}
