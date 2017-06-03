package food.track;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    private String nick;
    private String email;
    private String age;
    private String height;
    private String weight;
    private String delta;

    public User (int id) {
        String connectionUrl = "jdbc:sqlserver://foodtrack.database.windows.net:1433;database=FoodTrack;user=notroot@foodtrack;password=adihajmaktre+69";

        // Declare the JDBC objects.
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            // Create and execute an SQL statement that returns some data.
            String SQL = "SELECT nick, email, age, height, weight, delta FROM users WHERE id_users = "+id;
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            rs.next();
            nick = rs.getString(1);
            email = rs.getString(2);
            age = rs.getString(3);
            height = rs.getString(4);
            weight = rs.getString(5);
            delta = rs.getString(6);
        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

    public String getNick(){
        return nick;
    }
    public String getEmail(){
        return email;
    }


    public void setNick(String nick){
        this.nick = nick;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDelta() {
        return delta;
    }

    public void setDelta(String delta) {
        this.delta = delta;
    }

    @Override
    public String toString() {
        return "User{" +
                "nick='" + nick + '\'' +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", delta='" + delta + '\'' +
                '}';
    }
}