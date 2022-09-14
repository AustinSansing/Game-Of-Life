
import java.util.Iterator;

public class Grid implements Iterable<Cell_thread> {
    
	private Cell_thread[][] board; // Update ICell to Cell_thread
    private int rows, cols;

    public Grid(boolean[][] start, ICellFactory cf){
        rows = start.length;
        cols = start.length;
        board = new Cell_thread[rows][cols];
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                board[r][c] = new Cell_thread (cf.Make(this, r, c, start[r][c]));
	
            }
        }
    }
   
    
    class GridIterator implements Iterator<Cell_thread>{
        private int r =0;
        private int c = 0;
        public boolean hasNext(){
            return (r < rows) && ( c < cols);
        }
        public Cell_thread next() {
            if (!hasNext()) 
            	return null;
            
                Cell_thread cell = board[r][c];
                if(++c >= cols) { 
                    c=0; 
                    r++; 
                }
			return cell;
        }
    }
    

    public ICell CellAt(int row, int col) {
    	if((row >= 0) && (row < rows) && (col >= 0) && (col < cols)){
            return (board[row][col].Ithread);
        }else{
            return null;
        }
    }
    
    @Override
    public Iterator<Cell_thread> iterator() { return new GridIterator();}
    
    public void OneGen() throws InterruptedException {
        for(Cell_thread cell: this) cell.run(); // Updated from GameofLifee
        for(Cell_thread cell: this) cell.join();// Helps Cell_thread for next generation
        for(Cell_thread cell: this) cell.run(); // Joins the threads
        for(Cell_thread cell: this) cell.join();

    }
    public void Update(int gens) throws InterruptedException{
        for(int i =0; i<gens; ++i){
            OneGen();
        }
    }
    public boolean[][] State(){
        boolean[][] state = new boolean[rows][cols];
        for (Cell_thread cell : this){ // Updated using Cell_thread var's
        	state[cell.Ithread.row()][cell.Ithread.col()] = cell.Ithread.is_alive();
        }

        return state;
    }

}






