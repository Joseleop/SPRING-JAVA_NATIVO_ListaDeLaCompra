package es.studium.listadelacompra;

import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        Vista vista = new Vista();
        Modelo modelo = new Modelo();

        new Controlador(vista, modelo);
    }
}
