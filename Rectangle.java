public class Rectangle {
    private int length;
    private int width;
    private int posx;
    private int posy;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
        this.posx = 0;
        this.posy = 0;
    }

    //площадь
    public int sq(){
        int sq = length * width;
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

    //ширина
    public void sizew(int width){
        this.width = width;
    }


}
