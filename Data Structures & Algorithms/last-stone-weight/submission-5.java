class Solution {
    public int lastStoneWeight(int[] stones) {
        // PriorityQueue <Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i =0 ; i<stones.length ; i++){
        //     heap.offer(stones[i]);
        // }
        //     while(heap.size()>1){
        //         int first = heap.poll();
        //         int second = heap.poll();
        //         heap.offer(first-second);
        //     }
        // return heap.peek();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int s : stones) {
            minHeap.offer(-s);
        }

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            if (second > first) {
                minHeap.offer(first - second);
            }
        }

        minHeap.offer(0);
        return Math.abs(minHeap.peek());

    }

}
