# LCPArray 정리

## SuffixArray(접미사 배열, [링크](https://en.wikipedia.org/wiki/Suffix_array))

> **접미사 배열**은 어떤 문자열의 접미사를 사전식 순서대로 나열한 배열
>
> 번외로 Suffix tree([링크](https://en.wikipedia.org/wiki/Suffix_tree))도 있다.
- 예를 들어, 문자열 S="banana"의 접미사는 아래와 같이 총 6개

| Suffix | suffixIndex |
|-: |- |
| banana | 1 |
| anana | 2 |
| nana | 3 |
| ana | 4 |
| na | 5 |
| a | 6 |

- 이를 사전순으로 정렬하면 아래와 같다.

| Suffix | suffixIndex |
|- |- |
| a | 6 |
| ana | 4 |
| anana | 2 |
| banana | 1 |
| na | 5 |
| nana | 3 |

> 위처럼 정렬된 suffixIndex의 배열 [6,4,2,1,5,3]을 S의 SuffixArray라고 한다.

---

## LCPArray(Longest Common Prefix Array, [링크](https://en.wikipedia.org/wiki/LCP_array))

> LCPArray는 SuffixArray에서 이전 접미사와 공통되는 접두사의 길이를 저장한 배열

- SuffixArray에 각 item을 **SuffixItem{suffix, suffixIndex}** 이라고 한다면
- LCPArray[index] == 두 문자열의 공통되는 접두사 길이(SuffixArray[index - 1], SuffixArray[index])

> 위의 예에서 LCPArray는 [x,1,3,0,0,2]가 된다.
