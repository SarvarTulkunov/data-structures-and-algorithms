# 518. Coin Change II

from typing import List

class Solution:
    
    # DFS, Bottom Up
    def change(self, amount: int, coins: List[int]) -> int:
        
        n = len(coins)
        coins.sort()
        dp = [[0] * (amount + 1) for _ in range (n + 1)]

        for i in range(n + 1):
            dp[i][0] = 1

        for i in range(n - 1, -1, -1):
            for a in range(amount + 1):
                dp[i][a] = dp[i + 1][a]
                if(a >= coins[i]):
                    dp[i][a] += dp[i][a - coins[i]]

        return dp[0][amount]


    # DFS, Top Down
    def change2(self, amount: int, coins: List[int]) -> int:
        
        dp = {}

        def dfs(i, remain):

            if remain == 0:
                return 1
            
            if i == len(coins) or remain < 0:
                return 0

            if ((i, remain) in dp):
                 return dp[(i, remain)]

            res = 0            

            # Skip this coin
            res = dfs(i + 1, remain)

            # Use this coin
            res += dfs(i, remain - coins[i])

            dp[(i, remain)] = res

            return res

        return dfs(0, amount)