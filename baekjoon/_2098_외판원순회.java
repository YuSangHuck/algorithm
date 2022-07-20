package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
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

//  dp
//  1. 중복케이스를 찾는다
//  -> 같은 인자에 대한 중복호출
//  -> ex)  dfs(2, {1,3,2}) -> dfs(4, {1,3,2,4})
//          dfs(3, {1,2,3}) -> dfs(4, {1,2,3,4})
//          last가 4이고, visited는 실제로 비트이므로 동일하다
//  -> 중복을 줄이기위한 dp의 캐시 크기만 정하면 됨
//      세개의 변수(start,last,V)
//      start,last는 n을 따라가고
//      V는 n개의 도시를 각각 0,1로 표현하므로 2^n
//      따라서 캐시 크기는 n^2*2^n
//  -> dp에서 시간복잡도는 캐시의 크기를 따라간다
//      따라서 시간복잡도는  O(n^2*2^n)
//  2. 한번 방문한 도시는 재방문하지 않는다
//      재방문하지 않고, 시작도시로 돌아온다
//      사이클
//      사이클이므로 시작지점은 무관하다
//      n이 하나 줄어 n*2^n

//public class Main {
public class _2098_외판원순회 {

    private static int n, start, ALL_VISITED;
    private static int[][] board;
    private static Integer[][] dp;

    private static int dfs(int last, int visited) {
        if (visited == ALL_VISITED) {
            return board[last][start] != 0 ? board[last][start] : Integer.MAX_VALUE;
        }

        if (dp[last][visited] != null) {
            return dp[last][visited];
        }

        int tmp = Integer.MAX_VALUE;
        for (int left = 0; left < n; left++) {
            boolean notVisit = ((visited >> left) & 1) == 0;
            if (notVisit && board[last][left] != 0) {
                tmp = Math.min(tmp,
                        dfs(left, visited | (1 << left)) + board[last][left]);
            }
        }
        dp[last][visited] = tmp;
        return tmp;
    }

    private static int solution() {
        ALL_VISITED = (1 << n) - 1;
        start = 0;
        return dfs(start, 1 << start);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner kb = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_2098_외판원순회.txt");
        Scanner kb = new Scanner(fileInputStream);

        n = kb.nextInt();
        board = new int[n][n];
        dp = new Integer[n][1 << n]; // [n]: last의 경우의수 n개, [1<<n]: visited의 상태값 경우의수 2^n
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                board[y][x] = kb.nextInt(); // 비용행렬
            }
        }
        System.out.println(solution());
    }
}
