# 51. N-Queens
class MergeKArrays(object):
    def solveNQueens(self, n):
        
        cols = ()
        positiveDiag = ()
        negativeDiag = ()

        res = []
        board = [["."] * n in for i in range(n)]

        def backtrack(r):
            if(r == n):
                copy = ["".join(row) for row in board]
                res.append(copy)
                return
            
            for c in range(n):

                if(c in cols or (r + c) in positiveDiag or (r - c) in negativeDiag):
                    continue

                cols.add(c)
                positiveDiag.add(r + c)
                negativeDiag.add(r - c)
                board[r][c] = "Q"

                backtrack(r + 1)

                cols.remove(c)
                positiveDiag.remove(r + c)
                negativeDiag.remove(r - c)
                board[r][c] = "."