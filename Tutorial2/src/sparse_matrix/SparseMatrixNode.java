package sparse_matrix;
public class SparseMatrixNode<T> {
    int row=0, col=0;
    T info = null;
    SparseMatrixNode nextInRow = null;
    SparseMatrixNode nextInCol = null;
    public SparseMatrixNode() {
    }
    public SparseMatrixNode(int r, int c, T info){
        this.row = r; this.col = c; this.info = info;
        nextInCol = nextInRow = null;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public SparseMatrixNode getNextInRow() {
        return nextInRow;
    }

    public void setNextInRow(SparseMatrixNode nextInRow) {
        this.nextInRow = nextInRow;
    }

    public SparseMatrixNode getNextInCol() {
        return nextInCol;
    }

    public void setNextInCol(SparseMatrixNode nextInCol) {
        this.nextInCol = nextInCol;
    }
    public String toString(){
        return "[" + row + "," + col + "," + info +"]";
    }
    
}
