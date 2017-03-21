package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import vos.Usuario;

public class DAOUsuarios {

	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOUsuarios ()
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
	
	public ArrayList<Usuario> darUsuarios() throws SQLException
	{
		ArrayList<Usuario> usuarios  = new ArrayList<Usuario>();
		String sql = "SELECT * FROM USUARIO";

		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		
		while (rs.next())
		{
			System.out.println("while");
			int idUsuario = Integer.parseInt(rs.getString(1));
			String login = rs.getString(2);
			String password = rs.getString(3);
			int idRol = Integer.parseInt(rs.getString(4));
			System.out.println("usuario:"+login);
			usuarios.add(new Usuario(idUsuario, login, password, idRol));
		}
		
	System.out.println(usuarios.size());
		return usuarios;
	}
	
	public void addUsuario(Usuario user) throws SQLException{
		String sql = "INSERT INTO USUARIO VALUES (";
		sql += user.getIdusuario() + ", '";
		sql += user.getLogin() + "','";
		sql += user.getPassword() + "',";
		sql += user.getIdrol() + ")";
		
		System.out.println("SQL stmt    addUsuario:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	

}
