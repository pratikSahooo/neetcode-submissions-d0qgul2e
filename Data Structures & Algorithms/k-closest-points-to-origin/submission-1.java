class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        for(int i = 0 ; i<2 ;i++){
                int first = points[i][0];
                int second = points[i][1];
                int origin = 0 ;
                int ele = (int) Math.sqrt(Math.pow(first-origin,2)+Math.pow(second-origin,2)); 
                heap.offer(new int[]{ele,first,second});
        }
        int [][] result = new int[k][1];
        for(int i = 0 ; i<k ; i++){
            int[]ele =heap.poll() ;
            result[i] = new int []{ele[1],ele[2]};
        }
        return result;
    }
}
