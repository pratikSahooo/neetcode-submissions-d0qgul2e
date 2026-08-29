class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>() ;
        int i =0 ;
        for(int a : asteroids){
        boolean destroyed = false ; 
        while(!stack.isEmpty() && stack.peek()>0 && a<0){
            if(Math.abs(stack.peek())<Math.abs(a)){
                stack.pop();
                // stack.push(a);
            }
            else if(Math.abs(stack.peek()) == Math.abs(a)){
                stack.pop();
                destroyed = true;
                break;
            }
            else{
                destroyed = true ;
                break ;
            }
        }
        if(!destroyed){
            stack.push(a);
        }
        }
        int[]result = new int[stack.size()];
        for(i=0;i<stack.size();i++){
            result[i] = stack.get(i);
        }
         return result ;   
    }
}