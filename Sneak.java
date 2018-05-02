package com.company;

import java.util.*;

public class Sneak {
    public static ArrayList<Cell> cells=new ArrayList();
    public static int length;
    public static String direction;
    public static boolean alive;
    public Sneak(int _length, String _direction,ArrayList<Cell> _cells){
        length=_length;
        direction=_direction;
        cells=_cells;
        alive=true;
    }
}
