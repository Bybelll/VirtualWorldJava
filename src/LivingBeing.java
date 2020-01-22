
import java.awt.Color;

public interface LivingBeing {
    public void action();
    public boolean collision(LivingBeing colliding);
    public boolean tryReproduce();
    public int getInitiative();
    public World getWorld();
    public int getX();
    public int getY();
    public void setXY(int x, int y);
    public int getStrength();
    public void setStrength(int strength);
    public String getName();
    public void setCanMove(boolean newValue);
    public void setToDelete();
    public boolean getToDelete();
    public Color getColor();
}
