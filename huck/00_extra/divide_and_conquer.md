# 분할(divide) 정복(conquer)

## 개요

- 분할
> 문제를 동일한 유형의 여러 하위 문제로 나눈다.

- 정복
> 가장 작은 다위의 하위 문제를 해결

- 조합
> 하위 문제의 결과를 원래 문제에 대한 결과르 조합

## pseudocode

``` pseudo
function F(x):
  if F(x)가 간단 then:
    return F(x)의 계산 값
  else:
    x를 x1,x2로 분할
    F(x1), F(x2)를 호출
    return F(x1), F(x2)로 F(x)를 구한 값
```

분할의 기준인 **간단함**을 잘 정의해야 한다.