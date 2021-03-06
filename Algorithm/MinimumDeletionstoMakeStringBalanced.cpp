// class Solution {
// public:
//     int minimumDeletions(string s) {
//         const int n = s.length();
//         // dp[i][0] := min # of dels to make s[0:i] all 'a's;
//         // dp[i][1] := min # of dels to make s[o:i] ends with 0+ 'b's
//         vector<vector<int>> dp(n + 1, vector<int>(2));
//         for (int i = 0; i < n; ++i) {
//             if (s[i] == 'a') {
//                 dp[i + 1][0] = dp[i][0];
//                 dp[i + 1][1] = min(dp[i + 1][0], dp[i][1] + 1);
//             } else {
//                 dp[i + 1][0] = dp[i][0] + 1;
//                 dp[i + 1][1] = dp[i][1];
//             }
//         }
//         return min(dp[n][0], dp[n][1]);
//     }
// };

class Solution {
public:
    int minimumDeletions(string s) {
        int a = 0, b = 0;
        for (char c : s) {
            if (c == 'a') b = min(a, b + 1);
            else ++a;
        }
        return min(a, b);
    }
};
