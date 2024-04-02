import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class MazeSolver {
    
    private Cell[][] maze;
    private final int rows;
    private final int cols;
    Map<Cell, Cell> parentMap = new HashMap<>();

    public MazeSolver(Cell[][] maze) {
        this.maze = maze;
        rows = maze.length;
        if (rows == 0) {
            cols = 0;
        } else {
            cols = maze[0].length;
        }
        resetVisited();
    }

    public void solveMaze() {
        // Utiliazes a BFS algorithm to solve the maze by marking which cells belong to the solution path

        // Does not solve the maze if the rows or columns are zero
        if (rows == 0 || cols == 0) {
            return;
        }
        // Iterative breadth first search algorithm 
        Queue<Cell> queue = new LinkedList<>();
        queue.add(maze[0][0]);
        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                if (current.equals(maze[maze.length-1][maze[0].length-1])) {
                    break;
                }
                List<Cell> neighbors = getUnvisitedNeighbors(current);
                for (Cell neighbor : neighbors) {
                    queue.add(neighbor);
                    parentMap.put(neighbor, current);
                }
            }
        }

        createSolutionPath();
    }

    private void createSolutionPath() {
        // Traces back cells to their parents along the solution path and marks them as part of the solution

        // Does not create the solution path if the maze is 1x1 or the rows or columns are zero
        if (rows == 1 && cols == 1 || rows == 0 || cols == 0) {
            return;
        }

        Cell startCell = maze[0][0];
        Cell endCell = maze[maze.length-1][maze[0].length-1];

        startCell.setSolution();
        endCell.setSolution();

        Cell current = parentMap.get(endCell);
        while (!current.equals(startCell)) {
            current.setSolution();
            current = parentMap.get(current);
        }
    }

    private List<Cell> getUnvisitedNeighbors(Cell c) {
        // Returns a list of the unvisited neighbors not separated by a wall of the given cell c
        
        List<Cell> unvisitedNeighbors = new ArrayList<>();
        int[] coords = c.getCoords();
        int row = coords[0];
        int col = coords[1];

        if (!c.getNorthWall() && !maze[row-1][col].isVisited()) {
            unvisitedNeighbors.add(maze[row-1][col]);
        }

        if (!c.getEastWall() && !maze[row][col+1].isVisited()) {
            unvisitedNeighbors.add(maze[row][col+1]);
        }

        if (!c.getSouthWall() && !maze[row+1][col].isVisited()) {
            unvisitedNeighbors.add(maze[row+1][col]);
        }

        if (!c.getWestWall() && !maze[row][col-1].isVisited()) {
            unvisitedNeighbors.add(maze[row][col-1]);
        }

        return unvisitedNeighbors;
    }

    private void resetVisited() {
        // Marks every cell in the maze as not visited

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maze[i][j].setVisited(false);
            }
        }
    }

}
