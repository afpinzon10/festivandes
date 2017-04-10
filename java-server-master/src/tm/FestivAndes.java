package tm;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import dao.DAOAbono;
import dao.DAOBoletas;
import dao.DAOClientes;
import dao.DAOCompanias;
import dao.DAOEspacios;
import dao.DAOFunciones;
import dao.DAOPreferencias;
import dao.DAORF11;
import dao.DAORFC1;
import dao.DAORFC2;
import dao.DAORFC3;
import dao.DAORFC4;
import dao.DAOTablaVideos;
import dao.DAOUsuarios;


import vos.ListaVideos;
import vos.Preferencia;
import vos.RF10;
import vos.RFC1;
import vos.RFC2;
import vos.RFC3;
import vos.RFC4;
import vos.Abono;
import vos.Boleta;
import vos.Cliente;
import vos.Compania;
import vos.Espacio;
import vos.Funcion;
import vos.ListaBoletas;
import vos.ListaFunciones;
import vos.ListaPreferencias;
import vos.ListaRFC1;
import vos.ListaRFC2;
import vos.ListaRFC3;
import vos.ListaRFC4;
import vos.ListaUsuarios;
import vos.Usuario;
import vos.Video;


public class FestivAndes {


	private static final String CONNECTION_DATA_FILE_NAME_REMOTE = "/conexion.properties";
	private String connectionDataPath;
	private String user;
	private String password;
	private String url;
	private String driver;
	private Connection conn;


	public FestivAndes(String contextPathP) {
		connectionDataPath = contextPathP + CONNECTION_DATA_FILE_NAME_REMOTE;
		initConnectionData();
	}


