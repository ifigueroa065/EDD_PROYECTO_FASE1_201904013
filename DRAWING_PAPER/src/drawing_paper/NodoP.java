package drawing_paper;

public class NodoP {

    private String img;
    private NodoP prox;

    public NodoP(String img) {
        this.img = img;

        this.prox = null;
    }

    //MÉTODOS GETTER
    public String getImg() {
        return img;
    }

    public NodoP getProx() {
        return prox;
    }

    //MÉTODOS SETTER
    public void setImg(String img) {
        this.img = img;
    }

    public void setProx(NodoP p) {
        prox = p;
    }
}
