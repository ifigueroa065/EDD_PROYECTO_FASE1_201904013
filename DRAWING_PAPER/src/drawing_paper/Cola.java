package drawing_paper;

//IMPLEMENTANDO LA COLA DE RECEPCIÓN

import static drawing_paper.DRAWING_PAPER.TEMPORAL;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;



public class Cola {
    
    
    
    //Declaración de atributos
    private NodoC inicio;
    private NodoC termino;

    //Constructor sin parametros
    public Cola() {
        inicio = null;
        termino = null;
    }

    //Metodo insertar
    public void insertar(String Cliente, int id_cliente, String nombre_cliente, int img_color, int img_bw) {
        NodoC nuevoNodo = new NodoC(Cliente, id_cliente, nombre_cliente, img_color, img_bw);
        nuevoNodo.setNext(null);
        if (inicio == null ) {
            inicio = nuevoNodo;
            termino = nuevoNodo;
        }else{
            termino.setNext(nuevoNodo);
        }
        
        termino = nuevoNodo;
    }

    //Metodo extraer dato
    public void recorrer() {
        System.out.println("---COLA DE RECEPCIÓN");
        NodoC aux = this.inicio;
        while (aux!=null) {            
            
            System.out.println("Cliente: " + aux.getCliente());
            System.out.println("ID: " + aux.getId_cliente());
            System.out.println("NOMBRE: " + aux.getNombre_cliente());
            System.out.println("COLOR: " + aux.getImg_color());
            System.out.println("BW: " + aux.getImg_bw());
            System.out.println("----------------------");
            aux=aux.getNext();
            if(aux==this.inicio){
                break;
            }
        }
        
    }
    
    public void desencolar(){
        if (this.inicio!=null) {
            NodoC eliminar=this.inicio;
            this.inicio=this.inicio.getNext();
            
            System.out.println("----Estoy eliminando a---");
            System.out.println("Cliente: " + eliminar.getCliente());
            System.out.println("ID: " + eliminar.getId_cliente());
            System.out.println("NOMBRE: " + eliminar.getNombre_cliente());
            System.out.println("COLOR: " + eliminar.getImg_color());
            System.out.println("BW: " + eliminar.getImg_bw());
            
            System.out.println("----INSERTANDO A LISTA TEMPORAL----");
            TEMPORAL.agregar(eliminar.getId_cliente(), eliminar.getNombre_cliente(), eliminar.getImg_color(), eliminar.getImg_bw());
            TEMPORAL.recorrer();
            
            
            
            eliminar.next=null;
            if(this.inicio==null){
                this.termino=null;
            }
        }
    }

    //Metodo para comprobar que la cola no esta vacia
    public boolean estaVacia() {
        boolean cola = false;
        if (inicio == null & termino == null) {
            cola = true;
            System.out.println("La cola esta vacia");
        } else {
            System.out.println("La cola no esta vacia");
            cola = false;
        }
        return cola;
    }

    //Metodo para contar los elementos de la cola
    public int contar() {
        int contador = 0;
        NodoC c = this.inicio;
        while (c != null) {
            contador++;
            c = c.getNext();
        }
        System.out.println("Numero de datos en la cola: " + contador);
        return contador;
    }
    
    
    
