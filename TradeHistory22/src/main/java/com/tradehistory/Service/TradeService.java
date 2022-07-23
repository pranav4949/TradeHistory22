package com.tradehistory.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tradehistory.model.TradeHistory;
import com.tradehistory.repository.TradeRepository;
@Service
public class TradeService {
	
	@Autowired
	TradeRepository tradeRepository;

	public TradeHistory postTradeHistory(TradeHistory tradeHistory) {
		TradeHistory trade=tradeRepository.save(tradeHistory);
		return trade;
	}

	public List<TradeHistory> getalldatahistory() {
		List<TradeHistory>list=tradeRepository.findAll();
		return list;
	}

	public Optional<TradeHistory> getTradeHistoryBytradeId(String tradeId) {
		Optional<TradeHistory> trade=tradeRepository.findById(tradeId);
		return trade;
	}

	public TradeHistory updatetradingHistory(TradeHistory tradeHistory, String tradeId) {
		Optional<TradeHistory> trade=tradeRepository.findById(tradeId);
		TradeHistory tradeHistory1=trade.get();
		tradeHistory1.setTradeId(tradeHistory.getTradeId());
		tradeHistory1.setTradeName(tradeHistory.getTradeName());
		tradeHistory1.setTradeAccountNo(tradeHistory.getTradeAccountNo());
		tradeHistory1.setTradeDate(tradeHistory.getTradeDate());
		tradeRepository.save(tradeHistory1);
		return tradeHistory1;
	}

	public void delettradehistory(String tradeId) {
		tradeRepository.deleteById(tradeId);
		
	}
	

}
