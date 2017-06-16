def toJadenCase(string):
    lst = []
    count = 0
    for word in string.split(" "):
        for letter in word:
            lst.append(letter)
            lst[count] = lst[count].upper()
        count += len(word)+1
        lst.append(" ")
    lst.pop(-1)
    string = ''
    return string.join(lst)
print(toJadenCase("how can mirrors be real if our eyes aren't?"))
