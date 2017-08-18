
/**
* http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
* Solution is same described in this link above.
*
**/
public class PermTest {

public static void main(String[] args) throws Exception {
    String str = "abcdef";
    StringBuffer strBuf = new StringBuffer(str);
    doPerm(strBuf,str.length());

}
/**
 * List permutation of a string
 * 
 * @param s the input str
 * @return  the list of permutation
 */
private static void doPerm(StringBuffer str, int index){
    if(index <= 0)
        System.out.println(str);            
    else { //recursively solve this by placing all other chars at current first pos
        doPerm(str, index-1);
        int currPos = str.length()-index;
        for (int i = currPos+1; i < str.length(); i++) {//start swapping all other chars with current first char
            swap(str,currPos, i);
            doPerm(str, index-1);
            swap(str,i, currPos);//restore back my string buffer
        }
    }
}
/**
* Swaps the 2 characters in string whose position is give by pos1 and pos2
* dont assert anything. By construction all values passed wiil be correct.
* @param str  the input str
* @pos1 int to swap
* @pos2 int to swap with
*/
private  static void swap(StringBuffer str, int pos1, int pos2){
    char t1 = str.charAt(pos1);
    str.setCharAt(pos1, str.charAt(pos2));
    str.setCharAt(pos2, t1);
} 
}  
