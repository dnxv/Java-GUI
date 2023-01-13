from tkinter import *

root = Tk()
root.title('Visuals')
root.geometry("500x500")

my_canvas = Canvas(root, width=300, height=300, bg="white")
my_canvas.pack(pady=20)

points=[0, 0, 100, 100, 300, 100]
my_canvas.create_polygon(points, fill="black")

root.mainloop()

