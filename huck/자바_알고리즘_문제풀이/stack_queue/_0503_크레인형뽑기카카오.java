//https://cote.inflearn.com/contest/10/problem/05-03
package huck.자바_알고리즘_문제풀이.stack_queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

//public class Main {
public class _0503_크레인형뽑기카카오 {

    private int solution(int n, int[][] board, int m, int[] moves) {
        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int move : moves) {
            int x = move - 1;
            for (int y = 0; y < n; y++) {
                int v = board[y][x]; // 2차원에서 x,y면 배열은 y,x임 ㅋㅋ
                if (v != 0) {
                    board[y][x] = 0;
                    if (!stack.isEmpty() && stack.peek() == v) {
                        cnt++;
                        stack.pop();
                    } else {
                        stack.push(v);
                    }
                    break;
                }
            }
        }
        return cnt * 2;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0503_크레인형뽑기카카오 T = new _0503_크레인형뽑기카카오();

        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/stack_queue/_0503_크레인형뽑기카카오_input.txt");

        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] board = new int[n][n]; // 0~100, 인형종류(1~100)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = kb.nextInt();
            }
        }
        int m = kb.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = kb.nextInt();
        }

        System.out.println(T.solution(n, board, m, moves));
    }
}
