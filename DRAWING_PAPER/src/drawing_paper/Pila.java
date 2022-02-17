
package drawing_paper;

/**
 *
 * @author Usuario
 */
public class Pila {
    private NodoP top;
    
    public Pila(){
    	top = null;
    }
    
    public boolean vacia(){
    	return (top==null);
    }
 
    public void push (int img_color, int img_bw){
    	NodoP nuevoNodo;
    	if(vacia())
    		top = new NodoP(img_color, img_bw);
    	else{
    		nuevoNodo = new NodoP(img_color, img_bw);
    		nuevoNodo.setProx(top);
    		top = nuevoNodo;	
    	}
    }
    
    public void peek(){
    	NodoP temp = top;
    	if(temp!=null){
    		System.out.println("La pila es: ");
    		while(temp!=null){
    			System.out.println("COLOR: "+ temp.getImg_color() + "   BW:"+ temp.getImg_bw());
    			temp= temp.getProx();
    		}
    	}
    	else
    		System.out.println("PILA VACIA.");
    }
    
    public void cima(){
    	if(!vacia())
    		System.out.println("Cima: " + top.getImg_color());
    	else
    		System.out.println("La pila esta vacia");	
    }
    
    public void pop(){
    	if(!vacia()){
    		System.out.println("Dato extraido "+top.getImg_color());
    		top = top.getProx();
    	}
    	else
    		System.out.println("La pila esta vacia");
    }
    
    
}
