package huawei;

import java.util.*;

public class Exam03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] prior = line.split(",");
        List<Integer> pList = new ArrayList<>();
        List<Integer> ori = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(String s : prior){
            pList.add(Integer.parseInt(s));
            ori.add(Integer.parseInt(s));
            map.put(Integer.parseInt(s),0);
        }
        Collections.sort(pList, Comparator.reverseOrder());
        for(int i = 0;i < pList.size();i++){
            map.put(pList.get(i),i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < pList.size();i++){
            sb.append(pList.indexOf(ori.get(i)));
            if(i != pList.size()-1){
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }

}
