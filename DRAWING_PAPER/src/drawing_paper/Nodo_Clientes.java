package drawing_paper;

public class Nodo_Clientes {

    private String nombre;
    private int ventanilla;
    private int img_color;
    private int img_bw;
    private int pasos;
    private int id;
    Nodo_Clientes siguiente;

    public Nodo_Clientes(int id,String nombre, int ventanilla, int img_color, int img_bw, int pasos) {
        this.id=id;
        this.nombre = nombre;
        this.ventanilla = ventanilla;
        this.img_color = img_color;
        this.img_bw = img_bw;
        this.pasos = pasos;
        this.siguiente = null;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVentanilla() {
        return ventanilla;
    }

    public int getImg_color() {
        return img_color;
    }

    public int getImg_bw() {
        return img_bw;
    }

    //MÉTODOS GETTER
    public int getPasos() {
        return pasos;
    }

    public int getId() {
        return id;
    }
    
    
    public Nodo_Clientes getSiguiente() {
        return siguiente;
    }

    //MÉTODOS SETTER
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVentanilla(int ventanilla) {
        this.ventanilla = ventanilla;
    }

    public void setImg_color(int img_color) {
        this.img_color = img_color;
    }

    public void setImg_bw(int img_bw) {
        this.img_bw = img_bw;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }

    public void setSiguiente(Nodo_Clientes siguiente) {
        this.siguiente = siguiente;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
