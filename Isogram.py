def is_isogram(string,letter):
    lst = []
    count = 0
    for i in string:
        lst.append(letter)
    if letter > len(lst):
        for i in lst:
            if lst[letter] == i:
                count += 1
                if count > 1:
                    return False
                    break
            if i == lst[(len(lst)-1)]:
                letter += 1
                if is_isogram(string,letter):
                    break
    else:
        return True
print(is_isogram("hhelloh",0))
