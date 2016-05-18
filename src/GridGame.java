import java.util.Scanner;

public class GridGame {

    private void run() {
        System.out.print("Choose your player type: \nNormal(1)\nGood(2)\nBest(3)\n");
        Scanner sc = new Scanner(System.in);
        int playerType = sc.nextInt();
        Grid myGrid = new Grid(5);
        Player myPlayer;

        if (playerType == 1) myPlayer = new Player(Power.NORMAL);
        else if (playerType == 2) myPlayer = new Player(Power.GOOD);
        else myPlayer = new Player(Power.BEST);

        Game myGame = new Game(myPlayer, myGrid);
        myGame.play();
    }

    public static void main(String[] args) {
        new GridGame().run();
    }
}