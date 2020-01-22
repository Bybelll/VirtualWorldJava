import java.awt.*;
import java.util.Random;

public class Sloth extends Animal implements LivingBeing {
    public Sloth(World world, int x, int y, boolean canMove) {
        super(world, 2, 1, x, y, "Leniwiec", Color.red, true);
    }

    @Override
    public void action() {

        Random rand = new Random();
        int chance = rand.nextInt(3);
        if (canMove) {
            super.action();
            canMove = false;
        } else if (chance == 0) {
            canMove = true;
        }
    }

}
