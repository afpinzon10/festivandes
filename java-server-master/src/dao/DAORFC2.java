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
		String sql = "SELECT * FROM (SELECT IDOBRA, IDFUNCION, FECHA, LOCALIDAD.NOMBRE AS LOCALIDAD, PRECIO, T1.NOMBRE, UBICACION, TIPO, CIUDAD, TELEFONO, CAPACIDAD -(SELECT COUNT(*) FROM BOLETA WHERE IDFUNCION =T1.IDFUNCION) AS DISPONIBLE FROM (SELECT * FROM FUNCION NATURAL JOIN ESPACIO)T1"
+ " INNER JOIN LOCALIDAD ON LOCALIDAD.IDESPACIO = T1.IDESPACIO)T2 INNER JOIN  OBRA ON OBRA.IDOBRA = T2.IDOBRA"
+ " ORDER BY DISPONIBLE";
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
