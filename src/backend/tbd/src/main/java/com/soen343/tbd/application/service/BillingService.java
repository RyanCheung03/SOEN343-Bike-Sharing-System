package com.soen343.tbd.application.service;

import com.soen343.tbd.application.dto.BillingHistoryResponse;
import com.soen343.tbd.domain.model.Bill;
import com.soen343.tbd.domain.model.Trip;
import com.soen343.tbd.domain.model.user.User;
import com.soen343.tbd.domain.repository.BillRepository;
import com.soen343.tbd.domain.repository.TripRepository;
import com.soen343.tbd.domain.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BillingService {

    private final BillRepository billRepository;
    private final TripRepository tripRepository;
    private final UserRepository userRepository;

    public BillingService(BillRepository billRepository, TripRepository tripRepository,
                          UserRepository userRepository) {
        this.billRepository = billRepository;
        this.tripRepository = tripRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public BillingHistoryResponse getAllBillingHistoryForUser(String userEmail) {
        // Fetch the user by email
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("No user found with email: " + userEmail));

        // Fetch all the trips associated with the user
        List<Trip> trips = tripRepository.findAllByUserId(user.getUserId());

        // Fetch all the bills associated with the user
        List<Bill> bills = billRepository.findAllByUserId(user.getUserId());

        // Create a map of bills by trip ID for easy lookup
        Map<Long, Bill> billByTripId = bills.stream()
                .collect(Collectors.toMap(
                        bill -> bill.getTripId().value(),
                        bill -> bill
                ));

        // Build the list of TripBillDTO objects
        List<BillingHistoryResponse.TripBillDTO> tripBills = trips.stream()
                .map(trip -> {
                    Bill bill = billByTripId.get(trip.getTripId().value());

                    // Get station names (handle null for trips in progress)
                    String startStationName = trip.getStartStationId() != null ?
                            "Station " + trip.getStartStationId().value() : "Unknown";
                    String endStationName = trip.getEndStationId() != null ?
                            "Station " + trip.getEndStationId().value() : "In Progress";

                    return new BillingHistoryResponse.TripBillDTO(
                            trip.getTripId().value(),
                            trip.getBikeId().value(),
                            startStationName,
                            endStationName,
                            trip.getStartTime(),
                            trip.getEndTime(),
                            Math.round(trip.calculateDurationInMinutes()),
                            bill != null ? bill.getBillId().value() : null,
                            bill != null ? bill.getStatus().name() : "PENDING",
                            trip.getPricingStrategy() != null ? trip.getPricingStrategy().getPricingTypeName() : "Standard Bike Pricing",
                            trip.getPricingStrategy() != null ? trip.getPricingStrategy().getBaseFee() : 0.0,
                            trip.getPricingStrategy() != null ? trip.getPricingStrategy().getPerMinuteRate() : 0.0,
                            bill != null ? bill.getCost() : 0.0
                    );
                })
                .collect(Collectors.toList());

        // Calculate total amount spent
        Double totalAmountSpent = bills.stream()
                .mapToDouble(Bill::getCost)
                .sum();

        // Build and return the response
        return new BillingHistoryResponse(
                user.getEmail(),
                user.getFullName(),
                totalAmountSpent,
                trips.size(),
                tripBills
        );
    }
}
