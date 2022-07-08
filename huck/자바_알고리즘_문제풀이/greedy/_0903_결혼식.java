//https://cote.inflearn.com/contest/10/problem/09-01
package huck.자바_알고리즘_문제풀이.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//public class Main {
public class _0903_결혼식 {

    private final char ARRIVE = 'a', DEPART = 'd';

    static class Info implements Comparable<Info> {
        int t; // t
        char s; // 'a','d'

        public Info(int t, char s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "t=" + t +
                    ", s=" + s +
                    '}';
        }

        @Override
        public int compareTo(Info o) {
//            1순위 t는 오름차순
//            2순위 'd','a' 순
            if (this.t != o.t) {
                return t - o.t;
            } else {
                return o.s - s;
            }
        }
    }

    private void solution(ArrayList<Info> arr) {
//        System.out.println("n = " + n + ", arr = " + arr);
        Collections.sort(arr);

        int count = 0;
        int max = Integer.MIN_VALUE;
        for (Info info : arr) {
//            System.out.println(info);
            if (info.s == DEPART) {
                count--;
            } else {
                count++;
            }
            max = Math.max(max, count);
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0903_결혼식 T = new _0903_결혼식();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/greedy/_0903_결혼식.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        ArrayList<Info> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Info(kb.nextInt(), T.ARRIVE));
            arr.add(new Info(kb.nextInt(), T.DEPART));
        }

        T.solution(arr);

    }
}
