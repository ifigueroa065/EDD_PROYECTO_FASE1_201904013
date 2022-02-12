
package drawing_paper;


public class NodoC {
    
  //Declaracion de atributos
 private int dato;
 private NodoC next;
 
 //Constructor
 public NodoC(int dato){
 this.dato=dato;
 }
 
 //Metodos getter and setters
 public int getDato() 
 {
 return dato;
 }
 public void setDato(int dato) 
 {
 this.dato = dato;
 }
 public NodoC getNext() 
 {
 return next;
 }
 public void setNext(NodoC next) 
 {
 this.next = next;
 }
 
 //Metodo toString
 public String toString()
 {
 String s=" "+dato+" ";
 return s;
 }  
    
}
