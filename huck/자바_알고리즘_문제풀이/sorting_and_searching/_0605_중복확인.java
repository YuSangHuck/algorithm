//https://cote.inflearn.com/contest/10/problem/06-05
package huck.자바_알고리즘_문제풀이.sorting_and_searching;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

//public class Main {
public class _0605_중복확인 {
    private String solution(int n, int[] nums) {
        final String DUPLICATE = "D";
        final String UNIQUE = "U";

        HashMap<Integer, Boolean> m = new HashMap<>();
        for (int num : nums) {
            if (m.containsKey(num)) {
                return DUPLICATE;
            }
            m.put(num, true);
        }

        return UNIQUE;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0605_중복확인 T = new _0605_중복확인();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/sorting_and_searching/_0605_중복확인_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, nums));
    }
}
