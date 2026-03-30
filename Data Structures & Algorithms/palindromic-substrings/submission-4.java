class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
   
        int result = 0;

        for(int i = 0; i<n; i++) {
            
            result += countSubstrings(s, i, i) +
            countSubstrings(s, i, i+1);
        }

        return result;
    }

    private int countSubstrings(String s, int left, int right) {
        
        if(right >= s.length()) {
            return 0;
        }

        if(s.charAt(left) != s.charAt(right)) {
            return 0;
        }

        int count = 0;

        while(left>= 0 && right <s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count++;
        }

     return count;
    }
}
