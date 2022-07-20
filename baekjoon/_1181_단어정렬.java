package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

//public class Main {
public class _1181_단어정렬 {

    private static String solution(int n, String[] arr) {
//        1. 길이가 짧은거부터
//        2. 길이가 동일하면 사전순
//        3. 중복제외

        // 4n

//        - distinct(n) -> sorted(n, comparator) -> ArrayList::new(n)
        ArrayList<String> strings = Arrays.stream(arr).distinct().sorted((o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        }).collect(Collectors.toCollection(ArrayList::new));

        // iter4StringBuilder(n)
        StringBuilder sb = new StringBuilder();
        for (String string : strings) {
            sb.append(string).append('\n');
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
