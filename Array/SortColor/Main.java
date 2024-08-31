class Solution {
    public void sortColors(int[] arr) {
    //   Arrays.sort(nums);


    //Using the Brute Force or count number approach

//     int zeros = 0;
//     int ones = 0;
//     int twos = 0;

    

//     for(int num : nums){
//         if(num == 0) zeros++;
//         else if(num == 1) ones++;
//         else twos++;
//     }
//     int index =0;
        
//     while(zeros >0 ){
//   nums[index] =0;
//     index++;
//     zeros--;
//     }

//      while(ones >0) {
//     nums[index]= 1;
//     index++;
//     ones--;
//     }

    
//     while(twos >0 ){
//   nums[index] =2;
//     index++;
//     twos--;
    
//     }
  


//Using the Two Pointer Approach


//   int lo = 0;
//   int high = arr.length -1;
//   int i =0;

//   while(i <= high) {
//     if(arr[i] == 1) {
//         i++;
//     }else if( arr[i] == 0) {
//         int temp = arr[i];
//         arr[i] = arr[lo];
//         arr[lo] = temp;
//         lo++;
//         i++;
//     }else  {
//         int temp = arr[i];
//         arr[i] = arr[high];
//         arr[high] = temp;
//         high--;
//     }
//   }



    }
}


