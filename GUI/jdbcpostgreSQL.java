
import java.sql.*;
//import javax.swing.JOptionPane;

/*
CSCE 315
9-25-2019 Original
2/7/2020 Update for AWS
 */
public class jdbcpostgreSQL {

    public static void main(String args[]) {
        //dbSetup hides my username and password
        dbSetup my = new dbSetup();
        //Building the connection
        Connection conn = null;
        try {
            //Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:postgresql://csce-315-db.engr.tamu.edu/gang_40_db",
                    my.user, my.pswd);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }//end try catch
        System.out.println("Opened database successfully");
        String cus_lname = "";
        try {
            //create a statement object
            Statement stmt = conn.createStatement();
            //create an SQL statement
            String sqlStatement
                    = "SELECT "
                    + "c.first_name || ' ' || c.last_name AS customer_name, "
                    + "SUM(s.total_price) AS total_spent, "
                    + "COUNT(s.sales_id) AS num_orders "
                    + "FROM sales_history s "
                    + "JOIN customers c ON s.customer_id = c.customer_id "
                    + "GROUP BY c.customer_id, c.first_name, c.last_name "
                    + "ORDER BY total_spent DESC "
                    + "LIMIT 5;";
            
            //send statement to DBMS
            ResultSet result = stmt.executeQuery(sqlStatement);

            //OUTPUT
            System.out.println("Customer Last names, first name, and sales id from the Database.");
            System.out.println("______________________________________");
            while (result.next()) {
                String name = result.getString("customer_name");
                double spent = result.getDouble("total_spent");
                int orders = result.getInt("num_orders");
                System.out.println(name + " | $" + spent + " | Orders: " + orders);
            }
        } catch (Exception e) {
            System.out.println("Error accessing Database.");
        }
        //closing the connection
        try {
            conn.close();
            System.out.println("Connection Closed.");
        } catch (Exception e) {
            System.out.println("Connection NOT Closed.");
        }//end try catch
    }//end main
}//end Class
