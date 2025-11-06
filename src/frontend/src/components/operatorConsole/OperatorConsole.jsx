import React, { useState, useEffect } from "react";
import "./OperatorConsole.css";

const OperatorConsole = ({ operatorEvents = [] }) => {
  // debuggings
  useEffect(() => {
    console.log("Operator Console - Current events:", operatorEvents);
    if (operatorEvents.length > 0) {
      console.log("Latest event:", operatorEvents[0]);
    }
  }, [operatorEvents]);

  return (
    <div className="operator-console">
      <h3 className="console-title">Events Console</h3>
      <div className="event-list">
        {operatorEvents.length > 0 ? (
          operatorEvents.map((event, index) => (
            <div key={index} className="event-item">
              <div className="event-header">
                <span className="timestamp">
                  {new Date(event.timestamp).toLocaleTimeString()}
                </span>
                <span className="user">{event.userEmail}</span>
              </div>
              <div className="event-body">
                <strong>
                  {event.entityType} {event.action}
                </strong>
                <div className="event-description">{event.description}</div>
                {event.previousStatus && (
                  <div className="status-change">
                    Status: {event.previousStatus} → {event.newStatus}
                  </div>
                )}
              </div>
            </div>
          ))
        ) : (
          <div className="no-events">
            <p>No events to display</p>
            <p className="helper-text">
              System events will appear here in real-time
            </p>
          </div>
        )}
      </div>
    </div>
  );
};

export default OperatorConsole;
