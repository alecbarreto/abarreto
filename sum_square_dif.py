def square_sum_difference():
    lst = range(1,101)
    sum1 = 0
    sum2 = 0
    for num in lst:
        sum1 = sum1 + num**2
    for num in lst:
        sum2 += num
        if num == 100:
            sum2 = sum2**2
    return sum2-sum1

print square_sum_difference()
