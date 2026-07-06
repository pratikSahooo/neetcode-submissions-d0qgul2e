class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       int []arr = new int[k] ;
        Map<Integer,Integer> store = new HashMap<Integer,Integer>() ;
        for(int trav : nums){
            store.put(trav,store.getOrDefault(trav,0)+1);
        }

        for (int i=0;i<k;i++){
            int maxfreq = 0;
            int maxkey = 0 ;
            for(Map.Entry<Integer,Integer> itr : store.entrySet()){
                if (itr.getValue()>maxfreq){
                    maxfreq = itr.getValue();
                    maxkey =  itr.getKey() ;
                }
            }
            arr[i] = maxkey ;
            store.remove(maxkey) ;

        }
        return arr ;
    }
}
