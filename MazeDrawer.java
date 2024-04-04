public class MazeDrawer {

    private Cell[][] maze;
    private final int rows;
    private final int cols;

    public MazeDrawer(Cell[][] maze) {
        this.maze = maze;
        rows = maze.length;
        if (rows == 0) {
            cols = 0;
        } else {
            cols = maze[0].length;
        }
    }
    
    public void drawMaze() {
         /*
         * Draw the north border (first two rows)
         * Draw west and south walls of every row of cells except the last one
         *      Draw only the west walls for the last row of cells
         * Draw the south border (last two rows)
         */

        drawBorder();
        drawCells();
        drawBorder();
        System.out.println();
    }

    private void drawCells() {
        /*
         * Draw west and south walls of every row of cells except the last one
         *      Draw only the west walls for the last row of cells
         */

        // Does not draw the cells if the rows or columns are zero
        if (rows == 0 || cols == 0) {
            return;
        }
        // Print west walls, cell symbols, and south walls for every row except the last one
        for (int i = 0; i < rows - 1; i++) {
            System.out.print("# ");
            for (int j = 0; j < cols; j++) {
                printWestWall(i, j);
                printCellSymbol(i, j);
            }
            System.out.println("# #");

            System.out.print("# ");
            for (int j = 0; j < cols; j++) {
                printSouthWall(i, j);
            }
            System.out.println("# #");
        }

        // Print only west walls and cell symbols for last row
        System.out.print("# ");
        for (int i = 0; i < cols; i++) {
            printWestWall(rows-1, i);
            printCellSymbol(rows-1, i);
        }
        System.out.println("# #");
    }

    private void printWestWall(int i, int j) {
        // Prints the characters for the west wall of the cell at the given coordinates

        if (j-1 >= 0 && maze[i][j-1].isSolution() && maze[i][j].isSolution() && !maze[i][j].getWestWall()) {
            System.out.print("· ");
        } else if (maze[i][j].getWestWall()) {
            System.out.print("# ");
        } else {
            System.out.print("  ");
        }
    }

    private void printCellSymbol(int i, int j) {
        // Prints the characters for the symbol of the cell at the given coordinates

        if (maze[i][j].equals(maze[0][0])) {
            System.out.print("S ");
        } else if (maze[i][j].equals(maze[rows-1][cols-1])) {
            System.out.print("E ");
        } else if (maze[i][j].isSolution()) {
            System.out.print("· ");
        } else {
            System.out.print("  ");
        }
    }

    private void printSouthWall(int i, int j) {
        // Prints the characters for the south wall of the cell at the given coordinates

        if (i+1 <= rows-1 && maze[i][j].isSolution() && maze[i+1][j].isSolution() && !maze[i][j].getSouthWall()) {
            System.out.print("# · ");
        } else if (maze[i][j].getSouthWall()) {
            System.out.print("# # ");
        } else {
            System.out.print("#   ");
        }
    }

    private void drawBorder() {
        // Prints two rows of characters for a border

        // Only prints two pound symbols if the rows or columns are zero
        if (rows == 0 || cols == 0) {
            System.out.println("# #");
            return;
        }

        int drawingWidth = cols * 2 + 3;

        for (int i = 0; i < drawingWidth - 1; i++) {
            System.out.print("# ");
        }
        System.out.println("#");
        for (int i = 0; i < drawingWidth - 1; i++) {
            System.out.print("# ");
        }
        System.out.println("#");
    }

}
