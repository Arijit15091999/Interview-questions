def solve():
    t = int(input())

    for _ in range(t):
        n = int(input())
        ans = []

        k = n // 2
        last_item = k * (k + 1) - (k - 1) ** 2

        if last_item < 0 or last_item & 1 == 0 or k & 1 == 1:
            print("NO")
            continue

        start = 2
        for i in range(k):
            ans.append(start)
            start += 2

        start = 1
        for i in range(k, n - 1):
            ans.append(start)
            start += 2

        ans.append(last_item)

        print("YES")
        print(*ans)

solve()
        