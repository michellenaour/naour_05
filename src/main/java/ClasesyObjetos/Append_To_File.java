package ClasesyObjetos;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;

import java.io.*;
public class Append_To_File {

        public Zapatilla WriterZap() {
            JSONParser jsonParser = new JSONParser();
            JSONArray ja = new JSONArray();
            JSONObject JSONZapatilla = new JSONObject();
            JSONZapatilla.put("marca", "Nike");
            JSONZapatilla.put("modelo", "AirForce1");
            JSONZapatilla.put("color", "Black");
            ja.add(JSONZapatilla);
            Zapatilla zapatilla = new Zapatilla(JSONZapatilla.get("marca").toString(),JSONZapatilla.get("modelo").toString(),JSONZapatilla.get("color").toString());
            System.out.println(zapatilla.getString());

            try {
                System.out.println(ja);
                FileWriter file = new FileWriter("zapatillas.json",true);
                file.write(ja.toJSONString());
                file.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return zapatilla;
        }
    }

