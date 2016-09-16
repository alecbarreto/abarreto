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
