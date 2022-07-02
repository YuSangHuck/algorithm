//https://cote.inflearn.com/contest/10/problem/06-09
package huck.자바_알고리즘_문제풀이.sorting_and_searching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class _0610_마구간정하기_결정알고리즘 {
    private int getMaxCount(int[] arr, int distance) {
        int count = 1;
        int last = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[last] >= distance) {
                count++;
                last = i;
            }
        }
        return count;
    }

    private int solution(int n, int c, int[] arr) {
//        n은 마구간 개수
//        c는 말 개수
//        arr은 마구간 위치
        int answer = 0;
        Arrays.sort(arr);
//        System.out.println("n = " + n + ", c = " + c + ", arr = " + Arrays.toString(arr));

//        가장 가까운말들의 최대거리는 아래의 범위 안에 있다.
//        최소 1이고, 최대 c등분한것보단 작다.
        int lt = 1;
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        int rt = (max + min) / (c - 1);

//        1,2,4,8,9
//        => lt = 1, rt = 5
        while (lt <= rt) {
            int mid = (lt + rt) / 2; // 가까운말들의 최대거리, 3
            int count = getMaxCount(arr, mid); // 3일때 배치가능한 말의 수
            if (count < c) {
                rt = mid - 1;
            } else {
                answer = mid;
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0610_마구간정하기_결정알고리즘 T = new _0610_마구간정하기_결정알고리즘();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/sorting_and_searching/_0610_마구간정하기_결정알고리즘_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, c, arr));
    }
}
