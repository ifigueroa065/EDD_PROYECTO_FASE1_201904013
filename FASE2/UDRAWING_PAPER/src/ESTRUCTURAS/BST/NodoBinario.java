package ESTRUCTURAS;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author ifigueroa065
 */
public class NodoBinario {

    final Comparable valor;

    NodoBinario izquierdo;
    NodoBinario derecho;

    private static int correlativo = 1;

    private final int id;

    public NodoBinario(Comparable valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.id = correlativo++;
    }

    void insertar(Comparable val) {

        if (val.compareTo(valor) < 0) {
            if (izquierdo == null) {
                izquierdo = new NodoBinario(val);
            } else {
                izquierdo.insertar(val);
            }
        } else if (val.compareTo(valor) > 0) {
            if (derecho == null) {
                derecho = new NodoBinario(val);
            } else {
                derecho.insertar(val);
            }
        } else {
            System.err.println("No se permiten los valores duplicados: \""
                    + String.valueOf(val) + "\".");
        }
    }

    public void graficar(String path) {
        FileWriter fichero = null;
        PrintWriter escritor;
        try {
            fichero = new FileWriter("aux_grafico.dot");
            escritor = new PrintWriter(fichero);
            escritor.print(getCodigoGraphviz());
        } catch (Exception e) {
            System.err.println("Error al escribir el archivo aux_grafico.dot");
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                System.err.println("Error al cerrar el archivo aux_grafico.dot");
            }
        }
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec("dot -Tjpg -o " + path + " aux_grafico.dot");
            //Esperamos medio segundo para dar tiempo a que la imagen se genere.
            //Para que no sucedan errores en caso de que se decidan graficar varios
            //árboles sucesivamente.
            Thread.sleep(500);
        } catch (Exception ex) {
            System.err.println("Error al generar la imagen para el archivo aux_grafico.dot");
        }
    }

    private String getCodigoGraphviz() {
        return "digraph grafica{\n"
                + "rankdir=TB;\n"
                + "node [shape = record, style=filled, fillcolor=seashell2];\n"
                + getCodigoInterno()
                + "}\n";
    }

    private String getCodigoInterno() {
        String etiqueta;
        if (izquierdo == null && derecho == null) {
            etiqueta = "nodo" + id + " [ label =\"" + valor + "\"];\n";
        } else {
            etiqueta = "nodo" + id + " [ label =\"<C0>|" + valor + "|<C1>\"];\n";
        }
        if (izquierdo != null) {
            etiqueta = etiqueta + izquierdo.getCodigoInterno()
                    + "nodo" + id + ":C0->nodo" + izquierdo.id + "\n";
        }
        if (derecho != null) {
            etiqueta = etiqueta + derecho.getCodigoInterno()
                    + "nodo" + id + ":C1->nodo" + derecho.id + "\n";
        }
        return etiqueta;
    }
}
