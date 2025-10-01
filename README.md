# Educational Initiatives Assignment

A comprehensive Java project demonstrating software engineering principles through two main exercises: Design Patterns implementation and a real-world application using multiple design patterns.

## Project Structure

```
educational-initiatives/
├── .git/                    # Git version control directory
├── .vscode/                 # VS Code configuration files
├── build/                   # Compiled output directory
├── Exercise1/               # Design Patterns Implementation
│   ├── BehavioralDP/        # Behavioral Design Patterns
│   │   ├── Observer/        # Observer Pattern Implementation
│   │   └── Strategy/        # Strategy Pattern Implementation
│   ├── CreationalDP/        # Creational Design Patterns
│   │   ├── Factory/         # Factory Pattern Implementation
│   │   └── Singleton/       # Singleton Pattern Implementation
│   └── StructuralDP/        # Structural Design Patterns
│       ├── adapter/         # Adapter Pattern Implementation
│       └── decorator/       # Decorator Pattern Implementation
└── Exercise2/               # Real-world Application
    └── astranautScheduler/  # Astronaut Daily Schedule Organizer
        ├── exception/       # Custom exception classes
        ├── factory/         # Factory pattern for task creation
        ├── manager/         # Core scheduling management logic
        ├── model/           # Data models
        ├── observer/        # Observer pattern for notifications
        └── Main.java        # Application entry point
```

## Exercise 1: Design Patterns Implementation

### Behavioral Design Patterns

#### Observer Pattern (`Exercise1/BehavioralDP/Observer/`)

Implements the Observer pattern through an auction bidding system where bidders are notified of new bids.

- **`AuctionDemo.java`** - Main demonstration class showing the Observer pattern in action
- **`Auctioneer.java`** - Interface defining observer management methods (register, remove, notify)
- **`Bidder.java`** - Observer interface that bidders implement to receive updates
- **`LiveAuctioneer.java`** - Concrete subject that maintains bid state and notifies observers
- **`RegisteredBidder.java`** - Concrete observer that receives bid notifications

**Package**: `Exercise1.BehavioralDP.Observer`

#### Strategy Pattern (`Exercise1/BehavioralDP/Strategy/`)

Demonstrates the Strategy pattern through a shipping cost calculation system with different shipping strategies.

- **`CheckoutDemo.java`** - Main demonstration class showing different shipping strategies
- **`ShippingStrategy.java`** - Strategy interface defining the calculation method
- **`StandardShipping.java`** - Concrete strategy for standard shipping costs ($2.50/kg)
- **`ExpressShipping.java`** - Concrete strategy for express shipping costs ($4.75/kg)
- **`ShoppingCart.java`** - Context class that uses different shipping strategies

**Package**: `Exercise1.BehavioralDP.Strategy`

### Creational Design Patterns

#### Factory Pattern (`Exercise1/CreationalDP/Factory/`)

Implements the Factory pattern for creating platform-specific UI components.

- **`DialogFactory.java`** - Abstract factory interface for creating UI components
- **`Button.java`** - Abstract product interface for buttons
- **`MacDialog.java`** - Concrete factory for macOS components
- **`MacButton.java`** - Concrete macOS button implementation
- **`WindowsDialog.java`** - Concrete factory for Windows components
- **`WindowsButton.java`** - Concrete Windows button implementation

#### Singleton Pattern (`Exercise1/CreationalDP/Singleton/`)

Demonstrates the Singleton pattern through an application configuration manager.

- **`ConfigDemo.java`** - Main demonstration class showing Singleton usage
- **`AppConfig.java`** - Singleton class for managing application configuration

### Structural Design Patterns

#### Adapter Pattern (`Exercise1/StructuralDP/adapter/`)

Shows the Adapter pattern by integrating a new payment gateway with an existing payment processor interface.

- **`PaymentDemo.java`** - Main demonstration class showing adapter usage
- **`PaymentProcessor.java`** - Target interface that client expects
- **`NewPaymentGateway.java`** - Adaptee class with incompatible interface
- **`GatewayAdapter.java`** - Adapter that makes NewPaymentGateway compatible with PaymentProcessor

#### Decorator Pattern (`Exercise1/StructuralDP/decorator/`)

Implements the Decorator pattern for a pizza ordering system with dynamic toppings.

- **`PizzaShop.java`** - Main demonstration class showing decorator usage
- **`Pizza.java`** - Component interface for all pizza objects
- **`PlainPizza.java`** - Concrete component representing a basic pizza
- **`ToppingDecorator.java`** - Abstract decorator class for pizza toppings
- **`CheeseDecorator.java`** - Concrete decorator for cheese topping
- **`VeggieDecorator.java`** - Concrete decorator for vegetable topping

