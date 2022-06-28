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

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < actionLogList.size(); i++) {
            sb.delete(0, sb.length());
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


        double[] times = new double[]{8.48, 8.63, 9.87, 8.55, 13.32, 12.84, 12.77, 12.37, 14.26, 12.75, 11.90, 12.72, 13.35, 13.18, 8.25, 8.40, 9.10, 9.31, 15.77, 11.58, 12.12, 12.49, 12.95, 13.25, 118.86, 134.32, 139.14, 135.77, 129.57, 119.55, 121.42, 112.38};
        double[] memories = new double[]{85.6, 76, 89.8, 77.8, 86.1, 82.5, 84.2, 82.6, 84.5, 86.6, 82, 80, 76.1, 85.8, 79, 77.4, 77.9, 78.4, 82, 86.2, 76, 92.9, 81.5, 97.7, 174, 185, 175, 185, 195, 186, 177, 183};
        double sumTimes = 0, sumMemories = 0;
        for (int i = 0; i < times.length; i++) {
            sumTimes += times[i];
            sumMemories += memories[i];
        }
        System.out.println("avg time = " + sumTimes / times.length); // 41ms
        System.out.println("avg memories = " + sumMemories / times.length); // 108MB
    }
}
