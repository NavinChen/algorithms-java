package searches;

/**
 * @author: neo
 * @description: 二分查找 O(log n)
 */
public class BinarySearch {

    public static int search(int[] array, int element) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;
            int guess = array[middle];

            if (guess == element) {
                return middle;
            } else if (guess > element) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int index = BinarySearch.search(array, 3);
        System.out.println("index => " + index);
    }

}
