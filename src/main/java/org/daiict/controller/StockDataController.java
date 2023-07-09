package org.daiict.controller;

import org.daiict.model.QuoteResponse;
import org.daiict.model.SearchStockResponse;
import org.daiict.service.StockDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockDataController {
    @Autowired
    private StockDataService stockData;

    @GetMapping("/quote")
    public QuoteResponse.QuoteData stockData(@RequestParam("symbol") String symbol) {
        return stockData.getStockQuote(symbol);
    }

    @GetMapping("/search")
    public List<SearchStockResponse.SearchStockResponseData> searhcStocks(@RequestParam("query") String query) {
        return stockData.searchStock(query);
    }
}
