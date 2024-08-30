public class Main {
    public static void main(String[] args) {

        int nums[ ] = {1,2,2,1,3};
      
                int ans = 0;
                for(int num: nums) {
                    ans = ans ^ num;
                }
                System.out.println(ans); 
        
    }
}
