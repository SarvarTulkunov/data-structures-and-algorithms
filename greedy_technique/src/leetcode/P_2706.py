# 2706. Buy Two Chocolates

from typing import List

class Solution:
    def buyChoco(self, prices: List[int], money: int) -> int:
        
        min1, min2 = sys.maxsize, sys.maxsize

        for price in prices:
            if(price < min1):
                min2 = min1
                min1 = price

            elif price <= min2:
                min2 = price

        leftover = money - min1 - min2
        return leftover if leftover >= 0 else money