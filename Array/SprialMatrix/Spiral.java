package Array.SprialMatrix;

public class Spiral {
 public static void main(String[] args) {
    int[][] matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };

    int minrow = 0;
    int mincol = 0;
    int maxrow = matrix.length - 1;
    int maxcol = matrix[0].length - 1;

    while (minrow <= maxrow && mincol <= maxcol) {
        // Traverse top row
        for (int i = mincol; i <= maxcol; i++) {
            System.out.print(matrix[minrow][i] + " ");
        }
        minrow++;

        // Traverse right column
        for (int i = minrow; i <= maxrow; i++) {
            System.out.print(matrix[i][maxcol] + " ");
        }
        maxcol--;

        // Traverse bottom row if still within bounds
        if (minrow <= maxrow) {
            for (int i = maxcol; i >= mincol; i--) {
                System.out.print(matrix[maxrow][i] + " ");
            }
            maxrow--;
        }

        // Traverse left column if still within bounds
        if (mincol <= maxcol) {
            for (int i = maxrow; i >= minrow; i--) {
                System.out.print(matrix[i][mincol] + " ");
            }
            mincol++;
        }
    }
 }
}
