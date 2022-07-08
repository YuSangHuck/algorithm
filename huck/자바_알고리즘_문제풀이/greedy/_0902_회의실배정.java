//https://cote.inflearn.com/contest/10/problem/09-01
package huck.자바_알고리즘_문제풀이.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//public class Main {
public class _0902_회의실배정 {
    static class Meet implements Comparable<Meet> {
        @Override
        public int compareTo(Meet o) {
            return this.s - o.s;
        }

        int s, e;

        public Meet(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public String toString() {
            return "Meet{" +
                    "s=" + s +
                    ", e=" + e +
                    '}';
        }
    }

    private void solution(int n, ArrayList<Meet> arr) {
        int count = Integer.MIN_VALUE;
        Collections.sort(arr);
        for (int i = 0; i < arr.size(); i++) {
//            1개 고정
            Meet first = arr.get(i);
//            차례대로 비교
            int tmp = 1;
            for (int j = i + 1; j < n; j++) {
                Meet second = arr.get(j);
                if (first.e <= second.s) {
                    tmp++;
                    first = second;
                }

            }
            count = Math.max(count, tmp);

        }
        System.out.println(count);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0902_회의실배정 T = new _0902_회의실배정();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/greedy/_0902_회의실배정.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        ArrayList<Meet> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Meet(kb.nextInt(), kb.nextInt()));
        }

        T.solution(n, arr);

    }
}
