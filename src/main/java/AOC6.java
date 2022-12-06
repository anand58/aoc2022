import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AOC6 {
    public static void main(String[] pArgs) throws IOException {
        FileInputStream fStream = new FileInputStream("src/main/resources/aoc6.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
        Set<Character> s = new HashSet<>();
        Map<Character, Integer> m = new HashMap<>();
        char[] chr = br.readLine().toCharArray();
        int j = 0;
        System.out.println(m);
        while (true) {
            // where s.size() is compared with two conditions of the puzzle
            if (s.size() == 4) {
                System.out.println(j);
                break;
            } else if (j < chr.length - 1 && s.contains(chr[j])) {
                j = m.get(chr[j]) + 1;
                s = new HashSet<>();
                s.add(chr[j]);
                m.put(chr[j], j);
                j += 1;
            } else {
                m.put(chr[j], j);
                s.add(chr[j++]);
            }
        }
        fStream.close();
    }
}
