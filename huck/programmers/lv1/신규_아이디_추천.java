package huck.programmers.lv1;

public class 신규_아이디_추천 {
    public String solution(String new_id) {
//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        StringBuilder sb = new StringBuilder(new_id.toLowerCase());

//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        int p = 0;
        int loopCount = sb.length();
        for (int i = 0; i < loopCount; i++) {
//            삭제하면 p유지
            if (
                    !(('a' <= sb.charAt(p) && sb.charAt(p) <= 'z') ||
                            ('0' <= sb.charAt(p) && sb.charAt(p) <= '9') ||
                            (sb.charAt(p) == '-') ||
                            (sb.charAt(p) == '_') ||
                            (sb.charAt(p) == '.'))
            ) {
                sb.deleteCharAt(p);
            } else {
//            삭제안하면 p++
                p++;
            }
        }

//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        p = 0;
        loopCount = sb.length() - 1;
        for (int i = 0; i < loopCount; i++) {
//            sb.charAt(p), sb.charAt(1 + p) 비교
//            삭제하면 p유지
            if (sb.charAt(p) == '.' && sb.charAt(1 + p) == '.') {
                sb.deleteCharAt(p);
            } else {
//            삭제안하면 p++
                p++;
            }
        }

//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (sb.length() > 0 && sb.charAt(0) == '.') {
            sb.deleteCharAt(0);
        }
        int endIdx = sb.length();
        if (endIdx > 0 && sb.charAt(endIdx - 1) == '.') {
            sb.deleteCharAt(endIdx - 1);
        }

//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (sb.length() == 0) {
            sb.append('a');
        }

//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (sb.length() >= 16) {
            sb = new StringBuilder(sb.substring(0, 15));
            endIdx = sb.length();
            if (sb.charAt(endIdx - 1) == '.') {
                sb.deleteCharAt(endIdx - 1);
            }
        }

//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while (sb.length() < 3) {
            sb.append(sb.charAt(sb.length() - 1));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        신규_아이디_추천 T = new 신규_아이디_추천();
        String[] new_ids = new String[]{
                "...!@BaT#*..y.abcdefghijklm",
                "z-+.^.",
                "=.=",
                "123_.def",
                "abcdefghijklmn.p"
        };
        String[] results = new String[]{
                "bat.y.abcdefghi",
                "z--",
                "aaa",
                "123_.def",
                "abcdefghijklmn"
        };

        for (int i = 0; i < new_ids.length; i++) {
            String ret = T.solution(new_ids[i]);
            if (!results[i].equals(ret)) {
                System.out.println("false: " + i + ", ret: " + ret);
                System.out.println("new_ids[i] = " + new_ids[i]);
                System.out.println("results[i] = " + results[i]);
            }
        }
    }
}
