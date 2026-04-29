class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        int i = 0;
        int si = -1;
        int ws = 0;
        int we = 0;
        int min =  Integer.MAX_VALUE ;
        while(i<t.length()){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
            i++;
        }
        int unique = map.size();
        while(we<s.length()){
            if(map.containsKey(s.charAt(we))){
                map.put(s.charAt(we),map.get(s.charAt(we))-1);
                if(map.get(s.charAt(we))==0) unique-- ;
            }
            while(unique==0){
                int len = we-ws+1 ;
                if(len<min){
                    min = len ;
                    si = ws;
                }
                if(map.containsKey(s.charAt(ws))){
                        map.put(s.charAt(ws),map.get(s.charAt(ws))+1);
                        if(map.get(s.charAt(ws))>0)unique++ ;
                }
                ws++;
                }
            we++;
        }
        return si == -1?"": s.substring(si,si+min);
    }
}
