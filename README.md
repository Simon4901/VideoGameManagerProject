#Video Game Manager

The Video Game Manager is a Java desktop application that allows users to manage a collection of video games.  
It was developed as part of a university project to practice object-oriented programming and GUI development with Java Swing.

#Features

- Add video games to a library
- Display all stored games in a formatted list
- Sort games by different attributes (e.g. name, price, metascore)
- Choose sorting order (A–Z, Z–A, High-to-Low, Low-to-High)
- Automatically calculate the total price of all games
- Simple and clear graphical user interface

#Project Concept

The application separates data logic from user interface logic:

- Game data is stored and managed in a dedicated class
- The graphical user interface handles user input and output
- The UI interacts with the data layer using methods

#Project Structure

- Games
  - Represents a single video game
  - Stores attributes such as name, USK, genre, metascore, number of players, and price
  - Contains methods for adding games, formatting output, and calculating the total price

- GameManagerUI
  - Handles the graphical user interface
  - Contains buttons, text fields, combo boxes, and a text area
  - Uses the `Games` class to manage and display data

- JFrame
  - The UI class extends `JFrame` to create the application window
