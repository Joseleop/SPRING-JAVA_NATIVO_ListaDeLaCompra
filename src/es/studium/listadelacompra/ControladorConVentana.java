package es.studium.listadelacompra;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorConVentana implements ActionListener {
    private final VistaConVentana vistaConVentana;
    private final ModeloConVentana modeloConVentana;
    public ControladorConVentana(VistaConVentana v, ModeloConVentana m) {
        this.vistaConVentana = v;
        this.modeloConVentana = m;

        this.vistaConVentana.btnCambiarNombre.addActionListener(this);
        this.vistaConVentana.btnAgregar.addActionListener(this);
        this.vistaConVentana.btnEliminar.addActionListener(this);

        this.vistaConVentana.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vistaConVentana.btnCambiarNombre){
            System.out.println("Botón cambiar nombre");
            String nombreLista = vistaConVentana.txtNombreLista.getText();
        }
        else if(e.getSource()== vistaConVentana.btnAgregar){
            agregarArticulo();
        }
        else if (e.getSource() == vistaConVentana.btnEliminar){
            System.out.println("botón eliminar");
            eliminarArticulo();
        }
    }

    private void eliminarArticulo() {
        int articuloSeleccionado = vistaConVentana.listArticulos.getSelectedIndex();

        if(articuloSeleccionado == -1){
            System.out.println("No hay ningún artículo seleccionado");
            return;
        }
        if(articuloSeleccionado>=0){
            System.out.println(articuloSeleccionado);

        }
    }

    public void agregarArticulo(){
        String descripcion = vistaConVentana.txtDescripcion.getText().trim();
        String medida = vistaConVentana.txtMedida.getText().trim();

        if (descripcion.isBlank()) {
            System.out.println("La descripción no puede estar vacía");
            return;
        }
        if (medida.isBlank()) {
            System.out.println("La unidad de medida no puede estar vacía");
            return;
        }

        int cantidad;
        try {
            cantidad = Integer.parseInt(vistaConVentana.txtCantidad.getText().trim());
        } catch (NumberFormatException e) {
            System.out.println("La cantidad debe ser un número válido");
            return;
        }
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser mayor de 0");
            return;
        }

        // Crear el artículo y guardarlo en el modelo
        ArticuloAComprar articulo = new ArticuloAComprar();
        articulo.setDescripcion(descripcion);
        articulo.setCantidad(cantidad);
        articulo.setMedida(medida);
        modeloConVentana.lista.agregarProductoAComprar(articulo);

        // Mostrarlo en la ventana y limpiar el formulario
        vistaConVentana.modeloLista.addElement(descripcion + " - " + cantidad + " " + medida);
        vistaConVentana.txtDescripcion.setText("");
        vistaConVentana.txtCantidad.setText("");
        vistaConVentana.txtMedida.setText("");
    }
}
