def remove_smallest(numbers):
    if numbers == []:
        return []
    else:
        min = numbers[0]
        for i in range(1,len(numbers)):
            if numbers[i] < min:
                min = numbers[i]
        for j in range(0,len(numbers)):
            if numbers[j] == min:
                numbers.remove(numbers[j])
                break
        return numbers
