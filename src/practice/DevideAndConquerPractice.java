package practice;

/**
 * @author: neo
 * @description: D&C
 */
public class DevideAndConquerPractice {

    /**
     * @author: neo
     * @description: 算法图解第4章 4.1 请编写前述sum函数的代码
     */
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

    /**
     * @author: neo
     * @description: 算法图解第4章 4.2 编写一个递归函数来计算列表包含的元素数
     */
    public static int size(int[] array) {
        // base line condition
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return 1;
        }

        // recursive condition
        return 1 + size(removeElement(array, 0 ));
    }

    /**
     * @author: neo
     * @description: 算法图解第4章 4.3 找出列表中最大的数字
     */
    public static int max(int[] array) {
        // base line condition
        if (array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        // recursive condition
        int max = array[0];
        int next = max(removeElement(array, 0));
        return max > next ? max : next;
    }

    /**
     * @author: neo
     * @description: 算法图解第4章 4.4 还记得第1章介绍的二分查找吗？它也是一种分而治之算法。你能找出二分查找算法的基线条件和递归条件吗？
     */
    public static int binarySearch(int[] array, int element, int low, int high) {
        int middle = (low + high) / 2;
        int guess = array[middle];

        // base line condition
        if (low > high) {
            return -1;
        }
        
        if (guess == element) {
            return middle;
        }

        // recursive condition
        if (guess > element) {
            high = middle - 1;
        } else {
            low = middle + 1;
        }

        return binarySearch(array, element, low, high);
    }
    
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15};
        System.out.println(sum(array));
        System.out.println(size(array));
        System.out.println(max(array));
        System.out.println(binarySearch(array, 11, 0, array.length - 1));
    }
    
}
