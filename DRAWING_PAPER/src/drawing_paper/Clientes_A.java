package drawing_paper;

//LISTA DE CLIENTES ATENDIDOS

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Clientes_A {

    Nodo_Clientes inicio;
    private int tamanio;

    public void Lista() {
        inicio = null;
        tamanio = 0;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void agregar(int id,String nombre, int ventanilla, int img_color, int img_bw, int pasos) {
        // Define un nuevo nodo.
        Nodo_Clientes nuevo = new Nodo_Clientes(id,nombre, ventanilla, img_color, img_bw, pasos);

        if (esVacia()) {

            inicio = nuevo;

        } else {

            Nodo_Clientes aux = inicio;

            while (aux.getSiguiente() != null) {
                aux = aux.getSiguiente();
            }

            aux.setSiguiente(nuevo);
        }

        tamanio++;
    }

    public void agregarAlInicio(int id,String nombre, int ventanilla, int img_color, int img_bw, int pasos) {
        // Define un nuevo nodo.
        Nodo_Clientes nuevo = new Nodo_Clientes(id,nombre, ventanilla, img_color, img_bw, pasos);

        if (esVacia()) {

            inicio = nuevo;

        } else {

            nuevo.setSiguiente(inicio);

            inicio = nuevo;
        }

        tamanio++;
    }

    //Metodo extraer dato
    public void recorrer() {
        int contador = 0;
        Nodo_Clientes aux = this.inicio;
        while (aux != null) {
            contador++;
            System.out.println("----------------------");
            System.out.println("NOMBRE:" + aux.getNombre());
            System.out.println("VENTANILLA: " + aux.getVentanilla());
            System.out.println("IMG_C: " + aux.getImg_color());
            System.out.println("IMG_Bw: " + aux.getImg_bw());
            System.out.println("CANTIDAD DE PASOS:" + aux.getPasos());

            aux = aux.getSiguiente();
            if (aux == this.inicio) {
                break;
            }
        }

    }

    public void ORDENAR() {
        //APLICANDO BUBBLE SORT
        Nodo_Clientes aux_i;
        Nodo_Clientes aux_j;
        Nodo_Clientes auxValor;
        Nodo_Clientes auxAnterior_i = null;
        Nodo_Clientes auxAnterior_j = null;

        aux_i = this.inicio;

        while (aux_i != null) {
            aux_j = aux_i.siguiente;
            while (aux_j != null) {
                if (aux_i.getImg_color() > aux_j.getImg_color()) {
                    //System.out.println("\tcambiar: " + aux_i.getImg_color()+ " y " + aux_j.getImg_color()+ "\n");

                    auxValor = aux_i.siguiente;

                    if (auxValor.hashCode() != aux_j.hashCode()) {

                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = auxValor;
                        auxAnterior_j.siguiente = aux_i;
                    } else {

                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = aux_i;

                    }
                    //intercambiar las posiciones de los nodos [i],[j]
                    auxValor = aux_i;
                    aux_i = aux_j;
                    aux_j = auxValor;

                    ///Al cambiar la posicion de un nodo el nodo anterior de [i] debe apuntar al nuevo [i]
                    if (auxAnterior_i != null) {
                        auxAnterior_i.siguiente = aux_i;
                    }

                    //si cambiamos la posicion del primer nodo de la lista, debemos cambiar el nodo inicial.
                    if (aux_j.hashCode() == inicio.hashCode()) {
                        inicio = aux_i;
                    }

                }

                auxAnterior_j = aux_j;
                aux_j = aux_j.siguiente;

            }
            auxAnterior_i = aux_i;
            aux_i = aux_i.siguiente;

        }
    }
    
    
    
    public void BUSCAR(int id) {
        int contador = 0;
        Nodo_Clientes aux = this.inicio;
        while (aux != null) {
            contador++;
            
            if (aux.getId()==id) {
                System.out.println("----------------------");
                
            System.out.println("ID:" + aux.getId());    
            System.out.println("NOMBRE:" + aux.getNombre());
            System.out.println("VENTANILLA: " + aux.getVentanilla());
            System.out.println("IMG_C: " + aux.getImg_color());
            System.out.println("IMG_Bw: " + aux.getImg_bw());
            System.out.println("CANTIDAD DE PASOS:" + aux.getPasos());
            break;
            }
            

            aux = aux.getSiguiente();
            if (aux == this.inicio) {
                break;
            }
        }

    }
    
    
    public void PASOS() {
        //APLICANDO BUBBLE SORT
        Nodo_Clientes aux_i;
        Nodo_Clientes aux_j;
        Nodo_Clientes auxValor;
        Nodo_Clientes auxAnterior_i = null;
        Nodo_Clientes auxAnterior_j = null;

        aux_i = this.inicio;

        while (aux_i != null) {
            aux_j = aux_i.siguiente;
            while (aux_j != null) {
                if (aux_i.getPasos()> aux_j.getPasos()) {
                    //System.out.println("\tcambiar: " + aux_i.getImg_color()+ " y " + aux_j.getImg_color()+ "\n");

                    auxValor = aux_i.siguiente;

                    if (auxValor.hashCode() != aux_j.hashCode()) {

                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = auxValor;
                        auxAnterior_j.siguiente = aux_i;
                    } else {

                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = aux_i;

                    }
                    //intercambiar las posiciones de los nodos [i],[j]
                    auxValor = aux_i;
                    aux_i = aux_j;
                    aux_j = auxValor;

                    ///Al cambiar la posicion de un nodo el nodo anterior de [i] debe apuntar al nuevo [i]
                    if (auxAnterior_i != null) {
                        auxAnterior_i.siguiente = aux_i;
                    }

                    //si cambiamos la posicion del primer nodo de la lista, debemos cambiar el nodo inicial.
                    if (aux_j.hashCode() == inicio.hashCode()) {
                        inicio = aux_i;
                    }

                }

                auxAnterior_j = aux_j;
                aux_j = aux_j.siguiente;

            }
            auxAnterior_i = aux_i;
            aux_i = aux_i.siguiente;

        }
    }
    
    public String GenerarDTO(String titulo) {
        String result = "digraph G {\n";
        
        result +="node[ style=filled ,color=\"#E1E1A8\", shape=box];";
        result += "label=\"" + titulo + "\";\n";
        String conexionesTXT = "";
        String nodosTXT = "";

        Nodo_Clientes actualAux = this.inicio;
        while (actualAux != null) {
            nodosTXT += "N" + actualAux.hashCode() + "[label=\"" +"ID: " + actualAux.getId()
                    +"\n N:" + actualAux.getNombre()
                    +"\n COLOR:" + actualAux.getImg_color()
                    +"\n BW:" + actualAux.getImg_bw()
                    +"\n PASOS:" + actualAux.getPasos()
                    + "\"];\n";

            if (actualAux.siguiente != null) {
                conexionesTXT += "N" + actualAux.hashCode() + "->" + "N" + actualAux.siguiente.hashCode() + ";\n";
            }
            actualAux = actualAux.siguiente;
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
    
    public void ORDENAR_DES() {
        //APLICANDO BUBBLE SORT
        Nodo_Clientes aux_i;
        Nodo_Clientes aux_j;
        Nodo_Clientes auxValor;
        Nodo_Clientes auxAnterior_i = null;
        Nodo_Clientes auxAnterior_j = null;

        aux_i = this.inicio;

        while (aux_i != null) {
            aux_j = aux_i.siguiente;
            while (aux_j != null) {
                if (aux_i.getImg_color() < aux_j.getImg_color()) {
                    //System.out.println("\tcambiar: " + aux_i.getImg_color()+ " y " + aux_j.getImg_color()+ "\n");

                    auxValor = aux_i.siguiente;

                    if (auxValor.hashCode() != aux_j.hashCode()) {

                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = auxValor;
                        auxAnterior_j.siguiente = aux_i;
                    } else {

                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = aux_i;

                    }
                    //intercambiar las posiciones de los nodos [i],[j]
                    auxValor = aux_i;
                    aux_i = aux_j;
                    aux_j = auxValor;

                    ///Al cambiar la posicion de un nodo el nodo anterior de [i] debe apuntar al nuevo [i]
                    if (auxAnterior_i != null) {
                        auxAnterior_i.siguiente = aux_i;
                    }

                    //si cambiamos la posicion del primer nodo de la lista, debemos cambiar el nodo inicial.
                    if (aux_j.hashCode() == inicio.hashCode()) {
                        inicio = aux_i;
                    }

                }

                auxAnterior_j = aux_j;
                aux_j = aux_j.siguiente;

            }
            auxAnterior_i = aux_i;
            aux_i = aux_i.siguiente;

        }
    }

    public void ORDENAR_AS() {
        //APLICANDO BUBBLE SORT
        Nodo_Clientes aux_i;
        Nodo_Clientes aux_j;
        Nodo_Clientes auxValor;
        Nodo_Clientes auxAnterior_i = null;
        Nodo_Clientes auxAnterior_j = null;

        aux_i = this.inicio;

        while (aux_i != null) {
            aux_j = aux_i.siguiente;
            while (aux_j != null) {
                if (aux_i.getImg_bw()> aux_j.getImg_bw()) {
                    //System.out.println("\tcambiar: " + aux_i.getImg_color()+ " y " + aux_j.getImg_color()+ "\n");

                    auxValor = aux_i.siguiente;

                    if (auxValor.hashCode() != aux_j.hashCode()) {

                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = auxValor;
                        auxAnterior_j.siguiente = aux_i;
                    } else {

                        aux_i.siguiente = aux_j.siguiente;
                        aux_j.siguiente = aux_i;

                    }
                    //intercambiar las posiciones de los nodos [i],[j]
                    auxValor = aux_i;
                    aux_i = aux_j;
                    aux_j = auxValor;

                    ///Al cambiar la posicion de un nodo el nodo anterior de [i] debe apuntar al nuevo [i]
                    if (auxAnterior_i != null) {
                        auxAnterior_i.siguiente = aux_i;
                    }

                    //si cambiamos la posicion del primer nodo de la lista, debemos cambiar el nodo inicial.
                    if (aux_j.hashCode() == inicio.hashCode()) {
                        inicio = aux_i;
                    }

                }

                auxAnterior_j = aux_j;
                aux_j = aux_j.siguiente;

            }
            auxAnterior_i = aux_i;
            aux_i = aux_i.siguiente;

        }
    }
    
    
    /**
     * Elimina la lista
     */
    public void eliminar() {
        // Elimina el valor y la referencia a los demas nodos.
        inicio = null;
        // Reinicia el contador de tamaño de la lista a 0.
        tamanio = 0;
    }
}
