package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import vos.Funcion;
import vos.RFC8;
import vos.RFC8Espacio;
import vos.RFC8Funcion;

public class DAORFC8 {
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAORFC8 ()
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

	public ArrayList<RFC8> darRFC8() throws SQLException, Exception {
		ArrayList<RFC8> RFC8 = new ArrayList<RFC8>();
		String sql = "SELECT T3.NOMBRE AS NOMBREOBRA, IDOBRA, DURACION, IDIOMA, EDAD, SINOPSIS, COSTO, TRADUCCION, IDFUNCION, FECHA, IDESPACIO, NOMBREESPACIO, UBICACION, TIPO, CIUDAD, TELEFONO, HORAINICIO, HORAFIN, T3.IDCOMPANIA, COMPANIA.NOMBRE AS NOMBRECOMPANIA, EMAIL, IDUSUARIO FROM (SELECT NOMBRE, T2.IDOBRA, DURACION, IDIOMA, EDAD, SINOPSIS, COSTO, TRADUCCION, IDFUNCION, FECHA, IDESPACIO, NOMBREESPACIO, UBICACION, TIPO, CIUDAD, TELEFONO, HORAINICIO, HORAFIN, IDCOMPANIA FROM (SELECT T1.NOMBRE, IDOBRA, DURACION, IDIOMA, EDAD, SINOPSIS, COSTO, TRADUCCION, IDFUNCION, FECHA, T1.IDESPACIO, ESPACIO.NOMBRE AS NOMBREESPACIO, UBICACION, TIPO, CIUDAD, TELEFONO, HORAINICIO, HORAFIN FROM (SELECT OBRA.IDOBRA, NOMBRE, DURACION, IDIOMA, EDAD, SINOPSIS, COSTO, TRADUCCION, IDFUNCION, FECHA, IDESPACIO, REALIZADO FROM OBRA INNER JOIN FUNCION ON OBRA.IDOBRA = FUNCION.IDOBRA)T1 INNER JOIN ESPACIO ON T1.IDESPACIO = ESPACIO.IDESPACIO)T2 INNER JOIN COMPANIAOBRA ON T2.IDOBRA = COMPANIAOBRA.IDOBRA)T3 INNER JOIN COMPANIA ON T3.IDCOMPANIA = COMPANIA.IDCOMPANIA";
		System.out.println(sql);

		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();

		while (rs.next()) {
			int idfuncion = rs.g;
			Timestamp fecha = ;
			int idespacio = ;
			int idobra = ;
			int realizado = ;
			int asistenciatotal = ;
			int asistenciaregistrados = ;
			///////////////////////////////////////////////////////////////////////////
			//idespacio = ;
			String nombre = ;
			int capacidad = ;
			String ubicacion = ;
			String tipo = ;
			String ciudad = ;
			String telefono = ;
			Date horainicio = ;
			Date horafin = ;
			int dinerogenerado = ;
			////////////////////////////////////////////////////////////////////////////
			int idusuario = ;
			//nombre = ;
			String email = ;
			int idcompania = ;
			/////////////////////////////////////////////////////////////////////////////
			ArrayList<RFC8Funcion> funciones = new ArrayList<>();
			funciones.add(new RFC8Funcion(idfuncion, fecha, idespacio, idobra, realizado, asistenciatotal, asistenciaregistrados));
			ArrayList<RFC8Funcion> funcionesespacio = new ArrayList<>();
			funcionesespacio.add(new RFC8Funcion(idfuncion, fecha, idespacio, idobra, realizado, asistenciatotal, asistenciaregistrados));
			ArrayList<RFC8Espacio> espacios = new ArrayList<>();
			espacios.add(new RFC8Espacio(funcionesespacio, idcompania, email, idcompania, email, email, email, email, horafin, horafin, idcompania));
			RFC8.add(new RFC8(idusuario, nombre, email, idcompania, funciones, espacios));
		}
		return RFC8;
	}
}
