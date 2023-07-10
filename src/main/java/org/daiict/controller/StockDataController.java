package org.daiict.controller;

import org.daiict.config.CustomUserDetails;
import org.daiict.model.AddHoldingRequest;
import org.daiict.model.QuoteResponse;
import org.daiict.model.SearchStockResponse;
import org.daiict.service.StockDataService;
import org.daiict.service.UserPortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockDataController {
    @Autowired
    private StockDataService stockData;

    @Autowired
    private UserPortfolioService userPortfolioService;


    @GetMapping("/quote")
    public QuoteResponse.QuoteData stockData(@RequestParam("symbol") String symbol) {
        return stockData.getStockQuote(symbol);
    }

    @GetMapping("/search")
    public List<SearchStockResponse.SearchStockResponseData> searchStocks(@RequestParam("query") String query) {
        return stockData.searchStock(query);
    }

    @PostMapping("/add/holding")
    public ResponseEntity<?> addUserHolding(@RequestBody AddHoldingRequest addHoldingRequest){
        CustomUserDetails userDetails =  (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        try {
            userPortfolioService.saveHolding(addHoldingRequest, userDetails.getUsername());
            return ResponseEntity.ok("Successfully added holding");
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Failed to add holding", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
