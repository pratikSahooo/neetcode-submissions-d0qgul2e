class KthLargest {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int kthLargest = 0;

    public KthLargest(int k, int[] nums) {
        this.kthLargest = k ;
        int n =0 ;
        while( n <= nums.length){
            heap.offer(nums[n]);
            if(heap.size()>k){
                heap.poll();
            }
            n++;
        }
    }

    public int add(int val) {
        heap.offer(val);
        if(heap.size()>kthLargest){
            heap.poll();
        }
        return heap.peek();
    }
}
