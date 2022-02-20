package drawing_paper;

// NODO PARA IMPRESORA A BLANCO Y NEGRO
public class Nodo_PBw {

    private int id_cliente;
    Nodo_PBw next;

    public Nodo_PBw(int id_cliente) {
        this.id_cliente = id_cliente;
        this.next = null;
    }
    public Nodo_PBw() {
        this.id_cliente = 0;
        this.next = null;
    }

    //MÉTODOS GETTER
    public int getId_cliente() {
        return id_cliente;
    }

    public Nodo_PBw getNext() {
        return next;
    }

    //MÉTODOS SETTER
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setNext(Nodo_PBw next) {
        this.next = next;
    }
}
