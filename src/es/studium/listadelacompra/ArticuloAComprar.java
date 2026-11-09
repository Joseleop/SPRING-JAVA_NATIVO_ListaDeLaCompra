package es.studium.listadelacompra;

public class ArticuloAComprar {
    private String descripcion;
    private int cantidad;
    private String medida;

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return this.descripcion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getCantidad(){
        return this.cantidad;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    public String getMedida(){
        return this.medida;
    }
}
