package com.company.SnakeAndLadder;

public class RegularDice implements Dice{

    int sides;

    RegularDice(int sides){
        this.sides = sides;
    }

    @Override
    public int roll()
    {
            return (int) (Math.random() * sides) + 1;
    }

}
