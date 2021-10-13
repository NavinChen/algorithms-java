package practice;

/**
 * @author: neo
 * @description: D&C
 */
public class DevideAndConquer {

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
    
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        System.out.println(sum(array));
        System.out.println(size(array));
        System.out.println(max(array));
    }
    
}
