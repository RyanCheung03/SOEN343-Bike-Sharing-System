package com.soen343.tbd.application.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.ArrayList;

import com.soen343.tbd.application.dto.PricingPlanDTO;

@RestController
@RequestMapping("/api/pricing")
public class PricingController {

    @GetMapping("/plan")
    public List<PricingPlanDTO> getPricingPlans() {
        List<PricingPlanDTO> plans = new ArrayList<>();
        plans.add(new PricingPlanDTO("Basic", 1.0, 0.15, 0.0));
        plans.add(new PricingPlanDTO("E-Bike", 1.0, 0.15, 0.05));
        return plans;
    }
}
