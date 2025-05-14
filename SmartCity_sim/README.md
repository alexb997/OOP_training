# 🌆 Smart City Simulation System

A modular and extensible simulation of a futuristic smart city powered by object-oriented programming and software design patterns. This project mimics the behavior of a real-time smart city where you can manage zones, track sensor events, simulate emergencies, and optimize energy and traffic—all from a command-line interface.

---

## 🎯 Features

- 🏙️ **Dynamic Zones**: Residential, Commercial, and Industrial zones with smart buildings and devices.
- 🌐 **IoT Sensors**: React to simulated events like fires, pollution spikes, or traffic jams.
- 🚒 **Emergency Services**: Dispatch and handle incidents via Command and Observer patterns.
- 🚗 **Traffic and Transport**: Simulate routes and delays using Strategy pattern.
- ⚡ **Smart Energy**: Buildings use multiple energy sources—solar, wind, grid.
- 🧠 **AI-like Logic**: Rules engine handles cascading effects (e.g., air purifier starts if pollution > threshold).
- 📊 **Reports**: Generate usage, traffic, or environmental reports using Streams API.
- 🗃️ **Optional DB Integration**: Persist and reload simulation state via embedded DB (H2 or SQLite).
- 🧪 **Testable Architecture**: Built with testing in mind using JUnit and integration layers.

---

## 🧱 Project Structure

org.example.smartcity
├── Main.java # Starts CLI and CityManager
├── cli/
│ └── CLIHandler.java # Parses and executes commands
├── city/
│ ├── SmartCity.java # Core controller
│ ├── Zone.java # Abstract base zone
│ ├── ResidentialZone.java # Zone types (Residential, Commercial, etc.)
│ ├── Building.java # Base building class
│ └── Device.java # IoT device base class
├── event/
│ ├── Sensor.java # Devices triggering events
│ ├── SensorEvent.java
│ └── EventDispatcher.java # Dispatches and logs events
├── strategy/
│ ├── routing/
│ │ └── RouteStrategy.java # BikeRoute, BusRoute, EmergencyRoute
│ └── energy/
│ └── EnergySource.java # Solar, Wind, Grid implementations
├── observer/
│ └── AlertObserver.java # Notifies buildings/devices during events
├── command/
│ └── CityCommand.java # EvacuateZoneCommand, ActivatePurifierCommand, etc.
├── service/
│ ├── CityManager.java # Singleton managing city state
│ ├── EventService.java
│ └── ReportingService.java

---

## 🕹️ Sample CLI Commands

```shell
> create zone ResidentialZone Downtown
> add building ResidentialZone:Downtown SmartApartment1
> attach device SmartApartment1 AirQualitySensor
> simulate event AirQualitySensor HIGH_PM2.5
> report zone Downtown
> evacuate zone Downtown
> power down zone Downtown

🧠 Applied Design Patterns
Pattern	Purpose
Strategy	Dynamic routing or energy usage logic
Observer	IoT sensor-triggered city-wide updates
Command	Queue and execute system-wide actions
Factory	Create zones/devices/buildings modularly
Singleton	Centralized city manager
Decorator	Add enhanced features to base devices

🧪 Testing
JUnit tests for core services (event handling, device status, routing).

Integration tests to simulate full day in the city.

Optional: Use mocking frameworks (e.g. Mockito) for isolated tests.

💾 Future Enhancements
Embed H2 or SQLite database for persistence.

Add citizen simulation with movement and preferences.

Implement a plugin architecture to extend the city with external modules.

Create a simple GUI frontend (JavaFX or web-based).

Simulated clock & event scheduler.

📚 Requirements
Java 17+

Maven or Gradle

(Optional) SQLite or H2 for persistence

JUnit 5 for testing