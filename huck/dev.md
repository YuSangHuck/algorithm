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

> 문자열 내에서 특정 positon 조건

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

> 그룹을 사용하면 토큰 시퀀스를 결합하여 함께 작동할 수 있습니다.
> 캡처 그룹은 역참조로 참조할 수 있으며 결과에서 별도로 액세스할 수 있습니다.
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

> 둘러보기를 사용하면 결과에 포함하지 않고 기본 패턴 이전(lookbehind) 또는 이후(lookahead) 그룹을 일치시킬 수 있습니다. 
> 네거티브 룩어라운드는 패턴 전후에 일치할 수 없는 그룹을 지정합니다.
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
