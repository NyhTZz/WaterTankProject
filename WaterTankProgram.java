package summer;
import javax.swing.JOptionPane;

abstract class WaterTank {
    protected int capacity;
    protected int currentLevel;

    public WaterTank(int capacity) {
        this.capacity = capacity;
        this.currentLevel = 0; 
    }

    public abstract void fillTank(int liters);
    public abstract void useWater(int liters);
    public abstract String checkStatus();
}

class HomeTank extends WaterTank {
    public HomeTank() {
        super(200); 
    }

    @Override
    public void fillTank(int liters) {
        if (currentLevel + liters > capacity) {
            currentLevel = capacity;
        } else {
            currentLevel += liters;
        }
        JOptionPane.showMessageDialog(null,
            liters + " liters added. Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public void useWater(int liters) {
        if (currentLevel - liters < 0) {
            currentLevel = 0;
        } else {
            currentLevel -= liters;
        }
        JOptionPane.showMessageDialog(null,
            liters + " liters used. Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public String checkStatus() {
        if (currentLevel == 0) return "Empty";
        if (currentLevel == capacity) return "Full";
        return "In Use";
    }
}

class BuildingTank extends WaterTank {
    public BuildingTank() {
        super(1000); 
    }

    @Override
    public void fillTank(int liters) {
        if (currentLevel + liters > capacity) {
            currentLevel = capacity;
        } else {
            currentLevel += liters;
        }
        JOptionPane.showMessageDialog(null,
            liters + " liters added. Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public void useWater(int liters) {
        if (currentLevel - liters < 0) {
            currentLevel = 0;
        } else {
            currentLevel -= liters;
        }
        JOptionPane.showMessageDialog(null,
            liters + " liters used. Current level: " + currentLevel + "/" + capacity);
    }

    @Override
    public String checkStatus() {
        if (currentLevel == 0) return "Empty";
        if (currentLevel == capacity) return "Full";
        return "In Use";
    }
}

public class WaterTankProgram {
    public static void main(String[] args) {
        String choice = JOptionPane.showInputDialog("Enter type of tank: (1) HomeTank (2) BuildingTank");

        WaterTank tank;
        if ("1".equals(choice)) {
            tank = new HomeTank();
            JOptionPane.showMessageDialog(null, "You chose HomeTank (200 liters capacity)");
        } else {
            tank = new BuildingTank();
            JOptionPane.showMessageDialog(null, "You chose BuildingTank (1000 liters capacity)");
        }

        while (true) {
            String action = JOptionPane.showInputDialog("Choose action: (1) Fill Tank  (2) Use Water  (3) Check Status");

            if ("1".equals(action)) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to fill:"));
                tank.fillTank(liters);
            } else if ("2".equals(action)) {
                int liters = Integer.parseInt(JOptionPane.showInputDialog("Enter liters to use:"));
                tank.useWater(liters);
            } else if ("3".equals(action)) {
                JOptionPane.showMessageDialog(null, "Tank Status: " + tank.checkStatus());
            }

            String status = tank.checkStatus();
            if (status.equals("Empty") || status.equals("Full")) {
                JOptionPane.showMessageDialog(null, "Tank is " + status + "! Program ended.");
                break;
            }
        }
    }
}