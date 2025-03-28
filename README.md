# Game Of Life

The **Game Of Life** is a classic cellular automaton devised by mathematician John Conway in 1970. This project is a JavaFX implementation that simulates the evolution of a grid of cells based on a few simple rules. Despite its simplicity, the Game Of Life demonstrates how complex patterns can emerge from simple rules—a phenomenon that has fascinated scientists, programmers, and enthusiasts for decades.

---

## Table of Contents

- [Overview](#overview)
- [History](#history)
- [Features](#features)
- [Installation](#installation)
- [Usage](#usage)
- [Code Structure](#code-structure)
- [Development History](#development-history)
- [Contributing](#contributing)
- [License](#license)
- [Acknowledgements](#acknowledgements)

---

## Overview

This project simulates the evolution of a grid of cells where each cell can be either alive or dead. The simulation progresses in discrete time steps, referred to as generations, with the state of each cell in the next generation determined by its current state and the number of live neighbors it has. The JavaFX framework is used to render the grid on a graphical canvas, animate the changes, and provide user controls such as speed adjustment and pause/resume functionality.

---

## History

The Game Of Life was originally conceived by John Horton Conway, and it quickly became an iconic example of how complex behaviors can emerge from simple, local interactions. This project draws inspiration from Conway's original concept and serves as both an educational tool and a demonstration of modern JavaFX capabilities.

- **1970 – Conway's Creation:** John Conway introduced the Game Of Life, which captivated the attention of mathematicians and computer scientists due to its ability to simulate life-like behaviors with minimal rules.
- **Evolution in Programming:** Over the years, the Game Of Life has been implemented in various programming languages and environments, each iteration exploring optimizations and new features.
- **Modern JavaFX Implementation:** This particular version leverages JavaFX to provide a smooth, interactive user interface, complete with timeline animations, adjustable simulation speed, and graphical rendering using the Canvas API.

This README outlines not only how to use the current implementation but also gives insight into its historical context and evolution from a simple idea into a full-fledged simulation application.

---

## Features

- **Graphical User Interface (GUI):**  
  Utilizes JavaFX for rendering the simulation on a Canvas, providing a dynamic and interactive user experience.

- **Generational Updates:**  
  Uses a `Timeline` to automatically update the state of the grid, progressing through generations of the simulation.

- **Customizable Simulation Speed:**  
  Includes a slider control that allows users to adjust the speed of the simulation in real-time.

- **Pause and Resume Functionality:**  
  Offers buttons to pause and resume the simulation, giving users control over the execution flow.

- **Randomized Genesis State:**  
  The initial state of the board is randomized, with a configurable probability for each cell to be alive, ensuring unique starting conditions for each simulation run.

- **Efficient Rendering:**  
  The board is rendered by a custom `Board` class that extends JavaFX's `Canvas`, ensuring a smooth drawing process even for large grids.

---

## Installation

To run this project, ensure that you have the following installed on your system:

- **Java Development Kit (JDK) 8 or later:**  
  The application is built using Java and requires the JDK to compile and run.

- **JavaFX Library:**  
  JavaFX is used for the GUI and animation. Depending on your JDK version, you might need to download and configure the JavaFX SDK separately.

### Steps to Compile and Run

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/yourusername/GameOfLife.git
   cd GameOfLife
   ```

2. **Compile the Source Code:**

   Use your favorite IDE (like IntelliJ IDEA or Eclipse) that supports JavaFX, or compile via the command line:

   ```bash
   javac -d out -cp "path/to/javafx/lib/*" src/com/life/lifegame/*.java
   ```

3. **Run the Application:**

   ```bash
   java -cp "out:path/to/javafx/lib/*" com.life.lifegame.GameOfLife
   ```

   Ensure that you replace `path/to/javafx/lib/*` with the actual path to your JavaFX library.

---

## Usage

When you launch the application, the following components are available:

- **Simulation Canvas:**  
  The main area where the grid of cells is displayed. Live cells are rendered in a distinct color (WHEAT), while dead cells appear in black.

- **Generation Counter:**  
  A label that displays the current generation number, updating as the simulation progresses.

- **Control Buttons:**
    - **Stop:** Pauses the simulation.
    - **Resume:** Continues the simulation after it has been paused.

- **Speed Slider:**  
  Adjusts the rate at which the simulation advances through generations. The speed is indicated by a label that updates in real-time with the slider's value.

---

## Code Structure

The project is structured into two primary classes:

### 1. GameOfLife (Main Application)
- **Entry Point:**  
  Contains the `main` method which launches the JavaFX application.
- **Initialization:**  
  The `start` method initializes the board with a random genesis state and sets up the primary UI components.
- **Simulation Logic:**  
  Implements the core logic of Conway’s Game Of Life:
    - **Generation Update:**  
      The `nextGeneration` method calculates the next state of the board based on the current configuration.
    - **Neighbor Counting:**  
      The `countLiveNeighbors` method checks adjacent cells to determine how many live neighbors a cell has.
- **Animation:**  
  A `Timeline` is used to create an animation loop, updating the board every 200 milliseconds.

### 2. Board (Canvas Rendering)
- **Canvas Extension:**  
  Inherits from JavaFX's `Canvas` class to handle drawing operations.
- **Rendering Logic:**  
  The `drawBoard` method iterates over the 2D boolean array and renders each cell with appropriate color coding.

---

## Development History

This implementation represents a modern take on a long-standing simulation tradition:

- **Initial Version:**  
  The first versions focused on implementing the basic rules of cellular automata with a simple, console-based output.
- **Graphical Upgrade:**  
  Transitioning to JavaFX allowed for a richer, interactive experience. The introduction of a graphical board, along with real-time updates, made the simulation more accessible and visually appealing.
- **User Controls Enhancement:**  
  Recent iterations have introduced user controls such as pause/resume functionality and adjustable simulation speed, making it easier to experiment with different configurations and observe emergent behaviors.

The evolution of this project mirrors the historical growth of the Game Of Life concept—from an abstract mathematical curiosity to a widely appreciated tool for demonstrating complexity and emergent phenomena.

---

## Contributing

Contributions to this project are welcome! If you’d like to contribute:

1. **Fork the Repository:**  
   Create your own fork on GitHub.
2. **Create a Feature Branch:**  
   Develop your feature or bug fix on a separate branch.
3. **Submit a Pull Request:**  
   Once your changes are ready, submit a pull request for review.

Please ensure that your contributions follow the coding style and include relevant tests or documentation as needed.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

## Acknowledgements

- **John Conway:**  
  For creating the Game Of Life and inspiring generations of programmers and mathematicians.
- **JavaFX:**  
  For providing a robust framework to build interactive GUI applications.
- **The Open Source Community:**  
  For numerous contributions and discussions that have advanced the understanding and implementation of cellular automata.

---

Enjoy exploring the fascinating world of cellular automata and the emergent behaviors that arise from simple rules!
```