import java.util.Scanner;

public class GridGame {

    private void play() {
        Grid myGrid = new Grid(5);
        Scanner sc = new Scanner(System.in);
        boolean quitGame = false;
        while (!quitGame) {
            char c = sc.next().charAt(0);
            if (c == 'U') {
                quitGame = myGrid.moveUp();
            } else if (c == 'L') {
                quitGame = myGrid.moveLeft();
            } else if (c == 'R') {
                quitGame = myGrid.moveRight();
            } else if (c == 'D') {
                quitGame = myGrid.moveDown();
            } else {
                System.out.println("Invalid Action Demanded!");
            }
        }
        System.out.println("Game finished!");
    }

    public static void main(String[] args) {
        new GridGame().play();
    }
}
