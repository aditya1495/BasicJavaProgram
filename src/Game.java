import java.util.Scanner;

public class Game {

    private Player myPlayer;
    private Grid myGrid;

    public Game(Player myPlayer, Grid myGrid) {
        this.myPlayer = myPlayer;
        this.myGrid = myGrid;
    }

    public void play() {
        int nx, ny, vec = 0;
        boolean alive = true;
        boolean reached = false;
        Scanner sc = new Scanner(System.in);
        while (alive && !reached) {
            char dir = sc.next().charAt(0);

            if (dir == 'U') vec = 0;
            if (dir == 'D') vec = 1;
            if (dir == 'R') vec = 2;
            if (dir == 'L') vec = 3;

            nx = myPlayer.X; nx += myPlayer.dx[vec];
            ny = myPlayer.Y; ny += myPlayer.dy[vec];

            Move myMove = myGrid.isValid(nx, ny);

            switch (myMove) {
                case VALID:
                    myPlayer.updatePosition(nx, ny);
                    break;

                case OUTOFBOUND:
                    break;

                case HITWALL:
                    alive = myPlayer.hitWallEffect();
                    break;
            }
            reached = myGrid.hasReached(myPlayer.X, myPlayer.Y);
            System.out.println(myPlayer.X + " " + myPlayer.Y);
        }

        if (reached)
            System.out.println("Destination Reached.");
        else
            System.out.println("You are dead.");
    }
}
