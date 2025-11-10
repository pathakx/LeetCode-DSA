class Solution {
    public int countPrimes(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 0;
    int arr[] = new int[n];
        arr[0] = -1;
        arr[1] = -1;
        for (int i = 2; i < Math.sqrt(n); i++) {
            if (arr[i] != -1) {

                for (int j = i * i; j < n; j = j + i) {
                    if (j % i == 0) {
                        arr[j] = -1;
                    }
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] % i != -1) {
                count++;

            }
        }

        return count;
    }
}