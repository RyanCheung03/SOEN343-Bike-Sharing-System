import "./Pricing.css";
import React, { useEffect, useState } from "react";
import axios from "axios";

const Pricing = () => {
  const [plans, setPlans] = useState([]);
  const [costs, setCosts] = useState(null);

  useEffect(() => {
    const fetchPricingData = async () => {
      try {
        // Fetch available pricing plans
        const plansResp = await axios.get("/api/pricing/plan");

        // Example: make POST requests to calculate a 30-min trip
        const standardResp = await axios.post("/api/pricing/calculate", {
          bikeId: 1,
          startTime: new Date("2025-11-03T12:00:00Z"),
          endTime: new Date("2025-11-03T12:30:00Z"),
        });

        const eBikeResp = await axios.post("/api/pricing/calculate", {
          bikeId: 2,
          startTime: new Date("2025-11-03T12:00:00Z"),
          endTime: new Date("2025-11-03T12:30:00Z"),
        });

        setPlans(plansResp.data);
        setCosts({
          standard: standardResp.data,
          eBike: eBikeResp.data,
        });
      } catch (error) {
        console.error("Error fetching pricing:", error);
      }
    };

    fetchPricingData();
  }, []);

  if (!costs || plans.length === 0) return <p>Loading pricing...</p>;

  return (
    <div className="pricing-container">
      <h1>Pricing Plans</h1>
      <p>Compare our available ride options:</p>

      <div className="pricing-cards">
        {plans.map((plan) => (
          <div className="pricing-card" key={plan.planType}>
            <h2>{plan.planType}</h2>
            <p>{plan.description}</p>
            <ul>
              <li>
                <strong>Base Fee:</strong> ${plan.baseFee.toFixed(2)}
              </li>
              <li>
                <strong>Per-Minute Rate:</strong> ${plan.perMinuteRate.toFixed(2)}
              </li>
            </ul>

            {plan.planType === "STANDARD" && (
              <p>
                <strong>Example 30-min Trip:</strong> ${costs.standard.toFixed(2)}
              </p>
            )}
            {plan.planType === "EBIKE" && (
              <p>
                <strong>Example 30-min Trip:</strong> ${costs.eBike.toFixed(2)}
              </p>
            )}
          </div>
        ))}
      </div>

      <p className="pricing-note">
        *Trips are billed based on duration. E-bikes include an additional per-trip surcharge.
      </p>
    </div>
  );
};

export default Pricing;
