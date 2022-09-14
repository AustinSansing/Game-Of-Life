import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, InterruptedException{
		// Path to input file
		String FileName = "C:\\Users\\Owner\\eclipse-workspace\\GameOfLife\\src\\input.txt";
		
        Object[] returns = DisplayGrid.ReadFile(FileName , 'X');
        boolean[][] FileState = (boolean[][]) returns[0];
        int gens = (int) returns[1];

        Grid G = new Grid(FileState, new CellFactory());
        DisplayGrid.Show(G.State(), 'X', 'O', "Start");

        G.Update(gens);
        DisplayGrid.Show(G.State(), 'X', 'O', "Finish");
	}
}


