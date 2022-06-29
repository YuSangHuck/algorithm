package huck.programmers.lv3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class 추석_트래픽 {
    //    "2016-09-15 01:00:04.001 2.0s"
    private int[] timestampToMilliseconds(String timestamp) {
        String[] splits = timestamp.split(" "); // ["2016-09-15, 01:00:04.001, 2.0s"]
        // "2016-09-15"
        String endAt = splits[1]; // "01:00:04.001"
        String substring = splits[2].substring(0, splits[2].length() - 1); // "2.0"
        int duration = (int) (Double.parseDouble(substring) * 1000);// 2000

        String[] split = endAt.split(":");
        String hh = split[0]; // hh
        String mm = split[1]; // mm
        String ss_sss = split[2]; // ss.sss
        int convertMinutes = (int) TimeUnit.MILLISECONDS.convert(Integer.parseInt(mm), TimeUnit.MINUTES);
        int convertHours = (int) TimeUnit.MILLISECONDS.convert(Integer.parseInt(hh), TimeUnit.HOURS);
        int convertSeconds = (int) (Double.parseDouble(ss_sss) * 1000);// 2000

        int endAtMs = convertHours + convertMinutes + convertSeconds;
        int startAtMs = endAtMs - duration + 1; // endAt - processingTime
        return new int[]{startAtMs, endAtMs};
    }

    public int solution(String[] lines) {
//        System.out.println("lines = " + Arrays.deepToString(lines));
        int answer = Integer.MIN_VALUE;

        ArrayList<Integer> checkPoints = new ArrayList<>();

//        동시처리량이 변화하는 point는 각 요청의 시작과 끝
//        즉,  모든 요청의 시작과 끝만 검사하면 됨
//        loop를 위해 모든 요청을 flat하게 변환
        for (String line : lines) {
            int[] ints = timestampToMilliseconds(line);

            checkPoints.add(ints[0]);
            checkPoints.add(ints[1]);
        }

//        flatten된걸 오름차순으로 sort
        Collections.sort(checkPoints);

        for (Integer sCheck : checkPoints) {
//            검사지점은 sCheck ~ eCheck
            int eCheck = sCheck + 999;

//            모든 로그에 대해서 start, end 체크
            int cnt = 0;
            for (String line : lines) {
                int[] log = timestampToMilliseconds(line);
                int sLog = log[0];
                int eLog = log[1];

                if (sLog <= eCheck && eLog >= sCheck) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }


        return answer;
    }

    public static void main(String[] args) {
        추석_트래픽 T = new 추석_트래픽();
        String[][] input = {
                {
                        "2016-09-15 01:00:04.001 2.0s",
                        "2016-09-15 01:00:07.000 2s"
                },
                {
                        "2016-09-15 01:00:04.002 2.0s",
                        "2016-09-15 01:00:07.000 2s"
                },
                {
                        "2016-09-15 20:59:57.421 0.351s",
                        "2016-09-15 20:59:58.233 1.181s",
                        "2016-09-15 20:59:58.299 0.8s",
                        "2016-09-15 20:59:58.688 1.041s",
                        "2016-09-15 20:59:59.591 1.412s",
                        "2016-09-15 21:00:00.464 1.466s",
                        "2016-09-15 21:00:00.741 1.581s",
                        "2016-09-15 21:00:00.748 2.31s",
                        "2016-09-15 21:00:00.966 0.381s",
                        "2016-09-15 21:00:02.066 2.62s"
                }
        };

        int[] result = {
                1,
                2,
                7
        };

        for (int i = 0; i < input.length; i++) {
            int ret = T.solution(input[i]);
            if (ret != result[i]) {
                System.out.println("i = " + i);
                System.out.println("result[i] = " + result[i]);
                System.out.println("ret = " + ret);
            }
        }

//        double[] times = new double[]{3.58, 820.94, 832.49, 1.42, 32.25, 32.53, 785.66, 805.17, 35.11, 2.75, 3.23, 924.94, 47.80, 1.84, 1.20, 1.28, 1.26, 2811.76, 2822.22, 2722.07, 1.19, 1.16};
//        double[] memories = new double[]{76, 385, 396, 76.1, 104, 107, 399, 403, 98, 78.6, 77.7, 390, 102, 80.7, 80.7, 74.3, 71, 391, 395, 384, 74.6, 74.4};
//        double sumTimes = 0, sumMemories = 0;
//        for (int i = 0; i < times.length; i++) {
//            sumTimes += times[i];
//            sumMemories += memories[i];
//        }
//        System.out.println("avg time = " + sumTimes / times.length); // 577ms
//        System.out.println("avg memories = " + sumMemories / times.length); // 197MB
    }
}
