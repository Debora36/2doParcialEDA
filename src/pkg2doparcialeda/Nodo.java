package pkg2doparcialeda;

public class Nodo {

    int num;
    String nuez;

    public Nodo() {
        this.num = -1;
        this.nuez = "";
    }

    public Nodo(int num, String nuez) {
        this.num = num;
        this.nuez = nuez;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNuez() {
        return nuez;
    }

    public void setNuez(String nuez) {
        this.nuez = nuez;
    }

    @Override
    public String toString() {
        return '[' + nuez + " " + num + ']';
    }

}
