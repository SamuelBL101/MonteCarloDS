# Discrete Simulation Project

## Overview
This project implements a Monte Carlo based discrete simulation framework with multiple configurable strategies. 
The application consists of a simulation core, random generators, strategy implementations and a GUI for visualization and control of experiments.

## Architecture
The system is divided into frontend (GUI) and backend (simulation core).  
The core provides abstract simulation methods and is extended by multiple strategy classes that define the experiment logic.

### Simulation Core
The abstract simulation core defines lifecycle methods such as:
- beforeSim / afterSim
- beforeExperiment / afterExperiment
- simulate / experiment

It also supports pausing the simulation and reporting progress via callback functions.

### Random Generators
The project implements custom random generators:
- Uniform generators for discrete and continuous distributions
- Empirical generators based on cumulative probability arrays
- RandomSingleton for consistent seed management across experiments

These generators are used to model stochastic behavior in simulation experiments.

### Strategies
Five strategies (A–E) extend the simulation core and define different experiment scenarios.  
Each strategy initializes generators, runs replications and accumulates total cost metrics.  
Strategy E introduces a custom approach based on average delivery and demand values, optimizing overall costs.

## GUI and Visualization
The application includes a Swing-based GUI that allows users to:
- set number of replications and simulation parameters
- choose strategy A–E
- start/stop simulation execution
- visualize results using charts

Charts are dynamically updated during execution using JFreeChart.

## Validation of Generators
Random generators were validated using histogram analysis and Chi-square tests for:
- discrete uniform distribution
- empirical distribution
- continuous uniform distribution
- continuous empirical distribution

Results confirmed correctness of generated distributions.

## Results
Simulation experiments compared multiple strategies based on total costs.  
Results show that Strategy B performs best for the first scenario, while Strategy E provides the lowest overall cost in the second task.
