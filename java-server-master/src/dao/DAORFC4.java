package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vos.RFC3;
import vos.RFC4;

public class DAORFC4 {
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAORFC4 ()
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

	public ArrayList<RFC4> darRFC4() throws SQLException, Exception {
		ArrayList<RFC4> rfc4 = new ArrayList<RFC4>();
		String sql = "SELECT NOMBRE,IDFUNCION, COUNT(*) AS TOTAL, SUM(PRECIO) AS PRODUCIDO, ROUND((COUNT(*)/SUM(CAPACIDAD))*100,2) AS PORCENTAJE FROM "
				+ " (SELECT IDCLIENTE, A2.NOMBRE, A2.IDFUNCION, PRECIO, CAPACIDAD FROM (SELECT * FROM BOLETA NATURAL JOIN LOCALIDAD)A1 RIGHT JOIN (SELECT * FROM FUNCION NATURAL JOIN ESPACIO)A2 ON A1.IDFUNCION=A2.IDFUNCION) T1"
				+ " INNER JOIN"
				+ " (SELECT IDCLIENTE FROM CLIENTE WHERE IDUSUARIO IS NOT NULL)T2 ON T2.IDCLIENTE = T1.IDCLIENTE"
				+ " GROUP BY NOMBRE, IDFUNCION";
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int vendidas =rs.getInt(3);
			int producido = rs.getInt(4);
			int idfuncion = rs.getInt(2);
			String sitio = rs.getString(1);
			boolean cliente = true;
			double porcentaje = rs.getDouble(5);
			rfc4.add(new RFC4(vendidas, producido, idfuncion, sitio, cliente, porcentaje));
		}

		sql = "SELECT NOMBRE,IDFUNCION, COUNT(*) AS TOTAL, SUM(PRECIO) AS PRODUCIDO, ROUND((COUNT(*)/SUM(CAPACIDAD))*100,2) AS PORCENTAJE FROM "
				+ " (SELECT IDCLIENTE, A2.NOMBRE, A2.IDFUNCION, PRECIO, CAPACIDAD FROM (SELECT * FROM BOLETA NATURAL JOIN LOCALIDAD)A1 RIGHT JOIN (SELECT * FROM FUNCION NATURAL JOIN ESPACIO)A2 ON A1.IDFUNCION=A2.IDFUNCION) T1"
				+ " INNER JOIN"
				+ " (SELECT IDCLIENTE FROM CLIENTE WHERE IDUSUARIO IS NULL)T2 ON T2.IDCLIENTE = T1.IDCLIENTE"
				+ " GROUP BY NOMBRE, IDFUNCION";
		System.out.println(sql);

		prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		rs = prepStmt.executeQuery();

		while (rs.next()) {
			int vendidas =rs.getInt(3);
			int producido = rs.getInt(4);
			int idfuncion = rs.getInt(2);
			String sitio = rs.getString(1);
			boolean cliente = false;
			double porcentaje = rs.getDouble(5);
			rfc4.add(new RFC4(vendidas, producido, idfuncion, sitio, cliente, porcentaje));
		}
		return rfc4;
	}
}
