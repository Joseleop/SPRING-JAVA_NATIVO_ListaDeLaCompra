package es.studium.listadelacompra;

public class ArticuloAComprar {
    private String descripcion;
    private int cantidad;
    private String medida;

    public ArticuloAComprar(String descripcion, int cantidad, String medida) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.medida = medida;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMedida() {
        return this.medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
