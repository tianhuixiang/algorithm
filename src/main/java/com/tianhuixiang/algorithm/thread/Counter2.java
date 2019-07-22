package com.tianhuixiang.algorithm.thread;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Counter2 extends Applet{
    TextField t = new TextField(10);

    private SeparateSubTask sp = null;

    private Button onOff = new Button("Toggle"),start = new Button("start");

    public void init(){
        add(t);
        start.addActionListener(new StartL());
        add(start);
        onOff.addActionListener(new OnOffL());
        add(onOff);
    }

    class StartL implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(sp == null){
                sp = new SeparateSubTask(Counter2.this);
            }
        }
    }

    class OnOffL implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            if(sp != null){
                sp.invertFlag();
            }
        }
    }

    public static void main(String[] args){
       Counter2 applet = new Counter2();
       Frame frame = new Frame("Counter2");
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
            }
        });
        frame.add(applet,BorderLayout.CENTER);
        frame.setSize(300,300);
        applet.init();
        applet.start();
        frame.setVisible(true);
    }
}
