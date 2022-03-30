package ESTRUCTURAS;

/**
 *
 * @author ifigueroa065
 */
public class ArbolBinarioBusqueda {

    private NodoBinario raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(Comparable val) {
        if (raiz == null) {
            raiz = new NodoBinario(val);
        } else {
            raiz.insertar(val);
        }
    }

    public void graficar(String path) {
        raiz.graficar(path);
    }

    public void inorden() {
        System.out.println("Recorrido inorden del árbol binario de búsqueda:");
        inorden(raiz);
        System.out.println();
    }

    private void inorden(NodoBinario a) {
        if (a == null) {
            return;
        }
        inorden(a.izquierdo);
        System.out.print(a.valor + ",");
        inorden(a.derecho);
    }
}
