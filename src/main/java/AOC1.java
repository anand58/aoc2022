import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class AOC1 {
    public static void main(String [] pArgs) throws IOException {
      //  String fileName = "src/main/resources/aoc1.txt";
// Open the file
        FileInputStream fstream = new FileInputStream("src/main/resources/aoc1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int firstSum = 0;
        int firstmax = 0;
        int secondmax = 0;
        int thirdmax = 0;

//Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
           // System.out.println (strLine);
            if(strLine.equals("")){
                if(firstSum>firstmax) {
                    firstmax = firstSum;
                }
                firstSum = 0;
            } else {
                firstSum += Integer.parseInt(strLine);
            }
        }
       // System.out.println(firstmax);
        secondmax = getMax(firstmax);
        thirdmax = getMax(secondmax);
        System.out.println(firstmax+secondmax+thirdmax);

//Close the input stream
        fstream.close();
    }

    public static int getMax(int currentMax) throws IOException {
        FileInputStream fstream = new FileInputStream("src/main/resources/aoc1.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        int sum = 0;
        int max = 0;

        while ((strLine = br.readLine()) != null)   {
            if(strLine.equals("")){
                if(sum>max && sum < currentMax) {
                    max = sum;
                }
                sum = 0;
            } else {
                sum += Integer.parseInt(strLine);
            }
        }
        return max;
    }
}