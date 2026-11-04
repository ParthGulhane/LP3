
# N-Queens using Backtracking

N = int(input("Enter number of queens: "))

# Create N x N chessboard
board = [[0 for _ in range(N)] for _ in range(N)]


# Check whether placing queen is safe
def isSafe(row, col):

    # Check upper column
    for i in range(row):
        if board[i][col] == 1:
            return False

    # Check upper-left diagonal
    i, j = row, col
    while i >= 0 and j >= 0:
        if board[i][j] == 1:
            return False
        i -= 1
        j -= 1

    # Check upper-right diagonal
    i, j = row, col
    while i >= 0 and j < N:
        if board[i][j] == 1:
            return False
        i -= 1
        j += 1

    return True


# Backtracking function
def solveNQueens(row):

    # All queens are placed
    if row == N:
        return True

    # Try each column
    for col in range(N):

        if isSafe(row, col):

            board[row][col] = 1

            if solveNQueens(row + 1):
                return True

            # Backtracking
            board[row][col] = 0

    return False


# Place first queen at position (0,0)
if N <= 0:
    print("Enter a positive number.")

else:
    board[0][0] = 1

    # Place remaining queens
    if solveNQueens(1):

        print("Solution:")

        for row in board:
            print(*row)

    else:
        print("No solution exists")
