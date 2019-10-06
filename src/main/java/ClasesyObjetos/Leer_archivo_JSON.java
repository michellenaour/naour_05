package ClasesyObjetos;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Leer_archivo_JSON {

    public ArrayList<Zapatilla> m() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        ArrayList <Zapatilla>arr= new ArrayList<>();
        Reader reader = new FileReader("zapatillas.json");
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray array = (JSONArray) jsonObject.get("zapatillas");
        for(int i=0; i<7;i++){
            JSONObject Zap = (JSONObject) array.get(i);
            Zapatilla zapatilla= new Zapatilla(Zap.get("marca").toString(),Zap.get("modelo").toString(),Zap.get("color").toString());
            arr.add(zapatilla);
        }
        return arr;
    }
}
