package huck.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class ReportResult {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        HashSet<String> s = new HashSet<>();
        HashMap<String, ArrayList<String>> reportListByUser = new HashMap<>(); // reporter, reported[]
        HashMap<String, Integer> reportedCountByUser = new HashMap<>(); // reported, reportedCount


        for (String reporterReported : report) {
//            중복 무시
            if (s.contains(reporterReported)) {
                continue;
            }
            s.add(reporterReported);

            String[] s1 = reporterReported.split(" ");
            String reporter = s1[0];
            String reported = s1[1];

            ArrayList<String> prevList = reportListByUser.getOrDefault(reporter, new ArrayList<>());
            prevList.add(reported);
            reportListByUser.put(reporter, prevList);

            reportedCountByUser.put(reported, reportedCountByUser.getOrDefault(reported, 0) + 1);
        }

        for (int i = 0; i < id_list.length; i++) {
            String reporter = id_list[i];
            for (String reported : reportListByUser.getOrDefault(reporter, new ArrayList<>())) {
                if (reportedCountByUser.getOrDefault(reported, 0) >= k) {
                    answer[i]++;
                }
            }
        }

        return answer;

    }

    public static void main(String[] args) {
        ReportResult T = new ReportResult();

        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
//        int[] result = {2, 1, 1, 0};

//        String[] id_list = {"con", "ryan"};
//        String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
//        int k = 3;
//        int[] result = {0, 0};

        System.out.println(Arrays.toString(T.solution(id_list, report, k)));
    }
}

