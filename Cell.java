
public class Cell implements ICell {
	private boolean newFate = false;
    private boolean cellAlive;
    private boolean cellNextgen;
    private Grid cellMygrid;
    private int cellRow;
    private int cellCol;
    

    
    public Cell(Grid parent, int row, int col, boolean Alive){
        cellRow = row;
        cellCol = col;
        cellMygrid = parent; cellAlive = Alive;
    }
    
    public int row() {return cellRow;}
    public int col() {return cellCol;}
    public boolean is_alive() {return cellAlive;}
    public void update(){cellAlive = cellNextgen;}
    
    public void determine(){
        Iterable<ICell> myNeighbors = LifeRules.Neighbors(cellMygrid, cellRow, cellCol);
        int liveNeighbors = LifeRules.liveNeighbors(myNeighbors);
        cellNextgen = LifeRules.determine(cellAlive, liveNeighbors);
    }
	@Override
    public void run() { // Determine next generation
        if (!newFate) {
            determine();
            newFate = true;
        }
        else {
            update();
            newFate = false;
        }
    }
}


