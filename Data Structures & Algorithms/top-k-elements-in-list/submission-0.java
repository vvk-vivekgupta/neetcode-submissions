class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashSet<Integer>[] rank = new HashSet[nums.length+1];
        rank[0] = new HashSet<>();

        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            int count = freq.get(n);

            if (rank[count] == null)
                rank[count] = new HashSet<>();

            rank[count].add(n);
            rank[count-1].remove(n);
        }

        int res[] = new int[k];
        int j = 0;
        for (int i = nums.length; i >= 0; i--) {
            if (rank[i] != null) {
                for (var n : rank[i]) {
                    res[j] = n;
                    j++;
                    if (j >= k)
                        return res;
                }
            }
        }

        return res;
    }
}
