def is_pangram(s):
    alpha = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
    'r','s','t','u','v','w','x','y','z']
    for char in s:
        for i in alpha:
            if char == i:
                alpha.remove(char)
                break
    if len(alpha) == 0:
        return True
    return False

print(is_pangram("the quick brown fox jumps over the lazy dog"))
