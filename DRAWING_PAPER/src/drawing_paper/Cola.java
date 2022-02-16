package drawing_paper;

public class Cola {

    //Declaración de atributos
    private NodoC inicio;
    private NodoC termino;

    //Constructor sin parametros
    public Cola() {
        inicio = null;
        termino = null;
    }

    //Metodo insertar
    public void insertar(String Cliente, int id_cliente, String nombre_cliente, int img_color, int img_bw) {
        NodoC i = new NodoC(Cliente, id_cliente, nombre_cliente, img_color, img_bw);
        i.setNext(null);
        if (inicio == null & termino == null) {
            inicio = i;
            termino = i;
        }
        termino.setNext(i);
        termino = termino.getNext();
    }

    //Metodo extraer dato
    public void recorrer() {
        NodoC aux = this.inicio;
        while (aux!=null) {            
            System.out.println("----------------------");
            System.out.println("Cliente: " + aux.getCliente());
            System.out.println("ID: " + aux.getId_cliente());
            System.out.println("NOMBRE: " + aux.getNombre_cliente());
            System.out.println("COLOR: " + aux.getImg_color());
            System.out.println("BW: " + aux.getImg_bw());
            
            aux=aux.getNext();
            if(aux==this.inicio){
                break;
            }
        }
        
    }

    //Metodo para comprobar que la cola no esta vacia
    public boolean estaVacia() {
        boolean cola = false;
        if (inicio == null & termino == null) {
            cola = true;
            System.out.println("La cola esta vacia");
        } else {
            System.out.println("La cola no esta vacia");
            cola = false;
        }
        return cola;
    }

    //Metodo para contar los elementos de la cola
    public int contar() {
        int contador = 0;
        NodoC c = this.inicio;
        while (c != null) {
            contador++;
            c = c.getNext();
        }
        System.out.println("Numero de datos en la cola: " + contador);
        return contador;
    }

    
}
