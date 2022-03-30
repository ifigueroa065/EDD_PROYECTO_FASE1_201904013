
package ESTRUCTURAS;

/**
 *
 * @author ifigueroa065
 */
public class NodoB {
    //Valores
     int id;
    //Apuntadores
    NodoB siguiente;
    NodoB anterior;
    RamaB derecha;
    RamaB izquierda;

    public NodoB(int id) {
        this.id = id;
        this.anterior = null;
        this.siguiente = null;
        this.derecha = null;
        this.izquierda = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NodoB getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoB siguiente) {
        this.siguiente = siguiente;
    }

    public NodoB getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoB anterior) {
        this.anterior = anterior;
    }

    public RamaB getDerecha() {
        return derecha;
    }

    public void setDerecha(RamaB derecha) {
        this.derecha = derecha;
    }

    public RamaB getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(RamaB izquierda) {
        this.izquierda = izquierda;
    }
    
    
    
}
