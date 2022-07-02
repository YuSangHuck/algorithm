//https://cote.inflearn.com/contest/10/problem/06-07
package huck.자바_알고리즘_문제풀이.sorting_and_searching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//class Point implements Comparator {
class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
//    this, o 순서로 주어지면
//    오름차순: this - o
//    내림차순: o - this
    public int compareTo(Point o) {
        if (x == o.x) {
            return y - o.y;
        } else {
            return x - o.x;
        }
    }
}

//public class Main {
public class _0607_좌표정렬 {
    private String solution(int n, ArrayList<Point> points) {
        StringBuilder answer = new StringBuilder();
        Collections.sort(points);
        for (Point point : points) {
            answer.append(point.toString()).append('\n');
        }
        return answer.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0607_좌표정렬 T = new _0607_좌표정렬();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/sorting_and_searching/_0607_좌표정렬_input.txt");
        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            points.add(new Point(x, y));
        }
        System.out.println(T.solution(n, points));
    }
}
