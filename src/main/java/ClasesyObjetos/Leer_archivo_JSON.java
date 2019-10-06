package ClasesyObjetos;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

public class Leer_archivo_JSON {

    public ArrayList<Zapatilla> leer_archivo_json() {
        JSONObject jsonObject=Json_A_JSONObject("zapatillas.json");
        JSONArray jsonArray=JSONObject_A_JSONArray(jsonObject);
        return Crear_array_con_datos(jsonArray);

    }

    public JSONObject Json_A_JSONObject(String nombre_archivo){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try {
            Reader reader = new FileReader(nombre_archivo);
            jsonObject = (JSONObject) parser.parse(reader);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){System.out.println("Error! el fichero no existe");}
        catch (ParseException p){System.out.println("Error en la sintaxis del fichero");}
        return jsonObject ;
    }

    public JSONArray JSONObject_A_JSONArray(JSONObject jsonObject){
        JSONArray jsonarray=(JSONArray) jsonObject.get("zapatillas");
        return jsonarray;
    }

    public ArrayList<Zapatilla> Crear_array_con_datos(JSONArray array){
        ArrayList <Zapatilla>arr= new ArrayList<>();
        for(int i=0; i<7;i++){
            JSONObject Zap = (JSONObject) array.get(i);
            Zapatilla zapatilla= new Zapatilla(Zap.get("marca").toString(),Zap.get("modelo").toString(),Zap.get("color").toString());
            arr.add(zapatilla);
        }
        return arr;
    }
}
