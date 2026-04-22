def solve():
    number = input().strip()
    ans = []
    n = len(number)

    for i in range(n):
        original_digit = int(number[i])

        if i == 0 and original_digit == 9:
            ans.append(str(original_digit))
            continue
        if original_digit > 4:
            new_digit = min(9 - original_digit, original_digit)
            ans.append(str(new_digit))
    
    ans = "".join(ans)

    print(ans)

solve()