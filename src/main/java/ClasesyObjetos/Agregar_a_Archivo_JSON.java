package ClasesyObjetos;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.io.*;
public class Agregar_a_Archivo_JSON {
    static JSONArray ja = new JSONArray();
    static Zapatilla_Nueva zapatilla_nueva =new Zapatilla_Nueva();

    public Zapatilla Agregar_nueva_zapatilla_al_archivo(String marca ,String modelo,String color) {
        JSONObject jsonzapatilla = zapatilla_nueva.Crear_JSONZapatilla(marca , modelo , color);
        ja.add(jsonzapatilla);
        Try_Catch();
        return zapatilla_nueva.Crear_Zapatilla(jsonzapatilla);
    }

    private static void Try_Catch(){
        try {
            agregar_al_archivo();
        } catch (IOException e) {
            System.out.println("Error! el fichero no existe");
        }
    }

    private static void agregar_al_archivo () throws IOException {
        FileWriter file = new FileWriter("zapatillas.json", true);
        file.write(ja.toJSONString());
        file.close();
    }
}
