public class Square {
    private int length;
    private int posx;
    private int posy;

    public Square(int length) {
        this.length = length;
        this.posx = 0;
        this.posy = 0;
    }

    public Square() {
        this.length = 1;
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

    public void getPosition(){
        int [] a = {posx,posy};
        System.out.print(posx);
        System.out.print(';');
        System.out.println(posy);
    }

    //длина
    public void sizel(int length){
        this.length = length;
    }

    public int getLength(){
        return (length);
    }
}
