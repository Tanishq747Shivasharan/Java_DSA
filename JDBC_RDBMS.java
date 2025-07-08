import java.sql.*;
import java.util.Scanner;

public class JDBC_RDBMS {
	private static final String URL = "jdbc:postgresql://localhost:5432/codecompletedb";
	private static final String USER = "postgres";
	private static final String PASSWD = "tan3533";

	private static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWD);
	}

	public static void createTbl(String tbl, String sql) {
		try (Connection con = getConnection();
				Statement stmt = con.createStatement()) {
			stmt.executeUpdate(sql);
			System.out.println(tbl + " created successfully.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertData(String tblName, String name, int age, double salary) {
		String query = "INSERT INTO " + tblName + "(name, age, salary) VALUES (?, ?, ?)";
		try (Connection con = getConnection();
				PreparedStatement pstm = con.prepareStatement(query)) {
			pstm.setString(1, name);
			pstm.setInt(2, age);
			pstm.setDouble(3, salary);
			pstm.executeUpdate();
			System.out.println("Data inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateData(String tblName, int id, String name, int newAge, double salary) {
		String query = "UPDATE " + tblName + " SET name = ?, age = ?, salary = ? WHERE id = ?";
		try (Connection con = getConnection();
				PreparedStatement pstm = con.prepareStatement(query)) {
			pstm.setString(1, name);
			pstm.setInt(2, newAge);
			pstm.setDouble(3, salary);
			pstm.setInt(4, id);
			int rowAffected = pstm.executeUpdate();
			System.out.println(rowAffected + " row(s) updated.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateMulData(String tblName, Integer[] ids, String name, int age, double salary) {
		String sql = "UPDATE " + tblName + " SET name = ?, age = ?, salary = ? WHERE id = ANY(?)";
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, salary);

			Array idArray = con.createArrayOf("INTEGER", ids);
			pstmt.setArray(4, idArray);

			int rows = pstmt.executeUpdate();
			System.out.println(rows + " row(s) updated using collection.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void removeMulData(String tblName, Integer[] ids) {
		String sql = "DELETE FROM " + tblName + " WHERE id = ANY(?)";
		try (Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			Array idArray = con.createArrayOf("INTEGER", ids);
			pstmt.setArray(1, idArray);
			int rows = pstmt.executeUpdate();
			System.out.println(rows + " row(s) removed using collection.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void showTable(String tblName) {
		String sql = "SELECT * FROM " + tblName;
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			System.out.println("\n--- Data from " + tblName + " ---");
			while (rs.next()) {
				System.out.printf("%d | %s | %d | %.2f%n",
						rs.getInt("id"),
						rs.getString("name"),
						rs.getInt("age"),
						rs.getDouble("salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		String tableName = "empdetails";
		int choice;
		while (true) {
			System.out.println("\n--- MENU ---");
			System.out.println("1. Create Table");
			System.out.println("2. Insert Data");
			System.out.println("3. Update Single Row");
			System.out.println("4. Show Table");
			System.out.println("5. Exit");
			System.out.println("6. Update Multiple Rows");
			System.out.println("7. Remove Multiple Rows");

			System.out.print("Please Enter Your choice: ");
			if (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Try again.");
				scanner.next();
				continue;
			}
			choice = scanner.nextInt();
			scanner.nextLine(); 

			switch (choice) {
				case 1:
					String createSQL = "CREATE TABLE IF NOT EXISTS " + tableName +
							"(id SERIAL PRIMARY KEY, name VARCHAR(100), age INT, salary DECIMAL(10,2))";
					createTbl(tableName, createSQL);
					break;

				case 2:
					System.out.print("Enter Name: ");
					String name = scanner.nextLine();
					System.out.print("Enter Age: ");
					int age = scanner.nextInt();
					System.out.print("Enter Salary: ");
					double salary = scanner.nextDouble();
					insertData(tableName, name, age, salary);
					break;

				case 3:
					System.out.print("Enter ID to update: ");
					int id = scanner.nextInt();
					scanner.nextLine(); 
					System.out.print("New Name: ");
					String newName = scanner.nextLine();
					System.out.print("New Age: ");
					int newAge = scanner.nextInt();
					System.out.print("New Salary: ");
					double newSalary = scanner.nextDouble();
					updateData(tableName, id, newName, newAge, newSalary);
					break;

				case 4:
					showTable(tableName);
					break;

				case 5:
					System.out.println("Exiting...");
					scanner.close();
					return;

				case 6:
					System.out.print("Number of IDs to update: ");
					int countU = scanner.nextInt();
					Integer[] updateIds = new Integer[countU];
					for (int i = 0; i < countU; i++) {
						System.out.print("Enter ID " + (i + 1) + ": ");
						updateIds[i] = scanner.nextInt();
					}
					scanner.nextLine(); 
					System.out.print("New Name: ");
					String updName = scanner.nextLine();
					System.out.print("New Age: ");
					int updAge = scanner.nextInt();
					System.out.print("New Salary: ");
					double updSalary = scanner.nextDouble();
					updateMulData(tableName, updateIds, updName, updAge, updSalary);
					break;

				case 7:
					System.out.print("Number of IDs to delete: ");
					int countD = scanner.nextInt();
					Integer[] deleteIds = new Integer[countD];
					for (int i = 0; i < countD; i++) {
						System.out.print("Enter ID " + (i + 1) + ": ");
						deleteIds[i] = scanner.nextInt();
					}
					removeMulData(tableName, deleteIds);
					break;

				default:
					System.out.println("Invalid choice. Try again.");
			}
		}
	}
}