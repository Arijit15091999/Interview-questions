class Node:
    def __init__(self, start, end, data = 0):
        self.start = start
        self.end = end
        self.data = data
        self.left = None
        self.right = None
    
    def __str__(self):
        return f"[{self.data} | {self.start}-{self.end}]"
