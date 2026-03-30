class Solution {
    int[] parents;
    int[] rank;

    public int[] findRedundantConnection(int[][] edges)
    {
        parents = new int[edges.length + 1];
        rank = new int[edges.length + 1];

        for (int i = 1; i < parents.length; i++) {
            parents[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if(!union(edge[0], edge[1])){
                return edge;
            }
        }
        
        return new int[]{};
    }

    private int find(int node)
    {
        if (parents[node] != node) {
            parents[node] = find(parents[node]);
        }

        return parents[node];
    }

    private boolean union(int a, int b)
    {

        int parentA = find(a);
        int parentB = find(b);

        if (parentA == parentB) {
            return false;
        }

        if (rank[parentA] > rank[parentB]) {
            parents[parentB] = parentA;
            rank[parentA] += rank[parentB];
        } else {
            parents[parentA] = parentB;
            rank[parentB] += rank[parentA];
        }

        return true;
    }
}
