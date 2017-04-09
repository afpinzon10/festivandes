package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import vos.RFC1;
import vos.RFC3;

public class DAORFC3 {
private ArrayList<Object> recursos;
	
	private Connection conn;
	
	public DAORFC3 ()
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
	
	public ArrayList<RFC3> darRFC3() throws SQLException, Exception {
		ArrayList<RFC3> rfc3 = new ArrayList<RFC3>();
		String sql = "SELECT NOMBRE,IDFUNCION, COUNT(*) AS TOTAL, SUM(PRECIO) AS PRODUCIDO FROM (SELECT IDCLIENTE, NOMBRE,IDFUNCION, PRECIO FROM BOLETA NATURAL JOIN LOCALIDAD) T1"
				+ " INNER JOIN"
				+ " (SELECT IDCLIENTE FROM CLIENTE WHERE IDUSUARIO IS NOT NULL)T2 ON T2.IDCLIENTE = T1.IDCLIENTE"
				+ " GROUP BY NOMBRE, IDFUNCION ORDER BY IDFUNCION";
		System.out.println(sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
				int idfuncion = rs.getInt(2);
			 	int vendidas =rs.getInt(3);
				int producido = rs.getInt(4);
				String localidad = rs.getString(1);
				boolean cliente = true;
			rfc3.add(new RFC3(idfuncion, vendidas, producido, localidad, cliente));
		}
		
		sql = "SELECT NOMBRE,IDFUNCION, COUNT(*) AS TOTAL, SUM(PRECIO) AS PRODUCIDO FROM (SELECT IDCLIENTE, NOMBRE,IDFUNCION, PRECIO FROM BOLETA NATURAL JOIN LOCALIDAD) T1"
				+ " INNER JOIN"
				+ " (SELECT IDCLIENTE FROM CLIENTE WHERE IDUSUARIO IS NULL)T2 ON T2.IDCLIENTE = T1.IDCLIENTE"
				+ " GROUP BY NOMBRE, IDFUNCION ORDER BY IDFUNCION";
		System.out.println(sql);
		
		prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idfuncion = rs.getInt(2);
		 	int vendidas =rs.getInt(3);
			int producido = rs.getInt(4);
			String localidad = rs.getString(1);
			boolean cliente = true;
		rfc3.add(new RFC3(idfuncion, vendidas, producido, localidad, cliente));
	}
		return rfc3;
	}
}
