def F(n):
    if n == 0 or n == 1:
        return n
    return F(n-1) + F(n-2)

def productFib(prod):
    count = 1
    while F(count) * F(count+1) <= prod:
        if F(count) * F(count+1) == prod:
            return [F(count),F(count+1),True]
        else:
            count += 1
    return [F(count),F(count+1),False]
