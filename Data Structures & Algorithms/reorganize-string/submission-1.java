class Solution {
    public String reorganizeString(String s) {

        Map<Character,Integer> map = new TreeMap<>();

        for(char index : s.toCharArray()){
            char ele = index;
            map.put(ele , map.getOrDefault(ele,0)+1);
        }

        PriorityQueue <Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->
            b.getValue() - a.getValue() 
        );

        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            pq.offer(entry);
        }

        int index = 0;
        StringBuilder ans = new StringBuilder();
        Map.Entry<Character, Integer> prev = null;
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> curr = pq.poll();

            if (prev != null && prev.getValue() > 0) {
            ans.append(curr.getKey());
               pq.offer(prev);
            }
            curr.setValue(curr.getValue() - 1);

            prev = curr;
        }
        if (ans.length() == s.length()) {
        return "";
        }
        return ans.toString();
    }
}