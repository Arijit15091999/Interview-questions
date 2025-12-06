from Node import Node
from collections import deque
class SegmentTree:
    def __init__(self, arr: list):
        self.root = self.createTree(0, len(arr) - 1, arr)
    
    def createTree(self, start: int, end: int, arr: list) -> Node:
        if start > end:
            return None
        if start == end:
            leaf = Node(start, end)
            leaf.data = arr[start]
            return leaf
        mid = start + (end - start) // 2
        node = Node(start, end)
        
        node.left = self.createTree(start, mid, arr)
        node.right = self.createTree(mid + 1, end, arr)

        node.data = node.left.data + node.right.data

        return node
    
    def printTree(self):
        root = self.root
        q = deque()
        q.append(root)

        while len(q) > 0:
            n = len(q)

            for _ in range(n):
                node = q.popleft()
                print(node, end = " ")

                if node.left is not None:
                    q.append(node.left)
                if node.right is not None:
                    q.append(node.right)
            print()
    