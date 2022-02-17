package drawing_paper;

public class NodoC {

    //Declaracion de atributos
    private String Cliente;
    private int id_cliente;
    private String nombre_cliente;
    private int img_color;
    private int img_bw;

    private NodoC next;

    //Constructor
    public NodoC(String Cliente, int id_cliente, String nombre_cliente, int img_color, int img_bw) {
        this.Cliente = Cliente;
        this.id_cliente = id_cliente;
        this.nombre_cliente = nombre_cliente;
        this.img_color = img_color;
        this.img_bw = img_bw;
        this.next= null;
    }

    //MÉTODOS GETTER
    public String getCliente() {
        return Cliente;
    }

    public NodoC getNext() {
        return next;
    }

    public int getId_cliente() {
        return id_cliente;
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

    //MÉTODOS SETTER
    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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

    public void setNext(NodoC next) {
        this.next = next;
    }

    
}
