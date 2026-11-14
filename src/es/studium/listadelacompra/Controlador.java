package es.studium.listadelacompra;

public class Controlador {
    Vista vista;
    Modelo modelo;
    public Controlador(Vista v, Modelo m){
        this.vista = v;
        this.modelo = m;

        ejecutarprueba();


    }

    private void ejecutarprueba() {
        ListaDeLaCompra mercadona = new ListaDeLaCompra("Mercadona");
        mercadona.agregarProductoAComprar(new ArticuloAComprar("Paquete de arroz", 3, "Kg"));
        mercadona.agregarProductoAComprar(new ArticuloAComprar("Botella de leche", 6, "L"));
        mercadona.agregarProductoAComprar(new ArticuloAComprar("Barra de pan", 2, "U"));
        mercadona.agregarProductoAComprar(new ArticuloAComprar("Docena de huevos", 1, "U"));
        mercadona.agregarProductoAComprar(new ArticuloAComprar("Aceite de oliva virgen", 2, "L"));

        ListaDeLaCompra carrefour = new ListaDeLaCompra("Carrefour");
        carrefour.agregarProductoAComprar(new ArticuloAComprar("Pack de yogures naturales", 2, "U"));
        carrefour.agregarProductoAComprar(new ArticuloAComprar("Paquete de pasta", 4, "U"));

        System.out.println("--- ANTES de eliminar ---");
        vista.mostrarListaCompra(mercadona);
        modelo.guardarDatos(mercadona);
        mercadona.eliminarArticulo("Barra de pan");


        System.out.println("--- DESPUÉS de eliminar ---");
        vista.mostrarListaCompra(mercadona);
        modelo.guardarDatos(mercadona);
        vista.mostrarListaCompra(carrefour);

        System.out.println("--- RECUPERADA desde Mercadona.json ---");
        ListaDeLaCompra recuperada = modelo.leerDatos(new ListaDeLaCompra("Mercadona"));
        vista.mostrarListaCompra(recuperada);
    }
}
