class Solution {
    public int firstUniqChar(String s) {
       HashMap<Character, Integer> charCount = new HashMap<>();
           for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0; i < s.length(); i++){
            if (charCount.get(s.charAt(i)) == 1) {
                return i; // Return the index of the first unique character
            }
}
        
        return -1;
        
    }
}