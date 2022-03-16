
package udrawing_paper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 */
public class UDRAWING_PAPER {
    static String Cl ="";
    static int dpi=0;
    static String pass = "";
    static String name = "";
   
    public static void main(String[] args) {
        // TODO code application logic here
         
         //INTERFAZ PRINCIPAL = new INTERFAZ();
        // PRINCIPAL.setVisible(true);
        CARGAS();
        
    }
    
    
     static void CARGAS() {
        //MÉTODO PARA REALIZAR LA CARGA DEL ARCHIVO
        JSONParser parser = new JSONParser();

        try {
            System.out.println("***************LEYENDO CONTENIDO DEL ARCHIVO***************");
            Object obj = parser.parse(new FileReader("C_CLIENTES.json"));
            JSONObject data = (JSONObject) obj;
            System.out.println("JSON LEIDO: " + data);

            data.keySet().forEach(keyStr
                    -> {
                //ENTENDER FUNCIONAMIENTO DE KEYS
                //System.out.println("key:" + keyStr);
                if (((JSONObject) data.get(keyStr)).keySet() != null) {
                    ((JSONObject) data.get(keyStr)).keySet().forEach(keyStr2
                            -> {

                        Cl = (String) keyStr;
                        Object keyvalue2 = ((JSONObject) data.get(keyStr)).get(keyStr2);

                        if (keyStr2.equals("dpi")) {
                            dpi = Integer.parseInt((String) keyvalue2);
                        } else {
                            if (keyStr2.equals("nombre_cliente")) {

                                name = (String) keyvalue2;
                            } else {

                                if (keyStr2.equals("password")) {

                                    pass = (String) keyvalue2;
                                } else {

                                   
                                }
                            }

                        }
                        //ENTENDER FUNCIONAMIENTO DE KEYS
                        System.out.println("          key:" + keyStr2 + "   value:" + keyvalue2);

                    }
                    );
                }
                //CLIENTE.insertar(Cl, id, nombre_cliente, img_color, img_bw);
            });
           

            System.out.println("%%%%%%%%%%% SUCESSFULLY %%%%%%%%%%% ");

           
            
           

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ParseException e) {
        }

    }
}


