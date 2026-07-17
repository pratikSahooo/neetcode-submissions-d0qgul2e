
class Solution {
    public int[] getOrder(int[][] tasks) {
        
        int n = tasks.length;

        for(int i =0 ;i<tasks.length;i++){
            int enqT = tasks[i][0];
            int procT = tasks[i][1]; 
            tasks[i] = new int[] {enqT, procT, i};
        }
        Arrays.sort(tasks,Comparator.comparing(e->e[0]));

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] == b[0] ? 
        Integer.compare(a[1],b[1]) : Integer.compare(a[0],b[0])
        );

        int[] res = new int[n];
        int i = 0;
        int resInd =0;
        int time = tasks[0][0];

        while(!heap.isEmpty() || i<n){
            while(i>n && tasks[i][0]<=time){
                heap.offer(new int[]{tasks[i][1],tasks[i][2]});
                i++;
            }
            if(heap.isEmpty()){
               time = tasks[i][0];
            }
            else{
                int [] task = heap.poll();
                time += task[0];
                res[resInd++] = task[1];
            }
        }
        return res;
    }
}