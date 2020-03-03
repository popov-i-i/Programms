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

    public Rectangle() {
        this.length = 2;
        this.width = 1;
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

    //ширина
    public void sizew(int width){
        this.width = width;
    }

    public int getWidth(){
        return (width);
    }

}
