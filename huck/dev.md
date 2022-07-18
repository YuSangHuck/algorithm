# 자바_알고리즘_문제풀이

## input

- Scanner class
    - Scanner(InputStream) // 생성자
        - Scanner kb = new Scanner(new FileInputStream("./input.txt"))
        - Scanner kb = new Scanner(System.in)
    - next() // 공백까지 read
    - nextLine() // 한줄 read
    - nextInt() // int 타입 반환
    - 팁
        - 2차원 배열 사이즈를 아는 경우
            - kb.nextInt()로 n번

## string

> String.replaceAll(regex, replacement)\
> StringBuilder.reverse

- String class // String.value는 immutable
    - toUpperCase, toLowerCase
    - charAt(int index)
        - string에서 특정 index에 있는 문자 반환
    - toCharArray()
        - String to char[]
    - split(String regex)
    - `replaceAll(regex, replacement)`
        - [^A-Z] // A-Z로 시작하지 않는것
        - replaceAll(regex, "") // regex에 해당안되는거 전부 삭제
        - `replaceAll([^A-Z], "") // A-Z가 아닌거 전부 삭제`
- StringBuilder class // AbstractStringBuilder.value는 mutable
    - 기본적으로 String과 비슷하나 Appendable만 추가로 implements한거
    - append
    - `reverse`
        - 직접구현하면
            - lt=0, rt = length-1
            - while(lt < rt) swap(lt,rt)
    - 팁
        - `palindrome`
            - 회문은 for ( i < length/2 )
- Character class
    - isLowerCase(c)
    - toLowerCase(c)
    - isAlphabetic(c)
- Integer class
    - parseInt(string, radix) // 2진수를 10진수로

## Collections

> List, Set, Map, Queue, PriorityQueue, Stack

- Array built-in type
    - 걍 배열
    - Collections은 아님
- List interface
    - ArrayList // most
    - LinkedList
- Set interface
    - HashSet // most
    - TreeSet
    - LinkedHashSet
- Map interface
    - HashMap // most
    - TreeMap
    - LinkedHashMap
- Queue interface
    - ArrayDeque
    - LinkedList
- PriorityQueue class
    - PriorityQueue
- Stack class
    - Stack

## Sort

> 자바의 default 정렬은 오름차순(asc)임

- 비교기
    - Comparable<T> interface
        - compareTo(T o)
            - this와 파라미터 o를 비교
                - 오름차순(this, o 순서로 정렬)
                    - return -1
                    - return this - o // 단순 정수면 이렇게 하면 됨
                - 내림차순(o, this 순서로 정렬)
                    - return 1
                    - return o - this // 단순 정수면 이렇게 하면 됨
    - Comparator<T> interface
        - compare(T o1, T o2);
            - 비교대상이 this와 무관한 인자 o1,o2개
            - 보통 익명객체로 여러 비교기 만들어서 호출함
- 정렬
    - Arrays.sort // 오로지 Array만
    - Collections.sort // List implements한놈이면 가능
        - 내부적으로 아래의 List.sort(null) 호출
    - List.sort(Comparator) // 잘 안씀
        - List에 정의된 비교기 외에 1회성 정렬규칙인경우
        - 보통 람다씀

## 반복문

- loop 횟수가 고정
    - for
- loop 횟수가 미정
    - while

## twoPointer_slidingWindow

> 효율성 : O(n^2)-->O(n)

- twoPointer 포인터 변수명
    - 하나의 배열에서
        - lt, rt
    - n개의 배열에서
        - p1, p2, ...
- slidingWindow
    - 윈도우 크기가 m이면
    - 이전값 + arr[i] - arr[i-m]

## hashMap_treeSet

> 해쉬, 정렬지원 Set

- HashMap // hm // O(1)로 접근하기 위함
    - E get(key)
    - E getOrDefault(key, defaultValue)
    - Set<E> keySet()
    - boolean containsKey(key)
    - size() // return sizeOfKeys // 당연하게도 특정 key의 value가 0이라면 이것도 count함
    - remove(key)
    - equal(hashMap) // key와 key에 걸린 value까지 전부 체크해서 return
        - `value가 primitive가 아니면? 주소는 다르지만 값은 같은 클래스같은경우`
- TreeSet // ts // rbt기반의 set. 중복제거 + 정렬
    - new TreeSet<>(Collections.reverseOrder()) // Desc
    - add
    - remove
    - size
    - first
    - last
