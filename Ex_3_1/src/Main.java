import java.sql.SQLClientInfoException;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        Rectangle rectangle = new Rectangle(12,2);
        Square square = new Square(6);

        System.out.println(circle.sq());
        circle.getPosition();

        System.out.println(rectangle.sq());
        rectangle.getPosition();

        System.out.println(square.sq());
        square.getPosition();
    }
}
