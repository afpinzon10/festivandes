package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import vos.Espacio;
import vos.Funcion;


public class DAOFunciones {
	
private ArrayList<Object> recursos;
	
	private Connection conn;
	
	public DAOFunciones ()
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
	
	public ArrayList<Funcion> darFunciones() throws SQLException, Exception {
		ArrayList<Funcion> Funciones = new ArrayList<Funcion>();
		String sql = "SELECT * FROM FUNCION";
		System.out.println(sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			Timestamp fecha = rs.getTimestamp("FECHA");
			int idEspacio = Integer.parseInt(rs.getString("IDESPACIO"));
			int idObra = Integer.parseInt(rs.getString("IDOBRA"));
			int realizado = rs.getInt("REALIZADO");
			Funciones.add(new Funcion( idFuncion, fecha, idEspacio, idObra,realizado));
		}
		return Funciones;
	}

	public void addFuncion(Funcion funcion) throws SQLException {
		
		String sql = "INSERT INTO FUNCION VALUES (FECHA, HORA, IDESPACIO, IDOBRA)";
		sql += funcion.getFecha() + ",'";

		sql += funcion.getIdespacio() + ",'";
		sql += funcion.getIdobra() +")";
		
		System.out.println("SQL stmt    addCliente:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
		
	}
	
	public void funcionRealizada(Funcion func) throws SQLException{
		String sql = "UPDATE FUNCION SET REALIZADO = 1 WHERE IDFUNCION = "+func.getIdfuncion();
		System.out.println("SQL stmt    realizar funcion:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
		
	}
	
	
	public ArrayList<Funcion> darFunciones(String fechaInicio, String fechaFin, String companiaTeatro, String categoriaEspectaculo, String idioma, boolean traduccion) throws SQLException, Exception {
		ArrayList<Funcion> Funciones = new ArrayList<Funcion>();
		String sql = "SELECT * FROM FUNCION WHERE";
		
		
		int cont = 0;
		if (fechaInicio != null && fechaFin != null) {
			sql += "FECHA BETWEEN TO_DATE('" + fechaInicio + ",'dd/mm/yyyy) AND TO_DATE('" + fechaFin + ",'dd/mm/yyyy)";
			cont++;
		}
		if (companiaTeatro != null) {
			if(cont>0){ sql += " AND ";}
			
		}
		System.out.println(sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			Timestamp fecha = rs.getTimestamp("FECHA");
			int idEspacio = Integer.parseInt(rs.getString("IDESPACIO"));
			int idObra = Integer.parseInt(rs.getString("IDOBRA"));
			int realizado = rs.getInt("REALIZADO");
			Funciones.add(new Funcion( idFuncion, fecha, idEspacio, idObra,realizado));
		}
		return Funciones;
	}
	
	public Timestamp darFechaFuncion(int idfuncion) throws SQLException{
		String sql = "SELECT fecha FROM FUNCION WHERE IDFUNCION = "+idfuncion;
		System.out.println(sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		Timestamp ts= null;
		
		while (rs.next()) {
			ts = rs.getTimestamp(1);
		}
		
		return ts;
	}

}
