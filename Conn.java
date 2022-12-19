
package electricty.billing.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "Snehal@143");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
}
}
