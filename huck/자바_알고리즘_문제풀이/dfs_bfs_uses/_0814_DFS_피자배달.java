//https://cote.inflearn.com/contest/10/problem/08-14
package huck.자바_알고리즘_문제풀이.dfs_bfs_uses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//public class Main {
public class _0814_DFS_피자배달 {
    private static int n, m, answer = Integer.MAX_VALUE;
    private static int[][] board;
    private final static ArrayList<Point> houses = new ArrayList<>(), pizzas = new ArrayList<>();

    static class Point {
        private final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private void DFS(ArrayList<int[]> combinations, int n, int r, int depth, int startIdx, int[] combi, boolean[] visited) {
        if (depth == r) {
            combinations.add(combi.clone());
            return;
        }
        for (int i = startIdx; i < n; i++) {
            if (!visited[i]) {
                combi[depth] = i;
                visited[i] = true;
                DFS(combinations, n, r, depth + 1, i + 1, combi, visited);
                visited[i] = false;
            }
        }
    }

    private ArrayList<int[]> combi(int n, int r) {
//        0 ~ n-1중에 r개 선택
//        0 1 2
//        0 1 3
        ArrayList<int[]> combinations = new ArrayList<>();
        int[] combi = new int[r];
        boolean[] visited = new boolean[n];
        DFS(combinations, n, r, 0, 0, combi, visited);
        return combinations;
    }

    private int solution() {
//        l개의 피자집 중에서 m개의 조합을 구하고
        for (int[] combiOfPizzas : combi(pizzas.size(), m)) {
//            System.out.println(Arrays.toString(combiOfPizzas));
//            각 조합별로 도시의피자배달거리 구해서
            int[] disHouses = new int[houses.size()];
            for (int i = 0; i < disHouses.length; i++) {
                disHouses[i] = Integer.MAX_VALUE;
                Point house = houses.get(i);
                for (int pizzaIdx : combiOfPizzas) {
                    Point pizza = pizzas.get(pizzaIdx);
                    disHouses[i] = Math.min(disHouses[i],
                            Math.abs(pizza.x - house.x) + Math.abs(pizza.y - house.y));
                }
            }
//            그중에서 min을 출력
            int sum = 0;
            for (int disHouse : disHouses) {
                sum += disHouse;
            }
            answer = Math.min(answer, sum);
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
        _0814_DFS_피자배달 T = new _0814_DFS_피자배달();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/dfs_bfs_uses/_0814_DFS_피자배달.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        n = kb.nextInt(); // n by n
        m = kb.nextInt(); // m개의 피자집 살림, 살리는 기준은 도시의피자배달거리의 최소, 도시의피자배달거리는 각 집들의 피자배달거리의 합
//        이때 최소가 되는 도시의피자배달거리를 구하시오
        board = new int[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                int status = kb.nextInt();
                board[y][x] = status; // 0,1(집),2(피자집)
                if (status == 1) {
                    houses.add(new Point(x, y));
                } else if (status == 2) {
                    pizzas.add(new Point(x, y));
                }
            }
        }
        System.out.println(T.solution());
    }
}
