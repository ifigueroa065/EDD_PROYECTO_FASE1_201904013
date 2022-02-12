/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 
    public void push (int valor){
    	NodoP nuevoNodo;
    	if(vacia())
    		top = new NodoP(valor);
    	else{
    		nuevoNodo = new NodoP(valor);
    		nuevoNodo.setProx(top);
    		top = nuevoNodo;	
    	}
    }
    
    public void peek(){
    	NodoP temp = top;
    	if(temp!=null){
    		System.out.println("La pila es: ");
    		while(temp!=null){
    			System.out.println(temp.getValor());
    			temp= temp.getProx();
    		}
    	}
    	else
    		System.out.println("PILA VACIA.");
    }
    
    public void cima(){
    	if(!vacia())
    		System.out.println("Cima: " + top.getValor());
    	else
    		System.out.println("La pila esta vacia");	
    }
    
    public void pop(){
    	if(!vacia()){
    		System.out.println("Dato extraido "+top.getValor());
    		top = top.getProx();
    	}
    	else
    		System.out.println("La pila esta vacia");
    }
    
    
}
