package com.ct.designPattern.command.embed;

import java.util.ArrayList;

/**
 * Created by dell on 2018/5/6.
 */
class Point {
    float x,y;
    public Point(float x,float y){
        this.x = x;
        this.y = y;
    }
}

class PolyonCalc{

    public float getArea(Point[] pt){
        float s;
        int size = pt.length;
        if(size < 3) return 0;
        s = pt[0].y*(pt[size - 1].x - pt[1].x);
        for(int i=1; i<size; i++) s+=pt[i].y*(pt[i-1].x - pt[(i+1)%size].x);
        return (float)s/2;
    }

    public float getLength(Point[] pt){
        int i=0;
        float len = 0;
        for (i=0; i<pt.length -1; i++){
            len += distance(pt[i],pt[i+1]);
        }
        len += distance(pt[0],pt[pt.length - 1]);
        return len;
    }

    public float distance(Point one,Point two){
        return (float)Math.sqrt((one.x - two.x)*(one.x - two.x) + (one.y - two.y)*(one.y - two.y));
    }
}

interface ICommander{
    float calc();
}

class AreaCommander implements ICommander{
    PolyonCalc calc;
    Point[] pt;
    public AreaCommander(PolyonCalc calc,Point[] pt){
        this.calc = calc;
        this.pt = pt;
    }

    @Override
    public float calc() {
        return calc.getArea(pt);
    }
}

class LenCommander implements ICommander{
    PolyonCalc calc;
    Point[] pt;
    public LenCommander(PolyonCalc calc,Point[] pt){
        this.calc = calc;
        this.pt = pt;
    }

    @Override
    public float calc() {
        return calc.getLength(pt);
    }
}

class CommanderManage{
    ArrayList<ICommander> list = new ArrayList<>();
    public void add(ICommander c){
        list.add(c);
    }
    public void executeCommand(){
        for(int i=0; i<list.size(); i++){
            float value = list.get(i).calc();
            System.out.println("The area is:"+value);
        }
    }
}
