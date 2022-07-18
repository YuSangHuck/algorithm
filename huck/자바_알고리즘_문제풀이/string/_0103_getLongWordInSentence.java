//https://cote.inflearn.com/contest/10/problem/01-03
package huck.자바_알고리즘_문제풀이.string;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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


    static class ComparableString implements Comparable<ComparableString> {

        String s;

        public ComparableString(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(ComparableString o) {
            return o.s.length() - s.length();
        }
    }
    private static String splitListOfCustomStringSort(String str) {
        // (1)
        ArrayList<ComparableString> arr = new ArrayList<>();
        for (String s : str.split(" ")) {
            arr.add(new ComparableString(s));
        }

        // (2) 단순 Comparator 객체 생성
        // (1),(2),(3) => 357.3ms
        // (2) = 357.3 - 159.7 = 197.6ms
        Comparator<ComparableString> stringComparator = (o1, o2) -> o2.s.length() - o1.s.length();

        // NOTE Timsort vs ComparableTimSort 성능차이 이유는?
        // sorting에는 성능차이가 없다.
        // Comparator 생성에서 리소스를 많이 잡아먹는다.
        // cote 사이트에서는 거의 200ms
        
        // (3)
        // (1),(3) => 159.7ms
        Collections.sort(arr); // java.util.Arrays#sort(java.lang.Object[])
        // java.util.Collections#sort(java.util.List<T>)
        // -> java.util.List#sort
        // -> java.util.Arrays#sort(T[], java.util.Comparator<? super T>)
        // -> java.util.Arrays#sort(java.lang.Object[]) // Comparator == null 이므로
        // -> java.util.ComparableTimSort#sort
        // -> java.util.ComparableTimSort#binarySort
        // -> Comparable pivot.compareTo // java.lang.Comparable.compareTo

        // (4)
        // (1),(2),(4) => 351ms
        // (1),(4) => 153.4ms
        Collections.sort(arr, stringComparator); // 340ms, java.util.TimSort.sort
        // java.util.Collections#sort(java.util.List<T>)
        // -> java.util.List#sort
        // -> java.util.Arrays#sort(T[], java.util.Comparator<? super T>)
        // -> java.util.TimSort#sort // Comparator != null 이므로
        // -> java.util.TimSort#binarySort
        // -> c.compare(pivot, a[mid]) // java.util.Comparator.compare

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
