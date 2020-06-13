package LoPainter.Components;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class Shapes2D {
    private GraphicsContext gc;
    private boolean fill;

    public void setCanvas(Canvas c, Color color, boolean f){
        gc = c.getGraphicsContext2D();
        fill = f;
        if(fill)
            gc.setFill(color);
        else
            gc.setStroke(color);
    }

    public void drawLine(double x1, double y1, double x2, double y2) {
        gc.moveTo(x1, y1);
        gc.lineTo(x2, y2);
        gc.stroke();
    }

    public void drawOval(double x1, double y1, double width, double height) {
        if (width < 0) {
            width = -width;
            x1 = x1 - width;
        }
        if (height < 0) {
            height = -height;
            y1 = y1 - height;
        }
        if(fill)
            gc.fillOval(x1, y1, width, height);
        else
            gc.strokeOval(x1, y1, width, height);
    }

    public void drawRectangle(double x1, double y1, double width, double height) {
        if (width < 0) {
            width = -width;
            x1 = x1 - width;
        }
        if (height < 0) {
            height = -height;
            y1 = y1 - height;
        }
        if(fill)
            gc.fillRect(x1, y1, width, height);
        else
            gc.strokeRect(x1, y1, width, height);
    }

    public void drawRoundRectangle(double x1, double y1, double width, double height) {
        if (width < 0) {
            width = -width;
            x1 = x1 - width;
        }
        if (height < 0) {
            height = -height;
            y1 = y1 - height;
        }
        if(fill)
            gc.fillRoundRect(x1, y1, width, height, 30, 30);
        else
            gc.strokeRoundRect(x1, y1, width, height, 30, 30);
    }

    public void drawCircle(double x1, double y1, double x2, double y2){
        double deltax=Math.abs(x1-x2);
        double deltay=Math.abs(y1-y2);
        double res=Math.sqrt(deltax*deltax+deltay*deltay);
        if(fill){
            gc.fillOval(x1-res,y1-res,2*res,2*res);
        }
        else{
            gc.strokeOval(x1-res,y1-res,2*res,2*res);
        }
    }

    public void drawTri(double x1, double y1, double x2, double y2){
        double tg=(y1-y2)/(x1-x2);
        double res=Math.sqrt((y1-y2)*(y1-y2)+(x1-x2)*(x1-x2));
        double x3,y3;
        if(x2<x1) {
            x3 = x2 + res * Math.cos(60 * Math.PI / 180 + Math.atan(tg));
            y3 = y2 + res * Math.sin(60 * Math.PI / 180 + Math.atan(tg));
        }
        else{
            x3 = x1 + res * Math.cos(60 * Math.PI / 180 + Math.atan(tg));
            y3 = y1 + res * Math.sin(60 * Math.PI / 180 + Math.atan(tg));
        }
        double[] x={x1,x2,x3};
        double[] y={y1,y2,y3};
        if(fill){
            gc.fillPolygon(x,y,3);
        }
        else{
            gc.strokePolygon(x,y,3);
        }
    }

    public void MFBImage(Image img,double x1,double y1){
        gc.drawImage(img,x1-img.getWidth()*0.5,y1-img.getHeight()*0.5);
    }

    public void drawFillCanvas(double w, double h){
        gc.fillRect(0, 0, w, h);
    }
}