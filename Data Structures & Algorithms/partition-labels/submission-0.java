class Solution {
    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int end = 0;
        int start = -1;

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            end = Math.max(map.get(s.charAt(i)), end);

            if (end == i) {
                result.add(end - start);
                start = end;
            }
        }
        
        return result;
    }
}
