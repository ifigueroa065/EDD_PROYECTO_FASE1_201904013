
package drawing_paper;

//IMPLEMENTANDO IMPRESORA A BLANCO & NEGRO
public class PrintBw {
    //Declaración de atributos
    private Nodo_PBw inicio;
    private Nodo_PBw termino;

    //Constructor sin parametros
    public PrintBw() {
        inicio = null;
        termino = null;
    }

    //Metodo insertar
    public void insertar(int id_cliente) {
        Nodo_PBw i = new Nodo_PBw(id_cliente);
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
        Nodo_PBw aux = this.inicio;
        while (aux!=null) {            
            System.out.println("----------------------");
            System.out.println("ID: " + aux.getId_cliente());
            
            
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
        Nodo_PBw c = this.inicio;
        while (c != null) {
            contador++;
            c = c.getNext();
        }
        System.out.println("Numero de datos en la cola: " + contador);
        return contador;
    }
}
