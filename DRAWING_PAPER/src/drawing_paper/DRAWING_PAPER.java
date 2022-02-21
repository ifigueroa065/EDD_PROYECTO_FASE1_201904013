package drawing_paper;

/**
 *
 * @author ifigueroa065
 */
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DRAWING_PAPER {
    //DECLARACIÓN DE VARIABLES GLOBALES

    static Scanner entrada = new Scanner(System.in);
    static Scanner entrada2 = new Scanner(System.in);
    static boolean condicion = true;

    static Cola CLIENTE = new Cola();
    static ListTemp TEMPORAL = new ListTemp();
    static ListaS VENTANILLA = new ListaS();
    static ListaE ESPERA = new ListaE();
    static PrintColor IMP_COLOR = new PrintColor();
    static PrintBw IMP_BW = new PrintBw();
    static Clientes_A ATENDIDOS = new Clientes_A();

    static int stepColor = 2;

    static int step = 0;
    static int id = 0;
    static String nombre_cliente = "";
    static int img_color = 0;
    static int img_bw = 0;
    static String Cl = "";

    public static void main(String[] args) throws Exception {
        //AQUI SUCEDE TODA LA MAGIA :)

        MENU();

    }

    static void MENU() {
        System.out.println("");
        System.out.println("");
        System.out.println("____________________________________________________");
        System.out.println("");
        System.out.println("                  UDRAWING PAPER                    ");
        System.out.println("____________________________________________________");
        while (condicion == true) {
            System.out.println("****************************************************");
            System.out.println("**                Elija una opción                **");
            System.out.println("****************************************************");
            System.out.println("  -->1. CARGAS             ");
            System.out.println("  -->2. EJECUTAR PASO          ");
            System.out.println("  -->3. ESTADO EN MEMORIA DE LAS ESTRUCTURAS      ");
            System.out.println("  -->4. REPORTES           ");
            System.out.println("  -->5. ACERCA DE           ");
            System.out.println("  -->6. SALIR              ");

            switch (entrada.nextLine()) {
                case "1":
                    MENU_CARGAS();
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
                    MENU_REPORTES();
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
                    System.out.println("$$$$---NO SELECCIONÓ UNA OPCIÓN VÁLIDA---$$$$");
            }
        }
    }

    static void CARGAS() {
        //MÉTODO PARA REALIZAR LA CARGA DEL ARCHIVO
        JSONParser parser = new JSONParser();

        try {
            System.out.println("***************LEYENDO CONTENIDO DEL ARCHIVO***************");
            Object obj = parser.parse(new FileReader("Entrada2.json"));
            JSONObject data = (JSONObject) obj;
            //System.out.println("JSON LEIDO: " + data);

            data.keySet().forEach(keyStr
                    -> {
                //ENTENDER FUNCIONAMIENTO DE KEYS
                //System.out.println("key:" + keyStr);
                if (((JSONObject) data.get(keyStr)).keySet() != null) {
                    ((JSONObject) data.get(keyStr)).keySet().forEach(keyStr2
                            -> {

                        Cl = (String) keyStr;
                        Object keyvalue2 = ((JSONObject) data.get(keyStr)).get(keyStr2);

                        if (keyStr2.equals("id_cliente")) {
                            id = Integer.parseInt((String) keyvalue2);
                        } else {
                            if (keyStr2.equals("nombre_cliente")) {

                                nombre_cliente = (String) keyvalue2;
                            } else {

                                if (keyStr2.equals("img_color")) {

                                    img_color = Integer.parseInt((String) keyvalue2);
                                } else {

                                    if (keyStr2.equals("img_bw")) {

                                        img_bw = Integer.parseInt((String) keyvalue2);

                                    } else {

                                    }
                                }
                            }

                        }
                        //ENTENDER FUNCIONAMIENTO DE KEYS
                        //System.out.println("          key:" + keyStr2 + "   value:" + keyvalue2);

                    }
                    );
                }
                CLIENTE.insertar(Cl, id, nombre_cliente, img_color, img_bw);
            });
            CLIENTE.ORDENAR();
            CLIENTE.recorrer();

            //System.out.println("**************************************DESENCOLAR---");
            //CLIENTE.desencolar();
            //CLIENTE.desencolar();

            //System.out.println("");
            //System.out.println("");

            //CLIENTE.recorrer();

            System.out.println("%%%%%%%%%%% SUCESSFULLY %%%%%%%%%%% ");

            //TXT Generado para hacer el Grafo
            //System.out.println(CLIENTE.GenerarDTO("RECEPCION"));
            
            pressAnyKeyToContinue();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ParseException e) {
        }

    }

    static void EJ_PASO() {

        System.out.println("-------------- ESTOY EJECUTANDO UN PASO --------------");
        step++;
        System.out.println("                                          PASO " + step);
        if (VENTANILLA.estaVacia()) {
            System.out.println("________ DEBE GENERAR VENTANILLAS PRIMERO ________  ");
        } else {
            
            System.out.println("ESTOY DANDO UN PASO");

            //ATENDIDOS
            NodoE solovino = ESPERA.inicio;

            while (solovino != null) {
                boolean negra = false;
                boolean la_noche = false;

                Nodo_PBw tula = new Nodo_PBw();

                while (tula != null) {
                    if (solovino.getId() == tula.getId_cliente()) {
                        negra = true;
                        break;
                    }
                    tula = tula.getNext();
                }
                Nodo_PColor tusa = new Nodo_PColor();
                while (tusa != null) {
                    if (solovino.getId() == tusa.getId_cliente()) {
                        la_noche = true;
                        break;
                    }

                    tusa = tusa.getNext();
                }
                if (negra == false && la_noche == false) {
                    ATENDIDOS.agregar(solovino.getId(),solovino.getNombre_cliente(), solovino.getVentanilla(), solovino.getImg_color(), solovino.getImg_bw(), step);
                    //AQUI TENGO QUE ELIMINAR A SOLOVINO POR PARAMETRO XD 
                    ESPERA.Eliminar(solovino.getId());
                }

                solovino = solovino.getNext();
            }

            //IMPRIMIENDO
            if (IMP_BW.estaVacia() == false) {
                NodoE esperita = ESPERA.inicio;
                while (esperita != null) {
                    if (esperita.getId() == IMP_BW.inicio.getId_cliente()) {
                        //AQUI AGREGO A LA LISTA DE CLIENTES EN ESPERA
                        esperita.getFOTITAS().push("Bw");

                        //AQUI DESENCOLO DE IMP_BW
                        IMP_BW.desencolar();

                    }
                    esperita = esperita.getNext();
                }
            }

            if (IMP_COLOR.estaVacia() == false) {
                NodoE esperita = ESPERA.inicio;
                while (esperita != null) {
                    if (esperita.getId() == IMP_COLOR.inicio.getId_cliente()) {

                        stepColor--;
                        if (stepColor == 0) {
                            //AQUI AGREGO A LA LISTA DE CLIENTES EN ESPERA
                            esperita.getFOTITAS().push("Color");

                            IMP_COLOR.desencolar();
                            stepColor = 2;
                        }

                    }
                    esperita = esperita.getNext();
                }
            }

            //APILANDO
            NodoS gupi = VENTANILLA.inicio;
            while (gupi != null) {
                if (gupi.getStatus() == false) {
                    if (gupi.getImg_Color() > 0) {
                        gupi.getImagenes().push("Color");
                        gupi.setImg_Color(gupi.getImg_Color() - 1);
                    } else if (gupi.getImg_Bw() > 0) {

                        gupi.getImagenes().push("Bw");
                        gupi.setImg_Bw(gupi.getImg_Bw() - 1);

                    } else if (gupi.getImg_Color() == 0 && gupi.getImg_Bw() == 0) {
                        ESPERA.insertar(gupi.getId(), gupi.getNombre_cliente(), gupi.getNumero(), gupi.getImg_Color_F(), gupi.getImg_Bw_F());

                        NodoP alexa = gupi.getImagenes().CIMITA();
                        while (alexa != null) {

                            if (alexa.getImg().equals("Color")) {
                                IMP_COLOR.insertar(gupi.getId());
                                gupi.getImagenes().pop();
                            } else if (alexa.getImg().equals("Bw")) {
                                IMP_BW.insertar(gupi.getId());
                                gupi.getImagenes().pop();
                            }

                            alexa = alexa.getProx();
                        }
                        gupi.setStatus(true);
                        gupi.setNombre_cliente("");
                        gupi.setId(0);

                    }

                }
                gupi = gupi.getNext();
            }

            //VERIFICANDO VENTANILLA DISPONIBLE
            //VENTANILLA.status();

            NodoS nodito = VENTANILLA.inicio;

            while (nodito != null) {
                if (CLIENTE.estaVacia()) {
                    break;
                }
                if (nodito.getStatus()) {

                    nodito.setId(CLIENTE.inicio.getId_cliente());
                    nodito.setNombre_cliente(CLIENTE.inicio.getNombre_cliente());
                    nodito.setStatus(false);
                    nodito.setImg_Color(CLIENTE.inicio.getImg_color());
                    nodito.setImg_Bw(CLIENTE.inicio.getImg_bw());
                    nodito.setImg_Color_F(CLIENTE.inicio.getImg_color());
                    nodito.setImg_Bw_F(CLIENTE.inicio.getImg_bw());
                    nodito.setPasito(step);

                    CLIENTE.desencolar();
                    break;

                }
                nodito = nodito.getNext();
            }

            VENTANILLA.recorrer();

            System.out.println("________________________COLA DE COLOR______________");
            IMP_COLOR.recorrer();
            System.out.println("________________________COLA DE BW______________");
            IMP_BW.recorrer();

            System.out.println("------------------LISTA DE ESPERA--------------");
            ESPERA.recorrer();

            System.out.println("------------------LISTA DE ATENDIDOS--------------");
            ATENDIDOS.recorrer();

        }
        pressAnyKeyToContinue();
    }

    static void MOSTRAR_ESTADOS() {
        System.out.println("-------------- ESTADOS DE ESTRUCTURAS --------------");
        
        System.out.println("");
        System.out.println("________________ COLA DE RECEPCIÓN ________________  ");
        CLIENTE.recorrer();
        CLIENTE.GenerarImagen("L_RECEPCIÓN", CLIENTE.GenerarDTO("RECEPCION"));
        
        System.out.println("________________ LISTA DE VENTANILLAS ________________  ");
        VENTANILLA.recorrer();
        VENTANILLA.GenerarImagen("L_VENTANILLA", VENTANILLA.GenerarDTO("VENTANILLAS"));
        
        System.out.println("________________ LISTA DE ESPERA ________________  ");
        ESPERA.recorrer();
        ESPERA.GenerarImagen("L_ESPERA", ESPERA.GenerarDTO("ESPERA"));
        
        
        System.out.println("________________ COLA DE IMPRESORA A COLOR ________________  ");
        IMP_COLOR.recorrer(); 
        IMP_COLOR.GenerarImagen("IMP_COLOR", IMP_COLOR.GenerarDTO("IMPRESORA A COLOR"));
        
        System.out.println("________________ COLA DE IMPRESORA A BW ________________  ");
        IMP_BW.recorrer();
        CLIENTE.GenerarImagen("IMP_BW", CLIENTE.GenerarDTO("IMPRESORA A BW"));
        
        System.out.println("________________ LISTA DE ATENDIDOS ________________  ");
        ATENDIDOS.recorrer();
        ATENDIDOS.GenerarImagen("L_ATENDIDOS", ATENDIDOS.GenerarDTO("ATENDIDOS"));
        
        
        pressAnyKeyToContinue();
    }

    static void MOSTRAR_REPORTES() {
        System.out.println("--------------         REPORTES        --------------");

        pressAnyKeyToContinue();
    }

    static void DATOS() {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.println("               DATOS DEL ESTUDIANTE               ");
        System.out.println("__________________________________________________");
        System.out.println("");
        System.out.println("           MARLON ISAI FIGUEROA FARFÁN            ");
        System.out.println("           CARNET : 201904013                     ");
        System.out.println("           ESTRUCTURA DE DATOS - SECCIÓN B         ");
        System.out.println("");
        System.out.println("__________________________________________________");

        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");

        pressAnyKeyToContinue();
    }

    static void MENU_CARGAS() {

        while (condicion == true) {
            System.out.println("****************************************************");
            System.out.println("**                Elija una opción                **");
            System.out.println("****************************************************");
            System.out.println("  -->1.CARGA MASIVA DE CLIENTES           ");
            System.out.println("  -->2.CANTIDAD DE VENTANILLAS      ");
            System.out.println("  -->0.Volver              ");

            switch (entrada.nextLine()) {
                case "1":
                    CARGAS();
                    break;
                case "2":
                    //EJECUTANDO PASO
                    System.out.println("------ INGRESE EL # DE VENTANILLAS A CREAR----");
                    int numero = entrada2.nextInt();

                   

                    for (int i = 0; i < numero; i++) {

                        VENTANILLA.insertar(i + 1);
                    }
                    
                    //MOSTRANDO LOS NODOS CREADOS EN VENTANILLA
                    //VENTANILLA.recorrer();

                    System.out.println("");
                    System.out.println(" %%%% SE CREARON " + numero + " VENTANILLAS SATISFACTORIAMENTE %%%%");
                    pressAnyKeyToContinue();
                    break;
                case "0":
                    MENU();

                default:
                    System.out.println("$$$$---NO SELECCIONÓ UNA OPCIÓN VÁLIDA---$$$$");
            }
        }
    }

    static void MENU_REPORTES() {

        while (condicion == true) {

            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("     *************         REPORTES        *************      ");
            System.out.println("");
            System.out.println("______________________________________________________________");
            System.out.println("");
            System.out.println("**                      Elija una opción                    **");
            System.out.println("");
            System.out.println("______________________________________________________________");
            System.out.println("");
            System.out.println("  -->1. Top 5 de clientes con mayor cantidad de imágenes a color           ");
            System.out.println("  -->2. Top 5 de clientes con menor cantidad de imágenes en blanco y negro      ");
            System.out.println("  -->3. Información del cliente que más pasos estuvo en el sistema            ");
            System.out.println("  -->4. Datos de un cliente en específico              ");
            System.out.println("  -->0. Volver              ");

            switch (entrada.nextLine()) {
                case "1":
                    System.out.println("");
                    ATENDIDOS.ORDENAR_DES();
                    Nodo_Clientes aux = ATENDIDOS.inicio;
                    
                            System.out.println("     TOP 5 MAYOR IMG COLOR       ");
                    int cont = 0;
                    while (aux != null) {
                        cont++;
                        if (cont <6) {
                            System.out.println("NOMBRE: " + aux.getNombre());
                            System.out.println("IMG_COLOR: " + aux.getImg_color());
                            System.out.println("----------------------------------");
                        }

                        aux = aux.getSiguiente();
                    }
                    pressAnyKeyToContinue();
                    break;

                case "2":
                    //EJECUTANDO PASO
                    System.out.println("");
                    ATENDIDOS.ORDENAR_AS();
                    Nodo_Clientes aux2 = ATENDIDOS.inicio;
                    System.out.println("     TOP 5 MENOR IMG BW       ");
                    int cont2 = 0;
                    while (aux2 != null ) {
                        cont2++;
                        if (cont2 < 6) {
                            System.out.println("NOMBRE: " + aux2.getNombre());
                            System.out.println("IMG_BW: " + aux2.getImg_bw());
                            System.out.println("----------------------------------");
                        }
                        
                        aux2 = aux2.getSiguiente();
                    }
                    pressAnyKeyToContinue();
                    break;
                case "3":
                    System.out.println("");
                    ATENDIDOS.PASOS();
                    Nodo_Clientes pro=ATENDIDOS.inicio;
                    int tol=ATENDIDOS.getTamanio();
                    int cuento=0;
                    System.out.println(" __________ cliente que más pasos estuvo en el sistema  __________   ");
                    while (pro!=null) {                        
                        cuento++;
                        if(cuento==tol){
                            System.out.println("ID:"+pro.getId());
                            System.out.println("NOMBRE:"+pro.getNombre());
                            System.out.println("PASOS:"+pro.getPasos());
                            break;
                        }
                        pro=pro.getSiguiente();
                    }
                    break;
                case "4":
                    System.out.println("");
                    System.out.println("----- INGRESE EL ID CLIENTE A BUSCAR -----");
                    int numero = entrada2.nextInt();
                    
                    ATENDIDOS.BUSCAR(numero);
                    
                    break;
                case "0":
                    MENU();

                default:
                    System.out.println("$$$$---NO SELECCIONÓ UNA OPCIÓN VÁLIDA---$$$$");
            }
        }
    }

    static public void pressAnyKeyToContinue() {
        String seguir;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Press Enter key to continue...");
        try {
            seguir = teclado.nextLine();
        } catch (Exception e) {
        }
    }

}
