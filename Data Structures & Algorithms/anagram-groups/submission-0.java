class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> str = new HashMap<>();
        for(String s : strs ){
            char[]word = s.toCharArray();
            Arrays.sort(word);
            String key = new String(word);
            str.putIfAbsent(key,new ArrayList<>());
            str.get(key).add(s);
        }
        return new ArrayList<>(str.values());
    }
}
