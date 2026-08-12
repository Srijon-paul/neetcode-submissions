class Solution {
    public class Pair{
        int first;
        int second;
        Pair(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // implementation needs to be look properly, here the implementation is based on min min heap on both integers;
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
                if(a.first != b.first){
                    return a.first - b.first;
                }
                return a.second - b.second;
            }
        );
        map.forEach((key, value) -> {
            pq.offer(new Pair(value, key));
            if(pq.size() > k){
                pq.poll();
            }
        });
        int[] res = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll().second;
            i++;
        }
        return res;
    }
}
