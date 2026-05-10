class Solution {
    public List<List<String>> solveNQueens(int n) {

        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagPositive = new HashSet<>();
        Set<Integer> diagNegative = new HashSet<>();

        return nQueens(columns, diagPositive, diagNegative, 0, new ArrayList<>(), new ArrayList<>(), n);
    }

    private List<List<String>> nQueens(Set<Integer> columns, Set<Integer> diagPositive, Set<Integer> diagNegative, int row, List<List<String>> solutions, List<String> currentSolution, int n) {

        if (row == n) {
            solutions.add(new ArrayList<>(currentSolution));
            return solutions;
        }

        for (int i = 0; i < n; i++) {
            int diagNegValue = i - row;
            int diagPosValue = i + row;

            if (!columns.contains(i) && !diagPositive.contains(diagPosValue) && !diagNegative.contains(diagNegValue)) {
                Set<Integer> newColumns = new HashSet<>(columns);
                newColumns.add(i);

                Set<Integer> newDiagPositive = new HashSet<>(diagPositive);
                newDiagPositive.add(diagPosValue);

                Set<Integer> newDiagNegative = new HashSet<>(diagNegative);
                newDiagNegative.add(diagNegValue);

                currentSolution.add(generateSolutionStrings(i, n));

               nQueens(
                        newColumns,
                        newDiagPositive,
                        newDiagNegative,
                        row + 1,
                        solutions,
                        currentSolution,
                        n
                );
               
                currentSolution.remove(currentSolution.size() -1);
            }
        }

        return solutions;
    }

    private String generateSolutionStrings(int column, int n) {
        StringBuilder s = new StringBuilder();

        int before = column;

        s.append(".".repeat(Math.max(0, before)));
        s.append("Q");
        s.append(".".repeat(Math.max(0, n - (column + 1))));

        return s.toString();
    }
}