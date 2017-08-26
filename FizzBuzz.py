def FizzBuzz():
    for num in range(1,101):
        if num % 3 == 0 and num % 5 == 0:
            print  str(num) + " is divisible by 3 and 5!"
        elif num % 3 == 0:
            print str(num) + " is divisible by 3!"
        elif num % 5 == 0:
            print str(num) + " is divisible by 5!"
FizzBuzz()
