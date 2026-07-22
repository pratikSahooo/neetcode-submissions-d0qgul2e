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
            // Get the character with the highest remaining frequency
            Map.Entry<Character, Integer> curr = pq.poll();

            // Add it to the answer
            ans.append(curr.getKey());
        
            // If the previous character still has occurrences left,
            // add it back to the heap.
            if (prev != null && prev.getValue() > 0) {
                pq.offer(prev);
            }
        
            // Decrease the frequency of the current character
            curr.setValue(curr.getValue() - 1);
        
            // Keep it aside so it isn't used immediately again
            prev = curr;
        }
        if (ans.length() != s.length()) {
        return "";
        }
        return ans.toString();
    }
}