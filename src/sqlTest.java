import java.sql.*;

public class sqlTest {
    

    private static ResultSet rs;
    private static Statement st;
    final static String url = "jdbc:mysql://localhost:3306/users";
    final static String username = "rocky";
    final static String password = "";

    public static void main(String args[])throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        st = con.createStatement();
        //rs = st.executeQuery(query);
        String query = "select * from students;";
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.next();
        String count = rs.getString("id");
        System.out.println("Number of records in the cricketers_data table: "+count);
    }


}
