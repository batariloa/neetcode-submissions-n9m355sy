class Solution {

    Map<Integer, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        map = new HashMap();
        map.put(s.length(), true);

        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> dict, int index) {

        if(map.containsKey(index)){
            return map.get(index);
        }

        for(String word : dict){

            if(index  + word.length() <= s.length() 
            && s.substring(index, index + word.length()).equals(word)) {

                boolean canSplit = dfs(s, dict, index + word.length());

                if(canSplit) {
                    map.put(index, true);
                    return true;
                }
            }
        }

        map.put(index, false);
        return false;
    }
}
