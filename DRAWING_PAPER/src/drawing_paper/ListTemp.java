
package drawing_paper;

//IMPLEMENTANDO LISTA TEMPORAL PARA CLIENTES QUE LLEGUEN A VENTANILLA

public class ListTemp {
    
    NodoTemp inicio;
    private NodoTemp terminoT;
    
    public ListTemp(){
        inicio = null;
        terminoT = null;
    }
    
    public boolean esVacia(){
        return inicio == null;
    }
    
   
    
    public void agregar(int id, String nombre_cliente,int img_color, int img_bw){
        // Define un nuevo nodo.
        NodoTemp nuevoNodo = new NodoTemp(id, nombre_cliente, img_color, img_bw);
        
        if (inicio == null ) {
            inicio = nuevoNodo;
            terminoT = nuevoNodo;
        }else{
            terminoT.setSiguiente(nuevoNodo);
        }
        
        terminoT = nuevoNodo;
    }
     
    public void agregarAlInicio(int id, String nombre_cliente,int img_color, int img_bw){
        // Define un nuevo nodo.
        NodoTemp nuevo = new NodoTemp(id, nombre_cliente, img_color, img_bw);
        
        if (esVacia()) {
            
            inicio = nuevo;
        
        } else{
            
            nuevo.setSiguiente(inicio);
            
            inicio = nuevo;
        }
       
        
    }
    
    //Metodo extraer dato
    public void recorrer() {
        NodoTemp aux = this.inicio;
        while (aux!=null) {        
            System.out.println("---------LISTA TEMPORAL-------------");
            System.out.println("ID:"+aux.getId());
            System.out.println("NOMBRE:"+aux.getNombre_cliente());
            System.out.println("IMG_COLOR:"+aux.getImg_color());
            System.out.println("IMG_BW:"+aux.getImg_bw());
            
            
            aux=aux.getSiguiente();
            if(aux==this.inicio){
                break;
            }
        }
        
    }
    
    
    
    public void desencolar(){
        if (this.inicio!=null) {
            NodoTemp eliminar=this.inicio;
            this.inicio=this.inicio.getSiguiente();
            
            System.out.println("----Estoy eliminando a---");
            System.out.println("ID: " + eliminar.getId());
            System.out.println("NOMBRE: " + eliminar.getNombre_cliente());
            System.out.println("COLOR: " + eliminar.getImg_color());
            System.out.println("BW: " + eliminar.getImg_bw());
            
            System.out.println("----INSERTANDO A LISTA TEMPORAL----");
            
            
            
            
            eliminar.siguiente=null;
            if(this.inicio==null){
                this.terminoT=null;
            }
        }
    }
    
    public int  tamanio() {
        int tam=0;
        NodoTemp aux = this.inicio;
        while (aux!=null) {            
            tam++;
            
            aux=aux.getSiguiente();
            if(aux==this.inicio){
                break;
            }
        }
      return tam;
    }
    
    
    
    
}
