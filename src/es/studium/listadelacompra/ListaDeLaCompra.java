package es.studium.listadelacompra;

import java.util.ArrayList;
import java.util.List;

public class ListaDeLaCompra {

    private String nombreLista;
    private List<ArticuloAComprar> articulos;

    public ListaDeLaCompra() {
        this.nombreLista = "";
        this.articulos = new ArrayList<>();
    }

    public ListaDeLaCompra(String nombreLista) {
        this.nombreLista = nombreLista;
        this.articulos = new ArrayList<>();
    }

    public String getNombreLista() {
        return nombreLista;
    }

    public void setNombreLista(String nombreLista) {
        this.nombreLista = nombreLista;
    }

    public void agregarProductoAComprar(ArticuloAComprar articulo) {
        if (articulo != null) {
            this.articulos.add(articulo);
        }
    }

    public void eliminarArticulo(String descripcionArticulo) {
        if (descripcionArticulo == null) return;
        articulos.removeIf(articulo ->
                descripcionArticulo.equalsIgnoreCase(articulo.getDescripcion())
        );
    }

    public List<ArticuloAComprar> getArticulos() {
        return this.articulos;
    }
}