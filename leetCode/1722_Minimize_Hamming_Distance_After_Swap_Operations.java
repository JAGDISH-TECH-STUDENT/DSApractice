import java.util.*;

class minimizeHammingDistance {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        UnionFind uf = new UnionFind(n);

        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        Map<Integer, List<Integer>> components = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            components.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        int hamming = 0;
        for (List<Integer> comp : components.values()) {
            Map<Integer, Integer> countSource = new HashMap<>();
            Map<Integer, Integer> countTarget = new HashMap<>();

            for (int idx : comp) {
                countSource.put(source[idx], countSource.getOrDefault(source[idx], 0) + 1);
                countTarget.put(target[idx], countTarget.getOrDefault(target[idx], 0) + 1);
            }

            for (int val : countSource.keySet()) {
                if (countTarget.containsKey(val)) {
                    int common = Math.min(countSource.get(val), countTarget.get(val));
                    countSource.put(val, countSource.get(val) - common);
                    countTarget.put(val, countTarget.get(val) - common);
                }
            }

            for (int leftover : countSource.values()) {
                hamming += leftover;
            }
        }

        return hamming;
    }

    static class UnionFind {
        int[] parent;
        UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }
        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }
        void union(int a, int b) {
            parent[find(a)] = find(b);
        }
    }
    public static void main(String[] args) {
        minimizeHammingDistance s = new minimizeHammingDistance();
        int[] source = {1, 2, 3, 4};
        int[] target = {2, 1, 4, 5};
        int[][] allowedSwaps = {{0, 1}, {2, 3}};
        int result = s.minimumHammingDistance(source, target, allowedSwaps);
        System.out.println("Minimum Hamming Distance: " + result); // Output: 1
    }
}
