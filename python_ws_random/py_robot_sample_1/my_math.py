from string import Template

class myMath:
    def __int__(self):
        self.a = ""
        self.b = ""

    def myAdd(self, a, b):
        result = a + b
        print("Call class: {} + {} = {}".format(a,b,result))
        return result

    def myMinus(self, a, b):
        result = a - b
        print("Call class: {} - {} = {}".format(a,b,result))
        return result

def add(a, b):
    print("Call function: {} + {} = {}".format(a, b, a+b))
    return a + b

def Main():
    cart = []  # create a list

    # add items into list
    cart.append(dict(item="Books", price=90, qty=5))
    cart.append(dict(item="Mobile", price=100, qty=40))
    cart.append(dict(item="Laptop", price=900, qty=2))
    cart.append(dict(item="Tables", price=50, qty=10))

    # create  template
    cart_template = Template("$qty x $item = $price")
    print("first print: cart_template", cart_template)
    total = 0
    print("My Cart :")

    for cart_data in cart:
        print(cart_template.substitute(cart_data))
        total += cart_data["price"]
    print("Toal Price : " + str(total))


if __name__ == '__main__':
    Main()
    add(2, 3)

    math1 = myMath()
    math1.myAdd(3, 5)
    math1.myMinus(3, 5)