package huck.programmers.lv3;

import java.util.concurrent.TimeUnit;

public class 추석_트래픽 {
    //        2016-09-15 hh:mm:ss.sss
    int getMilliseconds(String date, String time) {
        String[] split = time.split(":");
        String hh = split[0]; // hh
        String mm = split[1]; // mm
        String ss_sss = split[2]; // ss.sss
        int convertMinutes = (int) TimeUnit.MILLISECONDS.convert(Integer.parseInt(mm), TimeUnit.MINUTES);
        int convertHours = (int) TimeUnit.MILLISECONDS.convert(Integer.parseInt(hh), TimeUnit.HOURS);
        int convertSeconds = getMilliSecondsFromSeconds(ss_sss);

        return convertHours + convertMinutes + convertSeconds;
    }

    private int getMilliSecondsFromSeconds(String ss_sss) {
        return (int) (Double.parseDouble(ss_sss) * 1000);
    }

    public int solution(String[] lines) {
//        System.out.println("lines = " + Arrays.deepToString(lines));
        int answer = Integer.MIN_VALUE;

        int[] startAtList = new int[lines.length];
        int[] endAtList = new int[lines.length];


        for (int i = 0; i < lines.length; i++) {
            String[] splits = lines[i].split(" "); // "2016-09-15 01:00:04.001 2.0s"
            String date = splits[0]; // "2016-09-15"
            String endAt = splits[1]; // "01:00:04.001"
            String substring = splits[2].substring(0, splits[2].length() - 1); // "2.0"
            int duration = getMilliSecondsFromSeconds(substring); // 2000

            endAtList[i] = getMilliseconds(date, endAt); // endAt
            startAtList[i] = endAtList[i] - duration + 1; // endAt - processingTime
        }


//        1. 1초 구간 설정. start의 최소값은 알수 없고, 최대값은 endAtList의 마지막값이다
//            설정된 구간은 시작과 끝을 포함하므로 start ~ start+999이다
//            즉, 설정된 구간 interval은 start ~ start+999이다

//         20:59:59.300
//        start가  20:59:58.233보다 조금 더 작을때
        for (int end = endAtList[0]; end <= endAtList[lines.length - 1]; end++) {
            int start = end - 999;
            int idx = 0;
            int cnt = 0;
            while (idx < lines.length) {
                if (start <= endAtList[idx] &&
                        end >= startAtList[idx]) {
                    cnt++;
                }
                idx++;
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


//        double[] times = new double[]{8.48, 8.63, 9.87, 8.55, 13.32, 12.84, 12.77, 12.37, 14.26, 12.75, 11.90, 12.72, 13.35, 13.18, 8.25, 8.40, 9.10, 9.31, 15.77, 11.58, 12.12, 12.49, 12.95, 13.25, 118.86, 134.32, 139.14, 135.77, 129.57, 119.55, 121.42, 112.38};
//        double[] memories = new double[]{85.6, 76, 89.8, 77.8, 86.1, 82.5, 84.2, 82.6, 84.5, 86.6, 82, 80, 76.1, 85.8, 79, 77.4, 77.9, 78.4, 82, 86.2, 76, 92.9, 81.5, 97.7, 174, 185, 175, 185, 195, 186, 177, 183};
//        double sumTimes = 0, sumMemories = 0;
//        for (int i = 0; i < times.length; i++) {
//            sumTimes += times[i];
//            sumMemories += memories[i];
//        }
//        System.out.println("avg time = " + sumTimes / times.length); // 41ms
//        System.out.println("avg memories = " + sumMemories / times.length); // 108MB
    }
}
