class Node:
    def __init__(self, startInterval, endInterval, data = 0):
        self.startInterval = startInterval
        self.endInterval = endInterval
        self.data = data
        self.left = None
        self.right = None
    
    def __str__(self):
        return f"[{self.data} | {self.startInterval}-{self.endInterval}]"
