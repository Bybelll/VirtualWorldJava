import java.awt.Color;
import java.util.Random;

public class Turtle extends Animal implements LivingBeing {
    public Turtle(World world, int x, int y, boolean canMove) {
        super(world, 2, 1, x, y, "Zolw", Color.ORANGE, true);
    }

    @Override
    public void action() {
        Random rand = new Random();
        int chance = rand.nextInt(4);
        if (chance == 0) {
            super.action();
        }
    }

    @Override
    public boolean collision(LivingBeing other) {
        if (other.getStrength() < 5) {
            this.world.consoleLogLn("Zwierzę " + other.getName()+ " ("+other.getX()+","+other.getY()+") " + " ma mniej niż 5 siły. " + other.getName() + " jego atak zostaje odparty.");
            return false;
        } else {
            return super.collision(other);
        }
    }
}