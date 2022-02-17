package drawing_paper;

public class NodoP {

    private int img_color;
    private int img_bw;
    private NodoP prox;

  

    public NodoP(int img_color, int img_bw) {
        this.img_color = img_color ;
        this.img_bw=img_bw;
        this.prox = null;
    }

   

    //MÉTODOS GETTER
    public int getImg_color() {
        return img_color;
    }

    public int getImg_bw() {
        return img_bw;
    }


    public NodoP getProx() {
        return prox;
    }
    
    //MÉTODOS SETTER

    public void setImg_color(int img_color) {
        this.img_color = img_color;
    }

    public void setImg_bw(int img_bw) {
        this.img_bw = img_bw;
    }
    
    
    
    public void setProx(NodoP p) {
        prox = p;
    }
}
