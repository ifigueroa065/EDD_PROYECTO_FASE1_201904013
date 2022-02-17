
package drawing_paper;

//LISTA DE CLIENTES ATENDIDOS

public class Clientes_A {
    private Nodo_Clientes inicio;
    private int tamanio;
    
    public void Lista(){
        inicio = null;
        tamanio = 0;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    public void agregar(String nombre, String ventanilla,int n_img,int pasos){
        // Define un nuevo nodo.
        Nodo_Clientes nuevo = new Nodo_Clientes(nombre, ventanilla, n_img, pasos);
        
        if (esVacia()) {
            
            inicio = nuevo;
        
        } else{
            
            Nodo_Clientes aux = inicio;
            
            while(aux.getSiguiente() != null){
                aux = aux.getSiguiente();
            }
            
            aux.setSiguiente(nuevo);
        }
        
        tamanio++;
    }
     
    public void agregarAlInicio(String nombre, String ventanilla,int n_img,int pasos){
        // Define un nuevo nodo.
        Nodo_Clientes nuevo = new Nodo_Clientes(nombre, ventanilla, n_img, pasos);
        
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
        Nodo_Clientes aux = this.inicio;
        while (aux!=null) {        
            contador++;
            System.out.println("----------------------");
            System.out.println("NOMBRE:" + aux.getNombre());
            System.out.println("VENTANILLA: " + aux.getVentanilla());
            System.out.println("CANTIDAD: " + aux.getN_img());
            System.out.println("CANTIDAD DE PASOS:" + aux.getPasos());
            
            
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
