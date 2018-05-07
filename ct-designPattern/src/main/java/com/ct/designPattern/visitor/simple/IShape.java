package com.ct.designPattern.visitor.simple;

/**
 * Created by dell on 2018/5/5.
 */
interface IShape {
    float getArea();
    float getLength();
    Object accept(IVisitor visitor);
}

class Triangle implements IShape{
    float x1,y1,x2,y2,x3,y3;
    public Triangle(float... floats){
        this.x1 = floats[0];
        this.y1 = floats[1];
        this.x2 = floats[2];
        this.y2 = floats[3];
        this.x3 = floats[4];
        this.y3 = floats[5];
    }

    public float getDist(float u1,float v1,float u2,float v2){
        return (float)Math.sqrt((u2-u1)*(u2-u1)+(v2-v1)*(v2-v1));
    }

    @Override
    public float getArea() {
        float a = getDist(x1,y1,x2,y2);
        float b = getDist(x1,y1,x3,y3);
        float c = getDist(x2,y2,x3,y3);
        float s = (a+b+c)/2;
        return (float) Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    @Override
    public float getLength() {
        float a = getDist(x1,y1,x2,y2);
        float b = getDist(x1,y1,x3,y3);
        float c = getDist(x2,y2,x3,y3);
        return a+b+c;
    }

    @Override
    public Object accept(IVisitor visitor) {
        return visitor.visit(this);
    }
}

interface IVisitor{
    Object visit(Triangle triangle);
}

class Point{
    float x,y;

    @Override
    public String toString() {
        return "x:"+x+",y:"+y;
    }
}

class CenterVisitor implements IVisitor{
    @Override
    public Object visit(Triangle triangle) {
        Point pt = new Point();
        pt.x = (triangle.x1+triangle.x2+triangle.x3)/3;
        pt.y = (triangle.y1+triangle.y2+triangle.y3)/3;
        return pt;
    }

    public static void main(String[] args) {
        IShape shape = new Triangle(1,2,3,4,5,6);
        IVisitor visitor = new CenterVisitor();
        System.out.println(shape.accept(visitor));
    }
}
