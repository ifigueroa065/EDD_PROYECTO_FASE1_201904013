
package drawing_paper;

public class ListaS {
 
    
    private NodoS inicio;
    private int tamanio;
    
    public void ListaS(){
        inicio = null;
        tamanio = 0;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    public void agregar(int id, String nombre_cliente,Pila_Img Imagenes, boolean status){
        // Define un nuevo nodo.
        NodoS nuevo = new NodoS(id, nombre_cliente, Imagenes, status);
        
        if (esVacia()) {
            
            inicio = nuevo;
        
        } else{
            
            NodoS aux = inicio;
            
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            
            aux.setSiguiente(nuevo);
        }
        
        tamanio++;
    }
     
    public void agregarAlInicio(int id, String nombre_cliente,Pila_Img Imagenes, boolean status){
        // Define un nuevo nodo.
        NodoS nuevo = new NodoS(id, nombre_cliente, Imagenes, status);
        
        if (esVacia()) {
            
            inicio = nuevo;
        
        } else{
            
            nuevo.setSiguiente(inicio);
            
            inicio = nuevo;
        }
       
        tamanio++;
    }
    
    //Metodo extraer dato
    public void recorrer() {
        int contador=0;
        NodoS aux = this.inicio;
        while (aux!=null) {        
            contador++;
            System.out.println("----------------------");
            System.out.println("VENTANILLA:"+contador);
            System.out.println("ID:"+ aux.getId());
            System.out.println("NOMBRE:"+ aux.getNombre_cliente());
            System.out.println("IMAGENES: "+ aux.getImagenes());
            
            
            
            aux=aux.getSiguiente();
            if(aux==this.inicio){
                break;
            }
        }
        
    }
    
    
    
    
    
    
    
    /**
     * Elimina la lista
     */
    public void eliminar(){
        // Elimina el valor y la referencia a los demas nodos.
        inicio = null;
        // Reinicia el contador de tamaño de la lista a 0.
        tamanio = 0;
    }
   
}
