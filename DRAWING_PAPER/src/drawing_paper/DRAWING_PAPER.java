package drawing_paper;

/**
 *
 * @author ifigueroa065
 */
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DRAWING_PAPER {
    //DECLARACIÓN DE VARIABLES GLOBALES

    static Scanner entrada = new Scanner(System.in);
    static boolean condicion = true;

    static ArrayList<String> lista = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        //CARGAS();
         //MENU();
         Cola cliente = new Cola();
         cliente.insertar("Cliente1", 0, "ISAI", 2, 3);
         cliente.insertar("Cliente2", 1, "ISAI", 2, 3);
         cliente.insertar("Cliente3", 2, "ISAI", 2, 3);
         cliente.insertar("Cliente4", 3, "ISAI", 2, 3);
         cliente.recorrer();
         
        /**
         * xCODIGO PARA PROBAR LISTA SIMPLE
         *
         * ListaS lista = new ListaS();
         *
         * System.out.println("<<-- Ejemplo de lista simple -->>\n");
         *
         * // Agregar al final de la lista lista.agregarAlFinal(12);
         * lista.agregarAlFinal(15); lista.agregarAlFinal(9); // Agregar in
         * inicio de la lista lista.agregarAlInicio(41);
         * lista.agregarAlInicio(6);
         *
         * System.out.println("<<-- Lista -->>"); lista.listar();
         *
         * System.out.println("\n\n<<-- Tamaño -->");
         * System.out.println(lista.getTamanio());
         *
         * System.out.println("\n<<-- Obtener el valor del nodo en la posicion 3 -->>");
         * System.out.println(lista.getValor(3));
         *
         * System.out.println("\nInsrta un nodo con valor 16 despues del 15");
         * lista.insertarPorReferencia(15, 16); lista.listar();
         * System.out.print(" | Tamaño: ");
         * System.out.println(lista.getTamanio());
         *
         * System.out.println("\n\nInsrta un nodo con valor 44 en la posición
         * 3"); lista.insrtarPorPosicion(3, 44); lista.listar();
         * System.out.print(" | Tamaño: ");
         * System.out.println(lista.getTamanio());
         *
         * System.out.println("\nActualiza el valor 12 del tercer nodo por 13");
         * lista.editarPorReferencia(12, 13); lista.listar(); System.out.print("
         * | Tamaño: "); System.out.println(lista.getTamanio());
         *
         * System.out.println("\nActualiza el valor nodo en la posición 0 por
         * 17"); lista.editarPorPosicion(0, 17); lista.listar();
         * System.out.print(" | Tamaño: ");
         * System.out.println(lista.getTamanio());
         *
         * System.out.println("\nElimina el nodo con el valor 41");
         * lista.removerPorReferencia(41); lista.listar(); System.out.print(" |
         * Tamaño: "); System.out.println(lista.getTamanio());
         *
         * System.out.println("\nElimina el nodo en la posición 4");
         * lista.removerPorPosicion(4); lista.listar(); System.out.print(" |
         * Tamaño: "); System.out.println(lista.getTamanio());
         *
         * System.out.println("\nConsulta si existe el valor 30");
         * System.out.println(lista.buscar(30));
         *
         * System.out.println("\nConsulta la posicion del valor 9");
         * System.out.println(lista.getPosicion(9));
         *
         * System.out.println("\nElimina la lista"); lista.eliminar();
         *
         * System.out.println("\nConsulta si la lista está vacia");
         * System.out.println(lista.esVacia());
         *
         * System.out.println("\n\n<<-- Fin de ejemplo lista simple -->>");
         *
         *
         */

        /**
         *
         * CÓDIGO PARA EVALUAR LA COLA
         *
         * Cola cola1=new Cola(); cola1.insertar(46); cola1.insertar(12);
         * cola1.insertar(87); cola1.insertar(125); cola1.insertar(30);
         * cola1.extraer(); cola1.estaVacia(); cola1.contar();
         * System.out.println(cola1.toString());
        *
         */
        /**
         *
         * CODIGO PARA EVALUAR LA PILA
         *
         *
         * //CREANDO LA PILA Pila p = new Pila();
         *
         * //OPERACIONES CON PILA p.push(2); p.push(8); p.push(1);
         *
         * p.peek(); p.cima(); p.pop(); p.peek(); p.pop(); p.cima(); p.pop();
         * p.peek();
          *
         */
    }

    static void MENU() {
        System.out.println("____________________________________________________");
        System.out.println("");
        System.out.println("                  UDRAWING PAPER                    ");
        System.out.println("____________________________________________________");
        while (condicion == true) {
            System.out.println("****************************************************");
            System.out.println("**                Elija una opción                **");
            System.out.println("****************************************************");
            System.out.println("  -->1.CARGAS             ");
            System.out.println("  -->2.EJECUTAR PASO          ");
            System.out.println("  -->3.ESTADO EN MEMORIA DE LAS ESTRUCTURAS      ");
            System.out.println("  -->4.REPORTES           ");
            System.out.println("  -->5.ACERCA DE           ");
            System.out.println("  -->6.SALIR              ");

            switch (entrada.nextLine()) {
                case "1":
                    //MENU DE CARGAS();
                    break;
                case "2":
                    //EJECUTANDO PASO
                    EJ_PASO();

                    break;
                case "3":
                    //OP3
                    MOSTRAR_ESTADOS();
                    break;

                case "4":
                    MOSTRAR_REPORTES();
                    break;
                case "5":
                    //DESCIFRAR
                    DATOS();

                    break;
                case "6":
                    condicion = false;
                    System.out.println("GRACIAS POR UTILIZAR MI PROGRAMA :)");

                    break;

                default:
                    System.out.println("--NO SELECCIONÓ UNA OPCIÓN VÁLIDA--");
            }
        }
    }

    static void CARGAS() {

        JSONParser parser = new JSONParser();

        try {
            System.out.println("ESTOY LEYENDO EL ARCHIVO");
            Object obj = parser.parse(new FileReader("Entrada.json"));
            JSONObject data = (JSONObject) obj;
            System.out.println("JSON LEIDO: " + data);

            data.keySet().forEach(keyStr
                    -> {

                System.out.println("key:" + keyStr);
                if (((JSONObject) data.get(keyStr)).keySet() != null) {
                    ((JSONObject) data.get(keyStr)).keySet().forEach(keyStr2
                            -> {

                        Object keyvalue2 = ((JSONObject) data.get(keyStr)).get(keyStr2);
                        System.out.println("          key:" + keyStr2 + "   value:" + keyvalue2);
                        lista.add((String) keyvalue2);
                    }
                    );
                }
            });

            for (String temp : lista) {
                System.out.println(temp);
            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ParseException e) {
        }

    }

    static void EJ_PASO() {
    }

    static void MOSTRAR_ESTADOS() {
    }

    static void MOSTRAR_REPORTES() {
    }

    static void DATOS() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("MARLON ISAI");
    }

}
