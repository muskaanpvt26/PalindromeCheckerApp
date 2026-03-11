import java.util.*;

public class UseCase13PalindromePerformanceApp {

    // Iterative approach
    public static boolean iterativePalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    // Stack approach
    public static boolean stackPalindrome(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray())
            stack.push(c);

        for (char c : str.toCharArray())
            if (c != stack.pop())
                return false;

        return true;
    }

    // Recursive approach
    public static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end)
            return true;

        if (str.charAt(start) != str.charAt(end))
            return false;

        return recursivePalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Iterative timing
        long start1 = System.nanoTime();
        iterativePalindrome(input);
        long end1 = System.nanoTime();

        // Stack timing
        long start2 = System.nanoTime();
        stackPalindrome(input);
        long end2 = System.nanoTime();

        // Recursive timing
        long start3 = System.nanoTime();
        recursivePalindrome(input, 0, input.length() - 1);
        long end3 = System.nanoTime();

        System.out.println("\nExecution Time Comparison:");

        System.out.println("Iterative Method: " + (end1 - start1) + " ns");
        System.out.println("Stack Method: " + (end2 - start2) + " ns");
        System.out.println("Recursive Method: " + (end3 - start3) + " ns");

        sc.close();
    }
}