//https://cote.inflearn.com/contest/10/problem/09-04
package huck.자바_알고리즘_문제풀이.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _0904_pQueue_최대수입스케쥴 {
    private static int answer = 0;

    static class Info implements Comparable<Info> {
        int d, m;

        public Info(int m, int d) {
            this.d = d;
            this.m = m;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "d=" + d +
                    ", m=" + m +
                    '}';
        }

        @Override
        public int compareTo(Info o) {
            return o.d - this.d;
        }
    }

//    d가 작은것부터가 아닌 큰거부터 모아서 pq에 넣는다
//    pq의 기준은 m이 큰거
//    3인거 모아서 pq에 넣고 pq 하나 빼고
//    2인거 모아서 pq에 넣고 pq 하나 빼고
//    ...
    private void solution(ArrayList<Info> arr) {
        Collections.sort(arr);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int max = arr.get(0).d;
        int j = 0;
        for (int i = max; i >= 1; i--) { // 3,2,1
            for (; j < arr.size(); j++) {
                Info jInfo = arr.get(j);
                if (jInfo.d < i) {
                    break;
                }
                pq.offer(jInfo.m);
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0904_pQueue_최대수입스케쥴 T = new _0904_pQueue_최대수입스케쥴();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/greedy/_0904_pQueue_최대수입스케쥴.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        ArrayList<Info> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Info(kb.nextInt(), kb.nextInt()));
        }

        T.solution(arr);
        System.out.println(answer);
    }
}
