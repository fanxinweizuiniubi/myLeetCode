package string;

public class LeetCode05Baoli {

    public static void main(String[] args) {
        String s = "abavcvabdaa";
        //System.out.println(s.substring(0,2+1));
        String ss = longestPalindrome(s);
        System.out.println(ss);
    }

    private static boolean isHuiwen(String s,int start,int end){
        String[] ss = s.split("");
        while(start < end){
            if(!ss[start].equals(ss[end])){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static String longestPalindrome(String s) {
        if(null == s) return null;
        int win =  s.length() - 1;
        String re = "null";
        while(re != null){
            for(int i = 0;i < s.length() - win;i++){
                boolean flag = isHuiwen(s.substring(i,win + i + 1),0,win);
                if(flag){
                    re = s.substring(i,win + i+ 1);
                    return re;
                }
            }
            win--;
        }
        return re;
    }

}
