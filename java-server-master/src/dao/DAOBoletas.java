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
		String sql = "SELECT * FROM BOLETA";

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
		sql += boleta.getFila() + "','";
		sql += boleta.getSilla() + "',";
		sql += boleta.getIdfuncion() + ",";
		sql += boleta.getIdcliente() + ")";
		
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
		
		if(rs.next()){
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
}
