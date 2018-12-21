package com.fun.client.utils;

public class ReturnRandom {
    public static Integer getRandom(Integer d) {
        if ((int)d==0||d==null){
            d=500;
        }
        int a = new java.util.Random().nextInt(1000) + 1;
        if(a>(1000-d)){
            return 1;
        }else{
            return  0;
        }
    }
}
