package com.samsung.airbnb.strategy;

import com.samsung.airbnb.entity.Inventory;
import java.math.BigDecimal;

public interface PricingStrategy {

    BigDecimal calculatePrice(Inventory inventory);
}
