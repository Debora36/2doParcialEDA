package pkg2doparcialeda;

public class Nuez {

    int num;
    String nuez;

    public Nuez() {
        this.num = -1;
        this.nuez = "";
    }

    public Nuez(int num, String nuez) {
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
