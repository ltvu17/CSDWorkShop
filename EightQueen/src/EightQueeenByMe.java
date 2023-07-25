
import java.io.PrintStream;

public class EightQueeenByMe {

    int n;
    final boolean available = true;
    int[] rows = null;
    boolean[] columns = null;
    boolean[] leftDiagonals = null;
    boolean[] rightDiagonals = null;
    int count = 0;

    public EightQueeenByMe(int n) {
        this.n = n;
        int i;
        rows = new int[n];
        columns = new boolean[n];
        for (i = 0; i < n; i++) {
            rows[i] = -1;
            columns[i] = available;
        }
        leftDiagonals = new boolean[2 * n - 1];
        rightDiagonals = new boolean[2 * n - 1];
        for (i = 0; i < 2 * n - 1; i++) {
            leftDiagonals[i] = rightDiagonals[i] = available;
        }
        count = 0;
    }

    private boolean validPosition(int row, int col) {
        return (columns[col] == available) && (leftDiagonals[row + col] == available)
                && (rightDiagonals[row - col + n - 1] == available);
    }

    public void printBoard(PrintStream stream) {
        if (count < 0) {
            return;
        }
        stream.println("Solution " + count + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stream.print((rows[i] == j) ? "Q " : "- ");
            }
            stream.println();
        }
    }

    public void putQueen(int row) {
        for (int col = 0; col < n; col++) {
            if (validPosition(row, col)) {
                rows[row] = col;
                columns[col] = !available;
                leftDiagonals[row + col] = !available;
                rightDiagonals[row - col + n - 1] = !available;
                if (row < n - 1) {
                    putQueen(row + 1);
                } else {
                    count++;
                    printBoard(System.out);
                }
                columns[col] = available;
                leftDiagonals[row + col] = available;
                rightDiagonals[row - col + n - 1] = available;
            }
        }
    }

    public void solve() {
        count = 0;
        putQueen(0);
    }

    public static void main(String[] args) {
        EightQueeenByMe problem = new EightQueeenByMe(8);
        problem.solve();
        System.out.println("Number of solutions:" + problem.count);
    }
}
