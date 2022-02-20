
package drawing_paper;


public class NodoE {
    ///agregando como atributo la pila
    Pila_Img FOTITAS;
    
    
    private int id;
    private String nombre_cliente;
    private int ventanilla;
    
    NodoE next;
    
    public  NodoE(){
        this.id =0 ;
        this.nombre_cliente="";
        this.ventanilla=0;
        FOTITAS=new Pila_Img();
        
        this.next = null;
    }

    public int getId() {
        return id;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public int getVentanilla() {
        return ventanilla;
    }

    public NodoE getNext() {
        return next;
    }

    public Pila_Img getFOTITAS() {
        return FOTITAS;
    }
    
    

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setVentanilla(int ventanilla) {
        this.ventanilla = ventanilla;
    }

    public void setNext(NodoE next) {
        this.next = next;
    }

    public void setFOTITAS(Pila_Img FOTITAS) {
        this.FOTITAS = FOTITAS;
    }
    
    
    
    
    
    

}
