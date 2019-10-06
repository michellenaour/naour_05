package ClasesyObjetos;

import org.json.simple.JSONStreamAware;
import org.json.simple.JSONValue;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;

public class Zapatilla  {
    // atributos
    String marca;
    String modelo;
    String color;

    // metodos

    public Zapatilla(String marca,String modelo,String color){
        super();
        this.marca=marca;
        this.modelo=modelo;
        this.color=color;

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getString(){
        return ("marca: "+this.marca+"    modelo: "+this.modelo+"   color: "+this.color);
    }

    public void writeJSONString(Writer out) throws IOException {
        LinkedHashMap obj = new LinkedHashMap();
        obj.put("marca",marca);
        obj.put("modelo",modelo);
        obj.put("color",color);
        JSONValue.writeJSONString(obj,out);
    }
}
