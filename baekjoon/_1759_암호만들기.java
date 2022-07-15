package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//public class Main {
public class _1759_암호만들기 {

    private static int l, c;
    // 모음, ai
    private final ArrayList<Integer> consonants = new ArrayList<>(); // 자음
    private final ArrayList<Integer> vowels = new ArrayList<>(); // 모음
    private final TreeSet<MyArrayList> ts = new TreeSet<>();
    private ArrayList<Integer> others;
    private int n, r;
    private final MyArrayList example = new MyArrayList();

    static class MyArrayList extends ArrayList<Integer> implements Comparable<MyArrayList> {

        public MyArrayList() {
            super();
        }

        public MyArrayList(MyArrayList example) {
            super(example);
        }

        @Override
        public int compareTo(MyArrayList o) {
            int sizeOfThis = size();
            int sizeOfO = o.size();
            if (sizeOfThis == sizeOfO) {
                for (int i = 0; i < sizeOfThis; i++) {
                    int nOfThis = get(i);
                    int nOfO = o.get(i);
                    if (nOfThis > nOfO) {
                        return 1; // this가 o 뒤에
                    } else if (nOfO > nOfThis) {
                        return -1; // o가 this 뒤에
                    }
                }
            }
            return 0;
        }
    }

    private void dfs(int d, int s) {
        if (d == r) {
            ts.add(new MyArrayList(example));
            return;
        }
        int prev = example.get(2 + d);
        for (int i = s; i < n; i++) {
            int cur = others.get(i);
//            if (prev > cur) {
//                return;
//            }
            example.set(3 + d, cur);
            dfs(d + 1, i + 1);
        }
    }

    private void solution(int l, char[] chars) {
        Arrays.sort(chars);
        for (int i = 0; i < l; i++) {
            example.add(0);
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                consonants.add(i); // 모음, 오름차순
            } else {
                vowels.add(i); // 자음, 오름차순
            }
        }

//        l 길이의 암호
//        모음은 최소1개, 자음은 최소2개
//        자음조합 구하고, 각 조합에서 모음 loop
        for (int i = 0; i < consonants.size(); i++) {
            int c1 = consonants.get(i);
            int s = 0;
            for (int j = 0; j < vowels.size(); j++) {
                if (c1 < vowels.get(j)) {
                    s = j;
                    break;
                }
            }
            for (int j = s; j < vowels.size(); j++) {
                for (int k = j + 1; k < vowels.size(); k++) {
//                    fixed
//                    chars[consonants.get(i); // 모음
//                    chars[vowels.get(j)]; chars[vowels.get(k)]; // 자음
                    int v1 = vowels.get(j);
                    int v2 = vowels.get(k);
                    example.set(0, c1);
                    example.set(1, v1);
                    example.set(2, v2);

                    others = new ArrayList<>();
                    for (int m = i + 1; m < consonants.size(); m++) {
                        others.add(consonants.get(m));
                    }
                    for (int m = k + 1; m < vowels.size(); m++) {
                        others.add(vowels.get(m));
                    }

                    n = others.size();
                    r = l - 3;
//                    dfs(0, 0);
                }
            }
        }

        for (ArrayList<Integer> t : ts) {
            System.out.println(t);
        }

    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
//        Scanner kb = new Scanner(System.in);
        _1759_암호만들기 T = new _1759_암호만들기();
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_1759_암호만들기.txt");
        Scanner kb = new Scanner(fileInputStream);

        l = kb.nextInt();
        c = kb.nextInt();
        char[] chars = new char[c];
        int i = 0;
        kb.nextLine();
        String s1 = kb.nextLine();
        for (String s : s1.split(" ")) {
            chars[i++] = s.charAt(0);
        }

        T.solution(l, chars);
    }
}
