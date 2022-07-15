package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _14889_스타트와링크 {

    private static int[][] board;
    private static int n, r, answer = Integer.MAX_VALUE;
    private static int[] teamA, teamB;

    private void dfs(int d, int s) {
        if (d == r) {
            int sumA = 0;
            int sumB = 0;
            int p = 0;
            for (int i = 0; i < n; i++) {
                boolean isTeamA = false;
                for (int j = 0; j < r; j++) {
                    if (i == teamA[j]) {
                        isTeamA = true;
                        break;
                    }
                }
                if (!isTeamA) {
                    teamB[p++] = i;
                }

            }
            for (int i = 0; i < r; i++) {
                for (int j = i + 1; j < r; j++) {
                    sumA = sumA + board[teamA[i]][teamA[j]] + board[teamA[j]][teamA[i]];
                    sumB = sumB + board[teamB[i]][teamB[j]] + board[teamB[j]][teamB[i]];
                }
            }
            answer = Math.min(answer, Math.abs(sumA - sumB));
            return;
        }

        for (int i = s; i < n; i++) {
            teamA[d] = i;
            dfs(d + 1, i + 1);
        }
    }

    private void solution() {
//        스타트팀, 링크팀
//        팀별 능력치는 sum(Sij)이다
//        Sij를 S(i,j)로 표현하면 S(i,j) = Sij + Sji
//        4명이고 2명씩이면
//        = S(0,1) /S(2,3)
//        = S01 + S10 / S23 S32
//        6명이고 3명씩이면
//        = S(0,1) + S(0,2) + S(1,2) / S(3,4) + S(3,5) + S(4,5)

//        조합구하면 됨. nCn/2
        int d = 0;
        int s = 0;
        dfs(d, s);
        System.out.println(answer);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _14889_스타트와링크 T = new _14889_스타트와링크();
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_14889_스타트와링크.txt");
        Scanner kb = new Scanner(fileInputStream);

        n = kb.nextInt(); // 짝수
        r = n / 2;
        teamA = new int[r];
        teamB = new int[r];
        board = new int[n][n];
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                board[y][x] = kb.nextInt();
            }
        }
        T.solution();
    }
}
