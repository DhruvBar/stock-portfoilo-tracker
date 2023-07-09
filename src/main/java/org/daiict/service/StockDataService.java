package org.daiict.service;

import org.daiict.model.QuoteResponse;
import org.daiict.model.SearchStockResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class StockDataService {
    @Autowired
    private RestTemplate restTemplate;

    public String getStockQuote(String symbol) {
        String url = String.format("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=8W6C042MM42CF6GP", symbol);
        QuoteResponse response = restTemplate.getForObject(url, QuoteResponse.class);
        return response.toString();
    }

    public List<SearchStockResponse.SearchStockResponseData> searchStock(String query){
        try {
            String url = String.format("https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=%s&apikey=8W6C042MM42CF6GP", query);
            SearchStockResponse searchStockResponse = restTemplate.getForObject(url, SearchStockResponse.class);
            return searchStockResponse.getBestMatches();
        }catch (Exception e){
            e.printStackTrace();
        }
        // returning empty list if search fails
        return new ArrayList<>();
    }
}
