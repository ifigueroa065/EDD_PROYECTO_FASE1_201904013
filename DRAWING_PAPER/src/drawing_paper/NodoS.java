
package drawing_paper;

/**
 *
 * @author  ifigueroa065

 */

// CODIGO  UTILIZADO PARA GENERAR LAS VENTANILLAS

public class NodoS {
   
    private int valor;
    
    
    private NodoS siguiente;
    
    public  NodoS(int valor){
        this.valor = valor;
        
        this.siguiente = null;
    }
    
    // MÉTODOS GETTER

    public int getValor() {
        return valor;
    }

    
     public NodoS getSiguiente() {
        return siguiente;
    }

    
    //MÉTODOS SETTER

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    public void setSiguiente(NodoS siguiente) {
        this.siguiente = siguiente;
    }    
}
