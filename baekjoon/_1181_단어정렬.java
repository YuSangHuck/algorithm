package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//public class Main {
public class _1181_단어정렬 {
    static class CustomString implements Comparable<CustomString> {
        String s;

        public CustomString(String s) {
            this.s = s;
        }

        @Override
        public int compareTo(CustomString o) {
            if (s.length() == o.s.length()) {
                return s.compareTo(o.s);
            } else {
                return s.length() - o.s.length();
            }
        }
    }

    private static String solution(int n, String[] arr) {
//        1. 길이가 짧은거부터
//        2. 길이가 동일하면 사전순
//        3. 중복제외

        // ㅁㄹ 젤 느림

        HashMap<String, Boolean> hashMap = new HashMap<>();
        ArrayList<CustomString> strings = new ArrayList<>();
//        distinct,ArrayList::new(n)
        for (String key : arr) {
            Boolean hasKey = hashMap.getOrDefault(key, false);
            if (!hasKey) {
                strings.add(new CustomString(key));
                hashMap.put(key, true);
            }
        }
//        sorted(n, comparator)
        strings.sort(null);

        // iter4StringBuilder(n)
        StringBuilder sb = new StringBuilder();
        for (CustomString string : strings) {
            sb.append(string.s).append('\n');
        }
        return sb.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner kb = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_1181_단어정렬.txt");
        Scanner kb = new Scanner(fileInputStream);

        int n = kb.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.next();
        }
        System.out.println(solution(n, arr));
    }
}
