package model;

public class Controladora{
	
	  //relacion
		private Producto [] almacenamiento;  //almacenamiento es el nombre del arreglo, y producto además de ser un atributo va ser una clase
		
		//Cada clase va tener un constructor y en este caso nuestra constructora va ser controladora y va inicializar  el arreglo
		
		public Controladora () {
			
		
			almacenamiento= new Producto [1000];
			crearCasosDePrueba();
			
		}
		
		// metodo que recibe la informacion del archivo ejecutable de otro objeto e
		// Este metodo nos sirve para almacenar el producto en uno de los espacios de el arreglo 
		public boolean almacenarProducto (String codigo, String nombre, double precio) {
			
			Producto nuevoProducto = new  Producto (codigo, nombre, precio);
			
			for (int i = 0; i<almacenamiento.length; i++) {
				
				if (almacenamiento[i] == null ){
					
					almacenamiento[i] = nuevoProducto;
					
					return true; //paramos con un return para que no se llenen las mil casillas del mismo numero
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
			
		
		
		
}