package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

import vos.RFC1;

public class DAORFC1 {
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAORFC1 ()
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

	public ArrayList<RFC1> darRFC1() throws SQLException, Exception {
		ArrayList<RFC1> rfc1 = new ArrayList<RFC1>();
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
			int idcompania =rs.getInt(1);
			int idobra = rs.getInt(2);
			String nombre = rs.getString(3);
			String email = rs.getString(4);
			int idusuario = rs.getInt(5);	
			String nombreobra = rs.getString(7);
			int duracion = rs.getInt(8);
			String idioma = rs.getString(9);
			int edad = rs.getInt(10);
			String sinopsis = rs.getString(11);
			int costo = rs.getInt(12);
			int traduccion = rs.getInt(13);
			Timestamp fecha = rs.getTimestamp(15);
			int idespacio = rs.getInt(16);
			int idcategoria = rs.getInt(17);
			String descripcion = rs.getString(18);


			rfc1.add(new RFC1(idcompania, idobra, nombre, email, idusuario, nombreobra, duracion, idioma, edad, sinopsis, costo, traduccion, fecha, idespacio, idcategoria, descripcion));
		}
		return rfc1;
	}
}
