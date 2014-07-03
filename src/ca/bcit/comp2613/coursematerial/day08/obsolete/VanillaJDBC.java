package ca.bcit.comp2613.coursematerial.day08.obsolete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 
 * @author Henry
 * 
 *         This is an example of the WRONG (spelt obsolete) way of connecting to
 *         a DB Would have been an OK soln ... 10 years ago.
 * 
 */
public class VanillaJDBC {

	// yeah, I could make constants with some of the variables below
	// I could ... do that finally close thing ...
	// but then again ... Vanilla JDBC == Old Obsolete way
	// THROWAWAY (aka WTF) code below
	public static void main(String[] args) throws Exception {
		String driverClassName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://sql3.freemysqlhosting.net/sql340330";
		String username = "sql340330";
		String password = "dR5!xA3!";
		Class.forName(driverClassName);

		Connection con = DriverManager.getConnection(url, username, password);

		Statement stmt = con.createStatement();
		stmt.execute("select * from teacher");
		ResultSet rs = stmt.getResultSet();
		rs.next();
		while (rs.next()) {
			System.out.println(rs.getString("first_name"));
		}
	}

}
