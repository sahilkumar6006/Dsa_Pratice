import java.util.HashMap;
import java.util.Map;

class HelloWorld {
    public static void main(String[] args) {
        String str = "a green apple";
        
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for (char ch : str.toCharArray()) {
            if (freqMap.containsKey(ch)) {
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                freqMap.put(ch, 1);
            }
        }
        
        for (char ch : str.toCharArray()) {
            if (freqMap.get(ch) == 1) {
                System.out.println(ch);
                break; 
            }
        }
    }
}
