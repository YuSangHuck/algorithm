package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"runtime"
	"strconv"
	"strings"
)

func init() {

}

func setStdin() {
	_, abs, _, _ := runtime.Caller(1)
	rel := filepath.Base(abs)
	os.Stdin, _ = os.Open(rel[0:len(rel)-len(".go")] + "_input.txt")
}

func sol() {
	n := 0
	r, w := bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout)
	defer w.Flush()
	fmt.Fscanln(r, &n)

	line, _ := r.ReadString('\n')
	s_tops := strings.Fields(line) // 0부터 시작
	n_tops := [500001]int{}
	var res []int
	for i := 0; i < n; i++ {
		n_tops[1+i], _ = strconv.Atoi(s_tops[i])
	}

	// 오른쪽부터
	for i := n; i > 0; i-- {
		for j := i - 1; j > 0; j-- {
			// 수신하면
			if n_tops[j] >= n_tops[i] {
				res = append(res, j)
				break
			}
			if j == 1 {
				res = append(res, 0)
			}
		}
	}
	// 제일 왼쪽거 1개
	res = append(res, 0)

	for i := range res {
		// 역순으로
		fmt.Fprintf(w, "%d ", res[n-i-1])
	}

}

func main() {
	if len(os.Getenv("IS_LOCAL")) != 0 {
		setStdin()
	}

	sol()
}
