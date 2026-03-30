class Solution {
    public int countSubstrings(String s) {

        boolean dp[][] = new boolean[s.length()][s.length()];

        int n = s.length();

        int result = 0;

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j<n; j++) {
                if(s.charAt(i) == s.charAt(j) && (j-i + 1 <=2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    result++;
                }
            }
        }

        return result;
    }
}
