package drawing_paper;

public class ListaE {

    NodoE inicio;
    private NodoE termino;

    //Constructor sin parametros
    public ListaE() {
        inicio = null;
        termino = null;
    }

    //Metodo insertar
    public void insertar(int id, String Nombre, int Ventanilla) {
        NodoE nuevoNodo = new NodoE();
        nuevoNodo.setNext(null);

        nuevoNodo.setId(id);
        nuevoNodo.setNombre_cliente(Nombre);
        nuevoNodo.setVentanilla(Ventanilla);

        if (inicio == null) {
            inicio = nuevoNodo;
            termino = nuevoNodo;
        } else {
            termino.setNext(nuevoNodo);

        }

        termino = nuevoNodo;
    }

    //Metodo extraer dato
    public void recorrer() {
        System.out.println("");
        NodoE aux = this.inicio;
        int contador = 0;
        while (aux != null) {
            contador++;
            System.out.println("---VENTANILLA" + contador);
            System.out.println("ID:" + aux.getId());
            System.out.println("NOMBRE: " + aux.getNombre_cliente());
            System.out.println("VENTANILLA:" + aux.getVentanilla());

            System.out.println("----------------------");
            aux = aux.getNext();
            if (aux == this.inicio) {
                break;
            }
        }

    }

    public void Eliminar(int identificador) {

        if (inicio.getId() == identificador) {
            inicio = inicio.getNext();

        } else {
            NodoE aux = inicio;
            while (aux.getNext().getId() != identificador) {
                aux = aux.getNext();
            }

            NodoE auxSig = aux.getNext().getNext();

            aux.setNext(auxSig);

        }
    }

}
