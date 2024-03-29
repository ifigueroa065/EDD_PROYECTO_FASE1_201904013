
package ESTRUCTURAS.MATRIZ;

import ESTRUCTURAS.ArbolAVL;

/**
 *
 * @author ifigueroa065
 */
public class NodoMatriz {
     public String x;
    public String y;
    public String carpeta;
    public NodoMatriz siguiente;
    public NodoMatriz atras;
    public NodoMatriz arriba;
    public NodoMatriz abajo;
    public ArbolAVL arbol;
    

    public NodoMatriz(String x, String y) {
        this.x = x;
        this.y = y;
        this.abajo = null;
        this.arriba = null;
        this.siguiente = null;
        this.atras = null;
        this.arbol= new ArbolAVL();
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getCarpeta() {
        return carpeta;
    }

    public void setCarpeta(String carpeta) {
        this.carpeta = carpeta;
    }

    public NodoMatriz getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoMatriz siguiente) {
        this.siguiente = siguiente;
    }

    public NodoMatriz getAtras() {
        return atras;
    }

    public void setAtras(NodoMatriz atras) {
        this.atras = atras;
    }

    public NodoMatriz getArriba() {
        return arriba;
    }

    public void setArriba(NodoMatriz arriba) {
        this.arriba = arriba;
    }

    public NodoMatriz getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoMatriz abajo) {
        this.abajo = abajo;
    }
}
