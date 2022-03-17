package udrawing_paper;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Usuario
 */
public class UDRAWING_PAPER {

    public static void main(String[] args) {
        // TODO code application logic here

        INTERFAZ PRINCIPAL = new INTERFAZ();
        PRINCIPAL.setVisible(true);

    }

    static void CARGAS() {
        //MÉTODO PARA REALIZAR LA CARGA DEL ARCHIVO DE CAPAS
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("CAPAS.json")) {

            Object obj = jsonParser.parse(reader);
            JSONArray clienteslist = (JSONArray) obj;
            System.out.println("El archivo contiene el siguiente JSON : ");
            //System.out.println(clienteslist);

            System.out.println("--------------------------------");
            for (Object cliente : clienteslist) {
                //System.out.println(cliente );

                JSONObject data = (JSONObject) cliente;

                System.out.println("ID CAPA" + data.get("id_capa"));

                JSONArray pix = (JSONArray) data.get("pixeles");

                for (Object pixel : pix) {
                    JSONObject chupi = (JSONObject) pixel;
                    System.out.print("fila : " + chupi.get("fila"));
                    System.out.print("  columna: " + chupi.get("columna"));
                    System.out.println("  color: " + chupi.get("color"));
                    System.out.println("**********");
                }

                System.out.println("--------------------------------");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    static void CARGAS2() {
        //MÉTODO PARA REALIZAR LA CARGA DEL ARCHIVO IMÁGENES
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader("IMAGENES.json")) {

            Object obj = jsonParser.parse(reader);
            JSONArray clienteslist = (JSONArray) obj;
            System.out.println("El archivo contiene el siguiente JSON : ");
            //System.out.println(clienteslist);

            System.out.println("--------------------------------");
            for (Object cliente : clienteslist) {
                //System.out.println(cliente );

                JSONObject data = (JSONObject) cliente;

                System.out.println("ID : " + data.get("id"));
                System.out.print("CAPAS : [ ");

                JSONArray pix = (JSONArray) data.get("capas");
                //System.out.println(pix);
                for (Object pixel : pix) {

                    System.out.print(pixel + ",");

                }
                System.out.print("]");
                System.out.println("");
                System.out.println("--------------------------------");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
