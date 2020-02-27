public class Circle {
    private int radius;
    private int posx;
    private int posy;

    public Circle(int radius) {
        this.radius = radius;
        this.posx = 0;
        this.posy = 0;
    }

    //площадь
    public double sq(){
        double pi = 3.14;
        double sq = radius * radius * pi;
        return sq;
    }

    //перемещение
    public void pos(int x, int y){
        this.posx += x;
        this.posy += y;
    }

    //радиус
    public void sizer(int radius){
        this.radius = radius;
    }
}
