//https://cote.inflearn.com/contest/10/problem/06-09
package huck.자바_알고리즘_문제풀이.sorting_and_searching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class _0609_뮤직비디오_결정알고리즘 {
    private int getCount(int[] arr, int capacity) {
        int count = 1;
        int sum = 0;
        for (int v : arr) {
            if (sum + v > capacity) {
                sum = v;
                count++;
            } else {
                sum += v;
            }
        }
        return count;
    }

    private int solution(int n, int m, int[] arr) {
//        System.out.println("n = " + n + ", m = " + m + ", arr = " + Arrays.toString(arr));
//        n개의 곡, 1~1000
//        arr[i]는 i번째 라이브 길이(분), arr[i]~1000
//        m은 dvd 개수, 1~n
//        -> dvd의 최소 용량(길이)

//        arr을 m개로 나눴을 때, 각 부분합의 max가 최소가되는 케이스
//        (1 2 3 4 5 6 7) (8) (9) => 28, 8, 9 => 28
//        (1 2 3 4 5 6) (7 8) (9) => 21, 15, 9 => 21
//        (1 2 3 4 5) (6 7) (8 9) => 15, 13, 17 => 17

//        ㄴㄴ 결정알고리즘
//        답은 lt와 rt 사이에 분명 존재한다
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = getCount(arr, mid);
            if (count > m) {
                lt = mid +1;
            } else {
                answer = mid;
                rt = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0609_뮤직비디오_결정알고리즘 T = new _0609_뮤직비디오_결정알고리즘();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/sorting_and_searching/_0609_뮤직비디오_결정알고리즘_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }
}
