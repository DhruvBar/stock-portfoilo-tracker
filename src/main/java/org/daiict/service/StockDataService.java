package org.daiict.service;

import org.daiict.config.ConfigProperties;
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

    @Autowired
    private ConfigProperties configProperties;

    public QuoteResponse.QuoteData getStockQuote(String symbol) {
        String url = String.format("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=%s", symbol, configProperties.getAlphaVantageApiKey());
        QuoteResponse response = restTemplate.getForObject(url, QuoteResponse.class);
        return response.getQuoteData();
    }

    public List<SearchStockResponse.SearchStockResponseData> searchStock(String query) {
        try {
            String url = String.format("https://www.alphavantage.co/query?function=SYMBOL_SEARCH&keywords=%s&apikey=%s", query, configProperties.getAlphaVantageApiKey());
            SearchStockResponse searchStockResponse = restTemplate.getForObject(url, SearchStockResponse.class);
            return searchStockResponse.getBestMatches();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // returning empty list if search fails
        return new ArrayList<>();
    }
}