	private void initConnectionData() {
		try {
			File arch = new File(this.connectionDataPath);
			Properties prop = new Properties();
			FileInputStream in = new FileInputStream(arch);
			prop.load(in);
			in.close();
			this.url = prop.getProperty("url");
			this.user = prop.getProperty("usuario");
			this.password = prop.getProperty("clave");
			this.driver = prop.getProperty("driver");
			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Método que  retorna la conexión a la base de datos
	 * @return Connection - la conexión a la base de datos
	 * @throws SQLException - Cualquier error que se genere durante la conexión a la base de datos
	 */
	private Connection darConexion() throws SQLException {
		System.out.println("Connecting to: " + url + " With user: " + user);
		return DriverManager.getConnection(url, user, password);
	}


	public ListaUsuarios darUsuarios() throws Exception {
		ArrayList<Usuario> usuarios;
		DAOUsuarios daousuarios = new DAOUsuarios();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daousuarios.setConn(conn);
			usuarios = daousuarios.darUsuarios();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daousuarios.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaUsuarios(usuarios);
	}

	public ListaFunciones darFunciones() throws Exception {
		ArrayList<Funcion> funciones;
		DAOFunciones daoFunciones = new DAOFunciones();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoFunciones.setConn(conn);
			funciones = daoFunciones.darFunciones();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoFunciones.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaFunciones(funciones);
	}

	public ListaBoletas darBoletas() throws Exception {
		ArrayList<Boleta> boletas;
		DAOBoletas daoBoletas = new DAOBoletas();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoBoletas.setConn(conn);
			boletas = daoBoletas.darBoletas();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoBoletas.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaBoletas(boletas);
	}


	public void addBoleta(Boleta boleta ) throws SQLException{
		DAOBoletas daoBoletas = new DAOBoletas();
		try {
			this.conn = darConexion();
			daoBoletas.setConn(conn);

			if(daoBoletas.sillaDispoble(boleta) && daoBoletas.boletasDisponibles(boleta)){
				daoBoletas.addBoleta(boleta);


			}
			conn.close();


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}finally {
			try {
				daoBoletas.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	public void deleteBoleta(Boleta boleta) throws Exception {
		DAOBoletas daoBoletas = new DAOBoletas();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoBoletas.setConn(conn);
			daoBoletas.deleteBoleta(boleta);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoBoletas.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public ListaPreferencias darPreferencias(String idUsuario, String idCliente) throws Exception {
		ArrayList<Preferencia> preferencias;
		DAOPreferencias daoPreferencias = new DAOPreferencias();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoPreferencias.setConn(conn);
			preferencias = daoPreferencias.darPreferencias(idUsuario, idCliente);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoPreferencias.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaPreferencias(preferencias);
	}


	////////////////////////////////////////
	///////Transacciones////////////////////
	////////////////////////////////////////


	//-----------------------------------------------------
	// RF1 REGISTRAR USUARIO
	//----------------------------------------------------

	public void registrarUsuario(Usuario user ) throws SQLException{
		DAOUsuarios daoUsuario = new DAOUsuarios();
		try {
			this.conn = darConexion();
			daoUsuario.setConn(conn);
			daoUsuario.addUsuario(user);
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}finally {
			try {
				daoUsuario.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}


	//-----------------------------------------------------
	// RF2 REGISTRAR CLIENTE
	//----------------------------------------------------

	public void registrarCliente(Cliente cliente ) throws SQLException{
		DAOClientes daoCliente = new DAOClientes();
		try {
			this.conn = darConexion();
			daoCliente.setConn(conn);
			daoCliente.addCliente(cliente);
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}finally {
			try {
				daoCliente.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}


	//-----------------------------------------------------
	// RF3 REGISTRAR COMPA��A DE TEATRO
	//----------------------------------------------------

	public void registrarCompania(Compania comp ) throws SQLException {
		DAOCompanias daoCompania = new DAOCompanias();
		try {
			this.conn = darConexion();
			daoCompania.setConn(conn);
			daoCompania.addCompania(comp);
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}finally {
			try {
				daoCompania.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}


	//-----------------------------------------------------
	// RF4 REGISTRAR FUNCION
	//----------------------------------------------------

	public void registrarFuncion(Funcion funcion ) throws SQLException {
		DAOFunciones daofunciones = new DAOFunciones ();
		try {
			this.conn = darConexion();
			daofunciones.setConn(conn);
			daofunciones.addFuncion(funcion);
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}finally {
			try {
				daofunciones.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	//-----------------------------------------------------
	// RF5 REGISTRAR ESPACIO
	//----------------------------------------------------

	public void registrarEspacio(Espacio espacio ) throws SQLException {
		DAOEspacios daoEspacio = new DAOEspacios();
		try {
			this.conn = darConexion();
			daoEspacio.setConn(conn);
			daoEspacio.addEspacio(espacio);
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}finally {
			try {
				daoEspacio.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}		

	public void realizarFuncion(Funcion func) throws SQLException {
		DAOFunciones daoFuncion = new DAOFunciones();

		try {
			this.conn = darConexion();
			daoFuncion.setConn(conn);
			daoFuncion.funcionRealizada(func);
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		}finally {
			try {
				daoFuncion.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}

	}

	//-----------------------------------------------------
	// RF7 REGISTRAR PREFERENCIA DE CLIENTE
	//----------------------------------------------------

	public void addPreferencia(Preferencia preferencia, String idUsuario, String idCliente) throws Exception {
		DAOPreferencias daoPreferencias = new DAOPreferencias();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoPreferencias.setConn(conn);
			daoPreferencias.addPreferencia(preferencia, idUsuario, idCliente);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoPreferencias.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void updatePreferencia(Preferencia preferencia, String idUsuario, String idCliente) throws Exception {
		DAOPreferencias daoPreferencias = new DAOPreferencias();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoPreferencias.setConn(conn);
			daoPreferencias.updatePreferencia(preferencia, idUsuario, idCliente);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoPreferencias.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	public void deletePreferencia(Preferencia preferencia, String idUsuario, String idCliente) throws Exception {
		DAOPreferencias daoPreferencias = new DAOPreferencias();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoPreferencias.setConn(conn);
			daoPreferencias.deletePreferencia(preferencia, idUsuario, idCliente);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoPreferencias.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	
	






	//-----------------------------------------------------
	// ITERACION 3
	//----------------------------------------------------


	public void addAbono(Abono abono) throws Exception {
		DAOAbono daoAbono = new DAOAbono();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAbono.setConn(conn);
			daoAbono.addAbono(abono);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAbono.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}
	public void deleteAbono(Abono abono) throws Exception {
		DAOAbono daoAbono = new DAOAbono();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoAbono.setConn(conn);
			daoAbono.deleteAbono(abono);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoAbono.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}





	/**
	 * Método que modela la transacción que busca el/los videos en la base de datos con el nombre entra como parámetro.
	 * @param name - Nombre del video a buscar. name != null
	 * @return ListaVideos - objeto que modela  un arreglo de videos. este arreglo contiene el resultado de la búsqueda
	 * @throws Exception -  cualquier error que se genere durante la transacción
	 */
	public ListaVideos buscarVideosPorName(String name) throws Exception {
		ArrayList<Video> videos;
		DAOTablaVideos daoVideos = new DAOTablaVideos();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVideos.setConn(conn);
			videos = daoVideos.buscarVideosPorName(name);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVideos.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaVideos(videos);
	}

	/**
	 * Método que modela la transacción que agrega un solo video a la base de datos.
	 * <b> post: </b> se ha agregado el video que entra como parámetro
	 * @param video - el video a agregar. video != null
	 * @throws Exception - cualquier error que se genera agregando el video
	 */
	public void addVideo(Video video) throws Exception {
		DAOTablaVideos daoVideos = new DAOTablaVideos();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVideos.setConn(conn);
			daoVideos.addVideo(video);
			conn.commit();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVideos.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	/**
	 * Método que modela la transacción que agrega los videos que entran como parámetro a la base de datos.
	 * <b> post: </b> se han agregado los videos que entran como parámetro
	 * @param videos - objeto que modela una lista de videos y se estos se pretenden agregar. videos != null
	 * @throws Exception - cualquier error que se genera agregando los videos
	 */
	public void addVideos(ListaVideos videos) throws Exception {
		DAOTablaVideos daoVideos = new DAOTablaVideos();
		try 
		{
			//////Transacción - ACID Example
			this.conn = darConexion();
			conn.setAutoCommit(false);
			daoVideos.setConn(conn);
			for(Video video : videos.getVideos())
				daoVideos.addVideo(video);
			conn.commit();
		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			conn.rollback();
			throw e;
		} finally {
			try {
				daoVideos.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	/**
	 * Método que modela la transacción que actualiza el video que entra como parámetro a la base de datos.
	 * <b> post: </b> se ha actualizado el video que entra como parámetro
	 * @param video - Video a actualizar. video != null
	 * @throws Exception - cualquier error que se genera actualizando los videos
	 */
	public void updateVideo(Video video) throws Exception {
		DAOTablaVideos daoVideos = new DAOTablaVideos();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVideos.setConn(conn);
			daoVideos.updateVideo(video);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVideos.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	/**
	 * Método que modela la transacción que elimina el video que entra como parámetro a la base de datos.
	 * <b> post: </b> se ha eliminado el video que entra como parámetro
	 * @param video - Video a eliminar. video != null
	 * @throws Exception - cualquier error que se genera actualizando los videos
	 */
	public void deleteVideo(Video video) throws Exception {
		DAOTablaVideos daoVideos = new DAOTablaVideos();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVideos.setConn(conn);
			daoVideos.deleteVideo(video);

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVideos.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
	}

	/**
	 * Método que modela la transacción que retorna el/los videos mas alquilados
	 * @return ListaVideos - objeto que modela  un arreglo de videos. este arreglo contiene el resultado de la búsqueda
	 * @throws Exception -  cualquier error que se genere durante la transacción
	 */
	public ListaVideos videosMasAlquilados() throws Exception {
		ArrayList<Video> videos;
		DAOTablaVideos daoVideos = new DAOTablaVideos();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daoVideos.setConn(conn);
			videos = daoVideos.darVideoMasAlquilado();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoVideos.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaVideos(videos);
	}



	public ListaRFC1 darRFC1() throws Exception {
		ArrayList<RFC1> rfc1;
		DAORFC1 daorfc1s = new DAORFC1();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daorfc1s.setConn(conn);
			rfc1 = daorfc1s.darRFC1();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daorfc1s.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaRFC1(rfc1);
	}

	public ListaRFC2 darRFC2() throws Exception {
		ArrayList<RFC2> rfc2;
		DAORFC2 daorfc2s = new DAORFC2();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daorfc2s.setConn(conn);
			rfc2 = daorfc2s.darRFC2();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daorfc2s.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaRFC2(rfc2);
	}

	public ListaRFC3 darRFC3() throws Exception {
		ArrayList<RFC3> rfc3;
		DAORFC3 daorfc3s = new DAORFC3();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daorfc3s.setConn(conn);
			rfc3 = daorfc3s.darRFC3();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daorfc3s.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaRFC3(rfc3);
	}

	public ListaRFC4 darRFC4() throws Exception {
		ArrayList<RFC4> rfc4;
		DAORFC4 daorfc4s = new DAORFC4();
		try 
		{
			//////Transacción
			this.conn = darConexion();
			daorfc4s.setConn(conn);
			rfc4 = daorfc4s.darRFC4();

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daorfc4s.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		return new ListaRFC4(rfc4);
	}


	public ListaBoletas addMuchasBoletas(RF10 lasBoletas) throws Exception {
		ArrayList<Boleta> listaBoletas = new ArrayList<>();
		DAOBoletas daoBoletas = new DAOBoletas();
		DAORF11 daorf11 = new DAORF11();
		int abono;
		try 
		{
			
			this.conn = darConexion();
			
			daoBoletas.setConn(conn);
			int restante =daoBoletas.darCapacidadRestante(lasBoletas.getIdlocalidad(), lasBoletas.getIdfuncion());
			
			if (restante < lasBoletas.getnumBoletas()){
				throw new Exception("No hay suficientes espacios dispobnibles");
			}else{
				
				int nextId = daoBoletas.darBoletaQueSigue()+1;
				int nextSilla = daoBoletas.darSillaQueSigue(lasBoletas.getIdlocalidad(), lasBoletas.getIdfuncion())+1;
				
				for (int i =0; i< lasBoletas.getnumBoletas(); i++){
					Boleta b = new Boleta(nextId, lasBoletas.getIdlocalidad(), "A", ""+nextSilla, lasBoletas.getIdfuncion(),lasBoletas.getIdcliente());
					
					addBoleta(b);
					listaBoletas.add(b);
				
				}
			}
			daorf11.setConn(conn);
			abono = daorf11.esAbono(lasBoletas);
			if(abono != 0){
				for (Boleta boleta : listaBoletas) {
					daorf11.addBoletaAbonada(boleta.getIdboleta(), abono);
				}
			}
			return new ListaBoletas(listaBoletas);
			

		} catch (SQLException e) {
			System.err.println("SQLException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			System.err.println("GeneralException:" + e.getMessage());
			e.printStackTrace();
			throw e;
		} finally {
			try {
				daoBoletas.cerrarRecursos();
				if(this.conn!=null)
					this.conn.close();
			} catch (SQLException exception) {
				System.err.println("SQLException closing resources:" + exception.getMessage());
				exception.printStackTrace();
				throw exception;
			}
		}
		
		
		
	}
	
	public void devolverBoleta(Boleta boleta) {
		// TODO Auto-generated method stub
		DAOFunciones daofunciones = new DAOFunciones();
		java.sql.Timestamp ts;
		try {
			ts = daofunciones.darFechaFuncion(boleta.getIdfuncion());
			Calendar cal = Calendar.getInstance();
			cal.setTime(ts);
		
			Calendar now = Calendar.getInstance();
			now.setTime(now.getTime());
			now.add(Calendar.DAY_OF_WEEK, 5);
				
			if 	(cal.before(now)){
				deleteBoleta(boleta);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	
}



}