# 846. Hand of Straights

from heapq import heapify
import heapq
from typing import Counter, List


class Solution:

    # Brute Force Solution - O(n^2)
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:

        hand.sort()
        n = len(hand)
        
        if n % groupSize != 0:
            return False

        if n == 0:
            return True
        
        target = hand[0]
        numberOfRemovedElements = 0

        i = 0
        while i < len(hand):

            if numberOfRemovedElements % groupSize == 0:
                i = 0
                target = hand[i]

            if(hand[i] == target):
                target = hand[i] + 1
                numberOfRemovedElements += 1
                hand.pop(i)
            else:
                i += 1

        return not hand
    
    # MinHeap - O(n * logn)
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize:
            return False

        count = {}
        for n in hand:
            count[n] = 1 + count.get(n, 0)

        minH = list(count.keys())
        heapq.heapify(minH)
        while minH:
            first = minH[0]
            for i in range(first, first + groupSize):
                if i not in count:
                    return False
                count[i] -= 1
                if count[i] == 0:
                    if i != minH[0]:
                        return False
                    heapq.heappop(minH)
                    
        return True