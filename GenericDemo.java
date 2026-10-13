public class GenericDemo {

    public static <E extends Comparable<E>> E max(E[] list) {
        if (list == null || list.length == 0) {
            throw new IllegalArgumentException("The array must not be null or empty.");
        }
        
        E max = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] != null && (max == null || list[i].compareTo(max) > 0)) {
                max = list[i];
            }
        }
        return max;
    }

    public static <E extends Comparable<E>> E min(E[] list) {
        if (list == null || list.length == 0) {
            throw new IllegalArgumentException("The array must not be null or empty.");
        }
        
        E min = list[0];
        for (int i = 1; i < list.length; i++) {
            if (list[i] != null && (min == null || list[i].compareTo(min) < 0)) {
                min = list[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Integer a[] = {1, 5, 3, 15};
        Double b[] = {0.5, 67.8, 3.8, 0.01};

        System.out.println("Find the max number in Integer list is: " + max(a));
        System.out.println("Find the max number in Double list is: " + max(b));
        System.out.println("Find the min number in Integer list is: " + min(a));
        System.out.println("Find the min number in Double list is: " + min(b));
    }
}
