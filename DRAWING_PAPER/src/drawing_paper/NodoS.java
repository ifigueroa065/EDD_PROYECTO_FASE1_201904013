
package drawing_paper;

/**
 *
 * @author  ifigueroa065

 */
public class NodoS {
   // Variable en la cual se va a guardar el valor.
    private int valor;
    // Variable para enlazar los nodos.
    private NodoS siguiente;
    /**
     * Constructor que inicializamos el valor de las variables.
     */
    public void NodoS(){
        this.valor = 0;
        this.siguiente = null;
    }
    
    // Métodos get y set para los atributos.
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public NodoS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoS siguiente) {
        this.siguiente = siguiente;
    }    
}
