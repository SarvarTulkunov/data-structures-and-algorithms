# 134. Gas Station

from typing import List


class Solution:

    # Solution 1 - Brute Force (Really Bad)
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:

        for station in range(0, len(gas)):
            tank = 0
            
            startingIndex, cnt = station, 0
            flag = False
            while cnt < len(gas):
                tank += gas[startingIndex]
                tank -= cost[startingIndex]

                if tank < 0: break

                startingIndex += 1
                if startingIndex == len(gas):
                   startingIndex = 0
                
                cnt += 1

                if cnt == len(gas):
                    flag = True
                    break

            if flag: return startingIndex

        return -1
    
    # Solution 2 - Greedy
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost):
            return -1

        total = 0
        res = 0
        for i in range(len(gas)):
            total += (gas[i] - cost[i])

            if total < 0:
                total = 0
                res = i + 1

        return res
    
    

if __name__ == "__main__":
    gas = [1, 2, 3, 4]
    cost = [2, 2, 4, 1]
    sol = Solution()
    print(sol.canCompleteCircuit(gas, cost))