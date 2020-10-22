package huawei;

public class LeetCode14 {

    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        String prefix = longestCommonPrefix(arr);
        System.out.println(prefix);
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        int singleStrLength = strs[0].length();
        int arrCount = strs.length;
        for(int i = 0;i < singleStrLength;i++){
            for(int j = 1;j < arrCount;j++){
                if(i == strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }

}
