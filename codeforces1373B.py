def solve():
    t = int(input())

    for _ in range(t):
        s = input().strip()
        count_one, count_zero = 0, 0

        for char in s:
            if char == "1":
                count_one += 1
            else:
                count_zero += 1

        move_count = min(count_zero, count_one)

        if move_count & 1 == 1:
            print("DA")
        else:
            print("NET")

solve()
        