package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import vos.RFC1;
import vos.RFC2;

public class DAORFC2 {

private ArrayList<Object> recursos;
	
	private Connection conn;
	
	public DAORFC2 ()
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
	
	public ArrayList<RFC2> darRFC2() throws SQLException, Exception {
		ArrayList<RFC2> rfc2 = new ArrayList<RFC2>();
		String sql = "SELECT * FROM (SELECT * FROM  PRODUCCION NATURAL JOIN COMPANIA)T1  "
				+ "INNER JOIN (SELECT * FROM (SELECT * FROM OBRA NATURAL JOIN FUNCION) NATURAL JOIN "
				+ "(SELECT * FROM CATEGORIA_OBRA NATURAL JOIN CATEGORIA))T2 ON T2.IDOBRA = T1.IDOBRA "
				+ "WHERE T1.NOMBRE LIKE '%RIOT%' AND FECHA BETWEEN TO_TIMESTAMP('2017/03/19 10:13:18', 'YYYY/MM/DD HH24:MI:SS') AND TO_TIMESTAMP('2017/03/19 14:13:18', 'YYYY/MM/DD HH24:MI:SS')"
				+ "AND DESCRIPCION LIKE '%MUSICAL%' AND TRADUCCION=1";
		System.out.println(sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			Timestamp fecha = rs.getTimestamp(3);
			String localidad = rs.getString(4);
			int precio = rs.getInt(5);
			String espacio = rs.getString(6);
			String ubicacion = rs.getString(7);
			String tipo = rs.getString(8);
			String ciudad = rs.getString(9);
			String telefono = rs.getString(10);
			int disponible = rs.getInt(11);
			String obra = rs.getString(13);
			int duracion = rs.getInt(14);
			String idioma = rs.getString(15);
			int edad = rs.getInt(16);
			String sinopsis = rs.getString(17);
			int costo = rs.getInt(18);
			int traduccion = rs.getInt(19);
			
		
			rfc2.add(new RFC2(fecha, localidad, precio, espacio, ubicacion, tipo, ciudad, telefono, disponible, obra, duracion, idioma, edad, sinopsis, costo, traduccion));
		}
		return rfc2;
	}
}
