package huck.programmers.lv1;

public class 신규_아이디_추천 {
    public String solution(String new_id) {
//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
        String lower = new_id.toLowerCase();

//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        String lowerAlphabet = "a-z";
        String digit = "\\d";
        String hypen = "-";
        String lodash = "_";
        String dot = "\\.";
        String replaced1 = lower.replaceAll("[^" +
                lowerAlphabet + digit + hypen + lodash + dot +
                "]", "");

//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        String replaced2 = replaced1.replaceAll(dot + "{2,}", ".");

//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        String replaced3 = replaced2.replaceAll(
                "^" + dot + "|" + dot + "$",
                "");
//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        String replaced4 = "a";
        if (replaced3.length() > 0) {
            replaced4 = replaced3;
        }

//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        String replaced5 = "";
        int endIdx = replaced4.length();
        if (endIdx >= 16) {
            endIdx = 15;
            if (replaced4.charAt(14) == '.') {
                endIdx = 14;
            }
        }
        replaced5 = replaced4.substring(0, endIdx);

//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        while (replaced5.length() <= 2) {
            replaced5 = replaced5 + replaced5.charAt(replaced5.length() - 1);
        }
        return replaced5;
    }

    public static void main(String[] args) {
        신규_아이디_추천 T = new 신규_아이디_추천();
        String[] new_ids = new String[]{
//                "...!@BaT#*..y.abcdefghi.kl.",
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
            if (!results[i].equals(T.solution(new_ids[i]))) {
                System.out.println("false");
                System.out.println("new_ids[i] = " + new_ids[i]);
                System.out.println("results[i] = " + results[i]);
            }
        }
    }
}
