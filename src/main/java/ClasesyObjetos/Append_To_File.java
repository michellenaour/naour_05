package ClasesyObjetos;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import java.io.*;
public class Append_To_File {
    static JSONArray ja = new JSONArray();

    public Zapatilla Agregar_nueva_zapatilla_al_archivo() {
        Zapatilla A= Crear_Zapatilla(Crear_JSONZapatilla());
        Try_Catch();
        return A;
    }

    private static JSONObject Crear_JSONZapatilla() {
        JSONObject JSONZapatilla = new JSONObject();
        JSONZapatilla.put("marca", "Nike");
        JSONZapatilla.put("modelo", "AirForce1");
        JSONZapatilla.put("color", "Black");
        ja.add(JSONZapatilla);
        return JSONZapatilla;
    }

    private static Zapatilla Crear_Zapatilla(JSONObject JSONZapatilla) {
        Zapatilla zapatilla = new Zapatilla(JSONZapatilla.get("marca").toString(), JSONZapatilla.get("modelo").toString(), JSONZapatilla.get("color").toString());
        return zapatilla;
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
