package com.example.bruce.snake_startercode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame {

  private int mMillisDelay, mScore, mLevel, mCountdown, mSpriteDim, mBOARD_WIDTH, mBOARD_HEIGHT, mXMax, mYMax;
  private boolean mGameOver;
  private int[] mAppleCoord = new int[2];
  private List<SnakeSegment> mSnake;
  private List<PivotPoint> mPivotPoints;


  public SnakeGame(int beginningDirection, int beginningSpriteDim, int beginningX, int beginningY, int width, int height) {
    mSnake = new ArrayList<>();
    mSnake.add(new SnakeSegment(beginningDirection, SnakeSegment.BodyParts.HEAD, beginningX, beginningY));
    mSnake.add(new SnakeSegment(beginningDirection, SnakeSegment.BodyParts.BODY, beginningX - 1, beginningY));
    mSnake.add(new SnakeSegment(beginningDirection, SnakeSegment.BodyParts.TAIL, beginningX - 2, beginningY));
    mPivotPoints = new ArrayList<>();
    mSpriteDim = beginningSpriteDim;
    mBOARD_WIDTH = width;
    mBOARD_HEIGHT = height;
    mScore = 0;
    mLevel = 1;
    mCountdown = 12;
    mMillisDelay = 400;
    mXMax = width/beginningSpriteDim;
    mYMax = height/beginningSpriteDim;
    setAppleCoord();
  }

    private void setAppleCoord(){
        SnakeSegment segment = mSnake.get(0);
        do{
            mAppleCoord[0] = (int) ((mXMax - 1) * Math.random() + 1) * mSpriteDim;
            mAppleCoord[1] = (int) ((mYMax - 1) * Math.random() + 1) * mSpriteDim;
        } while ( mAppleCoord[0] == segment.getXLoc() && mAppleCoord[1] == segment.getYLoc());
    }

  protected int getMillisDelay() {
    return mMillisDelay;
  }

  protected int getScore() {
    return mScore;
  }

  protected int getLevel() {
    return mLevel;
  }

  protected int getCountdown() {
    return mCountdown;
  }

  protected int getSpriteDim() {
    return mSpriteDim;
  }

  protected List<SnakeSegment> getSnake() {
    return mSnake;
  }

  protected boolean getGameOver() {
    return mGameOver;
  }

  protected int[] getAppleCoord() {
    return mAppleCoord;
  }



  protected void touched(float xTouched, float yTouched){
        SnakeSegment segment = mSnake.get(0);
        int x = segment.getXLoc();
        int y = segment.getYLoc();
        int deg = segment.getDegrees();

        if(deg == 180 || deg == 0) {
            if (yTouched > y * mSpriteDim)
                mPivotPoints.add(new PivotPoint(x , y, 90));
            else
                mPivotPoints.add(new PivotPoint(x , y, 270));
        }
        else if(deg == 90 || deg == 270){
            if (xTouched > x * mSpriteDim)
                mPivotPoints.add(new PivotPoint(x, y, 0));
            else
                mPivotPoints.add(new PivotPoint(x, y, 180));
        }
    }


    protected void eatApple() {

  }

  protected boolean play() {

      // declare variables

      for (int segment = 0; segment < mSnake.size(); segment++) {

          int XLoc = mSnake.get(segment).getXLoc();
          int YLoc = mSnake.get(segment).getYLoc();

          for (int i = 0; i < mPivotPoints.size(); i++) {
              PivotPoint pivot = mPivotPoints.get(i);
              if (XLoc == pivot.getXLoc() && YLoc == pivot.getYLoc()) {
                  mSnake.get(segment).setDegrees(pivot.getDegrees());
                  if (mSnake.get(segment).getBodyParts() == SnakeSegment.BodyParts.TAIL)
                      mPivotPoints.remove(i);
                  break;
              }
          }


          switch (mSnake.get(segment).getDegrees()) {
              case 0:
                  mSnake.get(segment).setXLoc(++XLoc);
                  break;
              case 90:
                  mSnake.get(segment).setYLoc(++YLoc);
                  break;
              case 180:
                  mSnake.get(segment).setXLoc(--XLoc);
                  break;
              case 270:
                  mSnake.get(segment).setYLoc(--YLoc);
                  break;
          }
          if (XLoc >= mXMax || YLoc >= mYMax || XLoc <= 0 || YLoc <= 0)
              mGameOver = true;

      }
          return mGameOver;
      }

}





