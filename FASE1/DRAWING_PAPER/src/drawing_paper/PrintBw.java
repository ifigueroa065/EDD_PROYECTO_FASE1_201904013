package drawing_paper;

//IMPLEMENTANDO IMPRESORA A BLANCO & NEGRO

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class PrintBw {

    //Declaración de atributos
    Nodo_PBw inicio;
    private Nodo_PBw termino;

    //Constructor sin parametros
    public PrintBw() {
        inicio = null;
        termino = null;
    }

    //Metodo insertar
    public void insertar(int id_cliente) {
        Nodo_PBw i = new Nodo_PBw(id_cliente);
        i.setNext(null);
        if (inicio == null & termino == null) {
            inicio = i;
            termino = i;
        }
        termino.setNext(i);
        termino = termino.getNext();
    }

    //Metodo extraer dato
    public void recorrer() {
        Nodo_PBw aux = this.inicio;
        while (aux != null) {
            System.out.println("----------------------");
            System.out.println("ID: " + aux.getId_cliente());

            aux = aux.getNext();
            if (aux == this.inicio) {
                break;
            }
        }

    }

    //Metodo para comprobar que la cola no esta vacia
    public boolean estaVacia() {
        boolean cola = false;
        if (inicio == null & termino == null) {
            cola = true;

        } else {

            cola = false;
        }
        return cola;
    }

    //Metodo para contar los elementos de la cola
    public int contar() {
        int contador = 0;
        Nodo_PBw c = this.inicio;
        while (c != null) {
            contador++;
            c = c.getNext();
        }
        System.out.println("Numero de datos en la cola: " + contador);
        return contador;
    }

    public void desencolar() {
        if (this.inicio != null) {
            Nodo_PBw eliminar = this.inicio;
            this.inicio = this.inicio.getNext();

            eliminar.next = null;
            if (this.inicio == null) {
                this.termino = null;
            }
        }
    }
    
    public String GenerarDTO(String titulo) {
        String result = "digraph G {\n";
        
        result +="node[ style=filled ,color=\"#E1E1A8\", shape=box];";
        result += "label=\"" + titulo + "\";\n";
        String conexionesTXT = "";
        String nodosTXT = "";

        Nodo_PBw actualAux = this.inicio;
        while (actualAux != null) {
            nodosTXT += "N" + actualAux.hashCode() + "[label=\"" +"ID:" + actualAux.getId_cliente()
                    +"\n BW"
                    + "\"];\n";

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
