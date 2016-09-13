#Imports Image library to make and edit the picture, random for the random shades
#of blue, and math so that I can use square root to make perfect equilateral
#triangles
from PIL import Image, ImageDraw, ImageFont
from random import *
from math import *
antialias = Image.ANTIALIAS
#These make the blank canvas that I draw on, and imports the picture of Dylan in 2
#different sizes
canvas = Image.new("RGB",(1200,1500),(20,20,20))
dylan1 = Image.open("/Users/josebarreto/Desktop/Pictures/DT.jpg").resize((125,115),
antialias)
dylan2 = Image.open("/Users/josebarreto/Desktop/Pictures/DT.jpg").resize((160,180),
antialias)

#Creates the triangles
def equiTriangle(pic,xstart,ystart,length,edgeColor):
    d = ImageDraw.Draw(pic)
    height = sqrt(length**2-((length/2)**2))
    #Base of each triangle
    d.line([(xstart,ystart),(xstart+length,ystart)],edgeColor)
    #Left leg of each triangle
    d.line([(xstart,ystart),(xstart+(length/2),(ystart-height))],edgeColor)
    #Right leg of each triangle
    d.line([(xstart+(length/2),(ystart-height)),(xstart+length,ystart)],edgeColor)
    circles(pic,xstart,ystart,height,length,edgeColor)
    xstart += length*1/3
    length = length*1/3
    ystart -= height*2/3
    if length > 1:
        equiTriangle(pic,xstart,ystart,length,edgeColor)

#Creates the circles that are inscribed the triangles
def circles(pic,xstart,ystart,height,length,edgeColor):
    d = ImageDraw.Draw(pic)
    #Creates the largest inscribed circle in each triangle
    d.ellipse([(xstart+(length*0.213),(ystart-(height*2/3))),
    (xstart+(length*0.789),ystart)],
    fill = (randint(0,255),randint(0,255),randint(255,255)),outline = edgeColor)
    #Creates the bottom right circle in each triangle
    d.ellipse([(xstart+(length*0.74),(ystart-(height*.22))),
    (xstart+(length*.92),ystart)],
    fill = (randint(0,255),randint(0,255),randint(255,255)),outline = edgeColor)
    #Creates the bottom left circle in each triangle
    d.ellipse([(xstart+(length*0.071),(ystart-(height*.22))),
    (xstart+(length*.263),ystart)],
    fill = (randint(0,255),randint(0,255),randint(255,255)),outline = edgeColor)

#Writes the text
def text(pic):
    fnt = ImageFont.truetype("Arial.ttf",115)
    color = (0,0,0,0)
    d = ImageDraw.Draw(pic)
    d.text((350,240), "Computer", font=fnt)
    d.text((400,410), "Science", font=fnt)
    d.text((551,550), "1", font=ImageFont.truetype("Arial.ttf",175))
    d.text((325,980), "By", font=ImageFont.truetype("Arial.ttf",125),fill="white")
    d.text((680,980), "Alec",font=ImageFont.truetype("Arial.ttf",125),fill="white")

#Generates the purple orbs that are outside the triangles
def orbs(pic,topx,topy,botx,boty,r,g,b):
    d = ImageDraw.Draw(pic)
    d.ellipse([(topx,topy),(botx,boty)], outline = (r,g,b),
    fill = (r,g,b))
    botx -= 2
    boty -= 2
    topx += 2
    topy += 2
    if r > 0 and r <= 255:
        r -= 3
    if r <= 0:
        g += 3
        if g > 0 and g <= 255:
            g -= 3
        if g <= 0:
            b += 3
            if b > 0 and b <= 255:
                b -= 3
            if b <= 0:
                r += 3
    if botx >= 0 and botx <= 1200 and boty >= 0 and boty <= 1500:
        orbs(pic,topx,topy,botx,boty,r,g,b)

#A function to put it all the previous functions together and make the triangles
#get smaller proportianally
def art(x,y,len,color):
    equiTriangle(canvas,x,y,len,color)
    equiTriangle(canvas,x,y,len/3,color)
    equiTriangle(canvas,x,y,len/9,color)
    equiTriangle(canvas,x+(len*2/3),y,len/3,color)
    equiTriangle(canvas,x+(len*2/3),y,len/9,color)
    equiTriangle(canvas,x+(len*2/3),y,len/3,color)
    equiTriangle(canvas,x+len*8/9,y,len/9,color)
    equiTriangle(canvas,x+len*2/9,y,len/9,color)
    equiTriangle(canvas,x+len*1/3,y-692.82,len/9,color)
    equiTriangle(canvas,x+len*5/9,y-692.82,len/9,color)

#Puts in Dylan's face
def face(pic1,pic2,x1,y1,x2,y2):
    canvas.paste(pic1,(0,0))
    canvas.paste(pic1,(x1,0))
    canvas.paste(pic1,(x1*2,y1))
    canvas.paste(pic1,(x1*3,y1))
    canvas.paste(pic1,(x1*4,y1))
    canvas.paste(pic1,(x1*5,y1))
    canvas.paste(pic1,(x1*6,y1))
    canvas.paste(pic1,(x1*7,y1))
    canvas.paste(pic1,(x1*8,y1))
    canvas.paste(pic1,(x1*9,y1))
    canvas.paste(pic1,(x1*10,y1))
    canvas.paste(pic2,(x2,y2))

#Calls the function that creates the triangles with inscribed circles
art(0,1386,1200,(20,20,20))
art(0,693,400,(20,20,20))
art(800,693,400,(20,20,20))
art(200,345,400,(20,20,20))
art(600,345,400,(20,20,20))

#Puts 4 of the purple orbs into where I want them
orbs(canvas,937,50,1187,300,255,0,255) #bottom left purple orb
orbs(canvas,935,750,1185,1000,255,0,255) #top left purple orb
orbs(canvas,20,750,270,1000,255,0,255) #top right purple orb
orbs(canvas,15,50,255,300,255,0,255) #bottom right purple orb

#flips the picture upside down
canvas = canvas.rotate(180)
#Calls the function that places Dylan's faces
face(dylan1,dylan2,120,0,519,1300)
#Calls the function that puts in the text
text(canvas)
#Saves the picture to a file on my computer
canvas.save("/Users/josebarreto/Desktop/Pictures/art11.jpg")
#displays the picture
canvas.show()
