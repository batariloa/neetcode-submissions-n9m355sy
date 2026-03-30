class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites)
    {


        HashMap<Integer, List<Integer>> mapDepedants = new HashMap<>();
        int[] inDegree = new int[numCourses]; // number of prerequisites for each course


        for (int[] prerequisite : prerequisites) {

            int val = prerequisite[0];
            int pre = prerequisite[1];

            inDegree[val]++;

            mapDepedants.computeIfAbsent(pre, k -> new ArrayList<>())
                .add(val);
        }


        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) stack.push(i);
        }

        int[] order = new int[numCourses];
        int currIndex = 0;

        while (!stack.isEmpty()) {

            int val = stack.pop();

            order[currIndex] = val;
            currIndex++;


            for (int dependant : mapDepedants.getOrDefault(val, List.of())) {
                inDegree[dependant]--;
                if (inDegree[dependant] == 0) stack.push(dependant);
            }
        }

        return (currIndex == numCourses) ? order : new int[0];
    }
}
