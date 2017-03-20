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
		ArrayList<Boleta> usuarios  = new ArrayList<Boleta>();
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
		
	System.out.println(usuarios.size());
		return usuarios;
	}
	
	public void addUsuario(Usuario user) throws SQLException{
		String sql = "INSERT INTO USUARIO VALUES (NULL,'";
		sql += user.getLogin() + "','";
		sql += user.getPassword() + "',";
		sql += user.getIdrol() + ")";
		
		System.out.println("SQL stmt    addUsuario:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
}
