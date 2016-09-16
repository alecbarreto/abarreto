def pythagorean():
    m = 2
    n = 1
    a = 3
    b = 4
    c = 5
    count = 2
    lst = []
    while a+b+c <= 1000:
        if a+b+c == 1000:
            return a*b*c
            break
        else:
            a = (m**2) - (n**2)
            b = 2 * m * n
            c = (m**2) + (n**2)
            m += 1
            n += 1
            lst.append(a)
    return lst
print pythagorean()
