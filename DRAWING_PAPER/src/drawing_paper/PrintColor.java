
package drawing_paper;

//IMPLEMENTANDO COLA PARA IMPRESORA DE COLOR
public class PrintColor {
    
    
    //Declaración de atributos
    Nodo_PColor inicio;
    private Nodo_PColor termino;

    //Constructor sin parametros
    public PrintColor() {
        inicio = null;
        termino = null;
    }

    //Metodo insertar
    public void insertar(int id_cliente) {
        Nodo_PColor i = new Nodo_PColor(id_cliente);
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
        Nodo_PColor aux = this.inicio;
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
           
        } else {
            
            cola = false;
        }
        return cola;
    }

    //Metodo para contar los elementos de la cola
    public int contar() {
        int contador = 0;
        Nodo_PColor c = this.inicio;
        while (c != null) {
            contador++;
            c = c.getNext();
        }
        System.out.println("Numero de datos en la cola: " + contador);
        return contador;
    }
    
    public void desencolar(){
        if (this.inicio!=null) {
            Nodo_PColor eliminar=this.inicio;
            this.inicio=this.inicio.getNext();
            
            eliminar.next=null;
            if(this.inicio==null){
                this.termino=null;
            }
        }
    }
}
