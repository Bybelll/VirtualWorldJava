
import java.awt.Color;

public class Sheep extends Animal implements LivingBeing{
    public Sheep(World world, int x, int y, boolean canMove) {
        super(world, 4, 4, x, y, "Owca", Color.LIGHT_GRAY, canMove);
    }
}
