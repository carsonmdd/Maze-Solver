import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class MazeGenerator {
    
    private Cell[][] maze;
    private final int rows;
    private final int cols;

    public MazeGenerator(int rows, int cols) {
        maze = new Cell[rows][cols];
        this.rows = rows;
        this.cols = cols;
        initializeCells();
    }

    public void generateMaze() {
        // Utilizes a DFS algorithm to generate a random maze by removing walls between cells

        // Does not generate the maze if the rows or columns are zero
        if (rows == 0 || cols == 0) {
            return;
        }
        // Randomized iterative depth first search algorithm
        Deque<Cell> stack = new LinkedList<>();
        maze[0][0].setVisited(true);
        stack.push(maze[0][0]);
        while (!stack.isEmpty()) {
            Cell current = stack.pop();
            List<Cell> unvisitedNeighbors = getUnvisitedNeighbors(current);
            if (!unvisitedNeighbors.isEmpty()) {
                stack.push(current);
                Cell random = unvisitedNeighbors.get(new Random().nextInt(unvisitedNeighbors.size()));
                removeWall(current.getCoords(), random.getCoords());
                random.setVisited(true);
                stack.push(random);
            }
        }
    }

    public Cell[][] getMaze() {
        // Returns the maze

        return maze;
    }

    private void removeWall(int[] coords1, int[] coords2) {
        // Removes the wall between two cells

        if (coords2[0] == coords1[0] - 1) {
            // Case: coords2 is north of coords1
            maze[coords1[0]][coords1[1]].setNorthWall(false);
            maze[coords2[0]][coords2[1]].setSouthWall(false);
        } else if (coords2[1] == coords1[1] + 1) {
            // Case: coords2 is east of coords1
            maze[coords1[0]][coords1[1]].setEastWall(false);
            maze[coords2[0]][coords2[1]].setWestWall(false);
        } else if (coords2[0] == coords1[0] + 1) {
            // Case: coords2 is south of coords1
            maze[coords1[0]][coords1[1]].setSouthWall(false);
            maze[coords2[0]][coords2[1]].setNorthWall(false);
        } else {
            // Case: coords2 is west of coords1
            maze[coords1[0]][coords1[1]].setWestWall(false);
            maze[coords2[0]][coords2[1]].setEastWall(false);
        }
    }

    private List<Cell> getUnvisitedNeighbors(Cell c) {
        // Returns a list of the unvisited neighbors of the given cell c

        List<Cell> unvisitedNeighbors = new ArrayList<>();
        int[] coords = c.getCoords();
        int row = coords[0];
        int col = coords[1];

        // Check north neighbor
        if (row-1 >= 0 && !maze[row-1][col].isVisited()) {
            unvisitedNeighbors.add(maze[row-1][col]);
        }

        // Check east neighbor
        if (col+1 <= cols-1 && !maze[row][col+1].isVisited()) {
            unvisitedNeighbors.add(maze[row][col+1]);
        }

        // Check south neighbor
        if (row+1 <= rows-1 && !maze[row+1][col].isVisited()) {
            unvisitedNeighbors.add(maze[row+1][col]);
        }

        //Check west neighbor
        if (col-1 >= 0 && !maze[row][col-1].isVisited()) {
            unvisitedNeighbors.add(maze[row][col-1]);
        }

        return unvisitedNeighbors;
    }

    private void initializeCells() {
        // Fills the maze with new cell objects
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j] = new Cell(new int[] {i, j});
            }
        }
    }

}
