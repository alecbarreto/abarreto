def Fibonacci():
    fib1 = 1
    fib2 = 2
    fibsum = 0
    while fib1 <= 4000000 and fib2 <= 4000000:
        if fib2 == 2:
            print fib2
            print "+"
            fibsum += fib2
        fib1 += fib2
        fib2 += fib1
        if fib1 % 2 == 0:
            print fib1
            print "+"
            fibsum += fib1
        if fib2 % 2 == 0 and fib2 < 3500000:
            print fib2
            print "+"
            fibsum += fib2
        if fib2 % 2 == 0 and fib2 >= 3500000:
            print fib2
            fibsum += fib2
        if fib1 >= 4000000 and fib2 >= 4000000:
            print "="
            print fibsum
Fibonacci()

def fibonacci(signature,n):
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
        sum += num1 + num2
        for i in range(n-3):
            sum += lst[-2]
            lst.append(sum)
    return lst

print(fibonacci([1,1,2],10))
