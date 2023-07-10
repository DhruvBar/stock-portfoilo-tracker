package org.daiict.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class StockData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String symbol;
    private Float price;
    private Float open;
    private Float high;
    private Float low;
    private Long volume;
    private String latestTradingDay;
    private Float previousClose;
    private Float changeValue;
    private Float changePercent;
    private Float sma;
    private Float macd;
    private Float stoch;
}
