

public class CellFactory implements ICellFactory {
        public ICell Make(Grid parent, int row, int col, boolean c){
                return new Cell(parent, row, col, c);
        }
}