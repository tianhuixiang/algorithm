package com.tianhuixiang.algorithm.thread;

public class SeparateSubTask extends Thread {
    private int count = 0;

    private Counter2 c2;

    private boolean runFlag = true;

    public SeparateSubTask(Counter2 c2){
        this.c2 = c2;
        start();
    }

    public void invertFlag (){
        this.runFlag = ! runFlag;
    }

    @Override
    public void run() {
        while(true){
            try{
                sleep(100);
            }catch (InterruptedException e){

            }
            if(runFlag){
                c2.t.setText(String.valueOf(++ count));
            }
        }
    }

}
