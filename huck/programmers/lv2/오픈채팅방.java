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
            StringBuilder sb = new StringBuilder();
            String[] splits = actionLogList.get(i).split(" ");
            String uid = splits[0];
            String action = splits[1];
//            Prodo 들어왔습니다, Ryan 들어왔습니다, Prodo 나갔습니다, Prodo 들어왔습니다
//            Prodo님이 들어왔습니다
            sb.append(nicknameMap.get(uid));
            sb.append("님이 ");
            sb.append(actionDefineMap.get(action));
            answer[i] = sb.toString();
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


        double[] times = new double[]{8.53, 9.02, 8.72, 9.28, 14.02, 12.71, 16.52, 13.27, 13.25, 14.17, 14.53, 11.82, 12.30, 13.35, 10.21, 8.56, 11.25, 8.99, 13.44, 12.07, 12.36, 11.63, 15.72, 12.92, 126.04, 135.64, 143.67, 131.11, 130.61, 111.94, 132.95, 109.49};
        double[] memories = new double[]{73.8, 77.4, 78.8, 82.3, 89.1, 88.7, 86, 96.8, 82.2, 92.1, 88.9, 74.7, 87.5, 77.9, 78.3, 80.6, 80.8, 79, 91.7, 87.8, 85.2, 77.2, 77.2, 73.3, 189, 179, 178, 186, 174, 165, 183, 174};
        double sumTimes = 0, sumMemories = 0;
        for (int i = 0; i < times.length; i++) {
            sumTimes += times[i];
            sumMemories += memories[i];
        }
        System.out.println("avg time = " + sumTimes / times.length); // 41ms
        System.out.println("avg memories = " + sumMemories / times.length); // 106MB
    }
}
