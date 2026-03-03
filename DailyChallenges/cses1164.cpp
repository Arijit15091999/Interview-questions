#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;

    vector<array<int, 3>> arr(n);
    for (int i = 0; i < n; i++) {
        cin >> arr[i][0] >> arr[i][1];
        arr[i][2] = i;  // original index
    }

    // sort by start time
    sort(arr.begin(), arr.end(), [](auto &a, auto &b) {
        return a[0] < b[0];
    });

    // min-heap: {end_time, room_number}
    priority_queue<
        pair<int, int>,
        vector<pair<int, int>>,
        greater<pair<int, int>>
    > pq;

    vector<int> res(n);
    int rooms = 0;

    for (auto &e : arr) {
        int start = e[0];
        int end = e[1];
        int idx = e[2];

        if (!pq.empty() && pq.top().first < start) {
            // reuse room
            auto [prevEnd, room] = pq.top();
            pq.pop();
            res[idx] = room;
            pq.push({end, room});
        } else {
            // allocate new room
            rooms++;
            res[idx] = rooms;
            pq.push({end, rooms});
        }
    }

    cout << rooms << "\n";
    for (int i = 0; i < n; i++) {
        cout << res[i] << " ";
    }
    cout << "\n";

    return 0;
}
