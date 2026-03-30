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
        minPath[0] = 0;

        Map<Integer, List<Node>> neighborMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            minPath[i] = Integer.MAX_VALUE;
            neighborMap.put(i, new ArrayList<>());
        }

        for (int[] edge : times) {
            int source = edge[0];
            int target = edge[1];
            int time = edge[2];

            neighborMap.get(source).add(new Node(target, time));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));
        minPath[k] = 0;

        queue.add(new Node(k, 0));

        while (!queue.isEmpty()) {

            Node currElement = queue.poll();

            if (currElement.time > minPath[currElement.target]) continue;

            for (Node neighbour : neighborMap.get(currElement.target)) {
                if (currElement.time + neighbour.time < minPath[neighbour.target]) {
                    minPath[neighbour.target] = neighbour.time + currElement.time;
                    queue.add(new Node(neighbour.target, minPath[neighbour.target]));
                }
            }
        }

        if (Arrays.stream(minPath).anyMatch(a -> a == Integer.MAX_VALUE)) {
            return -1;
        }

        return Arrays.stream(minPath).max().getAsInt();
    }
}
