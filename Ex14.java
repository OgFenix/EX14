
/**
 * This is maman 14 
 *
 * @author itay lior
 * @version (27/05/2022)
 */
public class Ex14
{
    // 1,3,5
    /**
     * The answers to the first question 1, first section are 3,5,6
     * 
     */
    /**
     * This is the answer for question 1, section b, part 1
     * @param int [][] m - array 
     * @param int val - the value you search
     * @return true if the value is in the array with o(n) efficiency 
     */
    public static boolean findValWhat(int[][]m,int val){
        int n = m.length;
        int minVal = m[0][0],maxVal= m[0][0],minPlace =0,maxPlace=n-1;
        for(int i = 0; i<n; i++){
            if(m[0][i]< minVal){
                minVal = m[0][i];
                minPlace = i;
            }
            if(m[0][i]> maxVal){
                maxVal = m[0][i];
                maxPlace = i;
            }
            if(m[0][i]== val){
                return true;
            }
        }
        for(;minPlace<=maxPlace;minPlace++){
            for(int i = 0; i<n; i++){
                if(m[minPlace][i] == val)
                    return true;
            }
        }
        return false;
    }

    /**
     * This is the answer for question 1, section b, part 2
     * @param int [][] m - array 
     * @param int val - the value you search
     * @return true if the value is in the array with o(n) efficiency 
     */
    public static boolean findValTest (int [][] m, int val){
        int n = m.length;
        int minVal = m[0][0],maxVal= m[0][0],minPlace =0,maxPlace=n-1;
        for(int i = 0; i<n; i++){
            if(m[0][i]< minVal){
                minVal = m[0][i];
                minPlace = i;
            }
            if(m[0][i]== val){
                return true;
            }
        }
        for(;minPlace<=maxPlace;minPlace++){
            for(int i = 0; i<n; i++){
                if(m[minPlace][i] == val)
                    return true;
            }
        }
        return false;
    }

    /**
     * This is the answer for question 2
     * @param int[]a - array 
     * efficiency is (o(n))
     * because when we use the length of a subarray we can run threw the array with and effienciy of o(n)
     * we count the length of the subarray and then we update the count depending how many characters are in the subarray
     * because in a subbaray of 1,2,4 there are 2 sub arrays (1,2) and (1,2,4)
     * so ((3-1)*2) / 2 equals 2 which is the numbers of subarrays that can fit 
     * that way we only go over the array n length of time 
     * @return - the number of subarrays that are increasing 
     */
    public static int strictlyIncreasing (int[] a)
    {
        int n = a.length;
        int count = 0;
        int subLength = 1;
        for (int i=0; i < n-1; ++i)
        {
            if (a[i + 1] > a[i]) // if the number after is bigger than increase the length and go for loop again
                subLength++;
            else // if not add to count the amount of subarrays in that section
            {
                count += (((subLength - 1) * subLength) / 2); //add the number of subbarrays into count
                subLength = 1; //reset the length value
            }
        }
        if (subLength > 1)
            count += (((subLength - 1) * subLength) / 2);
        return count;
    }
    /**
     * this is the answer to question 3 
     * @param the array of the question
     * @return the number of the largest flat sequence in the array 
     */
    public static int longestFlatSequence (int[] arr){ // the original function
        int array[] =  {-1,-1};
        return lengthFlat(arr,0,array,0);
    }
    public static boolean checkIfThere(int[]arr, int num){ // this checks if there was that number in the last flat sequence 
        if(arr[0]==-1){ // if there was no last number then set it to it
            arr[0] = num;
            return true;
        }
        if(arr[0]==num){ // if it already was there then return true
            return true;
        }
        if(arr[1]==-1){ // if there was no second number then set it to it
            if(arr[0] == num +1 || arr[0] == num -1){ 
                arr[1] = num;
                return true;
            }
        }
        if(arr[1]==num){// if it already was there then return true
            return true;
        }
        return false; // if there was no number then return false 
    }
    public static int lengthFlat (int [] arr, int index, int [] lastNum, int count){
        if(index == arr.length){// if the index reached end then return 0
            return 0;
        }
        if(!checkIfThere(lastNum,arr[index])){ // if the number isnt in the last flat sequence return 0
            return 0;
        }
        if(lastNum[1] == -1){ // call the function again if the sequence hasnt been reached yet 
            return lengthFlat(arr, index +1, lastNum,count++);
        }
        int[]tempLastNum = {-1,-1};
        return Math.max(1 + lengthFlat(arr, index +1, lastNum,count++),1+ lengthFlat(arr, index +1, tempLastNum,count++)); // calls for the sequnce once with a new flat sequence and one with the old 
    }
    /**
     * the answer to question 4 
     * @param the array to check
     * @return the amount of the most max points by the laws 
     */
    public static int findMaximum(int[][] mat){
        return findMaximum(mat,0,0);
    }
    public static int isMax(int a,int b){ // max function
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }
    public static int findMaximum(int[][] mat,int x, int y){
        if(x>=mat.length || x==-1 || y== -1 || y>=mat[0].length){ // if out of bounds return 0
            return 0;  
        }
        if(mat[x][y]==-1){ // if the value of the place is -1 return 0
            return 0;
        }
        if(y%2==0){ // if the row is even then you can go only right 
         
            return isMax(mat[x][y] + findMaximum(mat,x+1,y),mat[x][y] + findMaximum(mat,x,y+1)); // call the function again with the allowed values 
        }
        else{
          
            return isMax(mat[x][y] + findMaximum(mat,x-1,y),mat[x][y] + findMaximum(mat,x,y+1));// call the function again with the allowed values 
        }
        
        
    }
   
    
}