- 팁
    - hm에 길이가 k인 문자열의 각 문자를 key로 넣는 상황이라면 loop 전에 k-1개를 우선 hm에 셋해주면 편하다
    - HashMap // 탐색[O(1)]
    - Set // 중복제거
    - TreeSet // 중복제거 + 정렬
    - TreeMap // 탐색[rbt이므로 O(logN)] + 정렬.

## stack_queue

> 괄호있으면(쌍으로 묶이는 거) 보통 스택

- stack // Stack<E> var = new Stack<>();
    - push
    - pop
    - peek
    - size
    - isEmpty
- queue // Queue<E> var = new LinkedList<>();
    - offer, add // 값, 예외
    - pool, remove // 값, 예외
    - peek, element // 값, 예외
    - size
    - isEmpty

## regex

### character class

> 문자 집합

- character set
    - [aeiou]
    - 집합에 `포함된` 문자외 매칭
    - string = "gl`i`b j`o`cks"
        - matches: 2
- negated set
    - [^aeiou]
    - 집합에 `포함안된` 문자외 매칭
    - string = "`g``l`i`b`` ``j`o`c``k``s`"
        - matches: 8
- dot
    - .
    - `개행 제외` 모든 문자와 매칭
    - [^\n\r]와 동일하다
    - string = "`g``l``i``b`` ``j``o``c``k``s`"
        - matches: 10
- match any
    - [\s\S]
    - `개행 포함` 모든 문자와 매칭
    - string = "`g``l``i``b`` ``j``o``c``k``s`"
        - matches: 10
- word
    - \w
    - [A-Za-z0-9_]와 동일
    - string = "`g``l``i``b` `j``o``c``k``s`"
        - matches: 9
- not word
    - \W
    - [^A-Za-z0-9_]와 동일
    - string = "glib` `jocks"
        - matches: 1
- digit
    - \d
    - string = "glib jocks`1``2`"
        - matches: 2
- not digit
    - \D
    - string = "`g``l``i``b`` ``j``o``c``k``s`12"
        - matches: 10
- whitespace
    - \s
    - string = "glib` `jocks"
        - matches: 1
- not whitespace
    - \S
    - string = "`g``l``i``b` `j``o``c``k``s`"
        - matches: 9

### anchor

> 문자열 내에서 특정 positon 조건\
> ^[a-z]+[A-Z]+$ // 소문자 시작해서 주르륵 후 대문자 주르륵으로 끝

- beginning
    - ^
    - 문자열의 `시작부분과` 매칭
    - regex = "^\w+", string = "`she` sells seashells"
        - matches: 1
    - regex = "^\w", string = "`s`he sells seashells"
        - matches: 1
- end
    - $
    - 문자열의 `끝부분과` 매칭
    - regex = "\w+$", string = "she sells `seashells`"
        - matches: 1
    - regex = "\w$", string = "she sells seashell`s`"
        - matches: 1
