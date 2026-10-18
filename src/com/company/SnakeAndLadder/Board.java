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
        if(currPos + dice > size ){
            return currPos;
        }

        if(entities[currPos+dice]!=null){
            return entities[currPos+dice].step();
        }

        return currPos+dice;
    }

    public boolean addEntity(String entity_type, int start, int end){
        if(this.entities[start]!=null){
            return false;
        }
        this.entities[start] = new BoardEntity(start, end, entity_type);
        return true;
    }

    public boolean isEnd(int currPos){
        return this.size == currPos;
    }

    public int getSize(){
        return this.size;
    }
}
