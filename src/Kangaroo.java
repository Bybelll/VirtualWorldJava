import java.awt.Color;

public class Kangaroo extends Animal implements LivingBeing {
    public Kangaroo(World world, int x, int y, boolean canMove) {
        super(world, 8, 8, x, y, "Kangur", Color.MAGENTA, true);
    }

    @Override
    public void action(){
        super.action();
        super.action();
    }
}
