package hoa.api.services.ticket.microservices.basic_auth_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import hoa.api.services.CRUD;
import hoa.api.services.Service;
import hoa.api.services.ServiceConstants;
import hoa.api.services.SqlOperationType;

public abstract class AllUsers extends Service implements CRUD {

	public int id;
	public String username, password, firstName, lastName, role;

	private final String connectionString = ServiceConstants.CONNECTION_STRING;
	protected SqlOperationType operation;

	protected AllUsers(SqlOperationType operation) {
		this.operation = operation;
	}
	
	public AllUsers() {super();};

	/**
	 * @return the operation
	 */
	public synchronized SqlOperationType getOperation() {
		return operation;
	}

	public final String queryDb() {
		if (this.getOperation().equals(SqlOperationType.select)) {
			return executeQuerySelect(this.getOperation());
		}

		return executeQuerySelect(this.getOperation());
	}

	public final String queryDb(SqlOperationType operation) {
		if (this.getOperation().equals(SqlOperationType.select)) {
			return executeQuerySelect(this.getOperation());
		}
		return executeQuerySelect(this.getOperation());
	}

	private String executeQuerySelect(SqlOperationType operation) {
		// TODO Auto-generated method stub
		String status = "";
		if (this.getOperation().equals(SqlOperationType.select)) {
			final String sql = getQuery();
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(connectionString);
				System.out.println("Connected.");
				PreparedStatement stmt = connection.prepareStatement(sql);
				if (operation.equals(SqlOperationType.insert)) {
					stmt.executeUpdate();
					status = "success";
				} else if (operation.equals(SqlOperationType.select)) {
					ResultSet rs = stmt.executeQuery();
					status = "success.";
					while (rs.next()) {
						this.id = rs.getInt(AllUsersColumns.UID.toString());
						this.username = rs.getString(AllUsersColumns.Username.toString());
						this.password = rs.getString(AllUsersColumns.Password.toString());
						this.firstName = rs.getString(AllUsersColumns.FirstName.toString());
						this.lastName = rs.getString(AllUsersColumns.LastName.toString());
						this.role = rs.getString(AllUsersColumns.Role.toString());
					}

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return status;
	}

	@Override
	public final Object excuteQuery(SqlOperationType operation) {
		String status = "";
		if (this.getOperation().equals(SqlOperationType.select)) {
			final String sql = getQuery();
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection(connectionString);
				System.out.println("Connected.");
				PreparedStatement stmt = connection.prepareStatement(sql);
				if (operation.equals(SqlOperationType.insert)) {
					stmt.executeUpdate();
					status = "success";
				} else if (operation.equals(SqlOperationType.select)) {
					ResultSet rs = stmt.executeQuery();
					status = "success.";
					while (rs.next()) {
						this.id = rs.getInt(AllUsersColumns.UID.toString());
						this.username = rs.getString(AllUsersColumns.Username.toString());
						this.password = rs.getString(AllUsersColumns.Password.toString());
						this.firstName = rs.getString(AllUsersColumns.FirstName.toString());
						this.lastName = rs.getString(AllUsersColumns.LastName.toString());
						this.role = rs.getString(AllUsersColumns.Role.toString());
					}

				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return status;
	}

	protected abstract ResultSet executeSql(PreparedStatement stmt);

	protected abstract String getQuery();

	@JsonProperty("id")
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	@JsonProperty("id")
	/**
	 * @param id the id to set
	 */
	public void setId(int personId) {
		this.id = personId;
	}

	@JsonProperty("username")
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	@JsonProperty("username")
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	@JsonProperty("password")
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@JsonProperty("firstName")
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("firstName")
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@JsonProperty("lastName")
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("lastName")
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@JsonProperty("role")
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	@JsonProperty("role")
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
