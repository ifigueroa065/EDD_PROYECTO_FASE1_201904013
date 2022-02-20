package drawing_paper;

// NODO PARA IMPRESORA A COLOR
public class Nodo_PColor {

    private int id_cliente;
    Nodo_PColor next;

    public Nodo_PColor(int id_cliente) {
        this.id_cliente = id_cliente;
        this.next = null;
    }
    
    public Nodo_PColor() {
        this.id_cliente = 0;
        this.next = null;
    }

    //MÉTODOS GETTER
    public int getId_cliente() {
        return id_cliente;
    }

    public Nodo_PColor getNext() {
        return next;
    }

    //MÉTODOS SETTER
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNext(Nodo_PColor next) {
        this.next = next;
    }

}
