package org.daiict.model;

import lombok.Data;

@Data
public class AddHoldingRequest {
    String symbol;
    Float amount;
    Float purchasePrice;
}
