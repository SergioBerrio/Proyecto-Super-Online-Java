package paqueteAplicacion;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class Inventario {

	private static int ultimoCodigo = 0;
	private static int ficheroInventario;
	private static ArrayList<Producto> listaProductos;

	private Inventario() {

	}

	public static void initInventario() {
		if (listaProductos == null) {
			listaProductos = new ArrayList<Producto>();
		}
		if (ultimoCodigo < 0) {
			ultimoCodigo = 0;
		}
		if (ficheroInventario < 0) {
			ficheroInventario = 0;
		}
	}

	public static int getUltimoCodigo() {
		return ultimoCodigo;
	}

	public static void cargarProductos() throws IOException {
		initInventario();

		File ficheroProductos = new File("C:/DATOS/productos.txt");
		FileReader fichero = null;
		BufferedReader br = null;

		try {

			fichero = new FileReader(ficheroProductos);
			br = new BufferedReader(fichero);

			String linea;

			System.out.println("[[Cargando productos en el sistema...]]");

			while ((linea = br.readLine()) != null) {
				String[] restos = linea.split(" ");

				if (restos[restos.length - 1].contains("FrutaHortaliza")) {
					listaProductos.add(new FrutaHortaliza(Integer.parseInt(restos[0]), restos[1], Double.parseDouble(restos[2]), Integer.parseInt(restos[3]), Double.parseDouble(restos[4]), restos[5], restos[6]));
					ultimoCodigo = Integer.parseInt(restos[0]);

					String sql = "INSERT INTO FrutaHortaliza(Codigo, Nombre, Precio, Cantidad, Peso, Fecha, Origen) VALUES(?,?,?,?,?,?,?)";

					try {
						Connection conn = conectar();
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(restos[0]));
						pstmt.setString(2, restos[1]);
						pstmt.setDouble(3, Double.parseDouble(restos[2]));
						pstmt.setInt(4, Integer.parseInt(restos[3]));
						pstmt.setDouble(5, Double.parseDouble(restos[4]));
						pstmt.setString(6, restos[5]);
						pstmt.setString(7, restos[6]);
						pstmt.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}

				} else if (restos[restos.length - 1].contains("Lacteo")) {
					listaProductos.add(new Lacteo(Integer.parseInt(restos[0]), restos[1], Double.parseDouble(restos[2]), Integer.parseInt(restos[3]), Double.parseDouble(restos[4]), restos[5], restos[6]));
					ultimoCodigo = Integer.parseInt(restos[0]);

					String sql = "INSERT INTO Lacteo(Codigo, Nombre, Precio, Cantidad, Peso, Fecha, Lote) VALUES(?,?,?,?,?,?,?)";

					try {
						Connection conn = conectar();
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(restos[0]));
						pstmt.setString(2, restos[1]);
						pstmt.setDouble(3, Double.parseDouble(restos[2]));
						pstmt.setInt(4, Integer.parseInt(restos[3]));
						pstmt.setDouble(5, Double.parseDouble(restos[4]));
						pstmt.setString(6, restos[5]);
						pstmt.setString(7, restos[6]);
						pstmt.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}

				} else if (restos[restos.length - 1].contains("Bebida")) {
					listaProductos.add(new Bebida(Integer.parseInt(restos[0]), restos[1], Double.parseDouble(restos[2]), Integer.parseInt(restos[3]), Double.parseDouble(restos[4]), restos[5], restos[6]));
					ultimoCodigo = Integer.parseInt(restos[0]);

					String sql = "INSERT INTO Bebida(Codigo, Nombre, Cantidad, Precio, Peso, Fecha, Graduacion) VALUES(?,?,?,?,?,?,?)";

					try {
						Connection conn = conectar();
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(restos[0]));
						pstmt.setString(2, restos[1]);
						pstmt.setDouble(3, Double.parseDouble(restos[2]));
						pstmt.setInt(4, Integer.parseInt(restos[3]));
						pstmt.setDouble(5, Double.parseDouble(restos[4]));
						pstmt.setString(6, (restos[5]));
						pstmt.setString(7, (restos[6]));
						pstmt.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}

				} else if (restos[restos.length - 1].contains("Herramienta")) {
					listaProductos.add(new Herramienta(Integer.parseInt(restos[0]), restos[1], Double.parseDouble(restos[2]), Integer.parseInt(restos[3]), Double.parseDouble(restos[4])));
					ultimoCodigo = Integer.parseInt(restos[0]);

					String sql = "INSERT INTO Herramientas(Codigo, Nombre, Cantidad, Precio, Peso) VALUES(?,?,?,?,?)";

					try {
						Connection conn = conectar();
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(restos[0]));
						pstmt.setString(2, restos[1]);
						pstmt.setDouble(3, Double.parseDouble(restos[2]));
						pstmt.setInt(4, Integer.parseInt(restos[3]));
						pstmt.setDouble(5, Double.parseDouble(restos[4]));
						pstmt.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}

				} else if (restos[restos.length - 1].contains("Otros")) {
					listaProductos.add(new Otros(Integer.parseInt(restos[0]), restos[1], Double.parseDouble(restos[2]), Integer.parseInt(restos[3]), Double.parseDouble(restos[4]), restos[5]));
					ultimoCodigo = Integer.parseInt(restos[0]);

					String sql = "INSERT INTO Otros(Codigo, Nombre, Precio, Cantidad, Peso, Categoria) VALUES(?,?,?,?,?,?)";

					try {
						Connection conn = conectar();
						PreparedStatement pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1, Integer.parseInt(restos[0]));
						pstmt.setString(2, restos[1]);
						pstmt.setDouble(3, Double.parseDouble(restos[2]));
						pstmt.setInt(4, Integer.parseInt(restos[3]));
						pstmt.setDouble(5, Double.parseDouble(restos[4]));
						pstmt.setString(6, restos[5]);
						pstmt.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
				}
			}

			System.out.println("[[...Productos cargados en el inventario]]");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en la lectura del archivo txt.");
		} finally {
			fichero.close();
		}
	}

	public static void addNuevoProducto(Producto producto, int opcion) throws IOException {
		if (listaProductos == null) {
			initInventario();
		}

		listaProductos.add(producto);
		ultimoCodigo = producto.getCodigo();

		try {
			switch (opcion) {
				case 1:
					String sqlFrutaHortaliza = "INSERT INTO FrutaHortaliza(Codigo, Nombre, Precio, Cantidad, Peso, Fecha, Origen) VALUES(?,?,?,?,?,?,?)";

					try {
						Connection conn = conectar();
						PreparedStatement pstmt = conn.prepareStatement(sqlFrutaHortaliza);
						pstmt.setInt(1, producto.getCodigo());
						pstmt.setString(2, producto.getNombre());
						pstmt.setDouble(3, producto.getPrecio());
						pstmt.setInt(4, producto.getCantidad());
						pstmt.setDouble(5, producto.getPeso());
						pstmt.setString(6, producto.getFechaCaducidad());
						pstmt.setString(7, producto.getOrigen());
						pstmt.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 2:
					String sqlLacteo = "INSERT INTO Lacteo(Codigo, Nombre, Precio, Cantidad, Peso, Fecha, Lote) VALUES(?,?,?,?,?,?,?)";

					try {
						Connection conn = Inventario.conectar();
						PreparedStatement pstmt = conn.prepareStatement(sqlLacteo);
						pstmt.setInt(1, producto.getCodigo());
						pstmt.setString(2, producto.getNombre());
						pstmt.setDouble(3, producto.getPrecio());
						pstmt.setInt(4, producto.getCantidad());
						pstmt.setDouble(5, producto.getPeso());
						pstmt.setString(6, producto.getFechaCaducidad());
						pstmt.setString(7, producto.getLote());
						pstmt.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}


				case 3:
					String sqlBebida = "INSERT INTO Bebida(Codigo, Nombre, Cantidad, Precio, Peso, Fecha, Graduacion) VALUES(?,?,?,?,?,?,?)";

					try {
						Connection conn = conectar();
						PreparedStatement pstmt = conn.prepareStatement(sqlBebida);
						pstmt.setInt(1, producto.getCodigo());
						pstmt.setString(2, producto.getNombre());
						pstmt.setDouble(3, producto.getCantidad());
						pstmt.setDouble(4, producto.getPrecio());
						pstmt.setDouble(5, producto.getPeso());
						pstmt.setString(6, producto.getFechaCaducidad());
						pstmt.setString(7, producto.getGraduacion());
						pstmt.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 4:
					String sqlHerramientas = "INSERT INTO Herramientas(Codigo, Nombre, Cantidad, Precio, Peso) VALUES(?,?,?,?,?)";

					try {
						Connection conn = conectar();
						PreparedStatement pstmt = conn.prepareStatement(sqlHerramientas);
						pstmt.setInt(1, producto.getCodigo());
						pstmt.setString(2, producto.getNombre());
						pstmt.setDouble(3, producto.getCantidad());
						pstmt.setDouble(4, producto.getPrecio());
						pstmt.setDouble(5, producto.getPeso());
						pstmt.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;

				case 5:
					String sqlOtros = "INSERT INTO Otros(Codigo, Nombre, Precio, Cantidad, Peso, Categoria) VALUES(?,?,?,?,?,?)";

					try {
						Connection conn = conectar();
						PreparedStatement pstmt = conn.prepareStatement(sqlOtros);
						pstmt.setInt(1, producto.getCodigo());
						pstmt.setString(2, producto.getNombre());
						pstmt.setDouble(3, producto.getPrecio());
						pstmt.setInt(4, producto.getCantidad());
						pstmt.setDouble(5, producto.getPeso());
						pstmt.setString(6, producto.getCategoria());
						pstmt.executeUpdate();

					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
					break;
			}

			System.out.println("[[...Productos cargados en el inventario]]");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en la lectura del archivo txt.");
		}
	}

	
	/*public static void mostrarProductos() {
		if(listaProductos == null) {
			System.out.println("La lista de productos esta vacia");
			
		} else {
			System.out.println("**** Lista completa de productos catalogados ****");
			System.out.println("");

			for (int i = 0; i < listaProductos.size(); i++) {

				listaProductos.get(i).imprimir();
			}
		}
	}*/

	public static Producto getProducto(int codigo) {

		for (int i = 0; i < listaProductos.size(); i++) {
			if (listaProductos.get(i).getCodigo() == codigo) {
				return listaProductos.get(i);
			}
		}

		return null;
	}
	
	/*public static void actualizarCantidad(int codigo, double cantidad) {
		for (int i = 0; i < listaProductos.size(); i++) {
			if(listaProductos.get(i).getCodigo() == codigo) {
				listaProductos.get(i).setCantidad(codigo);
			}
		}
	}*/

	public static int tamano() {
		return listaProductos.size();
	}

	public static void mostrarProductosEnviables() {
		if (listaProductos == null) {
			System.out.println("La lista de productos esta vacía");

		} else {
			System.out.println("**** Lista de productos enviables del catálogo ****");
			System.out.println("");

			for (int i = 0; i < listaProductos.size(); i++) {

				listaProductos.get(i).imprimir();

			}
		}
	}
	
	/*public static void eliminarProducto(int codigo) {
		for (int i = 0; i < listaProductos.size(); i++) {
			if(listaProductos.get(i).getCodigo() == codigo) {
				listaProductos.remove(codigo);
			}
		}
	}*/

	public static void volcarProductos() {
		String ruta = "C:/DATOS/productos.txt";
		String texto = "";

		try {

			File archivo = new File(ruta);
			FileWriter fichero = null;

			if (archivo.exists()) {
				System.out.println("El fichero ya existe, preparado para sobreescribir");

			} else {
				System.out.println("El fichero no existe, se creara uno nuevo ahora mismo");
			}

			fichero = new FileWriter(archivo);

			for (int i = 0; i < listaProductos.size(); i++) {
				texto += listaProductos.get(i).volcar() + "\n";

			}

			fichero.write(texto);
			fichero.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error en la escritura del archivo txt");
		}
	}

	/*public static Connection conectar() {

		// SQLite connection string
		String url = "jdbc:sqlite:C:\\Users\\2DAM3\\Desktop\\Workspace_Android\\Android\\dbSuperOnline.sqlite";
		Connection conexion = null;

		try {
			conexion = DriverManager.getConnection(url);

			System.out.println("La conexión con la BD SQLite ha sido establecida.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return conexion;
	}*/

	public static Connection conectar() {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbSuperOnline", "root", "root");

			//System.out.println("La conexión con la BD Mysql ha sido establecida.");
		} catch (Exception e) {
			System.out.println(e);
		}

		return con;
	}

	public static void eliminarTablas(){

		String sqlEliminarFrutaHortaliza = "DROP TABLE IF EXISTS FrutaHortaliza";
		String sqlEliminarLacteo = "DROP TABLE IF EXISTS Lacteo";
		String sqlEliminarBebida = "DROP TABLE IF EXISTS Bebida";
		String sqlEliminarHerramientas = "DROP TABLE IF EXISTS Herramientas";
		String sqlEliminarOtros = "DROP TABLE IF EXISTS Otros";

		try{
			Connection conn = conectar();

			PreparedStatement pstmt = conn.prepareStatement(sqlEliminarFrutaHortaliza);
			PreparedStatement pstmt2 = conn.prepareStatement(sqlEliminarLacteo);
			PreparedStatement pstmt3 = conn.prepareStatement(sqlEliminarBebida);
			PreparedStatement pstmt4 = conn.prepareStatement(sqlEliminarHerramientas);
			PreparedStatement pstmt5 = conn.prepareStatement(sqlEliminarOtros);

			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
			pstmt4.executeUpdate();
			pstmt5.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void crearTablas(){

		String sqlCrearFrutaHortaliza = "CREATE TABLE FrutaHortaliza (" +
				"Codigo integer PRIMARY KEY," +
				"Nombre text NOT NULL," +
				"Precio double NOT NULL," +
				"Cantidad integer NOT NULL," +
				"Peso double NOT NULL," +
				"Fecha text NOT NULL,"+
				"Origen text NOT NULL)";

		String sqlCrearLacteo = "CREATE TABLE Lacteo (" +
				"Codigo integer PRIMARY KEY," +
				"Nombre text NOT NULL," +
				"Precio double NOT NULL," +
				"Cantidad integer NOT NULL," +
				"Peso double NOT NULL," +
				"Fecha text NOT NULL,"+
				"Lote text NOT NULL)";

		String sqlCrearBebida = "CREATE TABLE Bebida (" +
				"Codigo integer PRIMARY KEY," +
				"Nombre text NOT NULL," +
				"Precio double NOT NULL," +
				"Cantidad integer NOT NULL," +
				"Peso double NOT NULL," +
				"Fecha text NOT NULL,"+
				"Graduacion text NOT NULL)";

		String sqlCrearHerramientas = "CREATE TABLE Herramientas (" +
				"Codigo integer PRIMARY KEY," +
				"Nombre text NOT NULL," +
				"Precio double NOT NULL," +
				"Cantidad integer NOT NULL," +
				"Peso double NOT NULL)";

		String sqlCrearOtros = "CREATE TABLE Otros (" +
				"Codigo integer PRIMARY KEY," +
				"Nombre text NOT NULL," +
				"Precio double NOT NULL," +
				"Cantidad integer NOT NULL," +
				"Peso double NOT NULL," +
				"Categoria text NOT NULL)";

		try{
			Connection conn = conectar();

			PreparedStatement pstmt = conn.prepareStatement(sqlCrearFrutaHortaliza);
			PreparedStatement pstmt2 = conn.prepareStatement(sqlCrearLacteo);
			PreparedStatement pstmt3 = conn.prepareStatement(sqlCrearBebida);
			PreparedStatement pstmt4 = conn.prepareStatement(sqlCrearHerramientas);
			PreparedStatement pstmt5 = conn.prepareStatement(sqlCrearOtros);

			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
			pstmt4.executeUpdate();
			pstmt5.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void crearDatabase(){

		String sqlCrearDatabase = "CREATE DATABASE IF NOT EXISTS dbSuperOnline";

		try{
			Connection con = null;

			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");

				System.out.println("La DB dbSuperOnline ha sido creada.");
			} catch (Exception e) {
				System.out.println(e);
			}


			PreparedStatement pstmt = con.prepareStatement(sqlCrearDatabase);

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void actualizarCantidad(int codigo, int cantidad){

		String sqlActualizarFrutaHortaliza ="UPDATE FrutaHortaliza SET Cantidad = '" + cantidad + "' WHERE Codigo = " + codigo;
		String sqlActualizarLacteo ="UPDATE Lacteo SET Cantidad = '" + cantidad + "' WHERE Codigo = " + codigo;
		String sqlActualizarBebida ="UPDATE Bebida SET Cantidad = '" + cantidad + "' WHERE Codigo = " + codigo;
		String sqlActualizarHerramientas ="UPDATE Herramientas SET Cantidad = '" + cantidad + "' WHERE Codigo = " + codigo;
		String sqlActualizarOtros ="UPDATE Otros SET Cantidad = '" + cantidad + "' WHERE Codigo = " + codigo;

		try{
			Connection conn = conectar();

			PreparedStatement pstmt = conn.prepareStatement(sqlActualizarFrutaHortaliza);
			PreparedStatement pstmt2 = conn.prepareStatement(sqlActualizarLacteo);
			PreparedStatement pstmt3 = conn.prepareStatement(sqlActualizarBebida);
			PreparedStatement pstmt4 = conn.prepareStatement(sqlActualizarHerramientas);
			PreparedStatement pstmt5 = conn.prepareStatement(sqlActualizarOtros);

			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
			pstmt4.executeUpdate();
			pstmt5.executeUpdate();

			conn.close();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void mostrarProductos(){
		if(listaProductos == null) {
			System.out.println("La lista de productos esta vacía.");

		} else {
			System.out.println("**** Lista completa de productos catalogados ****");
			//System.out.println("");

			for (int i = 0; i < listaProductos.size(); i++) {

				listaProductos.get(i).imprimir();
			}

			String sqlSelectFrutaHortaliza ="SELECT * FROM FrutaHortaliza";
			String sqlSelectLacteo ="SELECT * FROM Lacteo";
			String sqlSelectBebida ="SELECT * FROM Bebida";
			String sqlSelectHerramientas ="SELECT * FROM Herramientas";
			String sqlSelectOtros ="SELECT * FROM Otros";

			try{
				Connection conn = conectar();
				Statement st = conn.createStatement();

				System.out.println("");
				System.out.println("**** Tabla de FrutaHortalizas ****");
				ResultSet rs = st.executeQuery(sqlSelectFrutaHortaliza);

				while (rs.next()) {
					int codigo = rs.getInt("Codigo");
					String nombre = rs.getString("Nombre");
					double precio = rs.getDouble("Precio");
					int cantidad = rs.getInt("Cantidad");
					double peso = rs.getDouble("Peso");
					String fecha = rs.getString("Fecha");
					String origen = rs.getString("Origen");

					// print the results
					System.out.printf("Código:%d, Nombre:%s, Precio:%.2f, Cantidad:%d, Peso:%.2f, Fecha:%s, " +
							"País de origen:%s\n", codigo, nombre, precio, cantidad, peso, fecha, origen);
				}

				System.out.println("");
				System.out.println("**** Tabla de Lácteos ****");
				ResultSet rs2 = st.executeQuery(sqlSelectLacteo);

				while (rs2.next()) {
					int codigo = rs2.getInt("Codigo");
					String nombre = rs2.getString("Nombre");
					double precio = rs2.getDouble("Precio");
					int cantidad = rs2.getInt("Cantidad");
					double peso = rs2.getDouble("Peso");
					String fecha = rs2.getString("Fecha");
					String lote = rs2.getString("Lote");

					// print the results
					System.out.printf("Código:%d, Nombre:%s, Precio:%.2f, Cantidad:%d, Peso:%.2f, Fecha:%s, " +
							"Lote:%s\n", codigo, nombre, precio, cantidad, peso, fecha, lote);
				}

				System.out.println("");
				System.out.println("**** Tabla de Bebidas ****");
				ResultSet rs3 = st.executeQuery(sqlSelectBebida);

				while (rs3.next()) {
					int codigo = rs3.getInt("Codigo");
					String nombre = rs3.getString("Nombre");
					double precio = rs3.getDouble("Precio");
					int cantidad = rs3.getInt("Cantidad");
					double peso = rs3.getDouble("Peso");
					String fecha = rs3.getString("Fecha");
					String graduacion = rs3.getString("Graduacion");

					// print the results
					System.out.printf("Código:%d, Nombre:%s, Precio:%.2f, Cantidad:%d, Peso:%.2f, Fecha:%s, " +
							"Graduación:%s\n", codigo, nombre, precio, cantidad, peso, fecha, graduacion);
				}

				System.out.println("");
				System.out.println("**** Tabla de Herramientas ****");
				ResultSet rs4 = st.executeQuery(sqlSelectHerramientas);

				while (rs4.next()) {
					int codigo = rs4.getInt("Codigo");
					String nombre = rs4.getString("Nombre");
					double precio = rs4.getDouble("Precio");
					int cantidad = rs4.getInt("Cantidad");
					double peso = rs4.getDouble("Peso");

					// print the results
					System.out.printf("Código:%d, Nombre:%s, Precio:%.2f, Cantidad:%d, Peso:%.2f\n",
							codigo, nombre, precio, cantidad, peso);
				}

				System.out.println("");
				System.out.println("**** Tabla de Otros ****");
				ResultSet rs5 = st.executeQuery(sqlSelectOtros);

				while (rs5.next()) {
					int codigo = rs5.getInt("Codigo");
					String nombre = rs5.getString("Nombre");
					double precio = rs5.getDouble("Precio");
					int cantidad = rs5.getInt("Cantidad");
					double peso = rs5.getDouble("Peso");
					String categoria = rs5.getString("Categoria");

					// print the results
					System.out.printf("Código:%d, Nombre:%s, Precio:%.2f, Cantidad:%d, Peso:%.2f, Categoría:%s\n",
							codigo, nombre, precio, cantidad, peso, categoria);
				}

				System.out.println("");

			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void eliminarProducto(int codigo){

		String sqlEliminarFrutaHortaliza ="DELETE FROM FrutaHortaliza WHERE Codigo = " + codigo;
		String sqlEliminarLacteo ="DELETE FROM Lacteo WHERE Codigo = " + codigo;
		String sqlEliminarBebida ="DELETE FROM Bebida WHERE Codigo = " + codigo;
		String sqlEliminarHerramientas ="DELETE FROM Herramientas WHERE Codigo = " + codigo;
		String sqlEliminarOtros ="DELETE FROM Otros WHERE Codigo = " + codigo;

		try{
			Connection conn = conectar();

			PreparedStatement pstmt = conn.prepareStatement(sqlEliminarFrutaHortaliza);
			PreparedStatement pstmt2 = conn.prepareStatement(sqlEliminarLacteo);
			PreparedStatement pstmt3 = conn.prepareStatement(sqlEliminarBebida);
			PreparedStatement pstmt4 = conn.prepareStatement(sqlEliminarHerramientas);
			PreparedStatement pstmt5 = conn.prepareStatement(sqlEliminarOtros);

			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
			pstmt4.executeUpdate();
			pstmt5.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
