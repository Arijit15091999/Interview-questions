def solve():
    t = int(input())

    for _ in range(t):
        p, f = map(int, input().strip().split())
        cnts, cntw = map(int, input().strip().split())
        s, w = map(int, input().strip().split())

        if s > w:
            s, w = w, s
            cnts, cntw = cntw, cnts
        
        ans = 0

        for i in range(min(cnts, p // s) + 1):
            s1 = i
            w1 = min(cntw, (p - s * i) // w)
            s2 = min(cnts - i, f // s)
            w2 = min(cntw - w1, (f - s2 * s) // w)

            ans = max(ans, s1 + s2 + w1 + w2)

        print(ans)

        
solve()