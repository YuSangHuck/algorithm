//https://cote.inflearn.com/contest/10/problem/10-04
package huck.자바_알고리즘_문제풀이.dynamic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//public class Main {
public class _1004_LIS_가장높은탑쌓기 {
    static class Brick {
        int a, h, w;

        public Brick(int a, int h, int w) {
            this.a = a;
            this.h = h;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Brick{" +
                    "area=" + a +
                    ", h=" + h +
                    ", w=" + w +
                    '}';
        }
    }

    private void solution(int n, int[][] arr) {
        ArrayList<Brick> bricks = new ArrayList<>();
        for (int[] ints : arr) {
            bricks.add(new Brick(ints[0], ints[1], ints[2]));
        }

        // dy[i]는 arr[i]를 끝으로 쌓아올린 탑의최대높이
        int[] dy = new int[n];
        dy[0] = bricks.get(0).h;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
//                무게, 넓이
                Brick iBrick = bricks.get(i);
                Brick jBrick = bricks.get(j);
                if (iBrick.w < jBrick.w && iBrick.a < jBrick.a) { // 무게, 넓이 조건으로 i를 j위에 올릴 수 있다면
                    max = Math.max(max, dy[j] + iBrick.h);
                }
            }
            if (max == 0) {
                max = bricks.get(i).h;
            }
            dy[i] = max;
        }
        System.out.println(dy[n - 1]);
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
