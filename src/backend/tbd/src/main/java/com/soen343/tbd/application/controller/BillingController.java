package com.soen343.tbd.application.controller;

import com.soen343.tbd.application.dto.BillingHistoryResponse;
import com.soen343.tbd.application.service.BillingService;
import com.soen343.tbd.application.service.CurrentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

    @Autowired
    private BillingService billingService;

    @Autowired
    private CurrentUserService currentUserService;

    /**
     * Get the billing history for the currently authenticated user.
     */
    @GetMapping("/user/history")
    public ResponseEntity<BillingHistoryResponse> getUserBillingHistory() {
        // Get the current authenticated user's email from JWT token
        String userEmail = currentUserService.getCurrentUserEmail();

        if (userEmail == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        try {
            BillingHistoryResponse response = billingService.getAllBillingHistoryForUser(userEmail);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

