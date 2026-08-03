class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        subsetBuilder(nums,0,curr,res);
        return res;
    }
    public void subsetBuilder(int[] nums,int index,List<Integer> curr,List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[index]);
        subsetBuilder(nums,index+1,curr,res);
        curr.remove(curr.size()-1);
        while((index+1)<nums.length && nums[index] ==  nums[index+1]){
            index++;
        }
        subsetBuilder(nums,index+1,curr,res);
    }
}
