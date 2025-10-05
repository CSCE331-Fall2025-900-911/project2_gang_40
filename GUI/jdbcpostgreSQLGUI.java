
import java.sql.*;
import javax.swing.*;


/*
CSCE 315
9-25-2019
 */
public class jdbcpostgreSQLGUI {

    public static void main(String[] args) {
        
        dbSetup my = new dbSetup();
        //Building the connection
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://csce-315-db.engr.tamu.edu/gang_40_db",
                    my.user, my.pswd);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }//end try catch
        
        JOptionPane.showMessageDialog(null, "Opened database successfully");

        Login loginScreen = new Login(conn);
        loginScreen.showLogin();
    }

    
    public static void showDatabaseGUI(Connection conn) {
        String name = "";
        DefaultListModel<String> listModel = null;
        try {
            //create a statement object
            Statement stmt = conn.createStatement();
            //create an SQL statement
            String last_nameStatement = "SELECT last_name FROM customers";
            
            //send statement to DBMS
            // ResultSet result = stmt.executeQuery(sqlStatement);

            //OUTPUT
            // JOptionPane.showMessageDialog(null, "Top 5 customers.");
            //  System.out.println("______________________________________");

            // changes
            listModel = GUIhelper.getLastNames(conn, last_nameStatement);
            
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error accessing Database.");
        }

        //list for the last names
        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);

        
        JFrame frame = new JFrame();
        frame.setTitle("Last Names of customers");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of application when clicked
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null); //center the frame
        frame.add(listScrollPane);


        //closing the connection
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                try {
                    conn.close();
                    JOptionPane.showMessageDialog(null, "Connection Closed.");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Connection NOT Closed.");
                }//end try catch
            }
        });

        frame.setVisible(true);
    }//end main class

    
}