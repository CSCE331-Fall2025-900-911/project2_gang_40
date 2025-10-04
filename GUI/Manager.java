
import java.sql.Connection;
import javax.swing.*;

public class Manager extends JFrame {

    private Connection conn;
    private JPanel mainPanel;

    public Manager(Connection conn) {
        this.conn = conn;
        setTitle("Manager");   
        setSize(800, 600); // size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); // center

        mainPanel = new JPanel();
        mainPanel.setLayout(null);
    }

    public void showManager(){
        //call the other methods to display in here

        setVisible(true);
    }

    /* TODOs */
    private void DisplayTable(){

    }

    //Will be done by Jenil
    private void Menu(){

    }

}
