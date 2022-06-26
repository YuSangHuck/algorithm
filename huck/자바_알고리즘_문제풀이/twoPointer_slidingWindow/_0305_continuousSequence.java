//https://cote.inflearn.com/contest/10/problem/03-05
package huck.자바_알고리즘_문제풀이.twoPointer_slidingWindow;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//public class Main {
public class _0305_continuousSequence {

    private int continuousSequence(int n) {
        int answer = -1; // 아래에서 자기자신 무조건 1개 포함 -> 제외
        int lt = 0;
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        for (int rt = 0; rt < n; rt++) {
//            rt가 셋팅이 됐으면
//            1. rt 기반 sum 갱신
            sum += arr[rt];
//            2. sum == n이면 answer++
            if (sum == n) {
                answer++;
            }
//            3. sum >= n이면
            while (sum > n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private int continuousSequence_CaseOptimize(int n) {
        int answer = 0; // 아래에서 자기자신 무조건 1개 포함 -> 제외
        int lt = 0;
        int sum = 0;
        int caseOptimize = 1 + (n / 2);
        int[] arr = new int[caseOptimize];
        for (int i = 0; i < caseOptimize; i++) {
            arr[i] = i + 1;
        }
        for (int rt = 0; rt < caseOptimize; rt++) {
//            rt가 셋팅이 됐으면
//            1. rt 기반 sum 갱신
            sum += arr[rt];
//            2. sum == n이면 answer++
            if (sum == n) {
                answer++;
            }
//            3. sum >= n이면
            while (sum > n) {
                sum -= arr[lt++];
                if (sum == n) {
                    answer++;
                }
            }
        }
        return answer;
    }

    private int continuousSequence_UsingQuotientAndRemainder(int n) {
//        연속 2개: k + (k+1)
//        => 2k + 1
//        연속 3개: k + (k+1) + (k+2)
//        => 3k + 3
//        연속 4개: k + (k+1) + (k+2) + (k+3)
//        => 4k + 6
//        연속 5개: k + (k+1) + (k+2) + (k+3) + (k+4)
//        => 5k + 10 = 5k + (1 + k)*k/2 - k

        int answer = 0;
        for (int k = 2; k < n / 2 + 1; k++) {
            int remainder = (1 + k) * k / 2 - k;

            int quotient = n - remainder;
            if (quotient <= 0) {
                break;
            }
            if (quotient % k == 0) {
                answer++;
            }
        }

        return answer;
    }

    public int solution(int n) {
//        return continuousSequence(n);
//        return continuousSequence_CaseOptimize(n);
        return continuousSequence_UsingQuotientAndRemainder(n);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0305_continuousSequence T = new _0305_continuousSequence();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/twoPointer_slidingWindow/_0305_continuousSequence_input.txt");

//        Scanner kb = new Scanner(System.in);
        Scanner kb = new Scanner(fileInputStream);
        int n = kb.nextInt();
        System.out.println(T.solution(n));
    }
}
