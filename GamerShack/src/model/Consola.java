package model;

public class Consola extends Producto {
    private String marca;

    public Consola(String codigo, String nombre, double precio, int cantidadDisponible, String marca) {
        super(codigo, nombre, precio, cantidadDisponible);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

   
    public String toString() {
        return "Consola [marca=" + marca + ", getMarca()=" + getMarca() + ", getCodigo()=" + getCodigo()
                + ", getNombre()=" + getNombre() + ", getPrecio()=" + getPrecio() + ", getCantidadDisponible()="
                + getCantidadDisponible() + "]";
    }

    @Override
    public double calcularImpuestos(double valor) {
        
        return valor*IVA;
    }
    
}
