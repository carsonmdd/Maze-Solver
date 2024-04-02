public class Cell {
    
    private final int[] coords;
    private boolean northWall;
    private boolean eastWall;
    private boolean southWall;
    private boolean westWall;
    private boolean visited;
    private boolean isSolution;

    public Cell(int[] coords) {
        this.coords = coords;
        northWall = true;
        eastWall = true;
        southWall = true;
        westWall = true;
        visited = false;
        isSolution = false;
    }

    public int[] getCoords() {
        // Returns the cell's coordinates
        
        return coords;
    }

    public boolean getNorthWall() {
        // Returns whether the cell has a north wall

        return northWall;
    }

    public void setNorthWall(boolean northWall) {
        // Sets the north wall to the given boolean input
        
        this.northWall = northWall;
    }

    public boolean getEastWall() {
        // Returns whether the cell has an east wall

        return eastWall;
    }

    public void setEastWall(boolean eastWall) {
        // Sets the east wall to the given boolean input

        this.eastWall = eastWall;
    }

    public boolean getSouthWall() {
        // Returns whether the cell has a south wall

        return southWall;
    }

    public void setSouthWall(boolean southWall) {
        // Sets the south wall to the given boolean input

        this.southWall = southWall;
    }

    public boolean getWestWall() {
        // Returns whether the cell has a west wall

        return westWall;
    }

    public void setWestWall(boolean westWall) {
        // Sets the west wall to the given boolean input

        this.westWall = westWall;
    }

    public boolean isVisited() {
        // Returns whether this cell was visited (for DFS and BFS algorithms)

        return visited;
    }

    public void setVisited(boolean visited) {
        // Sets whether this cell has been visited to the given boolean input

        this.visited = visited;
    }

    public boolean isSolution() {
        // Returns whether this cell is part of the solution path

        return isSolution;
    }

    public void setSolution() {
        // Sets this cell as part of the solution path

        isSolution = true;
    }

    public String toString() {
        // Returns a formatted string of this cell's coordinates

        return "(" + coords[0] + "," + coords[1] + ")";
    }

    public boolean equals(Object other) {
        // Returns whether this cell has the same variable values as the given other object

        Cell c = (Cell) other;
        return coords == c.coords 
            && northWall == c.northWall 
            && eastWall == c.eastWall 
            && southWall == c.southWall 
            && westWall == c.westWall 
            && visited == c.visited
            && isSolution == c.isSolution;
    }

}
