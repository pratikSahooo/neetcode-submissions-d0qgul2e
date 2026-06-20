interface Shape {
    Shape clone();
}

class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    @Override
    public Shape clone() {
        // Write your code here
        Rectangle newRec = new Rectangle(this.width,this.height);
        return newRec ;
    }
}

class Square implements Shape {
    private int length;

    public Square(int length) {
        this.length = length;
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public Shape clone() {
        // Write your code here
        Square newSqar = new Square(this.length);
        return newSqar ;
    }
}

class Test {
    public List<Shape> cloneShapes(List<Shape> shapes) {
        // Write your code here
        List<Shape> cloned = new ArrayList<Shape>();
        for(Shape sh : shapes){
            cloned.add(sh.clone());
        }
        return cloned ;
    }
}
