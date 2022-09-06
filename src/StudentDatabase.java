import java.sql.*;

public class StudentDatabase {

    private ResultSet rs;
    private Statement st;
    final static String url = "jdbc:mysql://localhost:3306/users";
    final static String username = "rocky";
    final static String password = "";
    public final String columns[] = {"id", "name", "mobileNumber", "age", "dob", "course", "courseDuration", "startDate", "endDate", "fathersName", "mothersName", "address", "feesPerMonth", "totalFees", "feesPaid"};
    public final int tableColumns = columns.length;

    StudentDatabase()throws Exception
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, username, password);
        st = con.createStatement();
        //rs = st.executeQuery(query);
    }

    int countRows()
    {
        String query = "select count(*) from students;";
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


    String[][] getData()throws Exception
    {
        int count = countRows();
        String data[][] = new String[count][tableColumns];
        String query = "SELECT * FROM students";
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
                //System.out.println(data[i][j]);
            }
        }
        return data;
    }

    String[][] getFilteredData(int searchColumnNumber, String searchText)throws Exception
    {
        int count = countRows();
        String data[][] = new String[count][tableColumns];
        String query;
        String searchColumn = columns[searchColumnNumber];
        if(searchColumnNumber==0 || searchColumnNumber==3 ||  searchColumnNumber==12  || searchColumnNumber==13)
            query = "SELECT * FROM students WHERE "+searchColumn+"="+searchText+";";
        else
            query = "SELECT * FROM students WHERE "+searchColumn+"=\""+searchText+"\";";

        try {
            rs = st.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int i=0;
        while(rs.next()) 
        {
            for(int j=0;j<tableColumns;j++)
            {
                data[i][j] = rs.getString(columns[j]);
            }
            i++;
        }
        return data;
    }

    String[] updateFees(String id, String feesPaid)throws Exception
    {
        String query = "UPDATE students SET feesPaid=\""+feesPaid+"\" WHERE id="+id+";";
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String getDataQuery = "SELECT * FROM students WHERE id="+id+";";
        try {
            rs = st.executeQuery(getDataQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.next();
        String data[]=new String[tableColumns];
        for(int j=0;j<tableColumns;j++)
            {
                data[j] = rs.getString(columns[j]);
                System.out.println(data[j]);
            }
        return data;
    }

    int getNextRow()
    {
        String lastIdQuery = "SELECT id FROM students ORDER BY id DESC LIMIT 1;";
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

    String[] registerData(String userData[])throws Exception
    {
        String id = Integer.toString(getNextRow()+1);
        String query = "INSERT INTO students VALUES ("+id+", \""+userData[0]+"\", "+"\""+userData[1]+"\", "+"\""+userData[2]+"\", "+"\""+userData[3]+"\", "+"\""+userData[4]+"\", "+"\""+userData[5]+"\", "+userData[6]+", "+userData[7]+", \""+userData[8]+"\", "+"\""+userData[9]+"\", "+"\""+userData[10]+"\""+", \""+userData[11]+"\", "+userData[12]+", \""+userData[13]+"\");";
        System.out.println(query);
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String getDataQuery = "SELECT * FROM students WHERE id="+id+";";
        try {
            rs = st.executeQuery(getDataQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.next();
        String data[]=new String[tableColumns];
        for(int j=0;j<tableColumns;j++)
            {
                data[j] = rs.getString(columns[j]);
                System.out.println(data[j]);
            }
        return data;
    }

    String[] updateData(String userData[])throws Exception
    {
        String id = userData[0];
        String query = "UPDATE students SET name=\""+userData[1]+"\", mobileNumber=\""+userData[2]+"\", course=\""+userData[3]+"\", courseDuration=\""+userData[4]+"\", startDate=\""+userData[5]+"\", endDate=\""+userData[6]+"\", feesPerMonth="+userData[7]+", totalFees="+userData[8]+", fathersName=\""+userData[9]+"\", mothersName=\""+userData[10]+"\", address=\""+userData[11]+"\", dob=\""+userData[12]+"\", age="+userData[13]+", feesPaid=\""+userData[14]+"\" WHERE id="+userData[0]+";";
        System.out.println(query);
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String getDataQuery = "SELECT * FROM students WHERE id="+id+";";
        try {
            rs = st.executeQuery(getDataQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        rs.next();
        String data[]=new String[tableColumns];
        for(int j=0;j<tableColumns;j++)
            {
                data[j] = rs.getString(columns[j]);
                System.out.println(data[j]);
            }
        return data;
    }
    void deleteStudent(String id)
    {
        String query = "DELETE FROM students WHERE id = "+id+";";
        try {
            st.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
