class Solution {


    public String longestPalindrome(String s) {

        int max = 0;
        int maxL = 0;
        int maxR = 0;

        for (int i = 0; i < s.length(); i++) {

            // asymetric
            int l = i;
            int r = i;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            l++;
            r--;

            if (r - l + 1 > max) {
                maxL = l;
                maxR = r;
                max = r - l + 1;
            }

            // symetric
            l = i;
            r = i + 1;

            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            l++;
            r--;

            if (r - l + 1 > max) {
                maxL = l;
                maxR = r;
                max = r - l + 1;
            }
        }

        return s.substring(maxL, maxR + 1);
    }
}
