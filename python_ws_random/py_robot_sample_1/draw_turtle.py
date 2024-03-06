import turtle

t = turtle.Turtle()

def draw_square_4_color():
    for c in ['red', 'blue', 'green', 'yellow']:
        t.color(c)
        t.forward(75)
        t.left(90)

draw_square_4_color()