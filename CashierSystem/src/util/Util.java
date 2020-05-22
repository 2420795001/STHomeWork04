package util;

/**
 * @author : kongyy
 * @time : 2020/5/21 17:55
 */
public class Util {

    public boolean isNumeric(String str){
        for(int i=str.length();--i>=0;){
            int chr=str.charAt(i);
            if(chr<48 || chr>57){
                return false;
            }
        }
        return true;
    }
}
