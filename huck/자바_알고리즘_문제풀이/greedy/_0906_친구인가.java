//https://cote.inflearn.com/contest/10/problem/09-05
package huck.자바_알고리즘_문제풀이.greedy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _0906_친구인가 {

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _0906_친구인가 T = new _0906_친구인가();
        FileInputStream fileInputStream = new FileInputStream("./huck/자바_알고리즘_문제풀이/greedy/_0906_친구인가.txt");
        Scanner kb = new Scanner(fileInputStream);

//        상호참조같은 느낌?
//        친구쌍 (a,b), (a,c), (d,e)가 주어졌을때 벤다이어그램으로 생각하면 편함

        int n = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<HashSet<Integer>> sets = new ArrayList<>();
        int setsCount = 0;

        int a = kb.nextInt();
        int b = kb.nextInt();
        HashSet<Integer> hs = new HashSet<>();
        hs.add(a);
        hs.add(b);
        setsCount++;
        sets.add(new HashSet<>(hs));

        for (int i = 1; i < m; i++) { // 친구쌍
            a = kb.nextInt();
            b = kb.nextInt();
            boolean newSet = true;

            for (int j = 0; j < setsCount; j++) { // sets 순회
                HashSet<Integer> set = sets.get(j);
                boolean checkA = set.contains(a);
                boolean checkB = set.contains(b);
                if (checkA || checkB) {
                    set.add(a);
                    set.add(b);
                    newSet = false;
                }
            }
            if (newSet) {
                hs = new HashSet<>();
                hs.add(a);
                hs.add(b);
                setsCount++;
                sets.add(new HashSet<>(hs));
            }
        }

        int i = kb.nextInt();
        int j = kb.nextInt();
        boolean flag = true;
        for (HashSet<Integer> set : sets) {
            boolean checkI = set.contains(i);
            boolean checkJ = set.contains(j);
            if (checkI && checkJ) {
                System.out.println("YES");
                flag = false;
            }
        }
        if (flag) {
            System.out.println("NO");
        }

//        for (HashSet<Integer> set : sets) {
//            System.out.println("set = " + set);
//        }
    }
}
