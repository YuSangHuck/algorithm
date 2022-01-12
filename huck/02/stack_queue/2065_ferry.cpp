#include<stdio.h>
#include<iostream>
#include<string>
#include<queue>
#define NSIZE 10000
using namespace std;
int M,t,N;
struct Data{
    int time; string pos; int idx;
};

queue<Data> L;
queue<Data> R;
char pos = 'L';
int finalTime[NSIZE];
void init() {
    scanf("%d %d %d", &M, &t, &N);
    for (int i = 0; i < N; i++) {
        Data c;
        cin >> c.time >> c.pos;
        c.idx = i;
        if (c.pos == "left") L.push(c);
        else R.push(c);
    }
}

int main() {
    init();
    int time = 0;

    while (R.size() + L.size() != 0) {
        int flag = 0;
        if (L.size() != 0 && L.front().time <= time) {
            flag = 1;
            if (pos == 'L') {
                pos = 'R';
                int cnt = 0;
                while (L.size() != 0 && L.front().time <= time & cnt < M) {
                    finalTime[L.front().idx] = time + t;
                    L.pop();
                    cnt++;
                }
                time += t;
            } else {
                time += t;
                int cnt = 0;
                while (L.size() != 0 && L.front().time <= time & cnt < M) {
                    finalTime[L.front().idx] = time + t;
                    L.pop();
                    cnt++;
                }
                time += t;
            }
        }
        
        if (R.size() != 0 && R.front().time <= time) {
            flag = 1;
            if (pos == 'R') {
                pos = 'L';
                int cnt = 0;
                while (R.size() != 0 && R.front().time <= time & cnt < M) {
                    finalTime[R.front().idx] = time + t;
                    R.pop();
                    cnt++;
                }
                time += t;
            } else {
                time += t;
                int cnt = 0;
                while (R.size() != 0 && R.front().time <= time & cnt < M) {
                    finalTime[R.front().idx] = time + t;
                    R.pop();
                    cnt++;
                }
                time += t;
            }
        }
        
        if (flag == 0) {
            time++;
        }
    }
    
    for (int i = 0; i < N; i++) {
        cout << finalTime[i] << endl;
    }

    return 0;
}