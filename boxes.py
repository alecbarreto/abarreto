from random import randint
blank = makeEmptyPicture(850,600, black)
dad = makePicture("/Users/josebarreto/Desktop/Pictures/Dad.jpg")
import time
import java.awt.Font as Font

sum1 = 0
sum2 = 0
count = -675

def randomboxes(pic,dad,x,y):
  global sum1
  global sum2
  global count
  while x <= getWidth(pic) and y <= getHeight(pic):
    c = makeColor(randint(0,255),randint(0,255),randint(0,255))
    addLine(pic, x, y, x+10, y,c)
    addLine(pic, x, y, x-7, y+7,c)
    addLine(pic, x+10, y, x+10, y+12,c)
    addLine(pic, x+10, y, x+2, y+8,c)  
    addLine(pic, x-6, y+6, x-6, y+15,c)
    addLine(pic, x+2, y+8, x+2, y+15,c) 
    addLine(pic, x+2, y+8, x-5, y+8,c)
    x += 12
    y += 12
  for i in range(1,10000):  
    sum1 += 7
    sum2 += 15
    x = 270 - sum1
    y = 30 + sum2
    while x <= getWidth(pic) and y <= getHeight(pic):
      c = makeColor(randint(0,255),randint(0,255),randint(0,255))
      addLine(pic, x, y, x+10, y,c)
      addLine(pic, x, y, x-7, y+7,c)
      addLine(pic, x+10, y, x+10, y+12,c)
      addLine(pic, x+10, y, x+2, y+8,c)  
      addLine(pic, x-6, y+6, x-6, y+15,c)
      addLine(pic, x+2, y+8, x+2, y+15,c) 
      addLine(pic, x+2, y+8, x-5, y+8,c)
      x += 12
      y += 12
      count += 1
      time.sleep(0.002)
      repaint(pic)
  c = makeColor(randint(50,255),randint(50,255),randint(50,255))
  comicSans = makeStyle("Comic Sans",Font.BOLD,50)
  addTextWithStyle(pic,575,60,"Happy",comicSans,c)
  c = makeColor(randint(50,255),randint(50,255),randint(50,255))
  addTextWithStyle(pic,575,140,"Fathers",comicSans,c)
  c = makeColor(randint(50,255),randint(50,255),randint(50,255))
  addTextWithStyle(pic,575,220,"Day!",comicSans,c)
  copyInto(dad,pic,185,260)
  repaint(pic)
  writePictureTo(pic,"/Users/josebarreto/Desktop/")

randomboxes(blank,dad,270,30)