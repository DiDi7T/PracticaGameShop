package model;

public class Controladora{
	
	  //relacion
		private Producto [] almacenamiento;  //almacenamiento es el nombre del arreglo, y producto además de ser un atributo va ser una clase
		
		//Cada clase va tener un constructor y en este caso nuestra constructora va ser controladora y va inicializar  el arreglo
		
		public Controladora () {
			
		
			almacenamiento= new Producto [1000];
			ventas =new Venta[10];
			crearCasosDePrueba();
			
		}
		
		public String listarProductos(){
			String lista = "";
			for(int i=0;i<almacenamiento.length;i++){
				if (almacenamiento[i]!=null){
					lista+="\n"+almacenamiento[i].getCodigo()+"-"+almacenamiento[i].getNombre();
				}
			}
			return lista;
		}
		
		public String listarcategoria(){
		
		Categoria[] categoriaArray = Categoria.values();
		
		String list = "";
		
		    for (int i = 0; i < categoriaArray.length; i++){
				
				list += "\n" + (i+1) + "-" + categoriaArray[i];
			}
			
			return list;
		}
		
		// metodo que recibe la informacion del archivo ejecutable de otro objeto e
		// Este metodo nos sirve para almacenar el producto en uno de los espacios de el arreglo 
		public boolean almacenarProducto (String codigo, String nombre, double precio, int categoria) {
			
			Categoria newCategoria = Categoria.GAME;
			
			switch(categoria){
				
				case 1:
					newCategoria = Categoria.GAME;
				break;
				
				case 2:
					newCategoria = Categoria.CONSOLE;
				break;
				
				case 3:
					newCategoria = Categoria.ACCESORY;
				break;
			}
		
			
			Producto nuevoProducto = new  Producto (codigo, nombre, precio, newcategoria);
			
			for (int i = 0; i<almacenamiento.length; i++) {
				
				if (almacenamiento[i] == null ){
					
					almacenamiento[i] = nuevoProducto;
					
					return true; //paramos con un return para que no se llenen las mil casillas del mismo numero
				}else if(almacenamiento[i].getCodigo().equals(codigo)){
					return false;
				}
				
			}
			
			return false; 
			
		}
		
		
		//equals para comparar string, textos
		
		
		
		
		
		/** 
		Descripcion: Este metodo permite buscar un producto a traves de su codigo, comparando el string ingresado con el codigo
		del producto almacenado en el arreglo
		pre: el arreglo almacenamimento esta inicializado 
		@param codigo String El codigo del producto a buscar 
		@return producto El producto buscado 
		*/
		
		public Producto buscarProducto (String codigo) {
			
			for ( int i = 0; i<almacenamiento.length; i++) { //recorrido parcial de el arreglo
			
				Producto temporal = almacenamiento[i]; //va tomar lo que sea que este en el almacenamiento en el espacio"i"
				
				if(temporal!=null){
					
					if (codigo.equals(temporal.getCodigo())) {    //condicion para el arreglo, el get codigo es del metodo producto y el get codigo saca el codigo y el temporal es la pocision del arreglo 
				
						return temporal; //porque cumplio la consición de ser igual
				
					}
				}
				
			}
			
			return null; //si no es igual va retornar esto. 
		}
		
		
		
		
		public String mostrarProducto ( String codigo){
		
		
			Producto temporal = buscarProducto(codigo);
			
			
			if (temporal== null) {
				
				return "el producto no se encuentra";
				
			}
			
			return temporal.toString (); 
			
			
			
			
		}
		
		public void crearCasosDePrueba(){
			almacenarProducto("1","PlayStation 6",7000000);
			almacenarProducto("2","Nintendo Switch 2",3000000);
		}
		
		public boolean modificarPrecioProducto(String codigo, double precio){
			return buscarProducto(codigo).setPrecio(precio);
		}
		
		
		public boolean eliminarProducto(String codigo){
			int indice =buscarIndiceProducto(codigo);
			
			if (indice !=-1){
				almacenamiento[indice]=null;
				return true;
			}
			return false;
		}
			
		public int buscarIndiceProducto (String codigo) {
			
			for ( int i = 0; i<almacenamiento.length; i++) { //recorrido parcial de el arreglo
			
				Producto temporal = almacenamiento[i]; //va tomar lo que sea que este en el almacenamiento en el espacio"i"
				
				if(temporal!=null){
					
					if (codigo.equals(temporal.getCodigo())) {    //condicion para el arreglo, el get codigo es del metodo producto y el get codigo saca el codigo y el temporal es la pocision del arreglo 
				
						return i; //porque cumplio la consición de ser igual
				
					}
				}
				
			}
			
			return -1; //si no es igual va retornar esto. 
		}
		
		
		public String realizarVenta(String nuevoProducto, int cantidadProducto){
			Producto temporal=buscarProducto(codigo);
			if(temporal!=null){
				if(temporal.hayProducto(cantidadProducto)){
					Venta nuevaVenta= new Venta(cantidadProducto,temporal);
					for (int z =0;z < ventas.length;z++){
						if(ventas[z]==null){
							ventas[z]=nuevaVenta;
							temporal.setCantidadDisponible(temporal.getCantidadDisponible-cantidadProducto);
							return nuevaVenta.toString();
						}
					}
				}
			}
			return "No se ha podido registrar la venta :c";
		}
			
		
		
		
}