
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;

//helper class to get queries
public class DataBasehelper {
    public static DefaultListModel<String> getLastNames(Connection conn, String sqlStatement) throws Exception {
        DefaultListModel<String> model = new DefaultListModel<>();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sqlStatement);
        while (rs.next()) {
            model.addElement(rs.getString("last_name"));
        }
        return model;
    }


}
