package fxDrawing.stage;

import javafx.scene.paint.Color;

public class Shape {
    static String toolName = "";
    static String lineSize = "7";
    static int rubberSize = 7;
    static int fontSize = 12;
    static String fontFamily = "AIGDT";
    static Color color = Color.BLACK;
    static String Text = "";
    static String IMGBox = "";
    static void resetToolName(String name){
        Shape.toolName = name;
    }
    static void resetLineSize(String size){
        Shape.lineSize = size;
    }
    static void resetRubberSize(int size){
        Shape.rubberSize = size;
    }
    static void resetFontSize(int size){
        Shape.fontSize = size;
    }
    static void resetFontFamily(String font){
        Shape.fontFamily = font;
    }
    static void resetColor(Color c){
        Shape.color = c;
    }
    static void resetText(String s){
        Shape.Text = s;
    }
    static void resetIMG(String s){
        Shape.IMGBox = s;
    }
}