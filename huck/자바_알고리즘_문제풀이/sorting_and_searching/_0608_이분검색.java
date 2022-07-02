//https://cote.inflearn.com/contest/10/problem/06-08
package huck.자바_알고리즘_문제풀이.sorting_and_searching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

//public class Main {
public class _0608_이분검색 {
    private int solution(int n, int m, int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
////        binary search 구현하면 됨
//        int lt = 0, rt = n - 1;
//        while (lt <= rt) {
//            int mid = (lt + rt) / 2;
//            if (nums[mid] == m) {
//                answer = mid + 1;
//                break;
//            }
//            if (nums[mid] > m) {
//                rt = mid - 1;
//            } else {
//                lt = mid + 1;
//            }
//        }
//        if (answer == 0) {
//            System.out.println("no value");
//        }
        answer = Arrays.binarySearch(nums, m) + 1;
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0608_이분검색 T = new _0608_이분검색();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/sorting_and_searching/_0608_이분검색_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, nums));
    }
}
