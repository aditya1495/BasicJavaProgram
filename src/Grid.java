import java.util.Arrays;

public class Grid {

    // Set of valid movement direction on 2D grid
    final static int dx[] = {1, -1, 0, 0};
    final static int dy[] = {0, 0, 1, -1};

    private int X, Y, N;
    private int[][]a;

    Grid() {
        X = 0;
        Y = 0;
    }

    public void initGrid(int N) {
        this.N = N;
        this.a = new int[N][N];
        System.out.println(N);
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                a[i][j] = (i * j + 56736) & 1;
            }
            System.out.println(Arrays.toString(a[i]));
        }
    }

    private boolean isValid(int nx, int ny) {
        if (nx < 0 || nx >= this.N || ny < 0 || ny >= this.N) return false;
        if (this.a[nx][ny] != 0) return false;
        return true;
    }

    private void updatePosition(int newX, int newY) {
        this.X = newX;
        this.Y = newY;
    }

    private void move(int dir) {
        int nx = this.X + dx[dir];
        int ny = this.Y + dy[dir];
        if (isValid(nx, ny) == true) {
            updatePosition(nx, ny);
            System.out.println("Moving to: " + nx + " " + ny);
        } else {
            System.out.println("Invalid / Out of bound cell detected");
        }
    }

    public void moveUp() {
        this.move(0);
    }

    public void moveDown() {
        this.move(1);
    }

    public void moveRight() {
        this.move(2);
    }

    public void moveLeft() {
        this.move(3);
    }

    public boolean hasReached() {
        return (this.X == this.N - 1 && this.Y == this.N - 1);
    }
}
