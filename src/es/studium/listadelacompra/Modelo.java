package es.studium.listadelacompra;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Modelo {

    private final String KEY_DESCRIPCION = "descripcion";
    private final String KEY_CANTIDAD = "cantidad";
    private final String KEY_MEDIDA = "medida";

    public void guardarDatos(ListaDeLaCompra lista) {
        JSONArray productos = new JSONArray();

        for (int i = 0; i < lista.getArticulos().size(); i++) {
            ArticuloAComprar articulo = lista.getArticulos().get(i);

            JSONObject obj = new JSONObject();
            obj.put(KEY_DESCRIPCION, articulo.getDescripcion());
            obj.put(KEY_CANTIDAD, articulo.getCantidad());
            obj.put(KEY_MEDIDA, articulo.getMedida());

            productos.put(obj);
        }
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(lista.getNombreLista() + ".json"),StandardCharsets.UTF_8)) {
            writer.write(productos.toString(4));
        } catch (IOException e) {
            System.err.println("Se ha producido un ERROR al generar el JSON " + e.getMessage());
        }
    }

    public ListaDeLaCompra leerDatos(ListaDeLaCompra lista){
        ListaDeLaCompra listaDeLaCompra = new ListaDeLaCompra();
        listaDeLaCompra.setNombreLista(lista.getNombreLista());
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(lista.getNombreLista() + ".json"),StandardCharsets.UTF_8)) {
            JSONArray productos = new JSONArray(new JSONTokener(reader));

            for (int i = 0; i < productos.length(); i++) {
                JSONObject producto = productos.getJSONObject(i);

                String descripcion = producto.getString(KEY_DESCRIPCION);
                int cantidad = producto.getInt(KEY_CANTIDAD);
                String medida = producto.getString(KEY_MEDIDA);

                ArticuloAComprar nuevoArticulo = new ArticuloAComprar(descripcion,cantidad,medida);
                listaDeLaCompra.agregarProductoAComprar(nuevoArticulo);
            }
        } catch (IOException e) {
            System.err.println("Se ha producido un ERROR al leer el JSON " + e.getMessage());
        }
        return listaDeLaCompra;
    }
}
