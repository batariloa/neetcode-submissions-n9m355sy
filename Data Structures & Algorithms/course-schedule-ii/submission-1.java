class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {


        HashMap<Integer, List<Integer>> mapDependants = new HashMap<>();

        int[] visited = new int[numCourses];


        for (int[] prerequisite : prerequisites) {
            int val = prerequisite[0];
            int pre = prerequisite[1];

            mapDependants.computeIfAbsent(pre, k -> new ArrayList<>())
                .add(val);
        }


        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, order, mapDependants, visited)) {
                    return new int[0]; // cycle detected
                }
            }
        }

        Collections.reverse(order);

        return order.stream().mapToInt(x -> x).toArray();
    }

    private boolean dfs(int index, List<Integer> order, Map<Integer, List<Integer>> mapDependants, int[] visited)
    {
        if (visited[index] == 1) {
            return false;
        }
        if (visited[index] == 2) {
            return true;
        }

        List<Integer> dependants = mapDependants.getOrDefault(index, new ArrayList<>());

        visited[index] = 1;

        for (int dependant : dependants) {
            boolean result = dfs(dependant, order, mapDependants, visited);
            if (!result) {
                return false;
            }
        }

        order.add(index);
        visited[index] = 2;

        return true;
    }
}
