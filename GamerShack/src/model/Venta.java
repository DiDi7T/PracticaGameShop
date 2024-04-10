package model;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class Venta {
	
	private double valorTotal;
	private double valorIva;
	private int cantidadVendida;
	private Producto productoVendido;
	private Calendar fechaVenta;
	
	public Venta(Producto productoVendido int cantidadVendida){
		
		double subTotal=cantidadVendida*productoVendido.getPrecio();
		valorIva=subTotal*0.19;
		valorTotal=subTotal+valorIva;
		this.cantidadVendida=cantidadVendida;
		this.productoVendido=productoVendido;
		fechaVenta=Calendar.getInstance();
		
		
	}
	public String toString(){
		String msg="Venta: "
		msg+= "Producto:" + productoVendido.getNombre()+ " - "+cantidadVendida+" - "+productoVendido.getPrecio()+" - "+"Fecha de la venta:"+new SimpleDateFormat("dd-MM-yyyy").format(fechaVenta.getTime());
		msg+="\nTotal:"+valorTotal;
		
		return msg; 
	}
}