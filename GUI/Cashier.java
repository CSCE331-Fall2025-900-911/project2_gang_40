

import java.sql.Connection;
import javax.swing.*;

public class Cashier extends JFrame {

    private JPanel mainPanel;
    private Connection conn;

    public Cashier(Connection conn) {
        this.conn = conn;
        setTitle("Cashier");
        setSize(800, 600); // size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        
    }

    public void showCashier(){
        //call the other methods to display in here
        setVisible(true);
    }

    
}
