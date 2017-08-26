import math

def is_prime(num):
    if num < 2:
        return False
    for i in range(2,int(math.sqrt(num))+1):
        if num % i == 0:
            return False
    return True

def big_prime():
    num = 3
    count = 1
    while count <= 100:
        if is_prime(num):
            count += 1
        num += 2
    return num-1

def sum_of_primes(n):
    sum = 2
    for i in range(3,n,2):
        if is_prime(i):
            sum += i
    return sum

def fact(num):
    if num != 1:
        return num * fact(num-1)
    return 1
