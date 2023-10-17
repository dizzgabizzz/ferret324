package com.example.ferret.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TokenGenerator {

    public static final String TAG = "Token Generator";

    public static int getRandomToken(){
        return (int) Math.floor(Math.random() * Math.floor(9999999));
    }

    public static ArrayList<Integer> getRandomPositions(){
        ArrayList<Integer> mNumbersList = new ArrayList<>();
        int vNumberRandom;
        while( mNumbersList.size() < 3){
            vNumberRandom = (int) (Math.floor(Math.random() * Math.floor(7))) + 1;
            if(!mNumbersList.contains(vNumberRandom)){
                mNumbersList.add(vNumberRandom);
            }

        }
        Collections.sort(mNumbersList);
        return  mNumbersList;

    }




}
