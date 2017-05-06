package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

import vos.Cliente;
import vos.RFC1;


public class DAOIT4 {
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOIT4 ()
	{
		recursos = new ArrayList<Object>();
	}

	public void cerrarRecursos() 
	{
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}

	public void setConn(Connection con){
		this.conn = con;
	}

	public ArrayList<Cliente> darRFC9(int idcompania) throws SQLException, Exception {
		
		ArrayList<Cliente> clientesRFC9 = new ArrayList<Cliente>();
		String sql = "SELECT DISTINCT IDCLIENTE, T3.NOMBRE,APELLIDO, T3.EMAIL, IDENTIFICACION FROM"
				+ "(SELECT IDCLIENTE, T1.NOMBRE, APELLIDO, EMAIL, IDENTIFICACION, IDOBRA FROM "
				+ "(SELECT IDCLIENTE, NOMBRE, APELLIDO, EMAIL, IDENTIFICACION, IDFUNCION FROM CLIENTE NATURAL JOIN BOLETA)T1"
				+ "INNER JOIN"
				+ "(SELECT IDFUNCION, IDOBRA FROM FUNCION NATURAL JOIN OBRA WHERE REALIZADO=1 AND FECHA BETWEEN '' AND '')T2"
				+ "ON T1.IDFUNCION=T2.IDFUNCION)T3"
				+ "INNER JOIN"
				+ "(SELECT IDOBRA FROM COMPANIAOBRA NATURAL JOIN COMPANIA WHERE IDCOMPANIA="+idcompania+")T4"
				+ "ON T3.IDOBRA=T4.IDOBRA"
				+ "ORDER BY A";
		System.out.println("RFC9"+sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idUsuario = rs.getInt(1);
			String nombre = rs.getString(2);
			String apellido = rs.getString(3);
			String email = rs.getString(4);
			String identificacion = rs.getString(5);
			clientesRFC9.add(new Cliente(null, idUsuario, nombre, apellido, email, identificacion));
		}
		return clientesRFC9;
	}
	
public ArrayList<Cliente> darRFC10() throws SQLException, Exception {
		
		ArrayList<Cliente> clientesRFC10 = new ArrayList<Cliente>();
		String sql ="SELECT IDCLIENTE, NOMBRE, APELLIDO, EMAIL, IDENTIFICACION FROM CLIENTE"
				+ "MINUS"
				+ "SELECT DISTINCT IDCLIENTE, T3.NOMBRE,APELLIDO, T3.EMAIL, IDENTIFICACION FROM"
				+ "(SELECT IDCLIENTE, T1.NOMBRE, APELLIDO, EMAIL, IDENTIFICACION, IDOBRA FROM "
				+ "(SELECT IDCLIENTE, NOMBRE, APELLIDO, EMAIL, IDENTIFICACION, IDFUNCION FROM CLIENTE NATURAL JOIN BOLETA)T1"
				+ "	INNER JOIN"
				+ "(SELECT IDFUNCION, IDOBRA FROM FUNCION NATURAL JOIN OBRA WHERE REALIZADO=1 AND FECHA BETWEEN '' AND '')T2"
				+ "ON T1.IDFUNCION=T2.IDFUNCION)T3"
				+ "INNER JOIN"
				+ "(SELECT IDOBRA FROM COMPANIAOBRA NATURAL JOIN COMPANIA WHERE IDCOMPANIA=0)T4"
				+ "	ON T3.IDOBRA=T4.IDOBRA"
				+ "ORDER BY A";
		System.out.println("RFC10"+sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idUsuario = rs.getInt(1);
			String nombre = rs.getString(2);
			String apellido = rs.getString(3);
			String email = rs.getString(4);
			String identificacion = rs.getString(5);
			clientesRFC10.add(new Cliente(null, idUsuario, nombre, apellido, email, identificacion));
		}
		return clientesRFC10;
	}

public ArrayList<Cliente> darRFC11() throws SQLException, Exception {
	
	ArrayList<Cliente> clientesRFC11 = new ArrayList<Cliente>();
	String sql = "SELECT "
			+ "NOMBREOBRA AS NOMBRE_OBRA, "
			+ "FECHA AS FECHA_FUNCION, "
			+ "NOMBRE AS SITIO_FUNCION, "
			+ "COUNT(IDBOLETA) AS CANTIDAD_BOLETAS_VENDIDAS, "
			+ "COUNT(IDCLIENTE) AS CANTIDAD_USUARIOS_REGISTRADOS "
			+ "FROM OBRA "
			+ "NATURAL JOIN "
			+ "FUNCION "
			+ "NATURAL JOIN "
			+ "ESPACIO "
			+ "NATURAL JOIN "
			+ "BOLETA "
			+ "NATURAL JOIN "
			+ "CLIENTE "
			+ "NATURAL JOIN "
			+ "LOCALIDAD "
			+ "NATURAL JOIN "
			+ "DESCRIPCIONESESPACIO "
			+ "NATURAL JOIN "
			+ "DESCRIPCIONTECNICA"
			+ "WHERE "
			+ "FECHA BETWEEN fecha1 AND fecha2 "
			+ "AND "
			+ "DESCRIPCION LIKE '%%' "
			+ "AND "
			+ "TIPO_LOCALIDAD LIKE '%%' "
			+ "AND "
			+ "TO_CHAR(FECHA, 'HH') BETWEEN hora1 AND hora2  "
			+ "AND "
			+ "TO_CHAR(FECHA, 'DD') = 0";
	
	
	System.out.println("RFC11"+sql);

	PreparedStatement prepStmt = conn.prepareStatement(sql);
	recursos.add(prepStmt);
	ResultSet rs = prepStmt.executeQuery();
//TODO HACER DAO
	while (rs.next()) {
		int idUsuario = rs.getInt(1);
		String nombre = rs.getString(2);
		String apellido = rs.getString(3);
		String email = rs.getString(4);
		String identificacion = rs.getString(5);
		clientesRFC11.add(new Cliente(null, idUsuario, nombre, apellido, email, identificacion));
	}
	return clientesRFC11;
}

public ArrayList<Cliente> darRFC12() throws SQLException, Exception {
	
	ArrayList<Cliente> clientesRFC12 = new ArrayList<Cliente>();
	String sql = "SELECT IDCLIENTE, "
			+ "NOMBRE, "
			+ "APELLIDO, "
			+ "EMAIL, "
			+ "IDENTIFICACION FROM"
			+ "(SELECT "
			+ "IDCLIENTE, "
			+ "NOMBRE, "
			+ "APELLIDO, "
			+ "EMAIL, "
			+ "IDENTIFICACION, "
			+ "COUNT(IDBOLETA) AS CONTEO"
			+ "FROM "
			+ "(CLIENTE "
			+ "NATURAL JOIN "
			+ "BOLETA "
			+ "NATURAL JOIN "
			+ "LOCALIDAD) "
			+ "WHERE NOMBRELOCALIDAD = 'VIP'"
			+ "GROUP BY IDCLIENTE, NOMBRE, APELLIDO, EMAIL, IDENTIFICACION)"
			+ "WHERE CONTEO >= N";
	
	System.out.println("RFC12"+sql);

	PreparedStatement prepStmt = conn.prepareStatement(sql);
	recursos.add(prepStmt);
	ResultSet rs = prepStmt.executeQuery();

	while (rs.next()) {
		int idUsuario = rs.getInt(1);
		String nombre = rs.getString(2);
		String apellido = rs.getString(3);
		String email = rs.getString(4);
		String identificacion = rs.getString(5);
		clientesRFC12.add(new Cliente(null, idUsuario, nombre, apellido, email, identificacion));
	}
	return clientesRFC12;
}
	
}
