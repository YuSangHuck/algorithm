package huck.programmers.lv2;

import java.util.ArrayList;
import java.util.HashMap;

public class 오픈채팅방 {
    public String[] solution(String[] record) {
        final String ENTER = "Enter";
        final String LEAVE = "Leave";
        final String CHANGE = "Change";
        HashMap<String, String> actionDefineMap = new HashMap<>();
        actionDefineMap.put(ENTER, "들어왔습니다.");
        actionDefineMap.put(LEAVE, "나갔습니다.");
        actionDefineMap.put(CHANGE, "");

        HashMap<String, String> nicknameMap = new HashMap<>(); // <uid, nickname>
        ArrayList<String> actionLogList = new ArrayList<>(); // "{uid} {action}"

        for (String s : record) {
            String[] splits = s.split(" ");
            String action = splits[0];
            String uid = splits[1];
            String nickname;
            if (splits.length == 3) {
                nickname = splits[2];
                nicknameMap.put(uid, nickname);
            }

            if (!action.equals(CHANGE)) {
                actionLogList.add(uid + " " + action);
            }
        }
        String[] answer = new String[actionLogList.size()];

        for (int i = 0; i < actionLogList.size(); i++) {
            String[] splits = actionLogList.get(i).split(" ");
            String uid = splits[0];
            String action = splits[1];
//            Prodo 들어왔습니다, Ryan 들어왔습니다, Prodo 나갔습니다, Prodo 들어왔습니다
//            Prodo님이 들어왔습니다
            answer[i] = nicknameMap.get(uid) + "님이 " + actionDefineMap.get(action);
        }

        return answer;
    }

    public static void main(String[] args) {
        오픈채팅방 T = new 오픈채팅방();

        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        String[] result = {"Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."};

        String[] ret = T.solution(record);
        for (int i = 0; i < result.length; i++) {
            try {
                if (!result[i].equals(ret[i])) {
                    System.out.println("i = " + i);
                    System.out.println("result[i] = " + result[i]);
                    System.out.println("ret[i] = " + ret[i]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        double[] times = new double[]{9.61, 8.77, 8.73, 11.40, 12.68, 13.78, 15.05, 14.38, 13.03, 14.31, 11.62, 16.87, 13.81, 15.89, 10.33, 11.06, 9.90, 9.23, 12.57, 14.39, 12.07, 11.90, 12.98, 12.74, 148.14, 155.91, 145.34, 139.70, 205.01, 127.40, 141.64, 116.56};
        double[] memories = new double[]{72.8, 67.5, 75.5, 77.2, 81.7, 84.1, 82.8, 83.4, 86.8, 79.4, 80.9, 84.5, 79.3, 85.7, 74.3, 77.4, 80.6, 78.7, 79.7, 81.8, 77, 83.1, 80.2, 74.3, 176, 160, 168, 168, 171, 164, 154, 171};
        double sumTimes = 0, sumMemories = 0;
        for (int i = 0; i < times.length; i++) {
            sumTimes += times[i];
            sumMemories += memories[i];
        }
        System.out.println("avg time = " + sumTimes / times.length); // 47ms
        System.out.println("avg memories = " + sumMemories / times.length); // 102MB
    }
}
