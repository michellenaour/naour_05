package ClasesyObjetos;

import org.json.simple.JSONObject;

public class Zapatilla_Nueva {
    public JSONObject Crear_JSONZapatilla(String marca ,String modelo,String color) {
        JSONObject JSONZapatilla = new JSONObject();
        JSONZapatilla.put("marca", marca);
        JSONZapatilla.put("modelo", modelo);
        JSONZapatilla.put("color", color);
        return JSONZapatilla;
    }
    public Zapatilla Crear_Zapatilla(JSONObject JSONZapatilla) {
        Zapatilla zapatilla = new Zapatilla(JSONZapatilla.get("marca").toString(), JSONZapatilla.get("modelo").toString(), JSONZapatilla.get("color").toString());
        return zapatilla;
    }
}
