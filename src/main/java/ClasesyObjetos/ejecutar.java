package ClasesyObjetos;


import org.json.simple.parser.ParseException;

import java.io.IOException;

import java.util.ArrayList;


public class ejecutar {

    static ArrayList<Zapatilla> array =new  ArrayList<>();
    static Append_To_File append_to_file = new Append_To_File();
    static Leer_archivo_JSON leer_archivo_json = new Leer_archivo_JSON();

    public static void main(String[] args) throws IOException, ParseException {
        array = leer_archivo_json.m();
        Zapatilla zapatillaNueva=append_to_file.WriterZap();
        array.add(zapatillaNueva);
        mostrar_zapatillas();
    }

    public static void mostrar_zapatillas(){
        System.out.println("-----------------Zapatillas-----------------");
        for (int i = 0; i < array.size(); i++) {
            Zapatilla zap = array.get(i);
            System.out.println(zap.getString());
        }
    }
}
