import turtle
'''
def branchMaker(lenBranch,t):
    if lenBranch > 0:
        t.forward(lenBranch)
        t.right(20)
        branchMaker(lenBranch-14,t)
        t.left(40)
        branchMaker(lenBranch-14,t)
        t.right(2)
        t.backward(lenBranch)

def fractal_tree():
    t = turtle.Turtle()
        t.left(90)
    t.up()
    t.backward(450)
    t.down()ss
    t.color("brown")
    branchMaker(125,t)
    turtle.screen().exitonclick()

fractal_tree()
'''

def tree(branchLen,t):
    if branchLen > 5:
        t.forward(branchLen)
        t.right(20)
        tree(branchLen-15,t)
        t.left(40)
        tree(branchLen-15,t)
        t.right(20)
        t.backward(branchLen)

def main():
    t = turtle.Turtle()
    myWin = turtle.Screen()
    t.left(90)
    t.up()
    t.backward(100)
    t.down()
    t.color("green")
    tree(75,t)
    myWin.exitonclick()

main()
