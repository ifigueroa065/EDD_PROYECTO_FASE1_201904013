
package drawing_paper;

public class ListaS {
 
    
    NodoS inicio;
    private NodoS termino;

    //Constructor sin parametros
    public ListaS() {
        inicio = null;
        termino = null;
    }
    
    //Metodo insertar
    public void insertar(int Numero) {
        
        NodoS nuevoNodo = new NodoS();
        nuevoNodo.setNumero(Numero);
        nuevoNodo.setNext(null);
        if (inicio == null ) {
            inicio = nuevoNodo;
            termino = nuevoNodo;
        }else{
            termino.setNext(nuevoNodo);
        }
        
        termino = nuevoNodo;
    }

    //Metodo extraer dato
    public void recorrer() {
        System.out.println("");
        NodoS aux = this.inicio;
        int contador=0;
        while (aux!=null) {            
            contador++;
            System.out.println("---VENTANILLA"+contador);
            System.out.println("ID:"+ aux.getId());
            System.out.println("NOMBRE: " + aux.getNombre_cliente());
            System.out.println("ESTADO:"+ aux.getStatus());
             System.out.println("IMG_Color:"+ aux.getImg_Color());
              System.out.println("IMG_Bw:"+ aux.getImg_Bw());
            System.out.println("----------------------");
            aux=aux.getNext();
            if(aux==this.inicio){
                break;
            }
        }
        
    }
    
    public boolean status() {
        boolean res=true;
        System.out.println("");
        NodoS aux = this.inicio;
        int contador=0;
        while (aux!=null) {            
            contador++;
            if (aux.getStatus()==true) {
                res=true;
                System.out.println("VENTANILLA DISPONIBLE");
            }else{
                res=false;
                System.out.println("VENTANILLA NO DISPONIBLE");
            }
            
            aux=aux.getNext();
            if(aux==this.inicio){
                break;
            }
        }
       return res;
    }
    
    public void desencolar(){
        if (this.inicio!=null) {
            NodoS eliminar=this.inicio;
            this.inicio=this.inicio.getNext();
            
            System.out.println("----Estoy eliminando a---");
            
            
            System.out.println("----INSERTANDO A LISTA TEMPORAL----");
           
            
            
            
            eliminar.next=null;
            if(this.inicio==null){
                this.termino=null;
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
    public int  tamanio() {
        int tam=0;
        NodoS aux = this.inicio;
        while (aux!=null) {            
            tam++;
            
            aux=aux.getNext();
            if(aux==this.inicio){
                break;
            }
        }
      return tam;
    }
    
    public void Atender(int id, String Nombre,int pasito){
        NodoS auxiliar =this.inicio;
        
        if (auxiliar!=inicio) {
            
            while(auxiliar.getStatus()){
            
            }
            auxiliar.setId(id);
            auxiliar.setNombre_cliente(Nombre);
            auxiliar.setPasito(pasito);
            auxiliar.setStatus(false);
            auxiliar.InitPila();
            
            auxiliar=auxiliar.getNext();
        }else{
            auxiliar.setId(id);
            auxiliar.setNombre_cliente(Nombre);
            auxiliar.setPasito(pasito);
            auxiliar.setStatus(false);
            auxiliar.InitPila();
            
            auxiliar=auxiliar.getNext();
        }
    
    }
   
}
