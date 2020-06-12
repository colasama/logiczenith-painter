package LoPainter.stage;

import javafx.scene.paint.Color;

public class Shape {
    public static String toolName = "填充";
    public static String lineSize = "7";
    public static int rubberSize = 7;
    public static int fontSize = 12;
    public static String fontFamily = "AIGDT";
    public static Color color = Color.BLACK;
    public static String Text = "";
    public static String IMGBox = "";
    public static void resetToolName(String name){
        Shape.toolName = name;
    }
    public static void resetLineSize(String size){
        Shape.lineSize = size;
    }
    public static void resetRubberSize(int size){
        Shape.rubberSize = size;
    }
    public static void resetFontSize(int size){
        Shape.fontSize = size;
    }
    public static void resetFontFamily(String font){
        Shape.fontFamily = font;
    }
    public static void resetColor(Color c){
        Shape.color = c;
    }
    public static void resetText(String s){
        Shape.Text = s;
    }
    public static void resetIMG(String s){
        Shape.IMGBox = s;
    }
}