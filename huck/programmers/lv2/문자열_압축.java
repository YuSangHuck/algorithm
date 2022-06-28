package huck.programmers.lv2;

public class 문자열_압축 {
    public int solution(String s) {
//        System.out.println("str = " + str + ", length = " + str.length());
        int answer = s.length();
//        string을 k길이로 잘라서 압축했을때, 결과가 가장 짧은것
//        단, k는 1 ~ str.length()
        for (int k = 1; k <= s.length() / 2; k++) {
            String compressed = "";
            int cnt = 1;
            int p1 = 0;

            String prevSubString = s.substring(p1, p1 + k);
            p1 += k;
            while (p1 + k <= s.length()) {
                String substring = s.substring(p1, p1 + k);
                if (prevSubString.equals(substring)) {
                    cnt++;
                } else {
                    if (cnt == 1) {
                        compressed = compressed + prevSubString;
                    } else {
                        compressed = compressed + cnt + prevSubString;
                    }
                    cnt = 1;
                }
                prevSubString = substring;
                p1 += k;
            }
            if (cnt == 1) {
                compressed = compressed + prevSubString;
            } else {
                compressed = compressed + cnt + prevSubString;
            }

            compressed += s.substring(p1);
//            System.out.println("k = " + k + ", compressed = " + compressed);

            answer = Math.min(compressed.length(), answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        문자열_압축 T = new 문자열_압축();
        String[] strings = {
                "a",
                "aabbaccc",
                "ababcdcdababcdcd",
                "abcabcdede",
                "abcabcabcabcdededededede",
                "xababcdcdababcdcd"
        };
        int[] results = new int[]{
                1,
                7,
                9,
                8,
                14,
                17
        };

        for (int i = 0; i < strings.length; i++) {
            if (results[i] != T.solution(strings[i])) {
                System.out.println("i = " + i);
                System.out.println("T.solution(strings[i]) = " + T.solution(strings[i]));
            }
        }

//        double[] times = new double[]{12.60, 13.69, 13.18, 12.38, 0.01, 11.91, 16.55, 13.57, 14.16, 16.54, 12.02, 12.59, 16.45, 19.41, 13.27, 1.07, 20.84, 13.92, 16.72, 17.21, 16.28, 17.46, 23.58, 22.54, 18.54, 17.47, 23.32, 11.89};
//        double[] memories = new double[]{78.5, 80.4, 77.6, 74.5, 74.9, 79.8, 86.4, 80.6, 84.4, 80.8, 75.1, 74.3, 75.9, 84.1, 76.5, 74.6, 75.7, 76.3, 89.2, 80.8, 79.4, 79.7, 84, 86.6, 83.8, 85.9, 84.3, 75};
//        double sumTimes = 0, sumMemories = 0;
//        for (int i = 0; i < times.length; i++) {
//            sumTimes += times[i];
//            sumMemories += memories[i];
//        }
//        System.out.println("avg time = " + sumTimes / times.length); // 15ms
//        System.out.println("avg memories = " + sumMemories / times.length); // 80MB
    }
}
