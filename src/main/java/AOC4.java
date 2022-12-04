import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AOC4 {
    public static void main(String[] pArgs) throws IOException {
        FileInputStream fstream = new FileInputStream("src/main/resources/aoc4.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int count = 0;
        while ((strLine = br.readLine()) != null) {

            String[] str = strLine.split(",");
            int firstLeft = Integer.parseInt(str[0].split("-")[0]);
            int firstRight = Integer.parseInt(str[0].split("-")[1]);
            int secondLeft = Integer.parseInt(str[1].split("-")[0]);
            int secondRight = Integer.parseInt(str[1].split("-")[1]);

// solution to part 1

            if (firstLeft > secondLeft) {
                if (firstRight <= secondRight) {
                    count += 1;
                }
            } else if (secondLeft > firstLeft) {
                if (secondRight <= firstRight) {
                    count += 1;
                }
            } else {
                count += 1;
            }

//solution to part 2
//            if (firstRight >= secondLeft && secondRight >= firstLeft) {
//                count += 1;
//            }

        }
        System.out.println(count);

        fstream.close();

    }
}
