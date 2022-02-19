
package drawing_paper;


// CODIGO  UTILIZADO PARA GENERAR LAS VENTANILLAS

public class NodoS {
    
    ///agregando como atributo la pila
    private Pila_Img Imagenes=new Pila_Img();
    
    private int id;
    private String nombre_cliente;
    private boolean status;
    
    private NodoS siguiente;
    
    public  NodoS(int id, String nombre_cliente,Pila_Img Imagenes, boolean status){
        this.id = id;
        this.nombre_cliente=nombre_cliente;
        this.Imagenes=Imagenes;
        this.status=status;
        this.siguiente = null;
    }
    
    // MÉTODOS GETTER

    public int getId() {
        return id;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public boolean isStatus() {
        return status;
    }

    public Pila_Img getImagenes() {
        return Imagenes;
    }
        
    

    
     public NodoS getSiguiente() {
        return siguiente;
    }

    
    //MÉTODOS SETTER

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setImagenes(Pila_Img Imagenes) {
        this.Imagenes = Imagenes;
    }
    
    
    
    
    
    public void setSiguiente(NodoS siguiente) {
        this.siguiente = siguiente;
    }    
}
