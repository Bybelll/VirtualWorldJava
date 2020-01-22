import java.awt.Color;

public class Guaranna extends Plant implements LivingBeing {
    public Guaranna(World world, int x, int y, boolean canMove) {
        super(world, 0, x, y, "Guarana", Color.pink, canMove, 50);
    }

    @Override
    public boolean collision(LivingBeing other) {
        if (super.collision(other) && this.toDelete) {
            this.world.consoleLogLn(this.name + " dodaje sily! " + other.getName()+ " ("+this.x+","+this.y+") " + " staje się silniejszy (+3)");
            other.setStrength(other.getStrength()+3);
            return true;
        }
        return false;
    }
}
