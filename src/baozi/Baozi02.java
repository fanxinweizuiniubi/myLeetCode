package baozi;

import java.io.*;
import java.util.*;

public class Baozi02 {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\tony fan\\Desktop\\原始数据.txt";
        File inputFile = new File(fileName);
        Scanner sc = new Scanner(inputFile);
        Map<String, Integer> map = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tmp = line.split("\\s+");
            String nominator = tmp[0];
            Set<String> set = new HashSet<>();
            for(int i = 1;i < tmp.length;i++){
                set.add(tmp[i]);
            }
            String[] noRepeatArr = new String[set.size()]; 
            int index = 0;
            for(String s : set){
                noRepeatArr[index++] = s;
            }
            for(int i = 0;i < noRepeatArr.length;i++) {
                if (!map.containsKey(noRepeatArr[i])) {
                    map.put(noRepeatArr[i], 1);
                } else if(!nominator.equals(noRepeatArr[i])){
                    map.put(noRepeatArr[i], map.get(noRepeatArr[i]) + 1);
                }
            }
        }
        Comparator<Map.Entry<String, Integer>> valueComparator = (o1, o2) -> o2.getValue() - o1.getValue();
        List<Map.Entry<String, Integer>> ans = new ArrayList<>(map.entrySet());
        Collections.sort(ans, valueComparator);

        File outputFile = new File("C:\\Users\\tony fan\\Desktop\\输出.txt");
        FileOutputStream fos = new FileOutputStream(outputFile);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        for (Map.Entry<String, Integer> entry : ans) {
            osw.write(entry.getKey());
            osw.write("\t");
            osw.write(entry.getValue() + "\n");
        }
        osw.close();
    }

}
