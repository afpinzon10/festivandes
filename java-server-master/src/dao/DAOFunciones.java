package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import vos.Abono;
import vos.Boleta;
import vos.Espacio;
import vos.Funcion;
import vos.ListaBoletas;
import vos.ListaFunciones2;


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
	
	public void deleteFuncion(int idFuncion) throws SQLException{
		String sql = "UPDATE FUNCION SET REALIZADO = 2 WHERE IDFUNCION = " + idFuncion;
		
		
		System.out.println("SQL stmt    deleteFuncion:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	
	public ListaFunciones2 RFC7(int idcliente) throws SQLException{
		String sql = "SELECT DISTINCT IDFUNCION, FECHA, IDESPACIO, IDOBRA, REALIZADO FROM (SELECT * FROM FUNCION NATURAL JOIN BOLETA WHERE REALIZADO = 1)T1 INNER JOIN CLIENTE ON T1.IDCLIENTE = " + idcliente;
		
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		ArrayList<Funcion> Funciones1 = new ArrayList<Funcion>();
		ArrayList<Funcion> Funciones2 = new ArrayList<Funcion>();
		ArrayList<Funcion> Funciones3 = new ArrayList<Funcion>();
		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			Timestamp fecha = rs.getTimestamp("FECHA");
			int idEspacio = Integer.parseInt(rs.getString("IDESPACIO"));
			int idObra = Integer.parseInt(rs.getString("IDOBRA"));
			int realizado = rs.getInt("REALIZADO");
			Funciones1.add(new Funcion( idFuncion, fecha, idEspacio, idObra,realizado));
		}
		
		
		sql = "SELECT DISTINCT IDFUNCION, FECHA, IDESPACIO, IDOBRA, REALIZADO FROM (SELECT * FROM FUNCION NATURAL JOIN BOLETA WHERE REALIZADO = 0)T1 INNER JOIN CLIENTE ON T1.IDCLIENTE = " + idcliente;
		System.out.println(sql);
		prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			Timestamp fecha = rs.getTimestamp("FECHA");
			int idEspacio = Integer.parseInt(rs.getString("IDESPACIO"));
			int idObra = Integer.parseInt(rs.getString("IDOBRA"));
			int realizado = rs.getInt("REALIZADO");
			Funciones2.add(new Funcion( idFuncion, fecha, idEspacio, idObra,realizado));
		}
		
		sql = "SELECT DISTINCT IDFUNCION, FECHA, IDESPACIO, IDOBRA, REALIZADO FROM (SELECT * FROM FUNCION NATURAL JOIN BOLETASCANCELADAS)T1 INNER JOIN CLIENTE ON T1.IDCLIENTE = " + idcliente;
		System.out.println(sql);
		prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		rs = prepStmt.executeQuery();
		
		while (rs.next()) {
			int idFuncion = Integer.parseInt(rs.getString("IDFUNCION"));
			Timestamp fecha = rs.getTimestamp("FECHA");
			int idEspacio = Integer.parseInt(rs.getString("IDESPACIO"));
			int idObra = Integer.parseInt(rs.getString("IDOBRA"));
			int realizado = rs.getInt("REALIZADO");
			Funciones3.add(new Funcion( idFuncion, fecha, idEspacio, idObra,realizado));
		}
		
		return new ListaFunciones2(Funciones1,Funciones2,Funciones3);
	
	}

	public ListaBoletas darBoletas(int idFuncion) throws SQLException {
		ArrayList<Boleta> boletas  = new ArrayList<Boleta>();
		String sql = "SELECT IDBOLETA, IDLOCALIDAD, FILA, SILLA, IDFUNCION, IDCLIENTE FROM BOLETA WHERE IDFUNCION = " + idFuncion;

		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next())
		{
			
			int idBoleta = rs.getInt(1);
			int idLocalidad = rs.getInt(2);
			String fila = rs.getString(3);
			String silla = rs.getString(4);
			idFuncion = rs.getInt(5);
			int idCliente = rs.getInt(6);
			boletas.add(new Boleta(idBoleta, idLocalidad, fila, silla, idFuncion, idCliente));
		
		}
		
	System.out.println("HAY BOLETAS "+ boletas.size());
		return new ListaBoletas(boletas);
	}

}
