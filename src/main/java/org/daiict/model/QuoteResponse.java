package org.daiict.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuoteResponse {
    @JsonProperty("Global Quote")
    private QuoteData quoteData;

    @Getter
    @Setter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class QuoteData {
        @JsonProperty("01. symbol")
        private String symbol;
        @JsonProperty("02. open")
        private String open;
        @JsonProperty("03. high")
        private String high;
        @JsonProperty("04. low")
        private String low;
        @JsonProperty("05. price")
        private String price;
        @JsonProperty("06. volume")
        private String volume;
        @JsonProperty("07. latest trading day")
        private String latestTradingDay;
        @JsonProperty("08. previous close")
        private String previousClose;
        @JsonProperty("09. change")
        private String change;
        @JsonProperty("10. change percent")
        private String changePercent;
    }
}
