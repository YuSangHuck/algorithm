package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

//  answer = INF
//  D = 비용행렬
//  
//
//  findPath(start, last, visited, sum) // start는 시작도시, last는 최근도시, visited는 방문한도시, sum은 여태까지의합
//      if 모든도시방문
//          disToHome = D[last][start] 혹은 INF
//          answer = min(ans, sum + disToHome)
//
//      for leftCity in visited의여집합
//          if last와 leftCity가 연결되어있다면
//              visted에 leftCity 추가
//              findPath(start, leftCity, visited, sum + D[last][leftCity]
//              visted에 leftCity 제거

//public class Main {
public class _2098_외판원순회 {

    private static int n, start, ALL_VISITED, answer = Integer.MAX_VALUE;
    private static int[][] board;

    private static void dfs(int last, int visited, int sum) {
        if (visited == ALL_VISITED) {
            int costToStart = board[last][start];
            if (costToStart != 0) {
                answer = Math.min(answer, costToStart + sum);
            }
            return;
        }
        for (int left = 0; left < n; left++) {
            boolean notVisit = ((visited >> left) & 1) == 0;
            if (notVisit && board[last][left] != 0) {
                dfs(left, visited | (1 << left), sum + board[last][left]);
            }
        }
    }

    private static int solution() {
        ALL_VISITED = (1 << n) - 1;
        for (int i = 0; i < n; i++) {
            start = i;
            dfs(i, 1 << i, 0);
        }

        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner kb = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_2098_외판원순회.txt");
        Scanner kb = new Scanner(fileInputStream);

        n = kb.nextInt();
        board = new int[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                board[y][x] = kb.nextInt(); // 비용행렬
            }
        }
        System.out.println(solution());
    }
}
