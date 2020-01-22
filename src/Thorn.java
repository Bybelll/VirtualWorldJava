
import java.awt.Color;


public class Thorn extends Plant implements LivingBeing{
    public Thorn(World world, int x, int y, boolean canMove) {
        super(world, 2, x, y, "Ciern„", Color.blue, canMove, 100);
    }
}
