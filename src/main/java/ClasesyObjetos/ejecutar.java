package ClasesyObjetos;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;


public class ejecutar {

    static ArrayList<Zapatilla> Zapatillas =new  ArrayList<>();
    static Append_To_File append_to_file = new Append_To_File();
    static Leer_archivo_JSON leer_archivo_json = new Leer_archivo_JSON();

    public static void main(String[] args)  {
        Crear_arreglo_Zapatillas();
        mostrar_zapatillas();
    }

    public static void Crear_arreglo_Zapatillas()  {
        Zapatillas = leer_archivo_json.leer_archivo_json();
        Zapatilla zapatillaNueva=append_to_file.Agregar_nueva_zapatilla_al_archivo();
        Zapatillas.add(7,zapatillaNueva);
    }

    public static void mostrar_zapatillas(){
        System.out.println("-----------------Zapatillas-----------------");
        for (int i = 0; i < Zapatillas.size(); i++) {
            Zapatilla zap = Zapatillas.get(i);
            System.out.println(zap.getString());
        }
    }
}
