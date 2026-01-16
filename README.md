---

## 📌 Project Context & Contributions

This repository is a fork of a **Concordia University (SOEN 343) group project** completed during Fall 2025 with a team of 6 students.

**My individual contributions include:**
- Designed the backend **project folder structure** and enforced a **layered architecture** (controller, service, persistence layers)
- Designed and implemented the **billing domain logic** using the **Strategy pattern** to support flexible pricing models
- Implemented end-to-end **billing computation workflows**, triggered upon trip completion and exposed via backend APIs
- Designed and implemented **PostgreSQL schemas**, tables, relationships, and primary/foreign keys
- Applied **repository and adapter patterns** to isolate persistence logic and manage database transactions
- Built the **billing history and payment workflow**, enabling users to view and settle past bills
- Wrote the majority of **unit tests** using **JUnit, Mockito, and AssertJ**, ensuring service-layer correctness
- Implemented structured **application logging** to improve observability and debugging

The project was developed collaboratively. This fork is maintained to showcase my personal contributions.


# The Bikers’ Dream – Interactive Bike Sharing Web App
SOEN 343 Project ( Concordia University - Fall 2025 )

**The Bikers’ Dream** is a modern, secure, and interactive bike-sharing web application that delivers **real-time station updates, seamless rentals, transparent billing, and role-based management**.

The application combines a **responsive React frontend**, a **Java Spring Boot backend**, and a **PostgreSQL relational database** to provide a reliable, production-ready experience for riders, operators, and administrators. It simulates a real-world bike-sharing platform similar to BIXI and follows a **layered architecture** (presentation, service, and persistence layers), emphasizing **scalability, data integrity, maintainability, and clean system design**.


---

## Team Members
| GitHub Username | Full Name           | Student ID |
|-----------------|------------------|-----------|
| @masspaol       | Massimo Paolini   | 40280323  |
| @elif5446       | Elif Sag Sesen    | 40283343  |
| @afkcya         | Ya Yi (Yuna) Chen | 40286042  |
| @RyanCheung03   | Ryan Cheung       | 40282200  |
| @ammarranko     | Ammar Ranko       | 40281232  |
| @nicoledesigns  | Nicole Antoun     | 40284018  |


---

## ✨ Key Features

### 🗺️ Interactive Station Map
- Real-time visualization of bike stations using **Leaflet**
- Live station status (active/inactive)
- Dock-level availability (empty, available, reserved)
- Visual indicators for:
  - Available bikes
  - Reserved bikes
  - E-bikes vs standard bikes
 
    
 <img width="959" height="866" alt="image" src="https://github.com/user-attachments/assets/18fbff05-91f4-448a-9932-cb1fa518ef1e" />


### 🚴 Bike Rental & Reservation
- Reserve bikes directly from the map
- Rent bikes instantly if available
- Return bikes to any compatible station
- Real-time rental state tracking

<img width="1225" height="747" alt="image" src="https://github.com/user-attachments/assets/d9a7148f-72a6-4437-923a-d325d8b09efd" />


### 🔐 Role-Based User Experience
- **Riders**: rent, reserve, return bikes, view trips & billing
- **Admins / Operators**:
  - Monitor station occupancy and maintenance 
  - Track rentals and reservations
  - View system-wide trip and billing history
 
<img width="1087" height="892" alt="image" src="https://github.com/user-attachments/assets/bbab596c-7fd3-441e-b052-ab59aefc6b1f" />


### 📊 Trip History & Search
- Detailed trip history per user
- Filter trips by:
  - Trip ID
  - Date range
  - Bike type
- View start/end stations, duration, and bike details

  <img width="1074" height="557" alt="image" src="https://github.com/user-attachments/assets/670ef2f2-7964-4252-9286-b768afda2cae" />


### 💳 Transparent Billing System
- Automatic bill generation after each ride
- Pricing plans:
  - **Standard Bike**
  - **E-Bike**
- Breakdown includes:
  - Base fee
  - Per-minute rate
  - Total cost
- Pending and paid bill tracking
- Account summary with total trips & outstanding balance

<img width="1210" height="793" alt="image" src="https://github.com/user-attachments/assets/ff8553d1-ac4a-4eda-98e8-b38c0ebb873c" />



---

## Requirements
Before running the application, ensure you have the following installed:

- **JDK**: version 25  
- **Maven**: version 3.5.6  
- **Node.js & npm** (for React frontend)  

---

## Running the Application

1. **Open two terminal windows**:
   - One for the frontend  
   - One for the backend  

2. **Backend Setup** (in the backend terminal):
   ```bash
   cd backend/tbd
   mvn clean install    # Run this only if new dependencies were added
   mvn spring-boot:run
3. **Frontend Setup** (in the frontend terminal):
   ```bash
   cd frontend
   npm install          # Run this only if new dependencies were added
   npm start
4. Once both backend and frontend are running, the application will be available in your browser at the default React port <code>http://localhost:3000</code>.
