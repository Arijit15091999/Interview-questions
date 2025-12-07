from Node import Node
from collections import deque
class SegmentTree:
    def __init__(self, arr: list):
        self.__root = self.createTree(0, len(arr) - 1, arr)
    
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
        root = self.__root
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
    def query(self, start, end):
        root = self.__root
        return self.__queryHelper(root, start, end)

    def __queryHelper(self, node: Node, start: int, end: int) -> int:
        if node.start >= start and node.end <= end:
            return node.data 
        elif node.start > end or node.end < start:
            return 0
        else:
            return self.__queryHelper(node.left, start, end) + self.__queryHelper(node.right, start, end)
    def update(self, index, newValue):
        root = self.__root
        self.__updateHelper(root, index, newValue)
    def __updateHelper(self, root, index, newValue) -> tuple:
        if root.start == index and root.end == index:
            prevValue = root.data
            root.data = newValue
            return (prevValue, root.data)

        if index < root.start or index > root.end:
            return (0, 0)

        if root.start <= index and root.end >= index:
            left = self.__updateHelper(root.left, index, newValue)
            right = self.__updateHelper(root.right, index, newValue)
            root.data += -left[0] -right[0] + left[1] + right[1]
            return (left[0] + right[0], left[1] + right[1])
    def rangeSum(self, start: int, end: int) -> int:
        pass
