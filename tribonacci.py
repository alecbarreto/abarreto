def tribonacci(signature,n):
    lst = []
    sum = 0
    num1 = signature[0]
    num2 = signature[1]
    num3 = signature[2]
    if n == 0:
        return []
    elif n == 1:
        lst.append(num1)
        return lst
    elif n == 2:
        lst.append(num1)
        lst.append(num2)
        return lst
    elif n == 3:
        lst.append(num1)
        lst.append(num2)
        lst.append(num3)
        return lst
    else:
        lst.append(num1)
        lst.append(num2)
        lst.append(num3)
        sum += num1 + num2 + num3
        for i in range(n-3):
            lst.append(sum)
            sum += lst[-2]
            sum += lst[-3]
    return lst

print(tribonacci([3,2,1],10))
