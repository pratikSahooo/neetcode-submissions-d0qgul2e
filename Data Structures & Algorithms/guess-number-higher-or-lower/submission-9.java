/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    int mid ;
    public int guessNumber(int n) {
        int start = 1;
        int end ;
        end = n ;
        while(start<=end){
            mid = start+(end - start)/2;
            int guessApi = guess(mid);
            if(guessApi == 0){
                return mid;
            }
            else if(guessApi == -1){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return mid ;
    }
}