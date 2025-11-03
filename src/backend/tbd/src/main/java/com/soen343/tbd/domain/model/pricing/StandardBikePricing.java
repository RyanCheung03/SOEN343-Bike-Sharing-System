package com.soen343.tbd.domain.model.pricing;

public class StandardBikePricing implements PricingStrategy {
    private static final double BASE_FEE = 1.0;
    private static final double COST_PER_MINUTE = 0.5;

    @Override
    public double calculateCost(long durationMinutes) {
        return BASE_FEE + (durationMinutes * COST_PER_MINUTE);
    }
}
