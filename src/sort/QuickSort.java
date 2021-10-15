package sort;

import java.util.Arrays;

/**
 * @author: neo
 * @description: 快速排序
 */
public class QuickSort {

    public static void qsort(int[] array) {
        qsort(array, 0, array.length - 1);
    }

    public static void qsort(int[] array, int left, int right) {
        if (left < right) {
            printArray("qsor", array);
            int base = partition(array, left, right);
            qsort(array, left, base - 1);
            qsort(array, base + 1, right);
        }
    }
    
    public static int partition(int[] array, int left, int right) {
        int pivot = array[right];
        int cursor = left;

        for (int i = left; i < right; i++) {
            if (array[i] <= pivot) {
                swap(array, i, cursor);
                cursor ++;
            }
            
            printArray("swap", array);
        }

        // cursor与right替换后，cursor左小右大
        swap(array, cursor, right);
        printArray("part", array);
        return cursor;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void printArray(String prefix, int[] array) {
        System.out.println(prefix + " " + Arrays.toString(array));
    }
    
    public static void main(String[] args) {
        int[] array = {10, 5, 2, 3, 11, 9};
        printArray("sour", array);
        qsort(array);
        printArray("sort", array);
    }
    
}
