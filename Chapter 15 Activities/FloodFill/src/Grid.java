import java.util.*; 

public class Grid
{
    private static final int SIZE = 10;
    int[][] pixels = new int[SIZE][SIZE];

    /**
     * Flood fill, starting with the given row and column.
    */
    
   public void floodfill(int row, int column) {
        int fillCounter = 1;
        Stack<Pair> floodStack = new Stack<>();
        
        floodStack.push(new Pair(row, column));

        while (!floodStack.isEmpty()) {
            Pair currentPoint = floodStack.pop();
            int r = currentPoint.row;
            int c = currentPoint.col;

            if (pixels[r][c] == 0) {
                pixels[r][c] = fillCounter++;

                
                if (r - 1 >= 0 && pixels[r - 1][c] == 0) {
                    floodStack.push(new Pair(r - 1, c));
                }
                if (c + 1 < SIZE && pixels[r][c + 1] == 0) {
                    floodStack.push(new Pair(r, c + 1));
                }
                if (r + 1 < SIZE && pixels[r + 1][c] == 0) {
                    floodStack.push(new Pair(r + 1, c));
                }
                if (c - 1 >= 0 && pixels[r][c - 1] == 0) {
                    floodStack.push(new Pair(r, c - 1));
                }
            }
        }
    }
      
      
      @Override
    public String toString()
    {
        String r = "";
        for (int i = 0; i < SIZE; i++)
        {
            for (int j = 0; j < SIZE; j++)
                r = r + String.format("%4d", pixels[i][j]);
            r = r + "\n";
        }
        return r;
    }
  }


    
 
