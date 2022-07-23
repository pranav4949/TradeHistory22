package com.tradehistory.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class TradeHistory {
	
	@MongoId
	private String tradeId;
	private String tradeName;
	private String tradeAccountNo;
	private Date tradeDate =new Date (System.currentTimeMillis());

}
