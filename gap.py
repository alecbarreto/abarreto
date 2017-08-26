def prime_check(num):
    for i in range(2,num):
        if num % i == 0:
            return False
        elif i == num - 1:
            return True

def gap(g, m, n):
    lst = []
    for i in range(m,n+1):
        if prime_check(i):
            lst.append(i)
    if m != n:
        for i in range(len(lst)):
            if lst[i+1] - lst[i] == g:
                return [lst[i],lst[i+1]]
            if lst[i+1] == lst[-1]:
                return None
    else:
        return None
