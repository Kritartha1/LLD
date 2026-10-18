package com.company.SnakeAndLadder;


public class Player {
    private int id;
    private String name;
    private int currPos;

    Player(int id, int currPos, String name){
        this.id = id;
        this.currPos = currPos;
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public int getCurrPos(){
        return this.currPos;
    }

    public int setCurrPos(int position){
        return this.currPos = position;
    }

    public String getName(){
        return this.name;
    }

}
