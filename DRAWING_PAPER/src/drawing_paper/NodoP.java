
package drawing_paper;


public class NodoP {
   private int valor;
	private NodoP prox;
	
	public NodoP(){
		this.valor = 0;
		this.prox = null;
	}
	
	public NodoP(int v){
		this.valor = v;
		this.prox = null;
	}
	
	public void setValor(int v){
		valor = v;
	}
	
	public void setProx(NodoP p){
		prox = p;
	}
	
	public int getValor(){
		return valor;
	}
	
	public NodoP getProx(){
		return prox;
	} 
}
