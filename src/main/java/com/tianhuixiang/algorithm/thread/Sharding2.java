package com.tianhuixiang.algorithm.thread;

import java.applet.Applet;
import java.awt.*;

public class Sharding2 extends Applet{
    TwoCounter2[] s;
    private static int accessCount = 0;
    private static TextField aCount = new TextField("0",10);
    public static void incrementAccess(){
        accessCount ++ ;
        aCount.setText(Integer.toString(accessCount));
    }

    private Button start = new Button("Start"),
            observer = new Button("Observe");
    private boolean isApplet = true;
    private int numCounters = 0;
    private int numObservers = 0;
    public void init(){
        if(isApplet){
            numCounters = Integer.parseInt(getParameter("size"));
            numObservers = Integer.parseInt(getParameter("observers"));
        }
    }

}

class TwoCounter2 extends Thread{
    private boolean started = false;
    private TextField t1 = new TextField(5),t2 = new TextField(5);
    private Label l = new Label("count1 == count2");
    private int count1 = 0,count2 = 0;
    public TwoCounter2(Container c){
        Panel p = new Panel();
        p.add(t1);
        p.add(t2);
        p.add(l);
        p.add(p);
    }

    public void start(){
        if(!started){
            started = true;
            super.start();
        }
    }

    public synchronized void run(){
        while (true){
            t1.setText(Integer.toString(count1 ++));
            t2.setText(Integer.toString(count2 ++));
            try{
                sleep(500);
            }catch (InterruptedException e){

            }
        }
    }

    public synchronized void synchTest(){
        if(count1 != count2){
            l.setText("Unsynched");
        }
    }
}

class Watcher2 extends Thread{
    private Sharding2 p;
    public Watcher2(Sharding2 p){
        this.p = p;
        start();
    }

    public void run(){
        while(true){
            for (int i =0;i <10;i++){

            }
        }
    }
}