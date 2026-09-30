import java.util.Scanner;
import java.util.Random;

public class MultiThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1());
        t1.start();
    }
}

class Thread1 implements Runnable {
    Scanner obj = new Scanner(System.in);
    Random r = new Random();

    public void run() {
        try {
            System.out.println("random num");
            int n = obj.nextInt();
            for (int i = 1; i <= n; i++) {
                int no = r.nextInt(100);
                if (no % 2 == 0) {
                    Thread2 t2 = new Thread2(no);
                    t2.start();
                } else {
                    Thread3 t3 = new Thread3(no);
                    t3.start();
                }
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Thread2 extends Thread {
    int n1;

    Thread2(int n) {
        n1 = n;
    }

    public void run() {
        System.out.println("Print the Square of number is:" + Math.pow(n1, 2));
    }
}

class Thread3 extends Thread {
    int n1;

    Thread3(int n) {
        n1 = n;
    }

    public void run() {
        System.out.println("Print the Cube of number is:" + Math.pow(n1, 3));
    }
}
