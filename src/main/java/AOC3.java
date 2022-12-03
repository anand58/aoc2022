import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AOC3 {
    public static void main(String [] pArgs) throws IOException {
        FileInputStream fstream = new FileInputStream("src/main/resources/aoc3.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int j = 97;
        int sum = 0;
        boolean visited = false;
        Map<Character, Integer> m = new HashMap<>();

        for(int i=1; i<=26; i++) {
            m.put((char) j++, i);
        }

        j = 65;
        for(int i=27; i<=52; i++) {
            m.put((char) j++, i);
        }
        System.out.println(m);
// solution first part
//        while ((strLine = br.readLine()) != null)   {
//              char[] c = strLine.toCharArray();
//              Set<Character> charset = new HashSet<>();
//              int lenbytwo = strLine.length()/2;
//              int len = strLine.length();
//              for(int i=0; i<lenbytwo; i++) {
//                  charset.add(c[i]);
//              }
//            for(int i=lenbytwo; i<len; i++) {
//                char chr = c[i];
//                if(charset.contains(chr) && !visited){
//                    visited = true;
//                   sum += m.get(chr);
//                   continue;
//                }
//               // charset.add(c[i]);
//            }
//
//            visited = !visited;
//
//        }
//        System.out.println(sum);
//        fstream.close();

//solution second part:
        int count = 0;
        Set<Character> charset = new LinkedHashSet<>();
        Set<Character> commonset = new HashSet<>();
                while ((strLine = br.readLine()) != null)   {
                    if(count == 3) {
                        count = 0;
                        charset = new HashSet<>();
                        commonset = new HashSet<>();
                    }
              char[] c = strLine.toCharArray();
              int len = strLine.length();
              for(int i=0; i<len; i++) {
                  char chr = c[i];
                  if(charset.contains(c[i]) && count==1){
                           commonset.add(c[i]);
                  } else if(commonset.contains(c[i]) && count==2 && !visited){
                      sum += m.get(c[i]);
                      visited = true;
                  } else if(count<1) {
                      charset.add(c[i]);
                  }
              }
                    count += 1;
                    visited = !visited;
        }
        System.out.println(sum);
        fstream.close();

    }
}
