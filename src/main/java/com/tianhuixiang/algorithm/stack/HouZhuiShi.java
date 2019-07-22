package com.tianhuixiang.algorithm.stack;

public class HouZhuiShi {

    public static void main(String[] args){
        SeqStack<Character> seqStack = new SeqStack<Character>();

        String midStr = "1+2*3+(4*5+6)*7";

        StringBuffer rigSb = new StringBuffer();


        for(Character c : midStr.toCharArray()){
            if(c == '+' || c == '-'){
                if(seqStack.isEmpty()){
                    seqStack.push(c);
                }else {
                    Character element = seqStack.get();
                    if(element == '*' || element == '/'){
                        rigSb.append(seqStack.pop());
                        getCharacter(seqStack,rigSb,c);
                    }else{
                        seqStack.push(c);
                    }
                }
            }else if(c == '*' || c == '/'){
                if(seqStack.isEmpty()){
                    seqStack.push(c);
                }else{
                    Character element = seqStack.get();
                    if(element == '*' || element == '/'){
                        element = seqStack.pop();
                        rigSb.append(element);
                        getMultiCharacter(seqStack,rigSb,c);
                    }else{
                        seqStack.push(c);
                    }
                }

            }else if(c == '('){
                seqStack.push(c);
            }else if(c == ')'){
                if(seqStack.isEmpty()){
                    break;
                }

                boolean flag = true;
                while(flag){
                    if(seqStack.isEmpty()){
                        flag = false;
                        continue;
                    }

                    Character element = seqStack.pop();
                    if(element == '('){
                        flag = false;
                    }else{
                        rigSb.append(element);
                    }
                }
            }else{
                rigSb.append(c);
            }
        }

        if(!seqStack.isEmpty()){
            while(!seqStack.isEmpty()){
                rigSb.append(seqStack.pop());
            }
        }

        System.out.println(rigSb.toString());
    }


    public static void getCharacter(SeqStack<Character> seqStack,StringBuffer sb,Character c){
        if(seqStack.isEmpty()){
            return ;
        }
        Character element = seqStack.get();
        if(element == '*' || element == '/'){
            sb.append(seqStack.pop());
            if(seqStack.isEmpty()){
                return;
            }else{
                getCharacter(seqStack,sb,c);
            }
        }else if(element == '+' || element == '-'){
            sb.append(seqStack.pop());
            if(seqStack.isEmpty()){
                seqStack.push(c);
                return;
            }else{
                getCharacter(seqStack,sb,c);
            }
        }else{
            seqStack.push(c);
        }
    }

    public static void getMultiCharacter(SeqStack<Character> seqStack,StringBuffer sb,Character c){
        if(seqStack.isEmpty()){
            return ;
        }
        Character element = seqStack.get();
        if(element == '*' || element == '/'){
            sb.append(seqStack.pop());
            if(seqStack.isEmpty()){
                return;
            }else{
                getCharacter(seqStack,sb,c);
            }
        }else{
            seqStack.push(c);
            return;
        }
    }
}