- [word boundary](https://ohgyun.com/392)
    - \b
    - 단어의 경계에 해단되는 위치와 매칭
    - 단어의 경계
        - between character, non-word character
        - position(start / end of string)
    - regex = "s\b", string = "she sell`s` seashell`s`"
        - matches: 2
    - regex = "\w\b", string = "sh`e` sell`s` seashell`s`"
        - matches: 3
    - regex = "\w+\b", string = "`she` `sells` `seashells`"
        - matches: 3
- not word boundary
    - \B
    - 단어가 아닌 경계에 해단되는 위치와 매칭
    - regex = "s\B", string = "`s`he `s`ells `s`ea`s`hells"
        - matches: 4
    - regex = "\w\B", string = "`s``h`e `s``e``l``l`s `s``e``a``s``h``e``l``l`s"
        - matches: 14
    - regex = "\w+\b", string = "`sh`e `sell`s `seashell`s"
        - matches: 3

### Escaped characters

> 특별한 문자들

- reserved characters
    - +*?^$\.[]{}()|/
    - \+, \*, ...
- octal escape
    - \251 == ©
- hex escape
    - \xa9 == ©
- unicode escape
    - \u00A9 == ©
- tab
    - \t
- line feed
    - \n
- vertical tab
    - \v
- form feed
    - \f
- carriage return
    - \r
- null
    - \0

### Group & References

> 그룹을 사용하면 토큰 시퀀스를 결합하여 함께 작동할 수 있습니다.\
> 캡처 그룹은 역참조로 참조할 수 있으며 결과에서 별도로 액세스할 수 있습니다.\
> 이해안됨

- [capturing group](https://blog.rhostem.com/posts/2018-11-11-regex-capture-group)
    - (ABC)
    - 여러 토큰을 함께 그룹화하고 `하위 문자열을 추출`하거나 `역참조를 사용`하기 위한 `캡처 그룹`을 만듭니다.
    - regex validation을 위한 test에서는 동일한 결과
    - regex = "(ha)", string = "`ha``ha``ha` `ha`a `ha`h!"
        - matches: 5
    - regex = "(ha)+", string = "`hahaha` `ha`a `ha`h!"
        - matches: 3
- non-capturing group
    - (?:ABC)
    - capturing group 없이 여러 토큰을 함께 그룹화
    - regex validation을 위한 test에서는 동일한 결과
    - regex = "(?:ha)+", string = "`hahaha` `ha`a `ha`h!"
        - matches: 3

### lookaround

> 둘러보기를 사용하면 결과에 포함하지 않고 기본 패턴 이전(lookbehind) 또는 이후(lookahead) 그룹을 일치시킬 수 있습니다.\
> 네거티브 룩어라운드는 패턴 전후에 일치할 수 없는 그룹을 지정합니다.\
> main pattern, lookaround, positive||negative

- positive lookahead
    - (`?=`ABC)
    - regex = "\d(?=px)", string = "1pt `2`px 3em `4`px"
        - matches: 2
- negative lookahead
    - (`?!`ABC)
    - regex = "\d(?!px)", string = "`1`pt 2px `3`em 4px"
        - matches: 2
- positive lookbehind
    - (`?<=`ABC)
- negative lookbehind
    - (`?<!`ABC)

## sorting_and_searching

> binary-search
> - Arrays.binarySearch(arr, key)
> - Collections.binarySearch(List<E> list, E key)
>
> 결정알고리즘과 결정검증함수

- sorting
    - 선택
        - 스왑이 특정 인덱스를 선택하고 일어남
    - 버블
        - 스왑이 버블처럼 일어남
    - 삽입
- search
    - binary
        - built-in
            - `Arrays.binarySearch(arr, key)`
        - 직접구현
            - O(logN)
            - lt, rt, mid
            - while(lt<=rt) { ... }
            - if mid not set, then no value
    - binary search 확장
        - `결정알고리즘`과 `결정검증함수`
            - 내가 찾고자 하는 **답이 확실하게 특정 범위내에 존재**한다.
            - 특정범위내에서 이분탐색으로 서칭하면 됨
                - ex1) 노래길이들,dvd개수가 주어짐 // 답: dvd의 크기
                    - 결정검증함수
                        - 주어진거: 노래길이들,dvd개수
                        - 답: dvd의 크기
                        - 즉, 답이 주어지면, 답으로 노래길이를 나눠담았을때, dvd의 최대개수를 알 수 있다.
                            - 찾은 dvd최대개수가 주어진 dvd개수보다 작으면? 답을 줄여야 함
                            - 그 외에는 답을 늘려야 함
                - ex2) 마구간위치,말개수가 주어짐 // 답: 가장 가까운 말들의 거리
                    - 결정검증함수
                        - 주어진거: 마구간위치, 말개수
                        - 답: 가까운 말들의 거리
                        - 즉, 답이 주어지면, 마구간 위치에 배치햇을때 배치가능한 말의최대개수를 알 수 있다
                            - 찾은 말의최대개수가 주어진 말개수보다 작으면? 답을 줄여야함
                            - 그 외에는 답을 늘려야함

## recursive_tree_graph

> memoization: [n]에서만 저장,재활용\
> graph: 인접리스트, 방향과 가중치

- recursive
    - 스택프레임 구조
        - 간단하게 매개변수, 지역변수, 복귀주소
        - 스택프레임때문에 배열로 짜는게 더 성능이 좋다
- memoization
    - 값을 저장하고, 재활용
    - 저장, 재활용은 항상 `n에서만`. f(n) = f(n-1) + f(n-2)일때
        - 저장
            - return memoization[n] = dfs(n-1) + dfs(n-2);
        - 재활용
            - if (memoization[n] > 0) return memoization[n];
