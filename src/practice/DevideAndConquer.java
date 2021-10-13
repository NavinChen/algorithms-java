package practice;

/**
 * @author: neo
 * @description: D&C
 */
public class DevideAndConquer {

    public static int sum(int[] array) {
        // base line condition
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        // recursive condition
        return array[0] + sum(removeElement(array, 0));
    }

    public static int[] removeElement(int[] array, int index) {
        int[] result = new int[array.length - 1];

        System.arraycopy(array, 0, result, 0, index);
        System.arraycopy(array, index + 1, result, index, array.length - index - 1);
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(sum(array));
    }
    
}
