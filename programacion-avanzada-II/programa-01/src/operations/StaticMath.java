package operations;

/**
 * @author: David Alejandro Lopez Torres. 17300155. 8D1
 * @version: 1.0
 */

public class StaticMath {
    
    /**
     * Check if a given number is prime by searching on 
     * its divisors (must be only 1 and itself)
     * @param number - int to check
     * @return boolean true if it's prime. Otherwise, false
     */
    public static boolean isPrime(int number) {
        if (number == 0 || number == 1) {
            return false;
        }

        for (int i = 2; i <= sqrt(number); i++) {
            if (number%i == 0) {
                return false;
            }
        }
        return true;
    } 

    /**
     * Check if a given number is perfect by adding its
     * divosors (except itself)
     * @param number - int to check
     * @return boolean true if it's perfect. Otherwise, false
     */
    public static boolean isPerfect(int number) {
        if (number == 0) {
            return false;
        }

        int count = 0;
        for (int i = 1; i < number; i++) {
            if (number%i == 0) {
                count += i;
            }
        }
        return count == number;
    }

    /**
     * Get the product of all the integers below a given number 
     * (inclusive)
     * @param number - int to get factorial
     * @return double with factorial of the number
     */
    public static double factorial(int number) {
        if (number == 0) {
            return 1;
        }

        return number*factorial(number-1);
    }

    /**
     * Get the integer part of the square root of a given number
     * @param number - double to get its square root
     * @return int part of the square root of number
     */
    public static int sqrt(double number) {
        int i = 0;
        while (number >= 0) {
            i++;
            number -= (2*i - 1);
        }
        return i-1;
    }
}
