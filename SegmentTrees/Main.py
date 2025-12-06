from Tree import SegmentTree

if __name__ == "__main__":
    arr = [3, 8, 7, 5, -10, -9, 55]
    tree = SegmentTree(arr)
    tree.printTree()