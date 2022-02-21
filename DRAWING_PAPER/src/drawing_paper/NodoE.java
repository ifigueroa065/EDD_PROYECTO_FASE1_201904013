package drawing_paper;

public class NodoE {

    ///agregando como atributo la pila
    Pila_Img FOTITAS;

    private int id;
    private String nombre_cliente;
    private int ventanilla;
    private int img_color;
    private int img_bw;

    NodoE next;

    public NodoE() {
        this.id = 0;
        this.nombre_cliente = "";
        this.ventanilla = 0;
        this.img_bw = 0;
        this.img_color = 0;
        FOTITAS = new Pila_Img();

        this.next = null;
    }

    public int getId() {
        return id;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public int getVentanilla() {
        return ventanilla;
    }

    public NodoE getNext() {
        return next;
    }

    public int getImg_color() {
        return img_color;
    }

    public int getImg_bw() {
        return img_bw;
    }

    public Pila_Img getFOTITAS() {
        return FOTITAS;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setVentanilla(int ventanilla) {
        this.ventanilla = ventanilla;
    }

    public void setNext(NodoE next) {
        this.next = next;
    }

    public void setImg_color(int img_color) {
        this.img_color = img_color;
    }

    public void setImg_bw(int img_bw) {
        this.img_bw = img_bw;
    }

    public void setFOTITAS(Pila_Img FOTITAS) {
        this.FOTITAS = FOTITAS;
    }

}
