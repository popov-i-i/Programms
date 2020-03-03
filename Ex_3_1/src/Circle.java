public class Circle {
    private int radius;
    private int posx;
    private int posy;

    public Circle(int radius) {
        this.radius = radius;
        this.posx = 0;
        this.posy = 0;
    }

    public Circle() {
        this.radius = 1;
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

    public void getPosition(){
        int [] a = {posx,posy};
        System.out.print(posx);
        System.out.print(';');
        System.out.println(posy);
    }

    //радиус
    public void sizer(int radius){
        this.radius = radius;
    }

    public int getRadius(){
        return (radius);
    }
}
