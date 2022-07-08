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
        // 최선은 먼저시작하는게 아닌 회의끝나는시각이 빨리끝나는거부터. 회의가 끝나야 시작할수있으므로
        // 회의시간이 짧은거부터가 아니라?
        // 둘다해야함. 1순위 끝나는시각으로 오름차순. 2순위 시작시각으로 오름차순
        @Override
        public int compareTo(Meet o) {
            if (this.e == o.e) {
                return this.s - o.s;
            } else {
                return this.e - o.e;
            }
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
        int count = 0;
        Collections.sort(arr);
        int e = 0;
        for (Meet meet : arr) {
            if (meet.s >= e) {
                count++;
                e = meet.e;
            }
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
