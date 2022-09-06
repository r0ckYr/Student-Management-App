import java.sql.*;

public class UserDatabase {

    ResultSet rs;
    Statement st;
    final static String url = "jdbc:mysql://localhost:3306/users";
    final static String username = "rocky";
    final static String password = "";
    final String columns[] = {"id", "username", "password"};
    int tableColumns = columns.length;

    UserDatabase()throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        st = con.createStatement();
        //rs = st.executeQuery(query);
    }

    int countRows()
    {
        String query = "select count(*) from employees;";
        int count = 0;
        try {
            rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    boolean checkCredentials(String username, String password ,boolean isAdmin)
    {
        String getEmployeePasswordQuery = "SELECT password FROM employees WHERE username=\""+username+"\";";
        String getAdminPasswordQuery = "SELECT password FROM admins WHERE username=\""+username+"\";";
        String userPassword = "";
        try
        {
            if(isAdmin)
                rs = st.executeQuery(getAdminPasswordQuery);
            else
                rs = st.executeQuery(getEmployeePasswordQuery);

            if(rs.next())
            {
                userPassword = rs.getString("password");
            }
            else
                return false;
        }
        catch(SQLException se)
        {
            se.printStackTrace();
        }

        if(userPassword.equals(password) && userPassword.length()>0)
            return true;
        else
            return false;
    }

    String[][] getData()throws Exception
    {
        int count = countRows();
        String data[][] = new String[count][3];
        String query = "SELECT * FROM employees";
        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        for (int i=0; i<count; i++) 
        {
            rs.next();
            for(int j=0;j<tableColumns;j++)
            {
                data[i][j] = rs.getString(columns[j]);
                System.out.println(data[i][j]);
            }
        }
        return data;
    }
    void deleteUser(String id)
    {
        String query = "DELETE FROM employees WHERE id = "+id+";";
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    int getNextRow()
    {
        String lastIdQuery = "SELECT id FROM employees ORDER BY id DESC LIMIT 1;";
        int count = 0;
        try {
            rs = st.executeQuery(lastIdQuery);
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    int addUser(String username, String password)
    {
        int count = getNextRow();
        String id = Integer.toString(count+1);
        String query = "INSERT INTO employees values ("+id+",\""+username+"\",\""+password+"\");";
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

}
