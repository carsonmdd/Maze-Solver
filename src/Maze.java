public class Maze {
    
    private Cell[][] maze;

    public Maze(int rows, int cols) {
        MazeGenerator mg = new MazeGenerator(rows, cols);
        mg.generateMaze();
        maze = mg.getMaze();
    }

    public void draw() {
        // Draws the maze
        
        MazeDrawer md = new MazeDrawer(maze);
        md.drawMaze();
    }

    public void solve() {
        // Solves the maze

        MazeSolver ms = new MazeSolver(maze);
        ms.solveMaze();
    }

}
