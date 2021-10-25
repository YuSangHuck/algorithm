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
	n_tops := [500000]int{}        // 0부터 시작
	var res [500000]string
	for i := 0; i < n; i++ {
		n_tops[i], _ = strconv.Atoi(s_tops[i])

		res[i] = "0"
		for j := i - 1; j > 0; j-- {
			// 수신하면
			if n_tops[j] >= n_tops[i] {
				res[i] = strconv.Itoa(1 + j)
				break
			}
		}
	}

	fmt.Fprint(w, strings.Join(res[:n], " "))

}

func main() {
	if len(os.Getenv("IS_LOCAL")) != 0 {
		setStdin()
	}

	sol()
}
