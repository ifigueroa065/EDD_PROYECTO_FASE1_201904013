
package drawing_paper;


// CODIGO  UTILIZADO PARA GENERAR LAS VENTANILLAS

public class NodoS {
    
    ///agregando como atributo la pila
    Pila_Img Imagenes;
    private int id;
    private String nombre_cliente;
    private int pasito;
    private boolean status;
    private int img_Color;
    private int img_Bw;
    private int Numero;
    
    NodoS next;
    
    public  NodoS(){
        this.id =0 ;
        this.nombre_cliente="";
        this.pasito=0;
        this.img_Color=0;
        this.img_Bw=0;
        this.Numero=0;
        Imagenes=new Pila_Img();
        this.status=true;
        this.next = null;
    }
    
    // MÉTODOS GETTER

    public int getId() {
        return id;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public boolean getStatus() {
        return status;
    }

    public Pila_Img getImagenes() {
        return Imagenes;
    }

    public int getPasito() {
        return pasito;
    }


    public int getImg_Color() {
        return img_Color;
    }

    public int getImg_Bw() {
        return img_Bw;
    }

    public int getNumero() {
        return Numero;
    }
        
    

    
     public NodoS getNext() {
        return next;
    }

    
    //MÉTODOS SETTER

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setImagenes(Pila_Img Imagenes) {
        this.Imagenes = Imagenes;
    }

    public void setPasito(int pasito) {
        this.pasito = pasito;
    }

    public void setImg_Color(int img_Color) {
        this.img_Color = img_Color;
    }

    public void setImg_Bw(int img_Bw) {
        this.img_Bw = img_Bw;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    

    
    public void setNext(NodoS siguiente) {
        this.next = siguiente;
    }   
    
    public void InitPila(){
        Imagenes=new Pila_Img();
    }
    
    
}
