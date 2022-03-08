package drawing_paper;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class ListaE {

    NodoE inicio;
    private NodoE termino;

    //Constructor sin parametros
    public ListaE() {
        inicio = null;
        termino = null;
    }

    //Metodo insertar
    public void insertar(int id, String Nombre, int Ventanilla, int img_color, int img_bw) {
        NodoE nuevoNodo = new NodoE();
        nuevoNodo.setNext(null);

        nuevoNodo.setId(id);
        nuevoNodo.setNombre_cliente(Nombre);
        nuevoNodo.setVentanilla(Ventanilla);
        nuevoNodo.setImg_color(img_color);
        nuevoNodo.setImg_bw(img_bw);

        if (inicio == null) {
            inicio = nuevoNodo;
            termino = nuevoNodo;
        } else {
            termino.setNext(nuevoNodo);

        }

        termino = nuevoNodo;
    }

    //Metodo extraer dato
    public void recorrer() {
        System.out.println("");
        NodoE aux = this.inicio;
        int contador = 0;
        while (aux != null) {
            contador++;
            System.out.println("---VENTANILLA" + contador);
            System.out.println("ID:" + aux.getId());
            System.out.println("NOMBRE: " + aux.getNombre_cliente());
            System.out.println("VENTANILLA:" + aux.getVentanilla());
            System.out.println("IMAGENES: " + aux.getFOTITAS());

            System.out.println("----------------------");
            aux = aux.getNext();
            if (aux == this.inicio) {
                break;
            }
        }

    }

    public void Eliminar(int identificador) {

        if (inicio.getId() == identificador) {
            inicio = inicio.getNext();

        } else {
            NodoE aux = inicio;
            while (aux.getNext().getId() != identificador) {
                aux = aux.getNext();
            }

            NodoE auxSig = aux.getNext().getNext();

            aux.setNext(auxSig);

        }
    }
    
    public String GenerarDTO(String titulo) {
        String result = "digraph G {\n";
        
        result +="node[ style=filled ,color=\"#E1E1A8\", shape=box];";
        result += "label=\"" + titulo + "\";\n";
        String conexionesTXT = "";
        String nodosTXT = "";

        NodoE actualAux = this.inicio;
        while (actualAux != null) {
            nodosTXT += "N" + actualAux.hashCode() + "[label=\"" +"ID:" + actualAux.getId()
                    +"\n N:" + actualAux.getNombre_cliente() 
                    +"\n COLOR:" + actualAux.getImg_color()
                    +"\n BW:" + actualAux.getImg_bw()
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
