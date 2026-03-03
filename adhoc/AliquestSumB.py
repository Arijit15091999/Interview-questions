# https://codeforces.com/gym/103373/problem/B%E2%81%A3%E2%81%A3

def divisor_sum(n):
    sum = [0] * (n + 1)

    for i in range(1, n + 1):
        for j in range(i, n + 1, i):
            sum[j] += i

    return sum


def check(number, sum):
    if sum[number] < 2 * number:
        print("deficient")
    elif sum[number] > 2 * number:
        print("abundant")
    else:
        print("perfect")


if __name__ == "__main__":
    n = int(1e6) + 1

    sum = divisor_sum(n)

    t = int(input())

    numbers = list(map(int, input().strip().split()))

    for number in numbers:
        check(number, sum) 