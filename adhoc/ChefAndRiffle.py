# https://www.codechef.com/JAN221B/problems/RIFFLES

def solve(n, k):
    arr = [i for i in range(n + 1)]

    for i in range(1, n + 1):
        if i & 1 == 1:
            arr[i] = (i + 1) // 2
        else:
            arr[i] = (n // 2) + (i // 2)
    
    
    result = [i for i in range(n + 1)]
    visited = [False] * (n + 1)

    for i in range(1, n + 1):
        if not visited[i]:
            curr = i
            cycle = []
            while not visited[curr]:
                visited[curr] = True
                cycle.append(curr)
                curr = arr[curr]
            
            cycle_length = len(cycle)

            shift = k % cycle_length

            for j in range(cycle_length):
                result[cycle[j]] = cycle[(j + shift) % cycle_length]
    

    for i in range(1, n + 1):
        index = result[i]
        arr[index] = i

    for i in range(1, n + 1):
        print(arr[i], end=" ")
    print()


if __name__ == "__main__":
    t = int(input())

    for _ in range(t):
        n, k = list(map(int, input().strip().split()))

        solve(n, k)