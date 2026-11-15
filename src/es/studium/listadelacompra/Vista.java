package es.studium.listadelacompra;

public class Vista {
    private static final int ANCHO = 50;

    public void mostrarTitulo(String texto) {
        System.out.println();
        System.out.println("=".repeat(ANCHO));
        System.out.println(" " + texto.toUpperCase());
        System.out.println("=".repeat(ANCHO));
    }

    public void mostrarMensaje(String texto) {
        System.out.println(">> " + texto);
    }

    public void mostrarError(String texto) {
        System.out.println("[ERROR] - " + texto);
    }

    public void mostrarListaCompra(ListaDeLaCompra lista) {
        System.out.println();
        System.out.println("-".repeat(ANCHO));
        System.out.println(" Lista: " + lista.getNombreLista());
        System.out.println("-".repeat(ANCHO));

        if (lista.getArticulos().isEmpty()) {
            System.out.println(" La lista está vacía");
        } else {
            System.out.printf(" %-3s %-26s %5s  %-6s%n", "Nº", "Descripción", "Cant.", "Medida");
            System.out.println("-".repeat(ANCHO));

            for (int i = 0; i < lista.getArticulos().size(); i++) {
                ArticuloAComprar articulo = lista.getArticulos().get(i);
                System.out.printf(" %-3d %-26s %5d  %-6s%n",
                        i + 1,
                        articulo.getDescripcion(),
                        articulo.getCantidad(),
                        articulo.getUnidad());
            }
        }

        System.out.println("-".repeat(ANCHO));
        System.out.println(" Total: " + lista.getArticulos().size() + " artículo(s)");
    }
}
