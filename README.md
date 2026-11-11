# Factory Robot Hazard Analyzer

## Overview

Factory Robot Hazard Analyzer is a Java-based application that evaluates the hazard risk score of a factory robot based on arm precision, worker density, and machinery state.

The project demonstrates Object-Oriented Programming concepts, exception handling, SOLID principles, clean code practices, and design patterns.

## Technologies Used

- Java 17
- Maven
- JUnit 5
- Git
- GitHub
- IntelliJ IDEA

## Functional Requirements

The application evaluates robot hazard risk using:

- Arm Precision
- Worker Density
- Machinery State

### Hazard Risk Formula

```
Hazard Risk = ((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor)
```

### Machinery Risk Factors

| Machinery State | Risk Factor |
|-----------------|-------------|
| Worn            | 1.3         |
| Faulty          | 2.0         |
| Critical        | 3.0         |

## Concepts Demonstrated

- Classes and Objects
- Encapsulation
- Abstraction
- Exception Handling
- Custom Exceptions
- SOLID Principles
- DRY, KISS and YAGNI
- Design Patterns
- Unit Testing with JUnit 5

## Project Development

The project is developed incrementally using separate Git feature branches for each use case.

### Branch Structure

| Branch | Purpose |
|--------|---------|
| `main` | Project documentation |
| `develop` | Integrated development branch |
| `feature/UC1-display-static-message` | UC1: Display static message |
| `feature/UC2-accept-inputs` | UC2: Accept inputs |
| `feature/UC3-calculate-hazard-risk` | UC3: Calculate hazard risk |
| `feature/UC4-input-validation` | UC4: Input validation |
| `feature/UC5-refactor-validation` | UC5: Refactor validation |
| `feature/UC6-custom-exception` | UC6: Custom exception |
| `feature/UC7-machinery-risk-mapping` | UC7: Machinery risk mapping |
| `feature/UC8-modular-oops-design` | UC8: Modular OOPS design |

Each completed feature branch is merged into the `develop` branch after implementation and testing.
