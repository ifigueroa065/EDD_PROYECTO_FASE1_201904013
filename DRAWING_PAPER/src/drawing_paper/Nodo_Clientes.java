
package drawing_paper;


public class Nodo_Clientes {
    
    private String nombre;
    private String ventanilla;
    private int n_img;
    private int pasos;
    
    private Nodo_Clientes siguiente;
    
    public  Nodo_Clientes(String nombre, String ventanilla,int n_img,int pasos){
        this.nombre=nombre;
        this.ventanilla=ventanilla;
        this.n_img=n_img;
        this.pasos=pasos;
        this.siguiente = null;
    }
    
    
    public String getNombre() {
        return nombre;
    }

    public String getVentanilla() {
        return ventanilla;
    }

    public int getN_img() {
        return n_img;
    }

    //MÉTODOS GETTER
    public int getPasos() {
        return pasos;
    }

    public Nodo_Clientes getSiguiente() {
        return siguiente;
    }
    
    //MÉTODOS SETTER

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVentanilla(String ventanilla) {
        this.ventanilla = ventanilla;
    }

    public void setN_img(int n_img) {
        this.n_img = n_img;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }
    
    
    
    public void setSiguiente(Nodo_Clientes siguiente) {
        this.siguiente = siguiente;
    }  
}
