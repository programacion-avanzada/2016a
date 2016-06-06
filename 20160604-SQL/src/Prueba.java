import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;

public class Prueba {
	
	private Connection conn;
	
	public Prueba() {
		conn = MySQLConnection.getConnection();
	}
	
	public void listarEmpleados() {
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("Select * from VWEmpleado");
			while (rs.next()) {
				int cod_empleado = rs.getInt(1);
				String empleado = rs.getString(2);
				String documento = rs.getString(3);
				String departamento = rs.getString(4);
				
				System.out.printf("Legajo: %06d %s %s Dpto: %s\n", cod_empleado, empleado, documento, departamento);
			}			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void agregaEmpleado(int cod_empleado, String apellido, String nombre, int cod_tipodoc,
								String documento, int cod_departamento) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("Insert into Empleado values(?, ?, ?, ?, ?, ?)");
			pstmt.setInt(1, cod_empleado);
			pstmt.setString(2, apellido);
			pstmt.setString(3, nombre);
			pstmt.setInt(4, cod_tipodoc);
			pstmt.setString(5, documento);
			pstmt.setInt(6, cod_departamento);
			pstmt.execute();			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void agregaEmpleado(String apellido, String nombre, int cod_tipodoc,
			String documento, int cod_departamento) {
		CallableStatement cStmt = null;
		
		try {
			cStmt = conn.prepareCall("{call INSERTA_EMPLEADO(?, ?, ?, ?, ?)}");
			cStmt.setString(1, apellido);
			cStmt.setString(2, nombre);
			cStmt.setInt(3, cod_tipodoc);
			cStmt.setString(4, documento);
			cStmt.setInt(5, cod_departamento);
			cStmt.execute();			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				cStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	
	public void actualizaEmpleadoDpto(int cod_empleado, int cod_departamento) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("Update Empleado set cod_departamento = ? where cod_empleado = ?");
			pstmt.setInt(1, cod_departamento);
			pstmt.setInt(2, cod_empleado);
			pstmt.executeUpdate();			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void eliminaEmpleado(int cod_empleado) {
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement("Delete from Empleado where cod_empleado = ?");
			pstmt.setInt(1, cod_empleado);
			pstmt.executeUpdate();			
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}
	
	public void desconectar() {
		MySQLConnection.close();
	}

	public static void main(String[] args) {
		
		Prueba prueba = new Prueba();
		System.out.println("Agrego empleados");
		prueba.agregaEmpleado(100000, "Crispino", "Julio", 1, "12345678", 200);
		prueba.agregaEmpleado(100001, "Videla", "Lucas", 1, "23456789", 200);
		prueba.agregaEmpleado(100002, "Perez", "Juan", 1, "34567891", 200);
		prueba.agregaEmpleado("Acme", "Coyote", 1, "11111111", 200);
		prueba.listarEmpleados();
		System.out.println("Actualizo el departamento del empleado Perez Juan");
		prueba.actualizaEmpleadoDpto(100002, 100);
		prueba.listarEmpleados();
		System.out.println("Elimino al empleado Perez Juan");
		prueba.eliminaEmpleado(100002);
		prueba.listarEmpleados();
		prueba.eliminaEmpleado(100003);
		prueba.eliminaEmpleado(100001);
		prueba.eliminaEmpleado(100000);
		prueba.desconectar();
	}
}
