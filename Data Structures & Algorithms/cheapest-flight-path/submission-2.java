class Solution {
    class Edge {

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        int from;
        int to;
        int weight;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] cheapest = new int[n];
        Arrays.fill(cheapest, Integer.MAX_VALUE);

        Map<Integer, List<Edge>> edgeMap = new HashMap<>();



        for (int[] flight : flights) {
            edgeMap.putIfAbsent(flight[0], new ArrayList<>());
            edgeMap.get(flight[0]).add(new Edge(flight[0], flight[1], flight[2]));
        }

        cheapest[src] = 0;

        for (int i = 0; i <= k; i++) {

            int[] temp = Arrays.copyOf(cheapest, cheapest.length);

            for (int nodeNum = 0; nodeNum < n; nodeNum++) {

                if (cheapest[nodeNum] == Integer.MAX_VALUE) continue;

                List<Edge> edges = edgeMap.get(nodeNum);

                if(edges == null) continue;

                for (Edge edge : edges) {
                    if (cheapest[nodeNum] + edge.weight < temp[edge.to]) {
                        temp[edge.to] = cheapest[nodeNum] + edge.weight;
                    }
                }

            }

            cheapest = temp;
        }

        return cheapest[dst] == Integer.MAX_VALUE ? -1 : cheapest[dst];
    }
}
