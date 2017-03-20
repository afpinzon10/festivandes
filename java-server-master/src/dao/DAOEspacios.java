package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import vos.Espacio;

public class DAOEspacios {

	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOEspacios ()
	{
		recursos = new ArrayList<Object>();
	}

	//Cierra el recuerso
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
	
	public ArrayList<Espacio> darEspacios() throws SQLException
	{
		ArrayList<Espacio> usuarios  = new ArrayList<Espacio>();
		String sql = "SELECT * FROM ESPACIO";

		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next())
		{
			int idEspacio = Integer.parseInt(rs.getString("IDESPACIO"));
			String nombre = rs.getString("NOMBRE");
			int capacidad = Integer.parseInt(rs.getString("CAPACIDAD"));
			String ubicacion = rs.getString("UBICACION");
			String tipo = rs.getString("TIPO");
			String ciudad = rs.getString("CIUDAD");
			String telefono = rs.getString("TELEFONO");
			Timestamp horaInicio = rs.getTimestamp("HORAINICIO");
			Timestamp horaFin =rs.getTimestamp("HORAFIN");
			usuarios.add(new Espacio(null, idEspacio, nombre, capacidad, ubicacion, tipo, ciudad, telefono, horaInicio, horaFin));
		}
		return usuarios;
	}
	
	
	public void addEspacio(Espacio espacio) throws SQLException {
		String sql = "INSERT INTO ESPACIO VALUES (NOMBRE, CAPACIDAD, UBICACION, TIPO, CIUDAD, TELEFONO, HORAINICIO, HORAFIN)";
		sql += espacio.getNombre() + ",'";
		sql += espacio.getCapacidad() + ",'";
		sql += espacio.getUbicacion() + ",'";
		sql += espacio.getTipo() + ",'";
		sql += espacio.getCiudad() + ",'";
		sql += espacio.getTelefono() + ",'";
		sql += espacio.getHorainicio() + ",'";
		sql += espacio.getHorainicio() + ",'";
		sql += espacio.getHorafin() + ")";
		
		System.out.println("SQL stmt    addCliente:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
		
	}
}
