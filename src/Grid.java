import java.util.Arrays;

public class Grid {

    // Set of valid movement direction on 2D grid
    final static int dx[] = {-1, +1, 0, 0};
    final static int dy[] = {0, 0, +1, -1};

    private int X, Y, size, health;
    private int[][] board;

    public Grid(int size) {
        this.health = 10;
        this.size = size;
        this.board = new int[size][size];
        System.out.println(size);
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                board[i][j] = getRandomBit();
            }
            System.out.println(Arrays.toString(board[i]));
        }
    }

    private int getRandomBit() {
        return Math.random() > 0.5 ? 0 : 1;
    }

    private boolean isValid(int nx, int ny) {
        return !(nx < 0 || nx >= this.size || ny < 0 || ny >= this.size) && this.board[nx][ny] == 0;
    }

    private void updatePosition(int newX, int newY) {
        this.X = newX;
        this.Y = newY;
    }

    private void move(int dir) {
        int nx = this.X + dx[dir];
        int ny = this.Y + dy[dir];
        if (isValid(nx, ny)) {
            updatePosition(nx, ny);
            System.out.println("Moving to: " + nx + " " + ny);
        } else {
            System.out.println("Invalid / Out of bound cell detected");
            if (--this.health == 0) System.out.println("Players died.");
        }
    }

    public void moveUp() {
        this.move(0);
        return hasReached();
    }

    public boolean moveDown() {
        this.move(1);
        return hasReached();
    }

    public boolean moveRight() {
        this.move(2);
        return hasReached();
    }

    public boolean moveLeft() {
        this.move(3);
        return hasReached();
    }

    private boolean hasReached() {
        return (this.X == this.size - 1 && this.Y == this.size - 1) || (this.health == 0);
    }
}
