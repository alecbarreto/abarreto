from PIL import Image, ImageDraw, ImageFont
from random import randint
img = Image.new("RGB",(3000,3000),"white")

def concentric(pic,topx,topy,botx,boty,r,g,b):
    d = ImageDraw.Draw(pic)
    d.ellipse([(topx,topy),(botx,boty)], outline = (r,g,b),
    fill = (r,g,b))
    botx -= 50
    boty -= 50
    topx += 50
    topy += 50
    if r > 0 and r <= 255:
        r -= 10
    if r <= 0:
        g += 10
        if g > 0 and g <= 255:
            g -= 10
        if g <= 0:
            b += 10
            if b > 0 and b <= 255:
                b -= 10
            if b <= 0:
                r += 10
    if botx >= 0 and botx <= 3000 and boty >= 0 and boty <= 3000:
        concentric(pic,topx,topy,botx,boty,r,g,b)
concentric(img,0,0,3000,3000,255,255,255)
img.show()
