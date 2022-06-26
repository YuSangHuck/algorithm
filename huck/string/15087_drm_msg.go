package main

import (
	"bufio"
	"fmt"
	"os"
	"path/filepath"
	"runtime"
)

func setStdin() {
	_, abs, _, _ := runtime.Caller(1)
	rel := filepath.Base(abs)
	os.Stdin, _ = os.Open(rel[0:len(rel)-len(".go")] + "_input.txt")
}

func sol() {
	r, w := bufio.NewReader(os.Stdin), bufio.NewWriter(os.Stdout)
	defer w.Flush()

	var s string
	fmt.Fscanf(r, "%s\n", &s)

	size := len(s)
	rotationValueLower, rotationValueUpper := 0, 0
	// divide
	for i := 0; i < size/2; i++ {
		rotationValueLower += int(s[i] - 'A')
	}
	for i := size / 2; i < size; i++ {
		rotationValueUpper += int(s[i] - 'A')
	}

	// rotate
	rotatedLower, rotatedUpper := [7501]int{}, [7501]int{}
	for i := 0; i < size/2; i++ {
		rotatedLower[i] = (int(s[i]-'A') + rotationValueLower) % 26
	}
	for i := size / 2; i < size; i++ {
		rotatedUpper[i-size/2] = (int(s[i]-'A') + rotationValueUpper) % 26
	}

	// merge
	merged := []byte{}
	for i := 0; i < size/2; i++ {
		merged = append(merged, byte('A'+((rotatedLower[i]+rotatedUpper[i])%26)))
	}

	fmt.Fprint(w, string(merged))
}

func main() {
	if len(os.Getenv("IS_LOCAL")) != 0 {
		setStdin()
	}
	sol()
}
