package co.com.tipi.test.modules.person.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import co.com.tipi.test.modules.person.model.PersonDTO;

@Repository
public class PersonRepository{
	
	@Value("${database.url}")
	private String dataBaseUrl;
	
	@Value("${database.username}")
	private String dataBaseUserName;
	
	@Value("${database.password}")
	private String dataBasePassword;
	
	public void insertPerson(PersonDTO person) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = DriverManager.getConnection(dataBaseUrl, dataBaseUserName, dataBasePassword);
			pstmt = connection.prepareStatement("insert into  tipitest.person(name,last_name,age) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getLastName());
			pstmt.setInt(3, person.getAge());
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new Exception("Error al insertar la persona");
			}		
			
		} finally {
			pstmt.close();
			connection.close();
		}
	}

	public void updatePerson(PersonDTO person) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			System.err.println(person.toString());
			connection = DriverManager.getConnection(dataBaseUrl, dataBaseUserName, dataBasePassword);
			pstmt = connection.prepareStatement("UPDATE tipitest.person SET name = ?,last_name = ?, age = ? where id = ?");
			pstmt.setString(1, person.getName());
			pstmt.setString(2, person.getLastName());
			pstmt.setInt(3, person.getAge());
			pstmt.setInt(4, person.getId());
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new Exception("Error al actualizar la persona");
			}		
			
		} finally {
			pstmt.close();
			connection.close();
		}
	}

	public PersonDTO selectPerson(int id) throws SQLException{
		PersonDTO response = null;
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connection = DriverManager.getConnection(dataBaseUrl, dataBaseUserName, dataBasePassword);
			pstmt = connection.prepareStatement("SELECT * FROM tipitest.person where id = ?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				response = new PersonDTO();
				response.setId(rs.getInt("id"));
				response.setName(rs.getString("name"));
				response.setLastName(rs.getString("last_name"));
				response.setAge(rs.getInt("age"));
			}			
		} finally {
			pstmt.close();
			connection.close();
		}
		return response;
	}

	public void deletePerson(PersonDTO person) throws Exception {
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = DriverManager.getConnection(dataBaseUrl, dataBaseUserName, dataBasePassword);
			pstmt = connection.prepareStatement("DELETE FROM tipitest.person where id = ?");
			pstmt.setInt(1, person.getId());
			int rowCount = pstmt.executeUpdate();
			if (rowCount == 0) {
				throw new Exception("Error al eliminar la persona");
			}		
			
		} finally {
			pstmt.close();
			connection.close();
		}
	}
	
}