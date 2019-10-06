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
    static JSONParser parser = new JSONParser();
    static ArrayList <Zapatilla>arreglo= new ArrayList<>();
    public ArrayList<Zapatilla> leer_archivo_json() throws IOException, ParseException {
        arreglo= Crear_array_con_datos((JSONArray) Leer_JSON());
        return arreglo;
    }

    public  ArrayList<Zapatilla> Leer_JSON()  {
        JSONParser parser = new JSONParser();
        JSONArray array = new JSONArray();
        try {
            Reader reader = new FileReader("zapatillas.json");
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            array = (JSONArray) jsonObject.get("zapatillas");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){e.printStackTrace();}
        catch (ParseException p){p.printStackTrace();}
        return array;
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
