package com.ct.designPattern.visitor.embed;

import java.lang.reflect.Method;

/**
 * Created by dell on 2018/5/5.
 */
interface IShape {
    float getArea();
    float getLength();
    Object accept(IVisitor visitor,String method);
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
    public Object accept(IVisitor visitor,String method) {
        return visitor.visit(this,method);
    }
}

class Point{
    float x,y;
    @Override
    public String toString() {
        return "x:"+x+",y:"+y;
    }
}

interface IVisitor{
    Object visit(Triangle t,String method);
}
class ShapeVisitor implements IVisitor{
    public Object getCenter(Triangle t){
        Point pt = new Point();
        pt.x = (t.x1+t.x2+t.x3)/3;
        pt.y = (t.y1+t.y2+t.y3)/3;
        return pt;
    }
    public float getInnerCircleR(Triangle t){
        float area = t.getArea();
        float len = t.getLength();
        return new Float(2.0f*area/len);
    }
    @Override
    public Object visit(Triangle t, String method) {
        Object result = null;
        try{
            Class classInfo = this.getClass();
            Method mt = classInfo.getMethod(method,Triangle.class);
            result = mt.invoke(this,new Object[]{t});
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
