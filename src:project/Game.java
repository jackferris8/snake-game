package project;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
    public final int L = 1;
    public final int R = 2;
    public final int D = 3;
    public final int U = 4;


    public static void main(String[] args) {
        Apple food = new Apple(Math.random(), Math.random());
        int direction = 0;
       Snake snake =  new Snake(food);
       snakeBlock head = snake.getList().get(0);
        System.out.println("I'm a snaaaaaaaake! HISSSSSSSSSSSssssss.....");

        StdDraw.clear(StdDraw.BLACK);
        head.draw();
        food.draw();
        StdDraw.show();


        while(!snake.collision()){
//            if(snake.keyCheck(direction) != 0) {
//                direction = snake.keyCheck(direction);
//            }
//            snakeBlock newSnake = snake.updateSnake(direction);
//            if(Math.abs(snake.getList().get(0).getX()-food.getX()) < 0.005 && Math.abs(snake.getList().get(0).getY()-food.getY()) < 0.005){
//                snake.getList().addFirst(newSnake);
//                food = new Apple(Math.random(), Math.random());
//            }else{
//                snake.getList().addFirst(newSnake);
//                snake.removeLast();
//            }
            StdDraw.clear(StdDraw.BLACK);
            snake.draw();
            food.draw();
            snake.keyCheck(direction);
            snake.updateSnake(direction);
            StdDraw.show(125);


           // StdDraw.pause(100);
            //StdDraw.clear();
        }
    }
    public static boolean isOnFood(Snake s, Apple a){
        double d = Math.sqrt(Math.pow(s.getList().getFirst().getX() - a.getX(),2) + Math.pow(s.getList().getFirst().getY() - a.getY(),2));
        if(d < 0.02){
            a.moveApple();
            return true;
        }
        return false;
    }
}
