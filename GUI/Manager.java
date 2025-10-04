
import java.sql.Connection;
import javax.swing.*;

public class Manager extends JFrame {

    private Connection conn;

    public Manager(Connection conn) {
        this.conn = conn;
        setTitle("Manager");   
        setSize(800, 600); // size
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLocationRelativeTo(null); // center

        
    }

    public void showManager(){
        //call the other methods to display in here
        setVisible(true);
    }

}
