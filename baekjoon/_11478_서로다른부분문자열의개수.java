package baekjoon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

//public class Main {
public class _11478_서로다른부분문자열의개수 {
    private static int solution(String s) {
        HashSet<String> hashSet = new HashSet<>();
        int l = s.length();
        for (int lt = 0; lt < l; lt++) {
            for (int rt = lt; rt < l; rt++) {
                hashSet.add(s.substring(lt, rt + 1));
            }
        }
        return hashSet.size();
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner kb = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream("./baekjoon/_11478_서로다른부분문자열의개수.txt");
        Scanner kb = new Scanner(fileInputStream);

        String s = kb.next();
        System.out.println(solution(s));
    }
}
