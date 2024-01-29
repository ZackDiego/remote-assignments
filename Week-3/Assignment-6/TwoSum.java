import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // create hashmap to store value that already examine
        HashMap<Integer, Integer> prevMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            // if diff is inside hashmap, return that value's index and i
            if (prevMap.containsKey(diff)) {
                return new int[]{prevMap.get(diff), i};
            }
            // store value and index inside hashmap
            prevMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println(Arrays.toString(result));
    }
}
