import java.util.Scanner;

public class Game {

    private Player myPlayer;
    private Grid myGrid;

    public Game(Player myPlayer, Grid myGrid) {
        this.myPlayer = myPlayer;
        this.myGrid = myGrid;
    }

    public void play() {
        boolean alive = true;
        boolean reached = false;
        Scanner sc = new Scanner(System.in);
        while (alive && !reached) {
            char dir = sc.next().charAt(0);
            Position newPos = new Position(0, 0);
            if (dir == 'U') newPos = myPlayer.move(Direction.UP);
            if (dir == 'D') newPos = myPlayer.move(Direction.DOWN);
            if (dir == 'R') newPos = myPlayer.move(Direction.RIGHT);
            if (dir == 'L') newPos = myPlayer.move(Direction.LEFT);

            Move myMove = myGrid.isValid(newPos);

            System.out.println(newPos + " " + myMove);

            switch (myMove) {
                case VALID:
                    myPlayer.updatePosition(newPos);
                    break;

                case OUTOFBOUND:
                    break;

                case HITWALL:
                    alive = myPlayer.hitWallEffect();
                    break;
            }
            reached = myGrid.hasReached(myPlayer.position);
            System.out.println(myPlayer.position);
        }

        if (reached)
            System.out.println("Destination Reached.");
        else
            System.out.println("You are dead.");
    }
}