- tree
    - 순회
    - dfs에서 root가 null일 때 // 초기값
        - 전위순회
            - `부`-왼-오
        - 중위순회
            - 왼-`부`-오
        - 후위순회
            - 왼-오-`부`
- bfs
    - 최단거리
- `graph`와 인접행렬
    - G(V,E) // Graph(Vertex, Edge), 인접행렬은 편의상 g[][]로 표현
        - `무방향`(양방향)
            - vertex 1,2가 연결됐다면 -> g[1][2] = g[2][1] = 1
            - vertex 1에서 연결된곳 찾을때는 -> for(v: g[1]) { if v equal 1, then v는 연결됨
        - `방향`
            - vertex 1,2가 연결됐다면 -> g[1][2] = 1
            - vertex 1에서 연결된곳 찾을때는 -> for(v: g[1]) { if v equal 1, then v는 연결됨
        - `가중치` 방향
            - vertex 1,2가 연결됐다면 -> g[1][2] = w
            - vertex 1에서 연결된곳 찾을때는 -> for(v: g[1]) { if v gt 0, then v는 w의 가중치로 연결됨
    - 인접행렬
        - 그래프가 표현된 2차원 배열
    - `인접리스트`
        - 간선을 0,1이 아닌 리스트에 add함
            - vertex가 n 개면 loop(n)하면서 n번 if하는걸 단순히 loop(list)하면 끝남
                - 메모리 최적화
                - 성능 최적화

## dfs_bfs_uses

> 부분집합은 dfs로 해야만하나?

### 순열, 조합, 중복순열, 중복조합 (외울것)

- 조합 // 01, 02, 03, 12, 13, 23

```java
import java.util.Arrays;

class T {
    private static int n, r;
    private static int[] combination = new int[r];

    private void dfs(int l, int s) {
        if (l == r) {
            System.out.println(Arrays.toString(combination));
            return;
        }
        for (int i = s; i < n; i++) {
            combination[l] = i;
            dfs(1 + l, 1 + i); // l번째 조합으로 i사용
        }
    }
}
```

- 순열 // 01, 02, 03, 10, 12, 13, 20, 21, 23, 30, 31, 32

```java
import java.util.Arrays;

class T {
    private static int n, r;
    private static int[] permutation = new int[r];
    private static boolean[] ch = new int[n];

    private void dfs(int l) {
        if (l == r) {
            System.out.println(Arrays.toString(permutation));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!ch[i]) {
                ch[i] = true;
                permutation[l] = i;
                dfs(1 + l);
                ch[i] = false;
            }
        }
    }
}
```

- 중복조합// 00, 01, 02, 03, 11, 12, 13, 22, 23, 33

```java
import java.util.Arrays;

class T {
    private static int n, r;
    private static int[] combination = new int[r];

    private void dfs(int l, int s) {
        if (l == r) {
            System.out.println(Arrays.toString(combination));
            return;
        }
        for (int i = s; i < n; i++) {
            combination[l] = i;
            dfs(1 + l, i);
        }
    }
}
```

- 중복순열 // 00, 01, 02, 03, 10, 11, 12, 13, 20, 21, 22, 23, 30, 31, 32, 33

```java
import java.util.Arrays;

class T {
    private static int n, r;
    private static int[] permutation = new int[r];

    private void dfs(int l) {
        if (l == r) {
            System.out.println(Arrays.toString(permutation));
            return;
        }
        for (int i = 0; i < n; i++) {
            permutation[l] = i;
            dfs(1 + l);
        }
    }
}
```

## PriorityQueue

> 기준의 default 정렬은 오름차순

- PriorityQueue<E> pq = new PriorityQueue<>(); // E의 compareTo에 따라 오름차순으로 정렬
- PriorityQueue<E> pq = new PriorityQueue<>(Collections.reverseOrder()); // E의 compareTo에 따라 내림차순으로 정렬

## greedy(다시 볼 것)

> 현재에서 최선의 선택\
> 어떤 기준으로 정렬한 후, 앞에서부터 순회하는것도 포괄적인 의미로\
> 다익스트라, 프림, 크루스칼 이건 정말 그리디\
> 나중에봤을때 최선이 아닐수도 잇다면? 동적계획법\
> `정렬`

- interval이 겹치는 갯수의 최대값
    - 1차배열로 flat하게 만들어라
    - 배열을 잘 정렬해서 counting
    - [_0903_결혼식](https://github.com/YuSangHuck/algorithm/tree/main/huck/자바_알고리즘_문제풀이/greedy/_0903_결혼식.java) 참조

### **다익스트라**

> 그래프의 기준점에서 다른지점들까지의 최단거리\
> 그리디를 이용

> O(n^2)\
> 다익스트라는 dis[n]을 fix하는 과정을 n번하고, 각 과정마다 최소값을 찾아야하므로 O(n)\
> 이걸 n번 반복하므로 O(n^2)\
> 가중치 방향그래프에서 1번정점에서 모든정점으로 최소거리비용\
> 조건1. 모든간선의 가중치는 0 혹은 양수다 // dis배열의 각 요소는 확정값에 의해 업데이트되면서 우상향이므로

> O(n*logn)\
> 다익스트라는 dis[n]을 fix하는 과정을 n번하고, 각 과정마다 최소값을 찾아야하므로 O(n)지만 pq 이용하면 O(logn)\
> 과정 n번하면 O(nlogn)\
> PriorityQueue를 이용하면 됨

- 과정
    - graph 생성 및 초기화
        - ArrayList<ArrayList>>graph = new ArrayList<>();
    - dis 생성 및 초기화
        - int[] dis = new int [n+1];
        - Arrays.fill(dis, Integer.MAX_VALUE);
    - 1번 정점 출발
        - dis[1] = 0
    - dis에서 최소값 찾고 체크 // O(n)
        - min = Integer.MAX_VALUE
        - for(int tmp: dis) { min = Math.min(min,tmp) }
    - 체크한 v 기준 체크안된곳&&갈수있는곳의 dis업데이트하면서 최소값 저장
    - 최소값에 해당되는 번호 체크

### disjoint-set // 서로소 집합(다시 볼 것, 외울것)

> **Union & Find 알고리즘** 활용

- Union & Find
    - 서로소 집합을 표현하기 위한 알고리즘 중 하나

- 과정
    - unf 배열
        - 인덱스는 학생번호
        - 값은 해당 학생이 소속된 집합번호????????
        - 초기값은 unf[i] == i
    - Union(a,b)
        - a,b를 하나의 집합으로 만들어라
    - Find(a)
        - a학생의 집합번호 반환

### **최소스패닝트리**

> cf) 그래프는 회로가 존재(순환), 트리는 회로 존재x -> 정점이 n개면 간선은 n-1개
> - ArrayList<Edge> edges, unf => 크루스칼
> - ArrayList<ArrayList<Edge>> graph, ch, PriorityQueue<Edge> pq => 프림
> - ArrayList<ArrayList<Edge>> graph, unf, PriorityQueue<Edge> pq => 내가푼거. 프림에서 ch 대신 unf 쓴거

- **크루스칼**, Union & Find 활용
    - edge를 cost 기준으로 오름차순
    - find의 값이 다를때만
        - edge의 v1,v2를 union
        - edge의 cost를 sum
- **프림**, PriorityQueue 활용
    - ArrayList<ArrayList<Edge>> graph, PriorityQueue<Edge> pq, boolean[] ch

## **dynamic**

> 복잡한문제를 해결할때
> 문제를 본질이 변하지 않는 내에서 작은단위로 쪼개서 memoization하고 큰단위에 적용(bottom up)

- [LIS](https://shoark7.github.io/programming/algorithm/3-LIS-algorithms)(다시 볼 것)
    - dy[i]는 arr[i]를 사용햇을때 최대값을 의미함
    - dy[i]는 max(dy[0], dy[1], ..., dy[i-1]) + arr[i]
    - [_1003_LIS_최대부분증가수열](https://github.com/YuSangHuck/algorithm/tree/main/huck/자바_알고리즘_문제풀이/dynamic/_1003_LIS_최대부분증가수열.java)
      참조
    - [_1004_LIS_가장높은탑쌓기](https://github.com/YuSangHuck/algorithm/tree/main/huck/자바_알고리즘_문제풀이/dynamic/_1004_LIS_가장높은탑쌓기.java)
      참조

## **knapsack**

> 그냥 가방문제 생각하면 됨
> 가방에 어떤값을 기준으로 최대가 되도록
> _1005는 동전이 무한개 -> dy의 초기값 INF && j가 증가하는 방향으로
> _1006은 시험문제는 1번만 -> dy의 초기값이 0 && j가 감소하는 방향으로
> n번가능한 경우는? 3중 dynamic 
