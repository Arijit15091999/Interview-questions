def solve():
    MOD = 998244353

    n = int(input())

    p1 = list(map(int, input().strip().split()))
    e1 = list(map(int, input().strip().split()))

    lcm = {}

    for i in range(n):
        lcm[p1[i]] = e1[i]

    m = int(input())

    p2 = list(map(int, input().strip().split()))
    e2 = list(map(int, input().strip().split()))

    gcd = {}

    for i in range(m):
        gcd[p2[i]] = e2[i]

    
    for prime in gcd:
        if prime not in lcm or gcd[prime] > lcm[prime]:
            print(0)
            return
    
    count = 0

    for prime in lcm:
        exp = gcd.get(prime, 0)

        if exp < lcm[prime]:
            count += 1

    print(pow(2, count, MOD))

solve()