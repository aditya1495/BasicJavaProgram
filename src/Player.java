public class Player {

    public int[] dx, dy;
    public int health, X, Y;

    public Player(Power myPower) {
        this.X = this.Y = 0;
        this.health = myPower.getHealth();
        int jump = myPower.getJump();
        this.dx = new int[]{-jump, jump, 0, 0};
        this.dy = new int[]{0, 0, jump, -jump};
    }

    public void updatePosition(int nx, int ny) {
        this.X = nx;
        this.Y = ny;
    }

    public boolean hitWallEffect() {
        return (--this.health > 0);
    }
}
