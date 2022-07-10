//https://cote.inflearn.com/contest/10/problem/10-04
package huck.자바_알고리즘_문제풀이.dynamic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//public class Main {
public class _1004_LIS_가장높은탑쌓기 {
    static class Brick implements Comparable<Brick> {

        int s, h, w;

        public Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Brick{" +
                    "s=" + s +
                    ", h=" + h +
                    ", w=" + w +
                    '}';
        }

        @Override
        public int compareTo(Brick o) {
            return o.s - s;
        }
    }

    private void solution(int n, int[][] arr) {
        ArrayList<Brick> bricks = new ArrayList<>();
        for (int[] ints : arr) {
            bricks.add(new Brick(ints[0], ints[1], ints[2]));
        }
        Collections.sort(bricks);

        // dy[i]는 arr[i]를 끝으로 쌓아올린 탑의최대높이
        int[] dy = new int[n];
        dy[0] = bricks.get(0).h;
        int answer = dy[0];
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) { // 1. j번째 쌓은 경우에서 max를 찾는거임
//                무게, 넓이
                Brick ib = bricks.get(i);
                Brick jb = bricks.get(j);
                if (ib.w < jb.w) { // 무게 조건으로 i를 j위에 올릴 수 있다면
                    if (max < dy[j]) {
                        max = dy[j];
                    }
                }
            }
            dy[i] = max + bricks.get(i).h; // 2. 그리고 찾은 max에다가 i번째 벽돌높이 더하는거고
            answer = Math.max(answer, dy[i]); // 3. 그 값 기준으로 answer update
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _1004_LIS_가장높은탑쌓기 T = new _1004_LIS_가장높은탑쌓기();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/dynamic/_1004_LIS_가장높은탑쌓기.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
            arr[i][2] = kb.nextInt();
        }
        T.solution(n, arr);

    }
}
