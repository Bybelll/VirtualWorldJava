
import java.awt.Color;

public class Grass extends Plant implements LivingBeing{
    public Grass(World world, int x, int y, boolean canMove) {
        super(world, 0, x, y, "Trawa", Color.green, canMove, 50);
    }
}
