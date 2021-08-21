## 파이썬에서 string concatenation은 어떻게 해야할까?

- +=

> 최악.\
> += 할때마다 새 객체 할당.
> 메모리, 속도, 효율성 모두 최악
> boj_10816 풀때 이거쓰니 최대 8초걸림\
> set reallocTime:  7.971063613891602

> query = ~~\
> query += ~~\
> query += ~~

- ''.join(str_list)

> 차선\
> +=에서 8초 걸린게 0.07초로 줄음\
> set arrayAppendTime:  0.06425595283508301\
> set arrayJoinTime:  0.005097866058349609
