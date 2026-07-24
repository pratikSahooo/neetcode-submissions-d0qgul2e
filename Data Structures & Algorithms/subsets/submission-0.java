class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> newList = new ArrayList<>();
        List<Integer>list = new ArrayList<>();
        makeSet(0,nums,list,newList);
        return newList;
    }

    public void makeSet(int index,int[]nums,List<Integer>list, List<List<Integer>>newList){
        if(index == nums.length){
            newList.add(new ArrayList(list));
            return ;
        }
        list.add(nums[index]);
        makeSet(index+1,nums,list,newList);

        list.remove(list.size()-1);
        makeSet(index+1,nums,list,newList);

    }
}
