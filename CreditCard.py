def validate(n):
    lst = []
    sum = 0
    for i in str(n):
        lst.append(i)
    if len(str(n)) % 2 == 1:
        count = 1
        for num in lst:
            sum += int(num)
            if count < len(lst):
                lst[count] = int(lst[count])*2
                if lst[count] >= 10:
                    lst[count] = int(lst[count]-9)
                count += 2
    elif len(str(n)) % 2 == 0:
        count = 0
        for num in lst:
            sum += int(num)
            if count < len(lst):
                lst[count] = int(lst[count])*2
                if lst[count] >= 10:
                    lst[count] = int(lst[count]-9)
                count += 2
    if sum % 10 == 0:
        return True
    else:
        return False

print(validate(4430473089695325))
