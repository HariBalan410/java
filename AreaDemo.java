import java.util.Scanner;

abstract class Shape {
    abstract void printArea();
}

class Rectangle extends Shape {
    int length, breadth;

    Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

       void printArea() {
        System.out.println("\n==================================================");
        System.out.println("Area of Rectangle = " + (length * breadth) + " square units");
        System.out.println("==================================================");
    }
}

class Triangle extends Shape {
    int base, height;

    Triangle(int base, int height) {
        this.base = base;
        this.height = height;
    }

       void printArea() {
        System.out.println("\n==================================================");
        System.out.println("Area of Triangle = " + (0.5 * base * height) + " square units");
        System.out.println("==================================================");
    }
}

class Circle extends Shape {
    int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    
    void printArea() {
        System.out.println("\n==================================================");
        System.out.printf("Area of Circle = %.2f square units%n", Math.PI * radius * radius);
        System.out.println("==================================================");
    }
}

public class AreaDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("**************************************************");
        System.out.println("            SHAPE AREA CALCULATOR");
        System.out.println("**************************************************");

        System.out.println("\nAvailable Shapes");
        System.out.println("[1] Rectangle");
        System.out.println("[2] Triangle");
        System.out.println("[3] Circle");

        System.out.print("\nEnter Your Choice : ");
        int choice = sc.nextInt();

        Shape shape;

        switch (choice) {
            case 1:
                System.out.print("\nEnter Length  : ");
                int length = sc.nextInt();

                System.out.print("Enter Breadth : ");
                int breadth = sc.nextInt();

                shape = new Rectangle(length, breadth);
                shape.printArea();
                break;

            case 2:
                System.out.print("\nEnter Base    : ");
                int base = sc.nextInt();

                System.out.print("Enter Height  : ");
                int height = sc.nextInt();

                shape = new Triangle(base, height);
                shape.printArea();
                break;

            case 3:
                System.out.print("\nEnter Radius  : ");
                int radius = sc.nextInt();

                shape = new Circle(radius);
                shape.printArea();
                break;

            default:
                System.out.println("\nInvalid Choice! Please select 1, 2, or 3.");
        }

        System.out.println("\nProgram Executed Successfully...");
        sc.close();
    }
}