package huck.programmers.lv1;

import java.util.Arrays;

public class 로또의_최고_순위와_최저_순위 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        System.out.println("lottos = " + Arrays.toString(lottos) + ", win_nums = " + Arrays.toString(win_nums));


        int mc = 0, zeroCount = 0;
        int p1 = 0, p2 = 0;
        while (p1 < lottos.length && lottos[p1] == 0) {
            zeroCount++;
            p1++;
        }
        while (p1 < lottos.length && p2 < win_nums.length) {
            if (lottos[p1] == win_nums[p2]) {
                mc++;
                p1++;
                p2++;
            } else if (lottos[p1] > win_nums[p2]) {
                p2++;
            } else {
                p1++;
            }
        }

//        mc = mc ~ mc+zeroCount
        int maxMc = mc + zeroCount;
        int minMc = mc;

        if (maxMc >= 2) {
            answer[0] = 7 - maxMc;
        } else {
            answer[0] = 6;
        }
        if (minMc >= 2) {
            answer[1] = 7 - minMc;
        } else {
            answer[1] = 6;
        }
        return answer;
    }

    public static void main(String[] args) {
        로또의_최고_순위와_최저_순위 T = new 로또의_최고_순위와_최저_순위();

//        case1
//        int[] lottos = new int[]{44, 1, 0, 0, 31, 25};
//        int[] win_nums = new int[]{31, 10, 45, 1, 6, 19};
//        [3, 5]

//        case2
//        int[] lottos = new int[]{0, 0, 0, 0, 0, 0};
//        int[] win_nums = new int[]{38, 19, 20, 40, 15, 25};
//        [1, 6]

//        case3
        int[] lottos = new int[]{45, 4, 35, 20, 3, 9};
        int[] win_nums = new int[]{20, 9, 3, 45, 4, 35};
//        [1, 1]

        System.out.println(Arrays.toString(T.solution(lottos, win_nums)));
    }
}
