import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AOC7 {

    static long timerStart;
    static int part = 1;


    public static abstract class Node {
        public Folder parent;
        public String name;

        public abstract long getSize();
    }


    public static class File extends Node {
        public int size;

        @Override
        public long getSize() {
            return size;
        }
    }


    public static class Folder extends Node {
        public List<Node> contents = new ArrayList<>();

        public List<Folder> getSubFolders() {
            return contents.stream().filter(n -> n instanceof Folder)
                    .map(n -> (Folder) n)
                    .collect(Collectors.toList());
        }

        public long getSize() {
            return contents.stream().map(Node::getSize).mapToLong(Long::longValue).sum();
        }
    }


    public static void main(String[] args) throws FileNotFoundException {

        FileInputStream fStream = new FileInputStream("src/main/resources/aoc7.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fStream));
        String strLine;

        List<String> inputLines = new ArrayList<>();
        try {
            while ((strLine = br.readLine()) != null) inputLines.add(strLine);
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        timerStart = System.nanoTime();
        solve(inputLines);
    }


    static void solve(List<String> input) {
        Folder root = new Folder();
        root.name = "/";
        Folder currentFold = root;
        for (int i = 1; i < input.size(); i++) {
            String[] parts = input.get(i).split(" ");

            if (parts[0].equals("$")) {
                if (parts[1].equals("cd")) {
                    if (parts[2].equals("..")) {
                        currentFold = currentFold.parent;
                    } else {
                        for (Node n : currentFold.contents) {
                            if (n.name.equals(parts[2])) {
                                currentFold = (Folder) n; // Should check, but meh
                                break;
                            }
                        }
                    }
                }
            } else if (parts[0].equals("dir")) {
                Folder folder = new Folder();
                folder.parent = currentFold;
                folder.name = parts[1];
                currentFold.contents.add(folder);
            } else {
                File file = new File();
                file.parent = currentFold;
                file.name = parts[1];
                file.size = Integer.parseInt(parts[0]);
                currentFold.contents.add(file);
            }
        }

        List<Folder> smallerFolders = new ArrayList<>();
        List<Folder> toCheck = new ArrayList<>(root.getSubFolders());

        while (toCheck.size() > 0) {
            Folder fold = toCheck.remove(0);
            toCheck.addAll(fold.getSubFolders());
            if (fold.getSize() <= 100000) smallerFolders.add(fold);
        }

        long sum = 0;
        for (Folder f : smallerFolders)
            sum += f.getSize();
        calculateAndPrint(sum);

        long totalSpace = 70000000;
        long freeSpace = totalSpace - root.getSize();

        long smallestFree = Integer.MAX_VALUE;
        toCheck = new ArrayList<>(root.getSubFolders());

        while (toCheck.size() > 0) {
            Folder fold = toCheck.remove(0);
            toCheck.addAll(fold.getSubFolders());
            long size = fold.getSize();
            if (freeSpace + size > 30000000 && size < smallestFree) smallestFree = size;
        }
        calculateAndPrint(smallestFree);
    }

    public static void calculateAndPrint(long answer) {
        calculateAndPrint(String.valueOf(answer));
    }

    public static void calculateAndPrint(String answer) {
        long timeSpent = (System.nanoTime() - timerStart) / 1000;
        System.out.println("Part " + part + ": " + answer + ", Duration: " + timeToString(timeSpent));
        timerStart = System.nanoTime();
        part++;
    }

    public static String timeToString(long timeSpent) {
        if (timeSpent < 1000)
            return timeSpent + "µs";
        if (timeSpent < 1000000)
            return (timeSpent / 1000.0) + "ms";
        return (timeSpent / 1000000.0) + "s";
    }
}