package multi.android.cafeorder;

public class CafeItem {

    int cafeimg;
    String name;

    public CafeItem(int cafeimg, String name) {
        this.cafeimg = cafeimg;
        this.name = name;
    }

    public int getcafeimg() {
        return cafeimg;
    }

    public String getName() {
        return name;
    }
}

