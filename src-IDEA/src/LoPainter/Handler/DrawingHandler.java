package LoPainter.Handler;
import LoPainter.assets.Path;
import LoPainter.assets.Size;
import LoPainter.shape.Shapes2D;
import LoPainter.stage.Shape;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.net.URL;
import java.util.*;

public class drawingHandler{
    private GraphicsContext pc;
    private VBox vbo;
    private Group content;
    private Label label;
    private Shapes2D shapeDrawer = new Shapes2D();
    //存储所有的操作/画布
    private List<Canvas> listCanvas;
    private Canvas paintCanvas;
    public static int paintCanvasWidth;
    public static int paintCanvasHeight;
    // 鼠标按下位置
    private double x1;
    private double y1;
    // 鼠标松开位置
    private double x2;
    private double y2;

    public drawingHandler(VBox vbo,Label label){
        this.vbo=vbo;
        this.label=label;
        content = new Group();
        vbo.getChildren().add(content);

        paintCanvas = new Canvas(Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
        pc = paintCanvas.getGraphicsContext2D();
        pc.setFill(Color.WHITE);
        pc.fillRect(0, 0, Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
        pc.restore();
        content.getChildren().add(paintCanvas);
        shapeDrawer.setCanvas(paintCanvas, Shape.color, false);
        paintCanvasWidth = (int) paintCanvas.getWidth();
        paintCanvasHeight = (int) paintCanvas.getHeight();
        listCanvas = new ArrayList<>();
        handlepaintCanvas();
    }

    private void handlepaintCanvas() {
        paintCanvas.setOnMouseMoved(event -> {
            label.setText(String.format("%.2f, %.2fpx ", event.getX(), event.getY()));
        });
        paintCanvas.setOnMouseExited(event -> {
            label.setText("");
        });

        paintCanvas.setOnMousePressed(event -> {
            Canvas c = new Canvas(paintCanvasWidth, paintCanvasHeight);
            pc = c.getGraphicsContext2D();
            c.setOnMousePressed(paintCanvas.getOnMousePressed());
            c.setOnMouseDragged(paintCanvas.getOnMouseDragged());
            c.setOnMouseReleased(paintCanvas.getOnMouseReleased());
            c.setOnMouseMoved(paintCanvas.getOnMouseMoved());
            c.setOnMouseExited(paintCanvas.getOnMouseExited());
            if (Shape.toolName.equals("Oval") || Shape.toolName.equals("Rect") || Shape.toolName.equals("Cir") || Shape.toolName.equals("Tri") ||Shape.toolName.equals("Rect2")) {
                if (!Shape.lineSize.equals("填充")) {
                    pc.setLineWidth(Integer.valueOf(Shape.lineSize));
                    shapeDrawer.setCanvas(c, Shape.color, false);
                } else if (Shape.lineSize.equals("填充")) {
                    shapeDrawer.setCanvas(c, Shape.color, true);
                }
            }else if(Shape.toolName.equals("油漆")){
                shapeDrawer.setCanvas(c, Shape.color, true);
            }else{
                pc.setLineWidth(Shape.rubberSize);
                shapeDrawer.setCanvas(c, Shape.color, false);
            }

            if (Shape.toolName.equals("橡皮"))
                pc.setStroke(Color.WHITE);
            x1 = event.getX();
            y1 = event.getY();
            if(Shape.toolName.equals("文字")){
                pc.setLineWidth(1);
                pc.setFont(Font.font(Shape.fontFamily, Shape.fontSize));
                pc.setStroke(Shape.color);
                pc.strokeText(Shape.Text, event.getX(), event.getY());
            }

            if (Shape.toolName.equals("MFB")){
                Image res=new Image(Path.SHAPE_CURSOR);
                if(Shape.IMGBox.equals("野兽")) {
                    res = new Image(Path.YS);
                }else if(Shape.IMGBox.equals("恐怖换头怪")){
                    res=new Image(Path.MAO);
                }else if(Shape.IMGBox.equals("武术家")){
                    res=new Image(Path.WSJ);
                }
                shapeDrawer.MFBImage(res,x1,y1);
            }

            listCanvas.add(c);
            content.getChildren().add(c);
        });

        paintCanvas.setOnMouseDragged(event -> {
            label.setText(String.format("%.1f, %.1fpx ", event.getX(), event.getY()));
            if (Shape.toolName.equals("铅笔") || Shape.toolName.equals("橡皮")) {
                pc.lineTo(event.getX(), event.getY());
                pc.stroke();
            }
        });

        paintCanvas.setOnMouseReleased(event -> {
            x2 = event.getX();
            y2 = event.getY();
            double width = x2 - x1;
            double height = y2 - y1;
            if (Shape.toolName.equals("Line")) {
                shapeDrawer.drawLine(x1, y1, x2, y2);
            } else if (Shape.toolName.equals("Oval")) {
                shapeDrawer.drawOval(x1, y1, width, height);
            } else if (Shape.toolName.equals("Rect")) {
                shapeDrawer.drawRectangle(x1, y1, width, height);
            } else if (Shape.toolName.equals("Rect2")) {
                shapeDrawer.drawRoundRectangle(x1, y1, width, height);
            } else if (Shape.toolName.equals("油漆")) {
                shapeDrawer.drawFillCanvas(paintCanvasWidth, paintCanvasHeight);
            } else if (Shape.toolName.equals("Cir")){
                shapeDrawer.drawCircle(x1,y1,x2,y2);
            } else if (Shape.toolName.equals("Tri")){
                shapeDrawer.drawTri(x1,y1,x2,y2);
            }
            pc.stroke();
        });
    }

    public List<Canvas> getDraw(){
        return listCanvas;
    }
}