package com.company.SnakeAndLadder;

public class SnakeValidateStrategy implements BoardEntityValidateStrategy{
    @Override
    public boolean validate(int start, int end, int n) {
        return end > 0 && start < n && end < n && start > end;
    }
}
