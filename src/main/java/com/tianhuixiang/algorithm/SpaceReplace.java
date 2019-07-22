package com.tianhuixiang.algorithm;

public class SpaceReplace {

    public static String replaceSpace(StringBuffer str,String replaceStr){
        Integer p1 = str.length()-1;

        for(int i =0 ; i<= p1; i++){
            if(str.charAt(i) == ' '){
                for(int j = 0;j < replaceStr.length()-1;j++){
                    str.append(" ");
                }
            }
        }

        Integer p2 = str.length()-1;

        while(p1 >= 0 && p2 > p1){
            char c = str.charAt(p1--);
            if(c == ' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else{
                str.setCharAt(p2--,c);
            }
        }
        return str.toString();
    }

    public static void main(String[] args){
        StringBuffer sb = new StringBuffer("A B C");
        System.out.println(replaceSpace(sb,"%20"));
        System.out.println("A B C".replace(" ","%20"));
    }
}
