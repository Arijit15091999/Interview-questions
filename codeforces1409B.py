def compute(a, b, x, y, n):
    d = min(n, a - x)
    a = a - d
    n -= d

    b = b - min(n, b - y)

    return a * b


def solve():
    t = int(input())

    for _ in range(t):
        a, b, x, y, n = tuple(map(int, input().strip().split()))

        ans = 10**18

        ans = min(ans, compute(a, b, x, y, n))
        ans = min(ans, compute(b, a, y, x, n))
        
        print(ans)
    
solve()