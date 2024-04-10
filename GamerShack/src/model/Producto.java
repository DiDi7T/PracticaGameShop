package model;


public class Producto {
	
	private String codigo;
	private String nombre;// atributos, son privados porque solo ellos los van a utilizar esto se llama encapsulamiento 
	private double precio; 
	private Categoria categoria;
	private Calendar fechaRegistro;
	private int cantidadDisponible;
	
	
	//constructor
	public Producto (String codigo, String nombre, double precio, Category category, int cantidadDisponible) {        //constructor objeto producto va tener esta forma, porque los atributos son necesarios puede ser para una operacion entonces van dentro del parentesis
	                                                                       // en java el atributo no se puede llamar igual a los parametros para poder que funcione añadimos this. codigo o se cambia el nombre del parametro, this es el atributo 
	
		this.codigo = codigo; 
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
		this.cantidadDisponible = cantidadDisponible;
		
		
		
	}
	
	public String toString()   {      //son publicos para   que otros metodos puedan usarlos
	
		String msg= "";
		
		
		msg+= "codigo:" + codigo;
		msg += "\nNombre: " + nombre;
		msg += "\nPrecio:" + precio;
		msg += "\nCategoria: "+categoria;
		return msg; 
	
	}
	
	public String getCodigo () { //metodo analizador da el codigo 
		
		return this.codigo;
		
		
	}
	public String getNombre () { //metodo analizador da el codigo 
		return this.nombre;
	}
	public boolean getPrecio () { //metodo analizador da el codigo 
		return Precio;
	}
	public boolean setPrecio(double precio){
		
		this.precio = precio;
		return true;
		
	}
	
	
	
	public int getCantidadDisponible () { //metodo analizador da el codigo 
		return cantidadDisponible;
	}
	public void setCantidadDisponible (int cantidadDisponible) { //metodo analizador da el codigo 
		this.cantidadDisponible=cantidadDisponible;
		
	}
	public boolean hayProducto(int cantidadAVender){
		
		if (cantidadDisponible>0&&cantidadDisponible>=cantidadAVender){
			return true;
		}
		return false;
	}

}