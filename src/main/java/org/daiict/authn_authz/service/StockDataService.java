package org.daiict.authn_authz.service;

import org.daiict.authn_authz.model.QuoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StockDataService {
    @Autowired
    private RestTemplate restTemplate;

    public String getStockQuote(String symbol)
    {
        String url = String.format("https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol=%s&apikey=8W6C042MM42CF6GP",symbol);
        QuoteResponse response = restTemplate.getForObject(url,QuoteResponse.class);
        return response.toString();
    }
}
