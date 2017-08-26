def validate(n):
    n = str(n)
    lst1 = []
    lst2 = []
    count = 0
    for num in n:
        lst1.append(num)
    if len(lst1) % 2 == 0:
        count = 0
    elif len(lst1) == 0:
        count = 1
    for num in range(0,len(lst1) + 1):
        if count == 0:
            if int(lst1[count]) * 2 > 9:
                lst2.append((int(lst1[count]) * 2) - 9)
                count += 2
            else:
                lst2.append(int(lst1[count]) * 2)
                count += 2
        elif count % 2 == 0:
            if int(lst1[count]) * 2 > 9:
                lst2.append((int(lst1[count]) * 2) - 9)
                count += 2
            else:
                lst2.append(int(lst1[count]) * 2)
                count += 2
    return lst2

print validate(5734)
