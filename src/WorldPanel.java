
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class WorldPanel extends JPanel {
    private World world;

    WorldPanel(World world) {
        super();
        this.world = world;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g.clearRect(0, 0, this.world.getWidth()*20, this.world.getHeight()*20);
        this.world.draw(g2);
    }

}
