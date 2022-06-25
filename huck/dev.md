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
  - 가변
    - ArrayList arr
      - add
    - int[] arr
      - arr[idx]
- void Arrays.sort(int[] a);

## 반복문

- loop 횟수가 정해져있으면
  - for
- 안정해져있으면
  - while