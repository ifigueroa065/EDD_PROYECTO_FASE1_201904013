package udrawing_paper;

import ESTRUCTURAS.ArbolAVL;
import ESTRUCTURAS.ArbolB;
import ESTRUCTURAS.ArbolBinarioBusqueda;
import ESTRUCTURAS.MATRIZ.Matriz;
import ESTRUCTURAS.NodoB;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author ifigueroa065
 */
public class UDRAWING_PAPER {

    public static void main(String[] args) {
        // TODO code application logic here

        //INTERFAZ PRINCIPAL = new INTERFAZ();
        //PRINCIPAL.setVisible(true);
        
        /*ArbolB arbol=new ArbolB();
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(5);
        arbol.insertar(9);
        arbol.insertar(12);
        arbol.insertar(18);
        arbol.insertar(25);
        arbol.insertar(65);
        arbol.insertar(92);
        arbol.insertar(99);*/
      
        //arbol.Recorrer_A();
        
        
        System.out.println();
        /*
        //Creamos un árbol cuyos nodos contendrán solamente numeros
        ArbolBinarioBusqueda arbol_numeros=new ArbolBinarioBusqueda();
        //Llenamos con información el árbol 
        //9,3,1,0,2,6,4,5,8,7,15,10,12,11
        
        arbol_numeros.insertar(9);
        arbol_numeros.insertar(3);
        arbol_numeros.insertar(1);
        arbol_numeros.insertar(0);
        arbol_numeros.insertar(2);
        arbol_numeros.insertar(6);
        arbol_numeros.insertar(4);
        arbol_numeros.insertar(5);
        arbol_numeros.insertar(8);
        arbol_numeros.insertar(7);
        arbol_numeros.insertar(15);
        arbol_numeros.insertar(10);
        arbol_numeros.insertar(12);
        arbol_numeros.insertar(11); 
         
        
        arbol_numeros.graficar("tarea5.jpg");
        
        arbol_numeros.inorden();*/
        
        /*
         ArbolAVL arbol_numeros=new ArbolAVL();
        //Llenamos con información el árbol
        arbol_numeros.insertar(12);
        arbol_numeros.insertar(5);
        arbol_numeros.insertar(26);
        arbol_numeros.insertar(33);
        arbol_numeros.insertar(59);
        arbol_numeros.insertar(27);
        arbol_numeros.insertar(15);      
        arbol_numeros.insertar(47);
        arbol_numeros.insertar(74);
        arbol_numeros.insertar(84);
        arbol_numeros.insertar(88);
        arbol_numeros.insertar(90);
        arbol_numeros.insertar(124);
        arbol_numeros.insertar(612);
        //Graficamos el árbol generando la imagen arbol_numeros.jpg
        arbol_numeros.graficar("arbol_numeros.jpg");
        //Imprimimos el contenido del árbol ordenado
        arbol_numeros.inorden();*/
        
        
        Matriz matrix= new Matriz();
        matrix.existeX("/");
        matrix.existeY("/");
        matrix.existeX("home");
        matrix.existeY("home");
        matrix.existeX("user");
        matrix.existeY("user");
        matrix.existeX("var");
        matrix.existeY("var");
        matrix.existeX("documents");
        matrix.existeY("documents");
        matrix.existeX("usac");
        matrix.existeY("usac");
        matrix.existeX("videos");
        matrix.existeY("videos");
        matrix.existeX("folder");
        matrix.existeY("folder");
        matrix.existeX("credentials");
        matrix.existeY("credentials");
        matrix.existeX("temp");
        matrix.existeY("temp");
        matrix.existeX("cache");
        matrix.existeY("cache");
        matrix.existeX("oracle");
        matrix.existeY("oracle");
        matrix.guardarMatriz("/", "/");
        matrix.guardarMatriz("home", "/");
        matrix.guardarMatriz("user", "/");
        matrix.guardarMatriz("var", "/");
        matrix.guardarMatriz("temp", "/");
        matrix.guardarMatriz("documents", "home");
        matrix.guardarMatriz("videos", "home");
        matrix.guardarMatriz("folder", "user");
        matrix.guardarMatriz("credentials", "user");
        matrix.guardarMatriz("usac", "documents");
        matrix.guardarMatriz("oracle", "var");
        matrix.guardarMatriz("cache", "temp");
        
        matrix.Modificar("home","videos", "nuevaCarpeta");
        matrix.Grafo();
        matrix.Graficar();
       

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
