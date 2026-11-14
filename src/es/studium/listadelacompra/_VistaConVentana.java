/*
package es.studium.listadelacompra;

import javax.swing.*;
import java.awt.*;

public class VistaConVentana {
    JFrame frame;
    JTextField txtNombreLista;
    JButton btnCambiarNombre;
    JButton btnCargar, btnGuardar;

    JTextField txtDescripcion;
    JTextField txtCantidad;
    JTextField txtMedida;
    JButton btnAgregar;

    DefaultListModel<String> modeloLista;
    JList<String> listArticulos;
    JButton btnEliminar;

    public VistaConVentana() {
        // Inicializamos la ventana mediante composición
        frame = new JFrame("Lista de la Compra");
        frame.setSize(520, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout(10, 10));

        // Panel Superior: Nombre de la lista y persistencia
        JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelNorte.add(new JLabel("Nombre:"));
        txtNombreLista = new JTextField(12);
        btnCambiarNombre = new JButton("Actualizar");
        btnCargar = new JButton("Cargar");
        btnGuardar = new JButton("Guardar");
        panelNorte.add(txtNombreLista);
        panelNorte.add(btnCambiarNombre);
        panelNorte.add(btnCargar);
        panelNorte.add(btnGuardar);
        frame.add(panelNorte, BorderLayout.NORTH);

        // Panel Central: Lista visual de artículos
        modeloLista = new DefaultListModel<>();
        listArticulos = new JList<>(modeloLista);
        frame.add(new JScrollPane(listArticulos), BorderLayout.CENTER);

        // Panel Inferior: Formulario y botones de acción
        JPanel panelSur = new JPanel(new GridLayout(4, 2, 5, 5));
        panelSur.setBorder(BorderFactory.createTitledBorder("Artículos"));

        panelSur.add(new JLabel("Descripción:"));
        txtDescripcion = new JTextField();
        panelSur.add(txtDescripcion);

        panelSur.add(new JLabel("Cantidad:"));
        txtCantidad = new JTextField();
        panelSur.add(txtCantidad);

        panelSur.add(new JLabel("Medida (Kg, L, U):"));
        txtMedida = new JTextField();
        panelSur.add(txtMedida);

        btnAgregar = new JButton("Agregar");
        btnEliminar = new JButton("Eliminar");
        panelSur.add(btnAgregar);
        panelSur.add(btnEliminar);

        frame.add(panelSur, BorderLayout.SOUTH);
        frame.setVisible(true);
    }
}
*/