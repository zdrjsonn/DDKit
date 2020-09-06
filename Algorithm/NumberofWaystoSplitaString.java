// Solution: Counting
// Counting how many ones int the binary string as T, if not a factor of 3, then there is no answer.
// Count how many positions that have prefix sum of T/3 as l, and how many positions that have prefix sum of T/3*2 as r.
// Ans = l * r
// But we need to special handle the all zero cases, which equals to C(N-2, 2) = (n - 1) * (n - 2) / 2
// Time complexity: O(n)
// Space complexity: O(1)
class Solution {
    public int numWays(String s) {
        final int kMod = (int)1e9 + 7;
        long n = s.length();
        int t = 0;
        for (char c : s.toCharArray()) t += c == '1' ? 1 : 0;
        if (t % 3 != 0) return 0;
        if (t == 0)
            return (int)(((1 + (n - 2)) * (n - 2) / 2) % kMod); // Java这里int强制转换要加在最外层才能运行正确。
        t /= 3;
        long l = 0;
        long r = 0;
        for (int i = 0, c = 0; i < n; ++i) {
            c += (s.charAt(i) == '1') ? 1 : 0;
            if (c == t) ++l;
            else if (c == t * 2) ++r;
        }
        return (int)((l * r) % kMod); // Java这里int强制转换要加在最外层才能运行正确。
    }
}
