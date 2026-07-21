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
    Map<Character,Integer> map = new TreeMap<>();
    for(char task : tasks){
        map.put(task , map.getOrDefault(task,0)+1);
    }
    PriorityQueue<Task> pq = new PriorityQueue<>();
    for(Character mp: map.keySet() ){
        int freq = map.get(mp);
        pq.offer(new Task(freq,0));
    }

    Queue<Task> q = new LinkedList<>();
    int time = 0;
    while(!pq.isEmpty() || !q.isEmpty()){
        time++ ;
        if(!pq.isEmpty()){
            // execute task 
            Task execTask = pq.poll();
            execTask.freq--;
            if(execTask.freq !=0 ){
                execTask.execTime = time + n;
                // task should wait now for time + n time so that it can execute again 
                q.offer(execTask);
            }
        }
        if(!q.isEmpty()&& q.peek().execTime == time){
            // time compared to peek of queue sequence of task , if his time came then
            Task waiting  = q.poll();
            // load it back agian for execution 
            pq.offer(waiting);
        }
    }
    return time ;
    }
}
