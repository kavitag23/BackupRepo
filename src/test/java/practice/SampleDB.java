package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleDB {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
Driver driveref=new Driver();


DriverManager.registerDriver(driveref);
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customerdb ", "root", "123456789");

Statement state=con.createStatement();

ResultSet res=state.executeQuery("Select * from customerinfo;");

while(res.next())
{
	System.out.println(res.getString(1)+"-"+res.getInt(2)+"-"+res.getString(3));
}

con.close();

	}

}
