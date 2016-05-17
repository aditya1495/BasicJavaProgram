import java.util.*;

public class GridGame {

    private void play() {
        Grid myGrid = new Grid();
        myGrid.initGrid(5);
        Scanner sc = new Scanner(System.in);
        while (myGrid.hasReached() == false) {
            char c = sc.next().charAt(0);
            if (c == 'U') {
                myGrid.moveUp();
            } else if (c == 'L') {
                myGrid.moveLeft();
            } else if (c == 'R') {
                myGrid.moveRight();
            } else if (c == 'D'){
                myGrid.moveDown();
            } else {
                System.out.println("Invalid Action Demanded!");
            }
        }
        System.out.println("Game over!");
    }

    public static void main(String[] args) {
        new GridGame().play();
    }
}
