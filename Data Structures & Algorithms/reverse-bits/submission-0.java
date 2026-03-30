class Solution {
    public static int reverseBits(int n)
    {

        // n = 1101  1011
        // res = 0

        int result = 0;

        for (int i = 0; i<32; i++) {
            result = result << 1;
            result = result | (n & 1);
            n = n >> 1;
        }

        return result;
    }
}
