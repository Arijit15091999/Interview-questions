from Tree import SegmentTree

if __name__ == "__main__":
    arr = [3, 8, 7, 5, -10, -9, 55]
    tree = SegmentTree(arr)
    tree.printTree()
    # ans = tree.query(2, 6)
    # print(ans)
    # tree.update(2, 10)
    # tree.printTree()
    print(tree.rangeSum(2, 5))