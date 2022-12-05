import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AOC5 {

    // Create String type Queue
    static Deque<Character> Queue1 = new ArrayDeque<>();
    static Deque<Character> Queue2 = new ArrayDeque<>();
    static Deque<Character> Queue3 = new ArrayDeque<>();
    static Deque<Character> Queue4 = new ArrayDeque<>();
    static Deque<Character> Queue5 = new ArrayDeque<>();
    static Deque<Character> Queue6 = new ArrayDeque<>();
    static Deque<Character> Queue7 = new ArrayDeque<>();
    static Deque<Character> Queue8 = new ArrayDeque<>();
    static Deque<Character> Queue9 = new ArrayDeque<>();


    public static void main(String[] pArgs) throws IOException {

        Map<Integer, Deque<Character>> m = new LinkedHashMap<>();
        m.put(1, Queue1);
        m.put(2, Queue2);
        m.put(3, Queue3);
        m.put(4, Queue4);
        m.put(5, Queue5);
        m.put(6, Queue6);
        m.put(7, Queue7);
        m.put(8, Queue8);
        m.put(9, Queue9);

        prepareStacks(m);
        FileInputStream fstream = new FileInputStream("src/main/resources/aoc5.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        Deque<Character> startQueue;
        Deque<Character> endQueue;

        while ((strLine = br.readLine()) != null) {
            String[] str = strLine.split(" ");
            int noOfCrates = Integer.parseInt(str[1]);
            int start = Integer.parseInt(str[3]);
            int end = Integer.parseInt(str[5]);
            startQueue = m.get(start);
            endQueue = m.get(end);
            updateQueue(startQueue, endQueue, "part 1", noOfCrates);
        }
        printResult(m);
        fstream.close();

    }

    private static void prepareStacks(Map<Integer, Deque<Character>> m) {
        for (int i : m.keySet()) {
            switch (i) {
                case 1:
                    m.get(i).addLast('R');
                    m.get(i).addLast('G');
                    m.get(i).addLast('J');
                    m.get(i).addLast('B');
                    m.get(i).addLast('T');
                    m.get(i).addLast('V');
                    m.get(i).addLast('Z');
                    break;
                case 2:
                    m.get(i).addLast('J');
                    m.get(i).addLast('R');
                    m.get(i).addLast('V');
                    m.get(i).addLast('L');
                    break;
                case 3:
                    m.get(i).addLast('S');
                    m.get(i).addLast('Q');
                    m.get(i).addLast('F');
                    break;
                case 4:
                    m.get(i).addLast('Z');
                    m.get(i).addLast('H');
                    m.get(i).addLast('N');
                    m.get(i).addLast('L');
                    m.get(i).addLast('F');
                    m.get(i).addLast('V');
                    m.get(i).addLast('Q');
                    m.get(i).addLast('G');
                    break;
                case 5:
                    m.get(i).addLast('R');
                    m.get(i).addLast('Q');
                    m.get(i).addLast('T');
                    m.get(i).addLast('J');
                    m.get(i).addLast('C');
                    m.get(i).addLast('S');
                    m.get(i).addLast('M');
                    m.get(i).addLast('W');
                    break;
                case 6:
                    m.get(i).addLast('S');
                    m.get(i).addLast('W');
                    m.get(i).addLast('T');
                    m.get(i).addLast('C');
                    m.get(i).addLast('H');
                    m.get(i).addLast('F');
                    break;
                case 7:
                    m.get(i).addLast('D');
                    m.get(i).addLast('Z');
                    m.get(i).addLast('C');
                    m.get(i).addLast('V');
                    m.get(i).addLast('F');
                    m.get(i).addLast('N');
                    m.get(i).addLast('J');
                    break;
                case 8:
                    m.get(i).addLast('L');
                    m.get(i).addLast('G');
                    m.get(i).addLast('Z');
                    m.get(i).addLast('D');
                    m.get(i).addLast('W');
                    m.get(i).addLast('R');
                    m.get(i).addLast('F');
                    m.get(i).addLast('Q');
                    break;
                case 9:
                    m.get(i).addLast('J');
                    m.get(i).addLast('B');
                    m.get(i).addLast('W');
                    m.get(i).addLast('V');
                    m.get(i).addLast('P');
                    break;
            }
        }
    }

    public static void updateQueue(Deque<Character> startQueue, Deque<Character> endQueue, String part, int noOfCrates) {
        if (part.equals("part 1")) {
            for (int i = 0; i < noOfCrates; i++) {
                endQueue.addLast(startQueue.removeLast());
            }
        } else if (part.equals("part 2")) {
            if (noOfCrates == 1) {
                endQueue.addLast(startQueue.removeLast());
            } else {
                Deque<Character> q = new ArrayDeque<>();
                for (int i = 0; i < noOfCrates; i++) {
                    q.addLast(startQueue.removeLast());
                }
                for (int i = 0; i < noOfCrates; i++) {
                    endQueue.addLast(q.removeLast());
                }
            }
        }
    }

    public static void printResult(Map<Integer, Deque<Character>> m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 9; i++) {
            sb.append(m.get(i).getLast());
        }
        System.out.println(sb);
    }
}
