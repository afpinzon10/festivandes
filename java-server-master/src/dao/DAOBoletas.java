package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.Boleta;
import vos.Usuario;

public class DAOBoletas {
	
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOBoletas ()
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
	
	public ArrayList<Boleta> darBoletas() throws SQLException
	{
		ArrayList<Boleta> boletas  = new ArrayList<Boleta>();
		String sql = "SELECT IDBOLETA, IDLOCALIDAD, FILA, SILLA, IDFUNCION, IDCLIENTE FROM BOLETA;";

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
			int idFuncion = rs.getInt(5);
			int idCliente = rs.getInt(6);
			boletas.add(new Boleta(idBoleta, idLocalidad, fila, silla, idFuncion, idCliente));
		
		}
		
	System.out.println("HAY BOLETAS "+ boletas.size());
		return boletas;
	}
	
	public void addBoleta(Boleta boleta) throws SQLException{
		String sql = "INSERT INTO BOLETA VALUES (";
		sql += boleta.getIdboleta() + ",";
		sql += boleta.getIdlocalidad() + ",'";
		sql += boleta.getSilla() + "',";
		sql += boleta.getIdfuncion() + ",";
		sql += boleta.getIdcliente() + ",'";
		sql += boleta.getFila() + "')";
		
		System.out.println("SQL stmt    addUsuario:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}

	public boolean sillaDispoble(Boleta boleta) throws SQLException {
		
		String sql = "SELECT COUNT(*) FROM BOLETA WHERE SILLA='"+boleta.getSilla()+"' AND FILA ='"+boleta.getFila()+"' ";
		System.out.println("SQL stmt    addUsuario:" + sql);
		
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		int existe =0;
		while (rs.next()){
			existe = rs.getInt(1);
		}
		if(existe >0){
			
			return false;
		}
		return true;
	}

	public boolean boletasDisponibles(Boleta boleta) throws SQLException {

		String sql = "SELECT DISTINCT CAPACIDAD -(SELECT COUNT(*) FROM BOLETA) AS BOLETASDISPONIBLES FROM (SELECT * FROM LOCALIDAD INNER JOIN ESPACIO ON LOCALIDAD.IDESPACIO=ESPACIO.IDESPACIO) NATURAL JOIN (SELECT * FROM FUNCION NATURAL JOIN BOLETA) WHERE IDFUNCION ="+boleta.getIdfuncion();
		System.out.println("SQL stmt    addUsuario:" + sql);
		
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		int total =0;
		while(rs.next()){
			 total = rs.getInt(1);
		}
		
		if(total <=0){
			return false;
		}
		return true;
		
	}
	
	public void deleteBoleta(Boleta boleta) throws SQLException{
		String sql = "DELETE FROM BOLETA WHERE IDBOLETA ="+boleta.getIdboleta();
		
		
		System.out.println("SQL stmt    deleteBoleta:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public int darCapacidadRestante(int idLocalidad, int idFuncion) throws SQLException{
		String vendiasSQL = "SELECT COUNT(IDFUNCION) as VENDIDAS  FROM BOLETA  WHERE IDLOCALIDAD = "+idLocalidad+" AND IDFUNCION = "+idFuncion+" group by IDFUNCION";
		System.out.println("SQL stmt:" + vendiasSQL);
		PreparedStatement prepStmt = conn.prepareStatement(vendiasSQL);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		int ocupadas = 0;
		
		while(rs.next()){
			 ocupadas = rs.getInt(1);
		}
		
		String totalesSQL = "SELECT  CAPACIDAD FROM LOCALIDAD NATURAL JOIN FUNCION WHERE IDFUNCION = "+idFuncion+" AND IDLOCALIDAD ="+idLocalidad;
		System.out.println("SQL stmt:" + totalesSQL);
		prepStmt = conn.prepareStatement(totalesSQL);
		recursos.add(prepStmt);
		rs = prepStmt.executeQuery();
		
		int tot = 0;
		
		while(rs.next()){
			 tot = rs.getInt(1);
		}
		
		int restantes = tot-ocupadas;
		return restantes;
		
	}
	
	public int darBoletaQueSigue() throws SQLException{
		String sql = "SELECT MAX(idBoleta) FROM BOLETA";
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		int siguiente =0;

		while(rs.next()){
			 siguiente = rs.getInt(1);
		}
		
		return siguiente;
	}
	
	public int darSillaQueSigue(int idLocalidad, int idFuncion) throws SQLException{
		
		String sql = "SELECT MAX(silla) FROM BOLETA WHERE IDLOCALIDAD = "+idLocalidad+ "AND IDFUNCION ="+idFuncion;
		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		int siguiente =0;

		while(rs.next()){
			 siguiente = Integer.parseInt(rs.getString(1));
		}
		
		return siguiente;
	}
	

}
