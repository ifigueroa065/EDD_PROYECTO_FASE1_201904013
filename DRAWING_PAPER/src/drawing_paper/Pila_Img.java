
package drawing_paper;

/**
 *
 * @author Usuario
 */
public class Pila_Img {
    private NodoP top;
    
    public Pila_Img(){
    	top = null;
    }
    
    public boolean vacia(){
    	return (top==null);
    }
 
    public void push (String img){
    	NodoP nuevoNodo;
    	if(vacia())
    		top = new NodoP(img);
    	else{
    		nuevoNodo = new NodoP(img);
    		nuevoNodo.setProx(top);
    		top = nuevoNodo;	
    	}
    }
    
    public void peek(){
    	NodoP temp = top;
    	if(temp!=null){
    		System.out.println("La pila es: ");
    		while(temp!=null){
    			System.out.println("TIPO: "+ temp.getImg());
    			temp= temp.getProx();
    		}
    	}
    	else
    		System.out.println("PILA VACIA.");
    }
    
    public void cima(){
    	if(!vacia())
    		System.out.println("Cima: " + top.getImg());
    	else
    		System.out.println("La pila esta vacia");	
    }
    
    public void pop(){
    	if(!vacia()){
    		System.out.println("Dato extraido "+top.getImg());
    		top = top.getProx();
    	}
    	else
    		System.out.println("La pila esta vacia");
    }
    
    public NodoP CIMITA() {
    
        return top;
    }
    
    
    public void CONTAR_COLOR(){
    	NodoP temp = top;
        int contador=0;
    	if(temp!=null){
    		System.out.println("La pila es: ");
    		while(temp!=null){
                    if (temp.getImg()== "Color") {
                        contador++;
                    }
                    
    			temp= temp.getProx();
    		}
    	}
    	else
    		System.out.println("PILA VACIA.");
    }
    
    public int CONTAR_BW(){
    	NodoP temp = top;
        int contador=0;
    	if(temp!=null){
    		System.out.println("La pila es: ");
    		while(temp!=null){
                    if (temp.getImg()== "Color") {
                        contador++;
                    }
                    
    			temp= temp.getProx();
    		}
    	}
    	else
    		System.out.println("PILA VACIA.");
        return contador;
    }
    
}
