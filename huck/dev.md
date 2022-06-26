# 자바_알고리즘_문제풀이

## input

- Scanner kb = new Scanner(InputSteam)
  - param
    - System.in 
    - new FileInputStream("./input.txt");
  - return
    - kb.next() // 공백까지 read
    - kb.nextLine() // 한줄 read
    - kb.nextInt() // int 타입 반환
- 2차원 배열
  - 사이즈를 아는 경우
    - kb.nextInt()로 n번

## string

- StringBuilder // AbstractStringBuilder.value는 mutable
  - append
  - toString
  - `reverse`
    - lt=0, rt = length-1
    - while(lt < rt)
  - cf) `palindrome`
    - 회문은 for ( i < length/2 )
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
- Character class
  - isLowerCase(c)
  - toLowerCase(c)
  - isAlphabetic(c)
- Integer class
  - parseInt(string, radix) // 2진수를 10진수로

## array

- ArrayList vs array
  - 사이즈가 가변
    - ArrayList arr
      - add
  - 사이즈가 불변
    - int[] arr
      - arr[idx]
- void Arrays.sort(int[] a);

## 반복문

- loop 횟수가 고정
  - for
- loop 횟수가 미정
  - while

## twoPointer_slidingWindow // 이거는 다시 한번 볼것 or 추가문제 더 풀어볼것
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