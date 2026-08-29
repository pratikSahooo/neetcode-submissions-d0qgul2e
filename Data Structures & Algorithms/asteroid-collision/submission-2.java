class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>() ;
        int i =0 ;
        for(int a : asteroids){
        boolean destroyed = false ;  
        // in question only we have been told that the smaller one will explode no action for the bigger one so it will remain as it is...
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