
/**
 * Write a description of class CheckEx1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CheckEx1
{
    public static boolean test(int [][] m)
    {
        int n=m.length;
        for(int r=0; r<(n-1); r++)
            for (int c=0; c<n; c++)
                for (int i=0; i<n; i++){
                    System.out.println(m[r][c] + " and " + m[r+1][i]);
                    if(m[r][c] > m[r+1][i]) {
                   return false;
                }
                }
                    
                
        return true;
    }

    public static boolean what(int [][] m)
    {
        int n=m.length;
        for(int x=0; x<n; x++)
            for (int y=0; y<(n-1); y++){
                System.out.println(m[x][y] + " and " +  m[x][y+1]);
                if(m[x][y] > m[x][y+1]) return false;
            }
        for(int x=0; x<n; x++)
            for (int y=0; y<(n-1); y++){
                 System.out.println(m[y][x] + " and " +  m[y+1][x]);
                 if(m[y][x] > m[y+1][x]) return false;
            }
                
        return true;
    }

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
    public static int strictlyIncreasing (int[] a)
    {
        int n = a.length;
        int count = 0;
        int len = 1;
        // Traverse through the array
        for (int i=0; i < n-1; ++i)
        {
            // If arr[i+1] is greater than arr[i],
            // then increment length
            if (a[i + 1] > a[i]) 
                len++;
                  
            // Else Update count and reset length
            else
            {
                count += (((len - 1) * len) / 2);
                len = 1;
            }
        }
          
        // If last length is more than 1
        if (len > 1)
            count += (((len - 1) * len) / 2);
      
        return count;
    }

    public static void main(String [] args)
    {
        //int[][] arr =  { { 1, 4 ,7}, {2, 5,8 },{3, 6,9 } } ;
        // { { 1, 2 ,3}, {1, 5,6 },{1, 8,9 } } ;
        int[][] arr =  { { 1, 2 ,3}, {2, 5,6 },{3, 8,9 } } ;
        //findValWhat(arr,5);
        //System.out.println(findValWhat(arr,5));
        System.out.println(what(arr));
        //System.out.println(test(arr));
    }

}
