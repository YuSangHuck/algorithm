package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _1358_하키 {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    private static boolean checkCircle(Point c, int r, Point person) {
        int x = person.x - c.x;
        int y = person.y - c.y;
        return r * r >= x * x + y * y;
    }

    private static boolean checkRectangle(Point ld, Point ru, Point person) {
        return ld.x <= person.x &&
                ru.x >= person.x &&
                ld.y <= person.y &&
                ru.y >= person.y;
    }

    private static int solution(int w, int h, int x, int y, int p, int[][] arr) {
        int r = h / 2;
        Point c1 = new Point(x, y + r);
        Point c2 = new Point(x + w, y + r);
        Point ld = new Point(x, y);
        Point ru = new Point(x + w, y + h);
        int answer = 0;
        for (int[] ints : arr) {
            Point person = new Point(ints[0], ints[1]);
            if (checkCircle(c1, r, person)) {
                answer++;
            } else if (checkCircle(c2, r, person)) {
                answer++;
            } else {
                if (checkRectangle(ld, ru, person)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner kb = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_1358_하키.txt");
        Scanner kb = new Scanner(fileInputStream);

        int w = kb.nextInt();
        int h = kb.nextInt();
        int x = kb.nextInt();
        int y = kb.nextInt();
        int p = kb.nextInt();
        int[][] arr = new int[p][2];
        for (int i = 0; i < p; i++) {
            arr[i][0] = kb.nextInt();
            arr[i][1] = kb.nextInt();
        }
        System.out.println(solution(w, h, x, y, p, arr));
    }
}
