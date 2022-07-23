package com.tradehistory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tradehistory.Service.TradeService;
import com.tradehistory.model.TradeHistory;
@RestController
@RequestMapping("/trade")
public class TradeController {
	
	
	@Autowired
	TradeService tradeService;
	
	@PostMapping("/post")
	private ResponseEntity<TradeHistory>postTradeHistory(@RequestBody TradeHistory tradeHistory){
		TradeHistory tradeHistory1=tradeService.postTradeHistory(tradeHistory);
		return new ResponseEntity<TradeHistory>(tradeHistory1,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	private ResponseEntity<List<TradeHistory>>getalldatatardehistory(){
		List<TradeHistory>trade=tradeService.getalldatahistory();
		return new ResponseEntity<List<TradeHistory>>(trade,HttpStatus.OK);
		
	}
	
	@GetMapping("/get/{tradeId}")
	private ResponseEntity<TradeHistory>getTradingHistoryBytradeId(@PathVariable String tradeId){
		Optional<TradeHistory> trade=tradeService.getTradeHistoryBytradeId(tradeId);
		TradeHistory trade1=trade.get();
		return new ResponseEntity<TradeHistory>(trade1,HttpStatus.OK);
	}
	
	@PutMapping("/put/{tradeId}")
	private ResponseEntity<TradeHistory>updatetradingHistory(@PathVariable String tradeId,@RequestBody TradeHistory tradeHistory){
		TradeHistory tradeHistory1=tradeService.updatetradingHistory(tradeHistory,tradeId);
		return new ResponseEntity<TradeHistory>(tradeHistory1,HttpStatus.OK);
	}
	
	@DeleteMapping("/del/{tradeId}")
	private ResponseEntity<String>delettradehistory(@PathVariable String tradeId){
		tradeService.delettradehistory(tradeId);
		return new ResponseEntity<String>("deleted",HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	

}
