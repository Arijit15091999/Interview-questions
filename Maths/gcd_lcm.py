def gcd_recursive(a, b):
    if b > a:
        return gcd_recursive(b, a)
    if b == 0:
        return a
    
    return gcd_recursive(b, a % b)


def gcd_iterative(a, b):
    if b > a:
        return gcd_iterative(b, a)
    
    while b != 0:
        a, b = b, a % b
    
    return a


def gcd(a, b, use_iterative = True):
    if use_iterative:
        return gcd_iterative(a, b)
    
    return gcd_recursive(a, b)


def extended_eucledian(a, b):    
    if b == 0:
        return a, 1, 0
    
    gcd, x1, y1 = extended_eucledian(b, a % b)

    x = y1
    y = x1 - (a // b) * y1

    return gcd, x, y


def lcm(a, b):
    return a // gcd(a, b) * b


def mod_inverse(a, m):
    gcd, x, _ = extended_eucledian(a, m)

    if gcd != 1:
        return None
    
    return x