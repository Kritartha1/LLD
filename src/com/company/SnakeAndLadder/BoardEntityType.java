package com.company.SnakeAndLadder;

public enum BoardEntityType {
    SNAKE(new SnakeValidateStrategy()),
    LADDER(new LadderValidateStrategy());
    private final BoardEntityValidateStrategy boardEntityValidateStrategy;

    BoardEntityType(BoardEntityValidateStrategy boardEntityValidateStrategy) {
        this.boardEntityValidateStrategy = boardEntityValidateStrategy;
    }

    public boolean isValid(int start, int end, int size){
        return this.boardEntityValidateStrategy.validate(start, end, size);
    }
}
