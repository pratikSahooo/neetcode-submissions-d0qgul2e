class Task implements Comparable<Task>{
    int freq;
    int execTime;

    public Task(int fr, int et){
        this.freq= fr ;
        this.execTime = et ;
    }

    public int compareTo(Task that){
        return that.freq - this.freq;
    }
    
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
    Map<Character,Integer> map = new HashMap<>();
        for(int i =0 ; i<tasks.length ; i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        PriorityQueue<Task> heap = new PriorityQueue<>();
        for(Character ch : map.keySet()){
            int mapFreqValue = map.get(ch);
            heap.offer(new Task(mapFreqValue,0));
        }
        Queue <Task> q = new LinkedList<>();
        int time = 0;
        while(!heap.isEmpty() || !q.isEmpty()){
            time++;
            if(!heap.isEmpty()){
                Task selectTask = heap.poll();
                selectTask.freq--;
                if(selectTask.freq != 0){
                    selectTask.execTime = time + n;
                    q.offer(selectTask);
                }
            }
            if(!q.isEmpty() && q.peek().execTime == time){
                Task waiting = q.poll();
                heap.offer(waiting);
            }
        }
        return time ;
    }
}
