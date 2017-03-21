package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import vos.Preferencia;

public class DAOPreferencias {
	private ArrayList<Object> recursos;

	private Connection conn;

	public DAOPreferencias ()
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
	
	public ArrayList<Preferencia> darPreferencias(String idUsuario, String idCliente2) throws SQLException
	{
		ArrayList<Preferencia> usuarios  = new ArrayList<Preferencia>();
		String sql = "SELECT * FROM Preferencia WHERE IDCLIENTE = " + Integer.parseInt(idCliente2);

		System.out.println("SQL stmt:" + sql);
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		ResultSet rs = prepStmt.executeQuery();
		while (rs.next())
		{
			int idCliente = Integer.parseInt(rs.getString("IDCLIENTE"));
			int idCategoria = Integer.parseInt(rs.getString("IDCATEGORIA"));
			int edad = Integer.parseInt(rs.getString("EDAD"));
			String tipoEspacio = rs.getString("TIPOESPACIO");
			usuarios.add(new Preferencia(idCliente, idCategoria, edad, tipoEspacio));
		}
		return usuarios;
	}
	

	public void addPreferencia(Preferencia Preferencia, String idUsuario, String idCliente) throws SQLException {
		String sql = "INSERT INTO Preferencia (IDCLIENTE, IDCATEGORIA, EDAD, TIPOESPACIO) VALUES ( ";
		sql += Integer.parseInt(idCliente) + ",";
		sql += Preferencia.getIdcategoria() + ",";
		sql += Preferencia.getEdad() + ",'";
		sql += Preferencia.getTipoespacio() + "')";
		
		System.out.println("SQL stmt    addPreferencia:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
		
	}
	
	public void updatePreferencia(Preferencia Preferencia, String idUsuario, String idCliente) throws SQLException {
		String sql = "UPDATE Preferencia (IDCLIENTE, IDCATEGORIA, EDAD, TIPOESPACIO) VALUES ( ";
		sql += Integer.parseInt(idCliente) + ",";
		sql += Preferencia.getIdcategoria() + ",";
		sql += Preferencia.getEdad() + ",'";
		sql += Preferencia.getTipoespacio() + "') WHERE IDCLIENTE = " + Integer.parseInt(idCliente) + 
				" AND IDCATEGORIA = " + Preferencia.getIdcategoria() + 
				" AND EDAD LIKE '%" + Preferencia.getEdad() + 
				"%' AND TIPOESPACIO LIKE '%" + Preferencia.getTipoespacio() + 
				"%'";
		
		System.out.println("SQL stmt    updatePreferencia:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
	}
	
	public void deletePreferencia(Preferencia Preferencia, String idUsuario, String idCliente) throws SQLException {
		String sql = "DELETE FROM Preferencia WHERE IDCLIENTE = " + Integer.parseInt(idCliente) + 
				" AND IDCATEGORIA = " + Preferencia.getIdcategoria() + 
				" AND EDAD LIKE '%" + Preferencia.getEdad() + 
				"%' AND TIPOESPACIO LIKE '%" + Preferencia.getTipoespacio() + 
				"%'";
		
		System.out.println("SQL stmt    deletePreferencia:" + sql);
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		recursos.add(prepStmt);
		prepStmt.executeQuery();
		
	}
}