## Exercise 2: Astronaut Daily Schedule Organizer

A comprehensive console-based application for managing astronaut daily schedules, demonstrating multiple design patterns working together.

### Core Application (`Exercise2/astranautScheduler/`)

#### Main Application

- **`Main.java`** - Entry point with console interface for user interaction
  - Provides commands: add, remove, view, help, exit
  - Handles user input and error management
  - Integrates all components together

#### Data Models (`model/`)

- **`Task.java`** - Core data model representing a scheduled task
  - Properties: description, start time, end time, priority
  - Implements time conflict detection logic

#### Schedule Management (`manager/`)

- **`ScheduleManager.java`** - Core business logic using Singleton pattern
  - Manages task collection and scheduling logic
  - Handles task conflicts and validation
  - Integrates with observer pattern for notifications

#### Task Creation (`factory/`)

- **`TaskFactory.java`** - Factory pattern for creating Task objects
  - Validates input parameters
  - Creates properly initialized Task instances
  - Centralizes task creation logic

#### Exception Handling (`exception/`)

- **`TaskConflictException.java`** - Custom exception for scheduling conflicts
  - Thrown when tasks have overlapping time slots
  - Provides detailed conflict information

#### Notification System (`observer/`)

Observer pattern implementation for conflict notifications:

- **`ConflictNotifier.java`** - Subject that manages conflict observers
- **`ConflictListener.java`** - Observer interface for conflict notifications
- **`UserNotifier.java`** - Concrete observer that displays conflict messages to users

## Design Patterns Used

### Exercise 1

- **Observer Pattern**: Auction bidding notification system
- **Strategy Pattern**: Shipping cost calculation strategies
- **Factory Pattern**: Platform-specific UI component creation
- **Singleton Pattern**: Application configuration management
- **Adapter Pattern**: Payment gateway integration
- **Decorator Pattern**: Dynamic pizza topping system

### Exercise 2

- **Singleton Pattern**: ScheduleManager ensures single instance
- **Factory Pattern**: TaskFactory for creating Task objects
- **Observer Pattern**: ConflictNotifier system for user notifications
- **Custom Exception Handling**: TaskConflictException for conflict management

## How to Compile and Run

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Command line access

### Exercise 1 - Design Patterns

Navigate to the root directory and compile all patterns:

```bash
# Compile Observer Pattern
cd Exercise1/BehavioralDP/Observer
javac *.java
cd ../../../
java Exercise1.BehavioralDP.Observer.AuctionDemo

# Compile Strategy Pattern
cd Exercise1/BehavioralDP/Strategy
javac *.java
cd ../../../
java Exercise1.BehavioralDP.Strategy.CheckoutDemo

# Similar process for other patterns...
```

### Exercise 2 - Astronaut Scheduler

```bash
# Compile the entire application
cd Exercise2/astranautScheduler
javac *.java */*.java

# Run the application
cd ../../
java Exercise2.astranautScheduler.Main
```

### Usage Example for Astronaut Scheduler

```
Astronaut Daily Schedule Organizer
> add "Morning Exercise" 07:00 08:00 High
Task added successfully. No conflicts.

> add "Team Meeting" 07:30 08:30 Medium
Task added successfully. Conflicts with: [Morning Exercise (07:00-08:00, High)]

> view
Scheduled Tasks:
Morning Exercise (07:00-08:00, High)
Team Meeting (07:30-08:30, Medium)

> remove "Morning Exercise"
Task removed successfully.

> exit
```

## Key Features

### Exercise 1

- Clean implementation of 6 major design patterns
- Proper package structure and organization
- Comprehensive demonstration of each pattern's use case
- Well-documented code with clear examples

### Exercise 2

- Interactive console-based user interface
- Real-time conflict detection and notification
- Robust error handling and input validation
- Multiple design patterns working together seamlessly
- Proper separation of concerns and modular architecture

## Learning Objectives

This project demonstrates:

- **Design Pattern Implementation**: Practical application of Gang of Four design patterns
- **Software Architecture**: Proper package organization and modular design
- **Error Handling**: Custom exceptions and graceful error management
- **User Interface Design**: Console-based interaction patterns
- **Code Organization**: Clear separation of concerns and responsibilities
- **Best Practices**: Proper naming conventions, documentation, and code structure

## Author

Soham Gandhi  
Educational Initiatives Assignment  
Date: September 2025
