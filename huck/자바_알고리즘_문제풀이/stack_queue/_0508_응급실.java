//https://cote.inflearn.com/contest/10/problem/05-07
package huck.자바_알고리즘_문제풀이.stack_queue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

class Person {
    private int id;
    private int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public int getPriority() {
        return priority;
    }
}

//public class Main {
public class _0508_응급실 {
    private int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(new Person(i, arr[i]));
        }

        while (!q.isEmpty()) {
//            진료받을놈 poll
            Person poll = q.poll();
//            대기중인놈 person
            for (Person person : q) {
                if (poll.getPriority() < person.getPriority()) {
                    q.offer(poll);
                    poll = null;
                    break;
                }
            }
            if (poll != null) {
                answer++;
                if (poll.getId() == m) {
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Main T = new Main();
        _0508_응급실 T = new _0508_응급실();
        FileInputStream fileInputStream = new FileInputStream("huck/자바_알고리즘_문제풀이/stack_queue/_0508_응급실_input.txt");
        Scanner kb = new Scanner(fileInputStream);
//        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(T.solution(n, m, arr));
    }

}
