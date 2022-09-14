
import java.util.ArrayList;
import java.util.List;

public class LifeRules{

        public static boolean determine(boolean Alive, int Neighbors){
                return (Alive && (Neighbors == 2  || Neighbors == 3))
                        || (!Alive && (Neighbors == 3));
        }

        public static int liveNeighbors(Iterable<ICell> Neighbors){
                int count = 0;
                for (ICell c : Neighbors) 
                	if (c.is_alive()) 
                		count++;
                return count;
        }
        public static List<ICell> Neighbors(Grid g, int r, int c){
            List<ICell> n = new ArrayList<>();
            AddIfNotNull(n, g.CellAt(r-1, c-1));
            AddIfNotNull(n, g.CellAt(r-1, c));
            AddIfNotNull(n, g.CellAt(r-1, c+1));
            AddIfNotNull(n, g.CellAt(r, c+1));
            AddIfNotNull(n, g.CellAt(r+1, c+1));
            AddIfNotNull(n, g.CellAt(r+1, c));
            AddIfNotNull(n, g.CellAt(r+1, c-1));
            AddIfNotNull(n, g.CellAt(r, c-1));
            return n;
        }
        private static void AddIfNotNull(List<ICell> l, ICell c) {
            if (c!=null) l.add(c);
    }

}






    

        



