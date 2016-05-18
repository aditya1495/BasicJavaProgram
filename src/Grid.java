import java.util.Arrays;

public class Grid {

    private int rowSize, colSize;
    private Cell[][] board;

    private void initBoard() {
        int rows = this.rowSize, cols = this.colSize;
        this.board = new Cell[rows][cols];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                board[i][j] = new Cell(getRandomBit() > 0);
                System.out.print(board[i][j].isBlocked ? 1 : 0);
            }
            System.out.println();
        }
    }

    public Grid(int rowSize) {
        this.rowSize = rowSize;
        this.colSize = rowSize;
        initBoard();
    }

    public Grid(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
        initBoard();
    }

    private int getRandomBit() {
        return Math.random() > 0.5 ? 0 : 1;
    }

    public Move isValid(int nx, int ny) {
        if (nx < 0 || ny < 0 || nx >= this.rowSize || ny >= this.colSize) return Move.OUTOFBOUND;
        if (board[nx][ny].isBlocked) return Move.HITWALL;
        return Move.VALID;
    }

    public boolean hasReached(int nx, int ny) {
        return nx == this.rowSize - 1 && ny == this.colSize - 1;
    }
}
