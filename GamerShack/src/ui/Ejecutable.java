package ui;
import java.util.Scanner;
import model.Controladora; //asi unimos los archivos 

//se encarga de la interfaz grafica 

public class Ejecutable{
	
	// atributos
	private Scanner lector; //Los atributos deben de ser privados.
	//relaciones ya que el ejecutable tiene una controladora 
	private Controladora controller; 
	
	
	public static void main(String [] args){
		Ejecutable exe= new Ejecutable(); //Este es el ejecutable o el objeto( Clase+nombre_del_Objeto+Constructore_del_objeto)
		exe.menu(); // exe es el objeto, la instancia, y a partir de eso se le llama el metodo menu
		
		
		
	}
	
	//Entidad y objeto es lo mismo
	
	/**
	Constructor--> Tipo del metodo, se le hace a la clase "Ejecutable". NO tiene retorno por que la clase
	Función: INICIALIZA el estado de la clase
	Atributo--> Scanner
	**/
	
	//ejecutable 
	public Ejecutable () {
		lector= new Scanner(System.in); //Atributo, no variable global.
		
		controller = new Controladora (); 
	}
	/**
	Constructor--> Tipo del metodo, se le hace a la clase "Ejecutable". NO tiene retorno por que la clase
	Función: INICIALIZA el estado de la clase
	Atributo--> Scanner
	**/
	public void menu(){
		boolean flag = true;
		do{
			System.out.println("Bienvenido al software de inventario del GamseShark");
			System.out.println("1) Registrar Producto");
			System.out.println("2) consultar Productos por codigo ");
			System.out.println("3) Cambiar precio de un producto");
			System.out.println("4) Borrar un producto");
			System.out.println("5) Agregar una venta");
			System.out.println("0) Salir");
			int option = lector.nextInt();
			switch(option){
				case 1:
				
				registrarProducto(); 
				break;
				
				case 2: 
				consultarProducto();
				break;
				
				case 3:
				modificarPrecio();
				break;
				case 4:
				eliminarProducto();
				break;
				case 5:
				realizarVenta();
				break;
				
				case 0: 
				flag=false;
				System.out.println("Gracias por usar nuestro servicio");
				break;
				
				default:
				System.out.println("Digite una opcion válida");
				break;
			}
			
		}while(flag);
		
	}
	
	public void eliminarProducto(){
		reader.nextLine();
		
		System.out.println("Digite el codigo del producto");
		String codigo =reader.nextLine();
		if(controller.eliminarProducto(codigo)){
			System.out.printLn("Producto eliminado exitosamente");
		}else{
			System.out.println("El producto no ha podido ser eliminado");
		}
	}
	
	public void registrarProducto (){ // en este metodo se pide la información se llama a la controladoram luego la controladora recibe informacion y lo que hace es crear un producto y almacenarlo 
		
			lector.nextLine(); //correción del bug del Scanner
	
		System.out.println("Digite el codigo del producto");
		String codigo = lector.nextLine ();
		
		System.out.println("Digite el nombre del producto");
		String nombre = lector.nextLine ();
		
		System.out.println("Digite el precio del producto");
		double precio = lector.nextDouble ();
		
		boolean resultado=controller.almacenarProducto (codigo, nombre, precio);  // tiene que ir en el mismo orden 
		if(resultado==true){
			System.out.println("Registro exitoso");
		}else{
			System.out.println("ha ocurrido un error");
		}
		
		
	}
	
	
	public void consultarProducto () { //no retorna nada porque este muestra la informacion al usuario del producto buscado 
	
		lector.nextLine(); //correción del bug del Scanner
		
		System.out.println(controller.listarProductos());
	
		System.out.println("Digite el codigo del producto");
		String codigo = lector.nextLine ();
		
		String msg = controller.mostrarProducto (codigo);
		if(msg.equals("El producto no se encuentra")){
			System.out.println(msg);
		}else{
			System.out.println("los datos del producto son: \n" + msg );
		}
		
		// \n es un salto de linea para que el codigo se muestre mas ordenado 
		
		
		
	
	}
	public void realizarVenta () { //no retorna nada porque este muestra la informacion al usuario del producto buscado 
	
		lector.nextLine(); //correción del bug del Scanner
		
		System.out.println(controller.listarProductos());
	
		System.out.println("Digite el codigo del producto");
		String codigo = lector.nextLine ();
		
		System.out.println("Digite la cantidad a vender del producto");
		int cantidadVendida=lector.nextInt();
		
		System.out.println(controladora.realizarVenta(codigo,cantidadVendida));
	
		
		// \n es un salto de linea para que el codigo se muestre mas ordenado 
		
		
		
	
	}
	
	public void modificarPrecio(){
		
		lector.nextLine();//Correcion del bug del Scanner.
		
		System.out.println(controladora.listarProductos());
		
		System.out.println("Ingresa el codigo");
		String codigo = lector.nextLine();
		
		String msg = controladora.mostrarProducto(codigo);
		
		if(msg.equals("The inquired product isn't avaibable.")){
			
			System.out.println(msg);
			
		}else{
		
		    System.out.println("The Details of the product are:\n" +msg);
			
			System.out.println("Type the Price of the new Product.");
		    double price = reader.nextDouble();
		
		    controladora.priceProductModify(code,price);
		}
		
		
		
		
	}
}