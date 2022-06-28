package huck.programmers.lv2;

public class 문자열_압축 {
    public int solution(String s) {
//        System.out.println("str = " + str + ", length = " + str.length());
        int answer = s.length();
//        string을 k길이로 잘라서 압축했을때, 결과가 가장 짧은것
//        단, k는 1 ~ str.length()
        for (int k = 1; k <= s.length() / 2; k++) {
            StringBuilder compressed = new StringBuilder();
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
                        compressed.append(prevSubString);
                    } else {
                        compressed.append(cnt).append(prevSubString);
                    }
                    cnt = 1;
                }
                prevSubString = substring;
                p1 += k;
            }
            if (cnt == 1) {
                compressed.append(prevSubString);
            } else {
                compressed.append(cnt).append(prevSubString);
            }

            compressed.append(s.substring(p1));
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

//        double[] times = new double[]{0.09, 0.54, 0.18, 0.06, 0.01, 0.06, 0.37, 0.35, 0.81, 2.39, 0.11, 0.10, 0.11, 0.53, 0.11, 0.04, 1.02, 0.87, 0.95, 2.52, 2.48, 3.26, 2.35, 2.22, 2.49, 2.40, 2.40, 0.05};
//        double[] memories = new double[]{75.6, 73.5, 74.5, 74, 75.5, 67.8, 73.2, 70.6, 77.4, 77, 73.6, 75, 73.1, 76.4, 72.1, 73.8, 72.9, 73.9, 70.7, 74.1, 76.6, 80.4, 73.7, 77.1, 79.4, 76.3, 75.6, 74.4};
//        double sumTimes = 0, sumMemories = 0;
//        for (int i = 0; i < times.length; i++) {
//            sumTimes += times[i];
//            sumMemories += memories[i];
//        }
//        System.out.println("avg time = " + sumTimes / times.length); // 1ms
//        System.out.println("avg memories = " + sumMemories / times.length); // 75MB
    }
}
