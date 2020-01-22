
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Predicate;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class World {
    private int width;
    private int height;
    private LinkedList organisms;
    private JTextArea console;

    World(int width, int height) {
        this.width = width;
        this.height = height;
        this.organisms = new LinkedList();
    }

    World() {
        this(20, 20);
    }

    public void setConsole(JTextArea console) {
        this.console = console;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void insertLivingBeing(LivingBeing adding) {
        this.organisms.insert(adding);

    }

    public Optional<LivingBeing> findLivingBeing(Predicate<LivingBeing> predicate) {
        return this.organisms.search(predicate);
    }

    public void tick() {
        this.clearConsole();
        this.organisms.doAction();
        this.organisms.refreshMove();
    }

    public void draw(Graphics2D g2) {
        this.organisms.draw(g2);
    }

    public void exportToFile() {
        String filename = JOptionPane.showInputDialog("Podaj nazwę pliku do którego ma zostać zapisany stan świata:");
        try (PrintWriter out = new PrintWriter(filename + ".txt")) {
            out.println(this.width);
            out.println(this.height);
            out.print(this.organisms.getExportData());
        } catch (Exception ex) {

        }
    }

    public void importFromFile() {
        String filename = JOptionPane.showInputDialog("Podaj nazwę pliku z którego ma zostać odczytany stan świata:");
        try (BufferedReader br = new BufferedReader(new FileReader(filename + ".txt"))) {
            StringBuilder sb = new StringBuilder();
            this.organisms = new LinkedList();
            this.width = Integer.parseInt(br.readLine());
            this.height = Integer.parseInt(br.readLine());
            this.consoleLogLn("świat o szerokości = " + this.width + "    oraz wysokości = " + this.height);
            String line = br.readLine();
            while (line != null) {
                LivingBeing importingOrganism;
                int x, y;
                switch (line) {
                    case "W":
                        this.consoleLog("Wilk:");
                        importingOrganism = new Wolf(this, 0, 0, false);
                        break;
                    case "O":
                        this.consoleLog("Owca:");
                        importingOrganism = new Sheep(this, 0, 0, false);
                        break;
                    case "Z":
                        this.consoleLog("Zolw:");
                        importingOrganism = new Turtle(this, 0, 0, true);
                        break;
                    case "L":
                        this.consoleLog("Leniwiec:");
                        importingOrganism = new Sloth(this, 0, 0,true);
                        break;
                    case "K":
                        this.consoleLog("Kangur:");
                        importingOrganism = new Kangaroo(this, 0, 0, true);
                        break;
                    case "T":
                        this.consoleLog("Trawa:");
                        importingOrganism = new Grass(this, 0, 0, false);
                        break;
                    case "G":
                        this.consoleLog("Guarana:");
                        importingOrganism = new Guaranna(this, 0, 0, true);
                        break;
                    case "C":
                    default:
                        this.consoleLog("Ciern:");
                        importingOrganism = new Thorn(this, 0, 0, false);
                        break;
                }
                x = Integer.parseInt(br.readLine());
                y = Integer.parseInt(br.readLine());
                this.consoleLogLn(" na pozycji x = " + x + "   y = " + y);
                importingOrganism.setXY(x, y);
                this.organisms.insert(importingOrganism);
                line = br.readLine();
            }
        } catch (Exception ex) {

        }
    }

    public void addAtPixelPosition(int x, int y) {
        if (x > this.width || y > this.height) {
            return;
        }
        Optional<LivingBeing> colliding = this.findLivingBeing(item -> item.getX() == x && item.getY() == y);
        if (colliding.isPresent()) {
            JOptionPane.showMessageDialog(null, "To pole jest już zajęte!");
            return;
        }
        String[] organisms = {"Wilk", "Owca", "Zolw", "Leniwiec", "Kangur", "Trawa", "Cierń", "Guarana"};
        int n = JOptionPane.showOptionDialog(null,
                "Który organizm chcesz dodać?",
                "Wybierz organizm",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                organisms,
                organisms[0]);
        if (n == -1) {
            return;
        }
        LivingBeing importingOrganism;
        switch (organisms[n]) {
            case "Wilk":
                this.consoleLog("Wilk:");
                importingOrganism = new Wolf(this, x, y, true);
                break;
            case "Owca":
                this.consoleLog("Owca:");
                importingOrganism = new Sheep(this, x, y, true);
                break;
            case "Zolw":
                this.consoleLog("Zolw:");
                importingOrganism = new Turtle(this, x, y, true);
                break;
            case "Leniwiec":
                this.consoleLog("Leniwiec:");
                importingOrganism = new Sloth(this, x, y, true);
                break;
            case "Kangur":
                this.consoleLog("Kangur:");
                importingOrganism = new Kangaroo(this, x, y, true);
                break;
            case "Trawa":
                this.consoleLog("Trawa:");
                importingOrganism = new Grass(this, x, y, true);
                break;
            case "Cierń":
            default:
                this.consoleLog("Ciern:");
                importingOrganism = new Thorn(this, x, y, true);
                break;
            case "Guarana":
                this.consoleLog("Guarana:");
                importingOrganism = new Guaranna(this, x, y, true);
                break;
        }
        this.consoleLogLn("  x = " + x + "   y = " + y);
        this.insertLivingBeing(importingOrganism);
    }

    public void consoleLog(String str) {
        System.out.print(str);
        this.console.append(str);
    }

    public void consoleLogLn(String str) {
        System.out.println(str);
        this.console.append(str + '\n');
    }

    public void clearConsole() {
        this.console.setText("");
    }
}
