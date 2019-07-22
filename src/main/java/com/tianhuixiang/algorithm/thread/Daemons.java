package com.tianhuixiang.algorithm.thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Daemons {
    public static void main(String[] args){
        Thread d = new Daemon();
        System.out.println("d.isDaemon() ="+d.isDaemon());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Waiting for CR");
        try{
            br.readLine();
        }catch (IOException E){}
    }

}
class Daemon extends Thread{
    private static final int SIZE = 10;

    private Thread[] t = new Thread[SIZE];

    public Daemon(){
        setDaemon(true);
        start();
    }

    @Override
    public void run() {
        for(int i=0 ; i<SIZE ; i++){
            t[i] = new DaemonSpawn(i);
        }

        for (int i=0 ;i < SIZE;i++){
            System.out.println("t["+i+"].isDaemon() =" + t[i].isDaemon());
        }
        while (true){
            yield();
        }
    }
}

class DaemonSpawn extends Thread{
    public DaemonSpawn(int i){
        System.out.println("DaemonSpawn" + i + " Started");
        start();
    }

    @Override
    public void run() {
        while (true){
            yield();
        }
    }
}