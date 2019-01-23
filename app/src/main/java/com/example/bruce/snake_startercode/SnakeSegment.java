package com.example.bruce.snake_startercode;

public class SnakeSegment
{
    private BodyParts mBodyParts;
    private int mDegrees, mXLoc, mYLoc;
    protected enum BodyParts {HEAD, BODY, TAIL};

    public SnakeSegment(int degrees, BodyParts bodyParts, int XLoc, int YLoc)
    {
        mDegrees = degrees;
        mBodyParts = bodyParts;
        mXLoc = XLoc;
        mYLoc = YLoc;
    }

    public BodyParts getBodyParts() {
        return mBodyParts;
    }

    public int getDegrees() {
        return mDegrees;
    }

    public int getXLoc() {
        return mXLoc;
    }

    public int getYLoc() {
        return mYLoc;
    }


    public void setDegrees(int degrees) {
        mDegrees = degrees;
    }

    public void setXLoc(int XLoc) {
        mXLoc = XLoc;
    }

    public void setYLoc(int YLoc) {
        mYLoc = YLoc;
    }

}
