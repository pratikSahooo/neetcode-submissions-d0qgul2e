class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            // If current number already exists
            // within the previous k elements
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);

            // Keep only k elements in the window
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}