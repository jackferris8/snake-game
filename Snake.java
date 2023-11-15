package project;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.List;

public class Snake {

	private int score = 0;
	private int L = 1;
	private int R = 2;
	private int D = 3;
	private int U = 4;


	private final int left;
	private final int right;
	private final int up;
	private final int down;
	private boolean east;
	private boolean west;
	private boolean north;
	private boolean south;
	private boolean firstMove = false;
	private boolean gameOn = true;
	private LinkedList<snakeBlock> snakeList;
	private Apple apple;

	public Snake(Apple food) {

		this.snakeList = new LinkedList<>();
		left = KeyEvent.VK_LEFT;
		right = KeyEvent.VK_RIGHT;
		up = KeyEvent.VK_UP;
		down = KeyEvent.VK_DOWN;
		east = true;
		west = false;
		north = false;
		south = false;
		this.apple = food;


		StdDraw.clear(StdDraw.BLACK);
		StdDraw.setPenColor(StdDraw.WHITE);
		snakeList.add(new snakeBlock(.5, .5));

	}

	public void removeLast() {
		snakeList.remove(snakeList.size() - 1);
	}

	public LinkedList<snakeBlock> getList() {

		return this.snakeList;
	}

	public void draw() {
		for (snakeBlock blocks : snakeList) {
			blocks.draw();
		}

	}


	public int keyCheck(int direction) {
		if (StdDraw.isKeyPressed(left) && (!east)) {
			west = true;
			south = false;
			north = false;
			return L;
		}
		if (StdDraw.isKeyPressed(right) && (!west)) {
			east = true;
			north = false;
			south = false;
			return R;
		}
		if (StdDraw.isKeyPressed(up) && (!south)) {
			north = true;
			east = false;
			west = false;
			return U;
		}
		if (StdDraw.isKeyPressed(down) && (!north)) {
			south = true;
			east = false;
			west = false;
			return D;
		}
		return direction;
	}

	public void updateSnake(int direction) {
		double headX;
		double headY;

		if (east) {
			headX = snakeList.getFirst().getX() + 0.02;
			headY = snakeList.getFirst().getY();
			snakeList.addFirst(new snakeBlock(headX, headY));
			if(!Game.isOnFood(this, apple)){
				snakeList.removeLast();
			}

		} else if (west) {
			headX = snakeList.getFirst().getX() - 0.02;
			headY = snakeList.getFirst().getY();
			snakeList.addFirst(new snakeBlock(headX, headY));
			if(!Game.isOnFood(this, apple)){
				snakeList.removeLast();
			}
		} else if (north) {
			headX = snakeList.getFirst().getX();
			headY = snakeList.getFirst().getY() + 0.02;
			snakeList.addFirst(new snakeBlock(headX, headY));
			if(!Game.isOnFood(this, apple)){
				snakeList.removeLast();
			}

		} else if (south) {
			headX = snakeList.getFirst().getX();
			headY = snakeList.getFirst().getY() - 0.02;
			snakeList.addFirst(new snakeBlock(headX, headY));
			if(!Game.isOnFood(this, apple)){
				snakeList.removeLast();
			}
		}
	}

	public boolean collision(){
		double headX;
		double headY;
		headX = snakeList.getFirst().getX();
		headY = snakeList.getFirst().getY();
		if(headX > .99 || headX < 0.01){
			return true;
		}
		if(headY > .99 || headY <0.01){
			return true;
		}
		for(snakeBlock blocks : snakeList){
			if(!(blocks == snakeList.getFirst())){
				if(headX == blocks.getX() && headY == blocks.getY()){
					return true;
				}
			}
		}
		return false;
	}
}