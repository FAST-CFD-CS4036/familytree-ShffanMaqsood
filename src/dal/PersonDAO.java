package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.PersonTO;

public class PersonDAO {
	private Connection con;
	
	public PersonDAO() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/22fallfinal?useSSL=false";
		String user = "root";
		String password = "";
		con = DriverManager.getConnection(url, user, password);
	}
	public PersonDAO(Connection con) {
		this.con = con;
	}
	
	public PersonTO getPerson(int cnic) {
		PersonTO person = new PersonTO();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `citizen` WHERE `cnic` = ?");
			ps.setInt(1, cnic);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				person.setCnic(rs.getInt("cnic"));
				person.setName(rs.getString("name"));
				person.setFather(rs.getInt("father"));
				person.setMother(rs.getInt("mother"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}
	
	
	public PersonTO getPersonDetails(String name) {
		PersonTO person = new PersonTO();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM `citizen` WHERE `name` = ?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				person.setCnic(rs.getInt("cnic"));
				person.setName(rs.getString("name"));
				person.setFather(rs.getInt("father"));
				person.setMother(rs.getInt("mother"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}

}
