# Maze-Solver
## Basic Overview
This application generates a random maze of provided dimensions and finds the solution path from the start to the end of the maze.
## Features
- Generate a random maze
- Solve a given maze
- Draw a given maze by printing characters to the terminal
## Class Breakdown
**Cell**
- Represents a single cell of a maze

**MazeGenerator**
- Generates a randomized maze with the provided rows and columns

**MazeSolver**
- Solves a given maze by marking which cells belong to the solution path

**MazeDrawer**
- Prints the given maze to the terminal

**Maze**
- Higher-level class that represents a maze
- Generates the maze upon initialization
- Can solve and draw the maze

**MazeMain**
- Consists of a main method with a simple example to run the program

## Algorithms Used
- A randomized iterative depth first search algorithm is used to generate the maze
- An iterative breadth first search algorithm is used to solve the maze

## Inspiration
After learning various algorithms and data structures in my classes, I wanted to put my new skills to the test and combine them in a meaningful way. I found uses for the two commonly-used search algorithms depth first search and breadth first search within maze generation and maze solving respectively. Throughout the program, I was also able to practice using a variety of data structures such as the stack, queue, map, and various lists.

## Reflection
Unlike class projects, this project required careful thought for planning rather than solely for implementation. I learned much more about overall design choices in addition to the more syntactical design choices I usually focus on in my classes. As I originally intended, I also gained a deeper understanding of the algorithms I had learned, as I had to know how to make adjustments to them to suit my application.
