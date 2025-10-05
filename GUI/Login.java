
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;

//Opens the first page and logins into manager or cashier depending on the user name and password
public class Login implements ActionListener {

    private static JLabel Userlabel;
    private static JLabel Passwordlabel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JLabel success;
    private Connection conn;

    public Login(Connection conn) {
        this.conn = conn;
    }

    public void showLogin() {
        JFrame frame = new JFrame("Login");
        JPanel panel = new JPanel();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 160);
        frame.setLocationRelativeTo(null);  //show in the middle
        frame.add(panel);

        panel.setLayout(null);

        Userlabel = new JLabel("User");
        Userlabel.setBounds(10, 20, 80, 25);
        panel.add(Userlabel);

        Passwordlabel = new JLabel("Password");
        Passwordlabel.setBounds(10, 50, 80, 25);
        panel.add(Passwordlabel);

        userText = new JTextField();
        userText.setBounds(100, 20, 190, 25);
        panel.add(userText);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 190, 25); //x,y,width,height
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(10, 80, 80, 25);
        button.addActionListener(this);
        panel.add(button);

        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();

        try {
            Statement stmt = conn.createStatement();
            String statemtn = "SELECT * FROM employees WHERE email = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(statemtn);
            pstmt.setString(1, user);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            
            if (rs.next()) {
                String role = rs.getString("role");
                success.setText("Login successful");

                if (role.equals("Manager")){
                    // JOptionPane.showMessageDialog(null, "You ARE IN MANAGER BUDDY!");
                    Manager managerView = new Manager(conn);
                    managerView.showManager();
                }
                else if (role.equals("Cashier")){
                //    JOptionPane.showMessageDialog(null, "You ARE IN Cashier BUDDY!");
                    Cashier cashierView = new Cashier(conn);
                    cashierView.showCashier();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Unfortunatey you are not allowed to use the POS system!");
                }
                
                SwingUtilities.getWindowAncestor(button).dispose();
                // jdbcpostgreSQLGUI.showDatabaseGUI(conn);
            }
            else{
                success.setText("Wrong email or password");

            }

        } catch (Exception f) {
            f.printStackTrace();
            success.setText("Database error occurred");
            
            return;
        }
    }
}
