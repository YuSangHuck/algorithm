//https://cote.inflearn.com/contest/10/problem/09-01
package huck.자바_알고리즘_문제풀이.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _0901_씨름선수 {

    private int count = 0;

    static class Person implements Comparable<Person> {
        private final int h, w;

        @Override
        public int compareTo(Person o) {
            return o.h - this.h;
        }

        public Person(int h, int w) {
            this.h = h;
            this.w = w;
        }
    }

    private void solution(int n, ArrayList<Person> arr) {
        Collections.sort(arr); // 키로 내림차순정렬되어있으니, 몸무게만 비교하면 된다.
        int max = Integer.MIN_VALUE;
        for (Person p : arr) {
            if (p.w > max) {
                max = p.w;
                count++;
            }
        }

        System.out.println(count);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0901_씨름선수 T = new _0901_씨름선수();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/greedy/_0901_씨름선수.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        ArrayList<Person> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Person(kb.nextInt(), kb.nextInt()));
        }

        T.solution(n, arr);

    }
}
