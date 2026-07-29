import java.util.Scanner;

interface CalculatorInterface
{
    void add(int a, int b);
    void sub(int a, int b);
    void mul(int a, int b);
    void div(int a, int b);
}

class Arithmetic implements CalculatorInterface
{
    public void add(int a, int b)
    {
        System.out.println("--------------------------------");
        System.out.println("Operation : Addition");
        System.out.println("Expression: " + a + " + " + b);
        System.out.println("Result    : " + (a + b));
        System.out.println("--------------------------------");
    }

    public void sub(int a, int b)
    {
        System.out.println("--------------------------------");
        System.out.println("Operation : Subtraction");
        System.out.println("Expression: " + a + " - " + b);
        System.out.println("Result    : " + (a - b));
        System.out.println("--------------------------------");
    }

    public void mul(int a, int b)
    {
        System.out.println("--------------------------------");
        System.out.println("Operation : Multiplication");
        System.out.println("Expression: " + a + " * " + b);
        System.out.println("Result    : " + (a * b));
        System.out.println("--------------------------------");
    }

    public void div(int a, int b)
    {
        if(b == 0)
        {
            System.out.println("Cannot divide by zero");
        }
        else
        {
            System.out.println("--------------------------------");
            System.out.println("Operation : Division");
            System.out.println("Expression: " + a + " / " + b);
            System.out.println("Result    : " + (a / b));
            System.out.println("--------------------------------");
        }
    }
}

public class Calculator
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        Arithmetic obj = new Arithmetic();

        System.out.println("================================");
        System.out.println("          CALCULATOR");
        System.out.println("================================");

        System.out.println("\nChoose an Operation:");
        System.out.println("[1] Addition");
        System.out.println("[2] Subtraction");
        System.out.println("[3] Multiplication");
        System.out.println("[4] Division");

        System.out.print("\nEnter your choice: ");
        int choice = sc.nextInt();

        System.out.print("Enter first number  : ");
        int a = sc.nextInt();

        System.out.print("Enter second number : ");
        int b = sc.nextInt();

        System.out.println();

        switch(choice)
        {
            case 1:
                obj.add(a, b);
                break;

            case 2:
                obj.sub(a, b);
                break;

            case 3:
                obj.mul(a, b);
                break;

            case 4:
                obj.div(a, b);
                break;

            default:
                System.out.println("Invalid Choice");
        }

        System.out.println("\nThank you for using Calculator!");
        System.out.println("================================");

        sc.close();
    }
}