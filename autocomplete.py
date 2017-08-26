def autocomplete(input_, dictionary):
    lst = []
    final = []
    alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
    'r','s','t','u','v','w','x','y','z']
    for char in input_:
        if char.lower() not in alpha:
            input_ = input_.replace(char,"")
    length = len(input_)
    for word in dictionary:
        count = 0
        if input_ == "" and len(final) < 5:
            final.append(word)
            count += 1
        for letter in word:
            if count < length and letter.lower() == input_[count].lower():
                lst.append(letter)
                count += 1
            else:
                break
        if lst != []:
            if input_.lower() == ''.join(lst).lower() and len(final) < 5:
                final.append(word)
            lst = []
    return final

print autocomplete("",['Zelda','Zygrade','zebra','zero','Zeus','zap cannon',
  'zephyr',
  'zig zag'])