    public void insertar_ORDEN(String Cliente, int id_cliente, String nombre_cliente, int img_color, int img_bw) {
        NodoC nuevoNodo = new NodoC(Cliente, id_cliente, nombre_cliente, img_color, img_bw);
        nuevoNodo.setNext(null);
        if (inicio == null ) {
            inicio = nuevoNodo;
            termino = nuevoNodo;
        }else{
            NodoC actualAux = this.inicio;
            NodoC siguienteAux;
            
             while (actualAux != null) {
                siguienteAux = actualAux.next;
                if (nuevoNodo.getId_cliente() < actualAux.getId_cliente()) {//insertar al inicio de la lista
                    nuevoNodo.next = actualAux;
                    inicio = nuevoNodo;
                    break;
                } else if (siguienteAux == null) {//insertar al final de la lista
                    actualAux.next = nuevoNodo;
                    break;
                } else if (nuevoNodo.getId_cliente() < siguienteAux.getId_cliente()) {//insertar en medio de la lista
                    actualAux.next = nuevoNodo;
                    nuevoNodo.next=siguienteAux;
                    break;
                }
                actualAux = actualAux.next;
            }
            
            
            
            
        

        }
        
        termino = nuevoNodo;
    }
    
    
    public void ORDENAR(){
        String auxCliente;
        int auxId;
        String auxnombre;
        int auxcolor;
        int auxbw;
    
        
        NodoC aux = this.inicio;
        NodoC auxsiguiente;
        
            System.out.println("---------------ESTOY ORDENANDO LA LISTA -------");
            
        while (aux!=null ) {            
            auxsiguiente=aux.next;
            
            int num1 = aux.getId_cliente();
            int num2 = aux.next.getId_cliente();
            
            if (num1 > num2 ) {
                        //OBTENIENDO VALORES Y GUARDANDOLOS
                        auxCliente = aux.getCliente();
                        auxId = aux.getId_cliente();
                        auxnombre=aux.getNombre_cliente();
                        auxcolor= aux.getImg_color();
                        auxbw= aux.getImg_bw();

                        //SETEANDO LA POSICION ACTUAL EL VALOR  DE LA POSICION SIGUIENTE
                        aux.setCliente(aux.next.getCliente());
                        aux.setId_cliente(aux.next.getId_cliente());
                        aux.setNombre_cliente(aux.next.getNombre_cliente());
                        aux.setImg_color(aux.next.getImg_color());
                        aux.setImg_bw(aux.next.getImg_bw());
                       

                        //SETEANDO LA POSICION SIGUIENTE CON LA POSICION ACTUAL
                        aux.next.setCliente(auxCliente);
                        aux.next.setId_cliente(auxId);
                        aux.next.setNombre_cliente(auxnombre);
                        aux.next.setImg_color(auxcolor);
                        aux.next.setImg_bw(auxbw);
                        
                       
                        

                    }
            
            aux=aux.getNext();
            
            
            if(aux==this.inicio){
                break;
            }
        }
        
        
    }
    
    
    public String GenerarDTO(String titulo) {
        String result = "digraph G {\n";
        result += "label=\"" + titulo + "\";\n";
        String conexionesTXT = "";
        String nodosTXT = "";

        NodoC actualAux = this.inicio;
        while (actualAux != null) {
            nodosTXT += "N" + actualAux.hashCode() + "[label=\"" + actualAux.getId_cliente()+ "\"];\n";

            if (actualAux.next != null) {
                conexionesTXT += "N" + actualAux.hashCode() + "->" + "N" + actualAux.next.hashCode() + ";\n";
            }
            actualAux = actualAux.next;
        }

        result += "//agregar nodos\n";
        result += nodosTXT;
        result += "//enlazar nodos\n";
        result += "{rank=same;\n";
        result += conexionesTXT;

        result += "}\n";

        result += "}\n";
        return result;
    }

    public void GenerarImagen(String nombre, String txtDTO) {
        try {
            //-----------Generar el txt
            String contenido = txtDTO;
            File file = new File(nombre + ".txt");

            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();

            //---------Compilar el dto
            String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
            String fileIn = file.getCanonicalPath();
            String fileOU = fileIn.replace(".txt", ".jpg");
            String tParam = "-Tjpg";
            String tOparam = "-o";

            String[] cmd = new String[5];
            cmd[0] = dotPath;
            cmd[1] = tParam;
            cmd[2] = fileIn;
            cmd[3] = tOparam;
            cmd[4] = fileOU;

            Runtime rt = Runtime.getRuntime();
            rt.exec(cmd);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
