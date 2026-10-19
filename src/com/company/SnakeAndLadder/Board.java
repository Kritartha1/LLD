package com.company.SnakeAndLadder;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private int size;
    private BoardEntity[] entities;

    Board(int size){
        this.size = size;
        this.entities = new BoardEntity[size+1];
    }

    public int findNextPosition(int currPos, int dice){
        return findNextPosition(currPos, dice, new boolean[size+1]);
    }


    public int findNextPosition(int currPos, int dice, boolean[] vis){
        if(currPos + dice > size ){
            return currPos;
        }

        if(entities[currPos+dice]!=null && !vis[currPos+dice]){
            vis[currPos+dice] = true;
            return findNextPosition(entities[currPos+dice].step(), 0, vis);
        }

        return currPos+dice;
    }

    public boolean addEntity(BoardEntityType entity_type, int start, int end){

        if(entity_type.isValid(start, end, size) && this.entities[start]==null){
            this.entities[start] = new BoardEntity(start, end, entity_type);
            return true;
        }
        return false;

    }

    public boolean isEnd(int currPos){
        return this.size == currPos;
    }

    public int getSize(){
        return this.size;
    }

}
