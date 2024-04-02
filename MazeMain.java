public class MazeMain {
    
    public static void main(String[] args) {
        Maze maze = new Maze(10, 10);
        maze.draw();
        maze.solve();
        maze.draw();
    }

}
