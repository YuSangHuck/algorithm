//https://cote.inflearn.com/contest/10/problem/01-03
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _0103_getLongWordInSentence {

    private static String splitIter(String str) { // 153ms
        String answer = "";

        String[] arr = str.split(" ");

        int max = Integer.MIN_VALUE;
        for (String s : arr) {
            if (s.length() > max) {
                answer = s;
                max = s.length();
            }
        }

        return answer;
    }

    private static String splitArraysSort(String str) { // 350ms
        String[] arr = str.split(" ");
        Comparator<String> stringComparator = (o1, o2) -> o2.length() - o1.length();
        Arrays.sort(arr, stringComparator); // n

        return arr[0]; // 2n
    }

    private static String splitListSort(String str) {
        Comparator<String> stringComparator = (o1, o2) -> o2.length() - o1.length();

        List<String> list = Arrays.asList(str.split(" ")); // 356ms

//        List<String> list = new ArrayList<>(); // 352ms
//        Collections.addAll(list, str.split(" "));

//        List<String> list = new ArrayList<>(); // 357ms
//        for (String s : str.split(" ")) {
//            list.add(s);
//        }

        list.sort(stringComparator);
        return list.get(0);

    }

    static class CustomString implements Comparable<CustomString> {

        String s;

        public CustomString(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(CustomString o) {
            return o.s.length() - s.length();
        }
    }
    private static String splitListOfCustomStringSort(String str) {
        ArrayList<CustomString> arr = new ArrayList<>();
        for (String s : str.split(" ")) {
            arr.add(new CustomString(s));
        }

        arr.sort(null); // 162ms
        Collections.sort(arr); // 160ms

        return arr.get(0).s;
    }

    public static String solution(String str) {
//        return splitIter(str); // 153ms
//        return splitArraysSort(str); // 355ms
//        return splitListSort(str); // 360ms
        return splitListOfCustomStringSort(str); // 160ms
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/string/_0103_getLongWordInSentence.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);

        String str = kb.nextLine();

        System.out.println(solution(str));
    }
}
