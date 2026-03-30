class Solution {
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        dp = new Boolean[s.length() + 1];

        dp[s.length()] = true;

        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int index) {

        if(index > s.length()) {
            return false;
        }

        if(dp[index] != null) {
            return dp[index];
        }

        for(String word : wordDict) {
            
            if(index + word.length() <= s.length() && 
            word.equals(s.substring(index, index + word.length()))) {
                boolean canSplit = dfs(s, wordDict, index + word.length());

                if(canSplit) {
                    dp[index] = true;
                    return true;
                }
            }
        }

            dp[index] = false;
            return false;
    }
}
