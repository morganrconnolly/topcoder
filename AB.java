/*
  Problem from Topcoder practice problems (http://www.topcoder.com)
  https://arena.topcoder.com/#/u/practiceCode/16319/46378/13642/1/325040
  Problem Statement
  You are given two s: N and K. Lun the dog is interested in strings that satisfy the following conditions:
  The string has exactly N characters, each of which is either 'A' or 'B'.
  The string s has exactly K pairs (i, j) (0 <= i < j <= N-1) such that s[i] = 'A' and s[j] = 'B'.
  If there exists a string that satisfies the conditions, find and return any such string. Otherwise, return an empty string.
*/
public class ABComputed {

    public static String createString(int i,int k){
        int noA =i;
        int noB =0;
        int curK = 0;
        int bPos =-1;
        boolean found=false;
        while(noA >= noB  && !found){
            if( k-curK  <noA){
                found=true;
                bPos=  k-curK;
            } else {
                curK = --noA * ++noB;
                if (curK == k) {
                    found = true;
                }else{
                    curK=curK-noB;
                }
            }
        }
        if (!found) {
            return "";
        }else{
            StringBuffer stringBuffer= new StringBuffer();
            for(int j=0; j<i; j++){
                if (j<noA) {
                    stringBuffer.append("A");
                }else{
                    stringBuffer.append("B");
                }
            }
            if(bPos >-1){
                stringBuffer.replace(bPos,bPos+1,"B");
            }
            return stringBuffer.toString();
        }
    }
    public static void main(String[] args) {
        for (int i = 1; i < 50; i++){
            System.out.println("8:"+i+" = "+createString(8, i));
        }
    }
}
