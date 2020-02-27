public class Square {
    private int length;
    private int posx;
    private int posy;

    public Square(int length) {
        this.length = length;
        this.posx = 0;
        this.posy = 0;
    }

    //площадь
    public int sq(){
        int sq = length * length;
        return sq;
    }

    //перемещение
    public void pos(int x, int y){
        this.posx += x;
        this.posy += y;
    }

    //длина
    public void sizel(int length){
        this.length = length;
    }
}
