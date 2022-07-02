//https://cote.inflearn.com/contest/10/problem/06-06
package huck.자바_알고리즘_문제풀이.sorting_and_searching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class _0606_장난꾸러기 {
    private String solution(int n, int[] nums) {
        StringBuilder answer = new StringBuilder();
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) {
                answer.append(i + 1).append(" ");
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0606_장난꾸러기 T = new _0606_장난꾸러기();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/sorting_and_searching/_0606_장난꾸러기_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, nums));
    }
}
