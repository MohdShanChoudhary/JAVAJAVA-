import java.util.ArrayList;
import java.util.Scanner;

public class PartA_SumUsingAutoboxing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter integers separated by space:");
        String input = sc.nextLine();
        String[] parts = input.split(" ");

        // String parsing and Autoboxing
        for (String part : parts) {
            Integer num = Integer.parseInt(part); // parsing string → Integer
            numbers.add(num); // autoboxing happens here
        }

        int sum = 0;
        // Unboxing inside loop
        for (Integer num : numbers) {
            sum += num; // unboxing from Integer → int
        }

        System.out.println("Sum of integers = " + sum);
        sc.close();
    }
}
