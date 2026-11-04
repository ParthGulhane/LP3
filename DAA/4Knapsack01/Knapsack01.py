
# 0/1 Knapsack using Dynamic Programming

n = int(input("Enter number of items: "))

weight = []
profit = []

for i in range(n):
    w = int(input(f"Enter weight of item {i + 1}: "))
    p = int(input(f"Enter profit of item {i + 1}: "))

    weight.append(w)
    profit.append(p)

W = int(input("Enter knapsack capacity: "))

# Create DP table
dp = [[0 for _ in range(W + 1)] for _ in range(n + 1)]

# Dynamic Programming
for i in range(1, n + 1):

    for w in range(W + 1):

        if weight[i - 1] <= w:

            dp[i][w] = max(
                profit[i - 1] + dp[i - 1][w - weight[i - 1]],
                dp[i - 1][w]
            )

        else:
            dp[i][w] = dp[i - 1][w]

print("Maximum Profit =", dp[n][W])
