def FizzBuzz(num):
    for num in range(1,num+1):
        if num % 15 == 0:
            print  str(num) + "FizzBuzz!"
        elif num % 3 == 0:
            print str(num) + "Fizz!"
        elif num % 5 == 0:
            print str(num) + "Buzz!"
FizzBuzz(num)
