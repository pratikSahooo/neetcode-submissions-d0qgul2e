class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        start(nums,list,curr);
        return list;
    }

    public void start(int[]nums, List<List<Integer>> list,List<Integer> curr){
        if(curr.size() == nums.length){
            list.add(new ArrayList(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(curr.contains(nums[i])){
                continue;
            }
            curr.add(nums[i]);
            start(nums,list,curr);
            curr.remove(curr.size()-1);
        }
    }
}

