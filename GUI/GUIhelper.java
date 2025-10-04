
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultListModel;

public class GUIhelper {
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
