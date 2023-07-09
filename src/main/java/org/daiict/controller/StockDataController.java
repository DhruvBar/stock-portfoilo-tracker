package org.daiict.controller;

import org.daiict.service.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockDataController {
    @Autowired
    private StockDataService stockData;
    @GetMapping("/data")
    public String stockData(@RequestParam("symbol") String symbol)
    {
        return stockData.getStockQuote(symbol);
    }
}
