
import java.awt.Color;

public class Wolf extends Animal implements LivingBeing{
    public Wolf(World world, int x, int y, boolean canMove) {
        super(world, 9, 5, x, y, "Wilk", Color.BLACK, canMove);
    }
}
