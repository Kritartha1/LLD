package com.company.SnakeAndLadder;

public class BoardEntity {

    private int start;
    private int end;
    private BoardEntityType type;

    BoardEntity(int start, int end, BoardEntityType type){
        this.start = start;
        this.end = end;
        this.type = type;
    }

    public int step(){
        return this.end;
    }

    public BoardEntityType getType(){
        return this.type;
    }




}
