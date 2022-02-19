
package drawing_paper;

public class NodoTemp {
    private int id;
    private String nombre_cliente;
    private int img_color;
    private int img_bw;
    
    NodoTemp siguiente;
    
    public  NodoTemp(int id,String nombre_cliente,int img_color, int img_bw){
        this.id = id;
        this.nombre_cliente=nombre_cliente;
        this.img_color=img_color;
        this.img_bw=img_bw;
        this.siguiente = null;
    }
    
    // MÉTODOS GETTER

    public int getId() {
        return id;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public int getImg_color() {
        return img_color;
    }

    public int getImg_bw() {
        return img_bw;
    }

    

    
     public NodoTemp getSiguiente() {
        return siguiente;
    }

    
    //MÉTODOS SETTER

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setImg_color(int img_color) {
        this.img_color = img_color;
    }

    public void setImg_bw(int img_bw) {
        this.img_bw = img_bw;
    }

    
    
    
    public void setSiguiente(NodoTemp siguiente) {
        this.siguiente = siguiente;
    }    
}
