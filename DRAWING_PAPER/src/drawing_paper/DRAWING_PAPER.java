package drawing_paper;

/**
 *
 * @author ifigueroa065
 */
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
    
    
    static Cola CLIENTE =new Cola();
    static ListTemp TEMPORAL =new ListTemp();
    
    
    
    static int id =0;
    static String  nombre_cliente="";
    static int img_color =0;
    static  int img_bw =0;
    static   String Cl="";
    
    
    public static void main(String[] args) throws Exception {
        //code application logic here
        
        
        
        
        
         MENU();
         
         /**
         Cola cliente = new Cola();
         cliente.insertar("Cliente1", 0, "ISAI", 2, 3);
         cliente.insertar("Cliente2", 1, "ISAI", 2, 3);
         cliente.insertar("Cliente3", 2, "ISAI", 2, 3);
         cliente.insertar("Cliente4", 3, "ISAI", 2, 3);
         cliente.recorrer();
         
         
          
         
          CARGAS();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        ListaS lista = new ListaS();
        int  a=4;
        
        for (int i = 0; i < a; i++) {
            Pila_Img Imagenes=new Pila_Img();
            lista.agregar(0,"",Imagenes,true);
        }
        
         lista.recorrer();
        System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
        ListaS lista = new ListaS();
        int  a=7;
        for (int i = 0; i < a; i++) {
            lista.agregar(i);
        }
        
         lista.recorrer();
         
         System.out.println("++++++++++++++++++++++++");
         Pila p = new Pila();
         p.push(1, 0);
         p.push(5, 3);
         p.push(4, 2);
         p.peek();
         
         
         System.out.println("====================");
         Clientes_A atendidos = new Clientes_A();
         atendidos.agregar("ISAI","VENTANILLA 1", 5, 48);
         atendidos.agregar("I","VENTANILLA 7", 5, 48);
         atendidos.agregar("SA","VENTANILLA 4", 5, 48);
         atendidos.agregar("I","VENTANILLA 6", 5, 48);
         atendidos.recorrer();**/
         
         
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
                            
                            Cl=(String) keyStr;
                        Object keyvalue2 = ((JSONObject) data.get(keyStr)).get(keyStr2);
                        
                        if(keyStr2.equals("id_cliente")){
                            id=Integer.parseInt((String) keyvalue2);
                        }else {
                            if (keyStr2.equals("nombre_cliente")) {
                                
                                nombre_cliente=(String) keyvalue2;
                            } else {
                                
                                if (keyStr2.equals("img_color")) {
                                    
                                    img_color=Integer.parseInt((String) keyvalue2);
                                } else {
                                    
                                    if (keyStr2.equals("img_bw")) {
                                        
                                        img_bw=Integer.parseInt((String) keyvalue2);
                                        
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
             CLIENTE.insertar_ORDEN(Cl, id, nombre_cliente, img_color, img_bw);
            });
               
        CLIENTE.recorrer();
        
        System.out.println("**************************************DESENCOLAR---");
        //CLIENTE.desencolar();
        //CLIENTE.desencolar();
        
            System.out.println("");
            System.out.println("");
        
        
        CLIENTE.recorrer();
         
            System.out.println("%%%%%%%%%%% SUCESSFULLY %%%%%%%%%%% ");
        
        CLIENTE.GenerarImagen("grafo1", CLIENTE.GenerarDTO("RECEPCION"));
        pressAnyKeyToContinue();
        
        
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ParseException e) {
        }

    }

    static void EJ_PASO() {
        
        System.out.println("-------------- ESTOY EJECUTANDO UN PASO --------------");
        CLIENTE.desencolar();
        pressAnyKeyToContinue();
    }

    static void MOSTRAR_ESTADOS() {
        System.out.println("-------------- ESTADOS DE ESTRUCTURAS --------------");
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
                    System.out.println("----INGRESE EL # DE VENTANILLAS A CREAR");
                    int numero = entrada2.nextInt();
                    
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    ListaS lista = new ListaS();
                    
                    for (int i = 0; i < numero; i++) {
                        Pila_Img Imagenes=new Pila_Img();
                        lista.agregar(0,"",Imagenes,true);
                    }

                     lista.recorrer();
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
                    CARGAS();
                    break;
                case "2":
                    //EJECUTANDO PASO
                    System.out.println("----INGRESE EL # DE VENTANILLAS A CREAR");
                    int numero = entrada2.nextInt();
                    
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    ListaS lista = new ListaS();
                    
                    for (int i = 0; i < numero; i++) {
                        Pila_Img Imagenes=new Pila_Img();
                        lista.agregar(0,"",Imagenes,true);
                    }

                     lista.recorrer();
                     pressAnyKeyToContinue();
                    break;
                case "3":
                    CARGAS();
                    break;
                case "4":
                    CARGAS();
                    break;
                case "0":
                    MENU();
                    

                default:
                    System.out.println("$$$$---NO SELECCIONÓ UNA OPCIÓN VÁLIDA---$$$$");
            }
        }
    }
    
    static public void pressAnyKeyToContinue()
{
    String seguir;
    Scanner teclado = new Scanner(System.in);
    System.out.println("Press Enter key to continue...");
    try
    {
        seguir = teclado.nextLine();
    }
    catch(Exception e)
    {}
}
    
    
}



