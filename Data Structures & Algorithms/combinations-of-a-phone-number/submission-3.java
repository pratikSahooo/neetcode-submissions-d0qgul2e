class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer,String> map = new HashMap<>();
        List<String> res = new ArrayList();
        if(digits.length()==0) return res;
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqr");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        combine(0,digits,map,res,new StringBuilder());
        return res ;
    }

    public void combine(int index,String digits,Map<Integer,String> map,List<String> res,StringBuilder curr){
        if(curr.length()==digits.length()){
            res.add(curr.toString());
            return ;
        }
        String combList = map.get(digits.charAt(index)- '0');
        for(int i = 0; i < combList.length();i++){
            curr.append(combList.charAt(i));
            combine(index+1,digits,map,res,curr);
            curr.deleteCharAt(curr.length()-1);
        }
    }

}
