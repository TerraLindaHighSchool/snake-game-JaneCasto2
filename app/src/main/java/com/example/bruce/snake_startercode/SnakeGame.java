package com.example.bruce.snake_startercode;

import java.util.ArrayList;
import java.util.List;

public class SnakeGame {

  private int mMillisDelay, mScore, mLevel, mCountdown, mSpriteDim, mBOARD_WIDTH, mBOARD_HEIGHT;
  private boolean mGameOver;
  private int[] mAppleCoord = new int[2];
  private List<SnakeSegment> mSnake;

  public SnakeGame(int beginningDirection, int beginningSpriteDim, int beginningX, int beginningY, int width, int height)
  {
    mSnake = new ArrayList<>();
    mSnake.add(new SnakeSegment(beginningDirection, SnakeSegment.BodyParts.HEAD, beginningX, beginningY ));
    mSnake.add(new SnakeSegment(beginningDirection, SnakeSegment.BodyParts.BODY, beginningX-1, beginningY ));
    mSnake.add(new SnakeSegment(beginningDirection, SnakeSegment.BodyParts.TAIL, beginningX-2, beginningY ));
    mSpriteDim = beginningSpriteDim;
    mBOARD_WIDTH = width;
    mBOARD_HEIGHT = height;
    mScore = 0;
    mLevel = 1;
    mCountdown = 12;
    mMillisDelay = 400;
  }


  protected int getMillisDelay(){
    return mMillisDelay;
  }

  protected int getScore(){
    return mScore;
  }

  protected int getLevel(){
    return mLevel;
  }

  protected int getCountdown(){
    return mCountdown;
  }

  protected int getSpriteDim(){
    return mSpriteDim;
  }

  protected List<SnakeSegment> getSnake(){
    return mSnake;
  }

  protected boolean getGameOver(){
    return mGameOver;
  }

  protected int[] getAppleCoord(){
    return mAppleCoord;
  }

  protected void touched(float xTouched, float yTouched){
  
  }
    
  protected void eatApple(){
  
  }
    
  protected boolean play(){
        return false;
  }
}
