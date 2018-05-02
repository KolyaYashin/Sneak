package com.company;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<Cell> deleteLastAndAddNewCell(Cell newCell,ArrayList<Cell> cells){
        cells.remove(0);
        cells.add(newCell);
        return cells;
    }
    private static ArrayList<Cell> AddNewCell(Cell newCell,ArrayList<Cell> cells){
        cells.add(newCell);
        return cells;
    }
    private static void show(Sneak sneak){
        StdDraw.clear();
        for (int i = 0; i < sneak.cells.size(); i++) {
            if(!sneak.alive){
                StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.text(.5,.5,"GAME OVER, YOUR SCORE: "+sneak.cells.size());
            }
            StdDraw.setPenColor(StdDraw.RED);
            StdDraw.filledCircle(eat.x/25,eat.y/25,.02);
            StdDraw.setPenColor(0, 170, 0);
            StdDraw.filledSquare(sneak.cells.get(i).x / 25, sneak.cells.get(i).y / 25, .02);

        }StdDraw.show(speed);
    }
    public static Cell eat=new Cell(0+(int)(Math.random()*25),0+(int)(Math.random()*25));
    static final int speed=90;
    public static void main(String[] args) {
        ArrayList<Cell> cells=new ArrayList();

        System.out.println(eat.x+" "+eat.y);
        cells.add(new Cell(5,5));
        cells.add(new Cell(6,5));
        cells.add(new Cell(7,5));
        cells.add(new Cell(8,5));
        cells.add(new Cell(9,5));
        cells.add(new Cell(10,5));
        cells.add(new Cell(11,5));
        Sneak sneak=new Sneak(7,"right",cells);
        StdDraw.setCanvasSize(500,500);
        show(sneak);
        boolean toBigNext=false;
        while(sneak.alive){
            if(StdDraw.hasNextKeyTyped()){
                char c=StdDraw.nextKeyTyped();
                if(c=='w'&&!(sneak.direction.compareTo("down")==0)){
                    sneak.direction="up";
                }
                if(c=='d'&&!(sneak.direction.compareTo("left")==0)){
                    sneak.direction="right";
                }
                if(c=='s'&&!(sneak.direction.compareTo("up")==0)){
                    sneak.direction="down";
                }
                if(c=='a'&&!(sneak.direction.compareTo("right")==0)){
                    sneak.direction="left";
                }

            }
            if(sneak.direction=="left"){
                if(sneak.cells.get(sneak.cells.size()-1).x==0){
                    deleteLastAndAddNewCell(new Cell(25,sneak.cells.get(sneak.cells.size()-1).y),sneak.cells);
                }else {
                    if(!toBigNext) {
                        deleteLastAndAddNewCell(new Cell(sneak.cells.get(sneak.cells.size() - 1).x - 1, sneak.cells.get(sneak.cells.size() - 1).y), sneak.cells);
                    }else{
                        AddNewCell(new Cell(sneak.cells.get(sneak.cells.size() - 1).x - 1, sneak.cells.get(sneak.cells.size() - 1).y), sneak.cells);
                        toBigNext=false;
                    }
                }
            }
            if(sneak.direction=="right"){
                if(sneak.cells.get(sneak.cells.size()-1).x==25){
                    deleteLastAndAddNewCell(new Cell(0,sneak.cells.get(sneak.cells.size()-1).y),sneak.cells);
                }else {
                    if(!toBigNext) {
                        deleteLastAndAddNewCell(new Cell(sneak.cells.get(sneak.cells.size() - 1).x + 1, sneak.cells.get(sneak.cells.size() - 1).y), sneak.cells);
                    }else{
                        AddNewCell(new Cell(sneak.cells.get(sneak.cells.size() - 1).x + 1, sneak.cells.get(sneak.cells.size() - 1).y), sneak.cells);
                        toBigNext=false;
                    }
                }
            }
            if(sneak.direction=="up"){
                if(sneak.cells.get(sneak.cells.size()-1).y==25){
                    deleteLastAndAddNewCell(new Cell(sneak.cells.get(sneak.cells.size() - 1).x,0),sneak.cells);
                }else {
                    if(!toBigNext) {
                        deleteLastAndAddNewCell(new Cell(sneak.cells.get(sneak.cells.size() - 1).x, sneak.cells.get(sneak.cells.size() - 1).y + 1), sneak.cells);
                    }else{
                        AddNewCell(new Cell(sneak.cells.get(sneak.cells.size() - 1).x, sneak.cells.get(sneak.cells.size() - 1).y + 1), sneak.cells);
                        toBigNext=false;
                    }
                }
            }
            if(sneak.direction=="down"){
                if(sneak.cells.get(sneak.cells.size()-1).y==0){
                    deleteLastAndAddNewCell(new Cell(sneak.cells.get(sneak.cells.size() - 1).x,25),sneak.cells);

                }else {
                    if(!toBigNext) {
                        deleteLastAndAddNewCell(new Cell(sneak.cells.get(sneak.cells.size() - 1).x, sneak.cells.get(sneak.cells.size() - 1).y - 1), sneak.cells);
                    }else{
                        AddNewCell(new Cell(sneak.cells.get(sneak.cells.size() - 1).x, sneak.cells.get(sneak.cells.size() - 1).y - 1), sneak.cells);
                        toBigNext=false;
                    }
                }
            }
            for(int i=0;i<sneak.cells.size()-2;i++) {
                if (sneak.cells.get(sneak.cells.size() - 1).y==sneak.cells.get(i).y&&sneak.cells.get(sneak.cells.size() - 1).x==sneak.cells.get(i).x) {

                    sneak.alive=false;
                }
            }
            if(sneak.cells.get(sneak.cells.size()-1).x==eat.x&&sneak.cells.get(sneak.cells.size()-1).y==eat.y){
               eat.x=0+(int)(Math.random()*25);
               eat.y=0+(int)(Math.random()*25);
               toBigNext=true;
            }
            show(sneak);
        }
    }
}
