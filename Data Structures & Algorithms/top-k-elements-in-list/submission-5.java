class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    int[] arr = new int[k];
    Map<Integer,Integer> map = new HashMap<>();
    
    for(int i = 0 ; i< nums.length ; i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
    }
    for(int i =0;i<k;i++){
        int maxkey = 0;
        int maxfreq = 0 ;
        for(Map.Entry<Integer,Integer> set : map.entrySet()){
            if(set.getValue()>maxfreq){
                maxfreq = set.getValue();
                maxkey = set.getKey();
            }
        }
        arr[i] = maxkey;
        map.remove(maxkey);
    }
    return arr ;
    }
}
