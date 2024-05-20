package belama.eclipse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import belama.eclipse.model.*;

public class connecteDB {
	private String jdbcURL = "jdbc:mysql://localhost:3306/taskmg?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "belama@2024";

	private static final String INSERT_ChefProjects_SQL = "INSERT INTO chefproject" + "  (name, email, country, department) VALUES "
			+ " (?, ?, ?, ?);";
	private static final String SELECT_ChefProject_BY_ID = "select id,name,email,country,department from chefproject where id =?";
	private static final String SELECT_ALL_ChefProjects = "select * from chefproject";
	private static final String DELETE_ChefProject_SQL = "delete from chefproject where id = ?;";
	private static final String UPDATE_ChefProject_SQL = "update chefproject set name = ?,email= ?, country =?, department =? where id = ?;";
	
	private static final String INSERT_Projects_SQL = "INSERT INTO project" + "  (chef_id, title, description, start_date, en_date, duration) VALUES "
			+ " (?, ?, ?, ?, ?, ?);";
	private static final String SELECT_Project_BY_Pr_ID = "select pr_id,chef_id,title,description,start_date,end_date,duration from project where pr_id =?";
	private static final String SELECT_Project_BY_Chef_ID = "select pr_id,chef_id,title,description,start_date,end_date,duration from project where chef_id =?";
	private static final String SELECT_ALL_Projects = "select * from project";
	private static final String DELETE_Projects_SQL = "delete from project where pr_id = ?;";
	private static final String UPDATE_Projects_SQL = "update project set chef_id = ?,title= ?, description =?, start_date =?, end_date =?, duration =? where pr_id = ?;";

	public connecteDB() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertChefProject(ChefProject Chef_pr) throws SQLException {
		System.out.println(INSERT_ChefProjects_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ChefProjects_SQL)) {
			preparedStatement.setString(1, Chef_pr.getName());
			preparedStatement.setString(2, Chef_pr.getEmail());
			preparedStatement.setString(3, Chef_pr.getCountry());
			preparedStatement.setString(4, Chef_pr.getDepartment());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public void insertProject(Project project) throws SQLException {
		System.out.println(INSERT_ChefProjects_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ChefProjects_SQL)) {
			preparedStatement.setString(1, project.getName());
			preparedStatement.setString(2, project.getEmail());
			preparedStatement.setString(3, project.getCountry());
			preparedStatement.setString(4, project.getDepartment());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public ChefProject selectChefProject(int id) {
		ChefProject Chef_pr = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ChefProject_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String department = rs.getString("department");
				Chef_pr = new ChefProject(id, name, email, country, department);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Chef_pr;
	}

	public List<ChefProject> selectAllChefProjects() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<ChefProject> Chef_prs = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ChefProjects);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String department = rs.getString("department");
				Chef_prs.add(new ChefProject(id, name, email, country, department));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return Chef_prs;
	}

	public boolean deleteChefProject(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ChefProject_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateChefProject(ChefProject Chef_pr) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ChefProject_SQL);) {
			statement.setString(1, Chef_pr.getName());
			statement.setString(2, Chef_pr.getEmail());
			statement.setString(3, Chef_pr.getCountry());
			statement.setString(4, Chef_pr.getDepartment());
			statement.setInt(5, Chef_pr.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
