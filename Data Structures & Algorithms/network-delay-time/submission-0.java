class Solution {
        class Node {

        public Node(int target, int time) {
            this.target = target;
            this.time = time;
        }

        int target;
        int time;
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] minPath = new int[n + 1];

        Map<Integer, List<Node>> neighborMap = new HashMap<>();

        for (int i = 0; i <= n; i++) {
            minPath[i] = Integer.MAX_VALUE;
            neighborMap.put(i, new ArrayList<>());
        }

        for (int[] edge : times) {
            int source = edge[0];
            int target = edge[1];
            int time = edge[2];

            neighborMap.get(source).add(new Node(target, time));
        }

        Set<Integer> visited = new HashSet<>();

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        visited.add(k);
        minPath[k] = 0;

        queue.add(new Node(k, 0));

        while (!queue.isEmpty() && visited.size() != n) {

            Node currElement = queue.poll();

            minPath[currElement.target] = Math.min(currElement.time, minPath[currElement.target]);
            visited.add(currElement.target);

            for (Node neighbour : neighborMap.get(currElement.target)) {
                if (currElement.time + neighbour.time < minPath[neighbour.target]) {
                    queue.add(new Node(neighbour.target, currElement.time + neighbour.time));
                }
            }
        }

        return visited.size() == n ? Arrays.stream(minPath).filter(a -> a!=Integer.MAX_VALUE).max().getAsInt() : -1;
    }
}
