package es.studium.listadelacompra;

public class Vista {
    public void mostrarListaCompra(ListaDeLaCompra lista){
        System.out.println("El nombre de la lista es: " + lista.getNombreLista());
        if (lista.getArticulos().isEmpty()){
            System.out.println("La lista está vacía");
        }
        for (int i = 0; i < lista.getArticulos().size(); i++) {
            ArticuloAComprar articulo = lista.getArticulos().get(i);
            System.out.println("Artículo " + (i+1) + ": " + articulo.getDescripcion() + " " + articulo.getCantidad() + " " + articulo.getMedida());
        }
    }
}
