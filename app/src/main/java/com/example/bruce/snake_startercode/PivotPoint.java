package com.example.bruce.snake_startercode;

public class PivotPoint {

    private int mXLoc, mYLoc, mDegrees;

    public PivotPoint(int XLoc, int YLoc, int Degrees){
        mXLoc = XLoc;
        mYLoc = YLoc;
        mDegrees = Degrees;
    }

    public int getXLoc() {
        return mXLoc;
    }

    public int getYLoc() {
        return mYLoc;
    }

    public int getDegrees() {
        return mDegrees;
    }
}
