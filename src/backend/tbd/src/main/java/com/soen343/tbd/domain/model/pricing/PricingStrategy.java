package com.soen343.tbd.domain.model.pricing;

public interface PricingStrategy {
    double calculateCost(long durationMinutes);
}

