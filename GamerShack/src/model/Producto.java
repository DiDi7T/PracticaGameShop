package model;

public class Producto {
	
	private String codigo;
	private String nombre;// atributos, son privados porque solo ellos los van a utilizar esto se llama encapsulamiento 
	private double precio; 
	
	
	//constructor
	public Producto (String codigo, String nombre, double precio) {        //constructor objeto producto va tener esta forma, porque los atributos son necesarios puede ser para una operacion entonces van dentro del parentesis
	                                                                       // en java el atributo no se puede llamar igual a los parametros para poder que funcione añadimos this. codigo o se cambia el nombre del parametro, this es el atributo 
	
		this.codigo = codigo; 
		this.nombre = nombre;
		this.precio = precio;
		
		
		
		
	}
	
	public String toString()   {      //son publicos para   que otros metodos puedan usarlos
	
		String msg= "";
		
		
		msg+= "codigo:" + codigo;
		msg += "\nNombre: " + nombre;
		msg += "\nPrecio:" + precio;
		
		return msg; 
	
	}
	
	public String getCodigo () { //metodo analizador da el codigo 
		
		return this.codigo;
		
	}
}