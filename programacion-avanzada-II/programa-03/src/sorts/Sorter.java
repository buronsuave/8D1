/**
 * @author: David Alejandro Lopez Torres. 17300155. 8D1
 * @version: 1.0
 */

package sorts;

public class Sorter {
    /**
     * Sorts an array and returns a new array with the sorted values. 
     * Uses radix sort: check digits and group by modulo 10
     * @param values - unsorted array
     * @return sorted array
     */
    public static int[] radixSort(int[] values) {

        int[][] digitModulus = new int[10][];
        initRows(digitModulus);
        overwriteRow(digitModulus, values, 0);

        int exp = 0;
        int max = getMaxPow(values);

        while (exp < max) {
            int[][] aux = new int[10][];
            initRows(aux);

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < digitModulus[i].length; j++) {
                    int index = (digitModulus[i][j] / pow(10, exp)) % 10;
                    pushValue(digitModulus[i][j], aux, index);
                }
            }

            digitModulus = aux;
            exp++;
        }

        return digitModulus[0];
    }

    /**
     * Push a new value into a row of a given array of arrays
     * @param value - int to push
     * @param destination - array of arrays to push the value
     * @param index - number of row of array of arrays to be pushed
     */
    private static void pushValue(int value, int[][] destination, int index) {
        int[] aux = new int[destination[index].length + 1];
        
        for (int i = 0; i < destination[index].length; i++) {
            aux[i] = destination[index][i];
        }
        aux[destination[index].length] = value;

        destination[index] = aux;
    }

    /**
     * Creates and instantiate a new matrix
     * @param matrix - matrix for initialization
     */
    private static void initRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[0];
        }
    }

    /**
     * Copy an array on a given row for a array of arrays
     * @param matrix - matrix with overwritten row
     * @param array - array to be copied
     * @param index - number of row of array of arrays to overwritten
     */
    private static void overwriteRow(int[][] matrix, int[] array, int index) {
        matrix[index] = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            matrix[index][i] = array[i];
        }
    }

    /**
     * Check if a given 10 power it's greater than all the values of the array
     * @param values - array to sort
     * @param exp - exponent to chech (10^exp)
     * @return boolean of the check
     */
    private static boolean checkPow(int[] values, int exp) {
        for (int i = 0; i < values.length; i++) {
            if ((values[i] / pow(10, exp)) > 0) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get the max power that divides all the numbers of the array
     * @param values - array to sort
     * @return int of the max value
     */
    private static int getMaxPow(int[] values) {
        int exp = 0;
        while (checkPow(values, exp)){
            exp ++;
        }

        return exp + 1;
    }

    /**
     * Get base ^ pow value (with ints)
     * @param base - base of the exponentiation
     * @param exp - exponent of the exponentiation
     * @return int of base^exponent value
     */
    private static int pow(int base, int exp) {
        if (exp == 0) {
            return 1;
        }

        return base * pow(base, exp - 1);
    }
}
