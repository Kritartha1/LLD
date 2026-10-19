package com.company.SnakeAndLadder;

public class LadderValidateStrategy implements BoardEntityValidateStrategy{
    @Override
    public boolean validate(int start, int end, int n) {
        return start > 0 && end > 0 && end <= n && start < end;
    }
}
