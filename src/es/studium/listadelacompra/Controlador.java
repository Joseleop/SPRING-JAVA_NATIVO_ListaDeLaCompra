package es.studium.listadelacompra;

import java.io.IOException;

public class Controlador {
    private final Vista vista;
    private final Modelo modelo;

    public Controlador(Vista vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;

        iniciar();
    }

    private void iniciar() {
        ListaDeLaCompra mercadona = crearLista("Mercadona",
                new ArticuloAComprar("Paquete de arroz", 3, "Kg"),
                new ArticuloAComprar("Botella de leche", 6, "L"),
                new ArticuloAComprar("Barra de pan", 2, "U"),
                new ArticuloAComprar("Docena de huevos", 1, "U"),
                new ArticuloAComprar("Aceite de oliva virgen", 2, "L"));

        ListaDeLaCompra carrefour = crearLista("Carrefour",
                new ArticuloAComprar("Pack de yogures naturales", 2, "U"),
                new ArticuloAComprar("Paquete de pasta", 4, "U"));

        vista.mostrarTitulo("Antes de eliminar");
        vista.mostrarListaCompra(mercadona);
        guardar(mercadona);

        mercadona.eliminarArticulo("Barra de pan");

        vista.mostrarTitulo("Después de eliminar");
        vista.mostrarListaCompra(mercadona);
        guardar(mercadona);
        guardar(carrefour);

        vista.mostrarTitulo("Otra lista");
        vista.mostrarListaCompra(carrefour);

        mostrarRecuperada(mercadona.getNombreLista());
        mostrarRecuperada(carrefour.getNombreLista());
    }

    private ListaDeLaCompra crearLista(String nombre, ArticuloAComprar... articulos) {
        ListaDeLaCompra lista = new ListaDeLaCompra(nombre);
        for (ArticuloAComprar articulo : articulos) {
            lista.agregarProductoAComprar(articulo);
        }
        return lista;
    }

    private void mostrarRecuperada(String nombre) {
        vista.mostrarTitulo("Recuperada desde " + nombre + ".json");
        vista.mostrarListaCompra(cargar(nombre));
    }

    private void guardar(ListaDeLaCompra lista) {
        try {
            modelo.guardarDatos(lista);
            vista.mostrarMensaje("Lista \"" + lista.getNombreLista() + "\" guardada");
        } catch (IOException e) {
            vista.mostrarError("No se pudo guardar la lista: " + e.getMessage());
        }
    }

    private ListaDeLaCompra cargar(String nombre) {
        try {
            ListaDeLaCompra lista = modelo.leerDatos(nombre);
            vista.mostrarMensaje("Lista \"" + nombre + "\" cargada");
            return lista;
        } catch (IOException e) {
            vista.mostrarError("No se pudo cargar la lista: " + e.getMessage());
            return new ListaDeLaCompra(nombre);
        }
    }
}