package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _1759_암호만들기 {

    private static int r, n;
    private static int[] combi;
    private static char[] chars;

    private void dfs(int d, int s, int cCount, int vCount) { // 모음카운트, 자음카운트
//        r-d // 남은개수
        int remainCount = r - d;
        if (remainCount < cCount || remainCount < vCount) {
            return;
        }
        if (d == r) {
            StringBuilder sb = new StringBuilder();
            for (int i : combi) {
                sb.append(chars[i]);
            }
            System.out.println(sb);
            return;
        }
        for (int i = s; i < n; i++) {
            combi[d] = i;
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                dfs(d + 1, i + 1, cCount - 1, vCount);
            } else {
                dfs(d + 1, i + 1, cCount, vCount - 1);
            }
        }

    }

    private void solution() {
        Arrays.sort(chars);
//        chars에서 l개 뽑는 조합
        dfs(0, 0, 1, 2);
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _1759_암호만들기 T = new _1759_암호만들기();
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_1759_암호만들기.txt");
        Scanner kb = new Scanner(fileInputStream);

        r = kb.nextInt();
        combi = new int[r];
        n = kb.nextInt();
        chars = new char[n];
        kb.nextLine();
        String s1 = kb.nextLine();
        int i = 0;
        for (String s : s1.split(" ")) {
            chars[i++] = s.charAt(0);
        }

        T.solution();
    }
}
