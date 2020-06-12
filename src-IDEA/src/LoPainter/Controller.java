package LoPainter;

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

public class Controller implements Initializable{
    @FXML private ColorPicker colorPicker;
    @FXML private Label label;
    @FXML private Button toolsPencil;
    @FXML private Button toolsEraser;
    @FXML private Canvas paintCanvas;
    //@FXML private AnchorPane acPane;
    @FXML private VBox vbo;

    private Group content;
    private GraphicsContext pc;
    private Shapes2D shapeDrawer = new Shapes2D();
    private List<Canvas> listCanvas;//存储所有的操作/画布
    private List<Button> toolsButton;//存储所有的按钮
    public static int paintCanvasWidth;
    public static int paintCanvasHeight;
    // 鼠标按下位置

    private double x1;
    private double y1;
    // 鼠标松开位置
    private double x2;
    private double y2;
    /*
    public void buttonListener(){
        toolsPencil.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            String name = ((Button) e.getSource()).getText();//获取它的名字
            System.out.println(name);
            Shape.resetToolName(name);
        });
    }
    */
    public void changeText(){
        paintCanvas.setOnMouseMoved(event -> {
            label.setText(String.format("%.2f, %.2fpx ", event.getX(), event.getY()));
        });
        paintCanvas.setOnMouseExited(event -> {
            label.setText("");
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //buttonListener();
        content = new Group();
        vbo.getChildren().add(content);
        changeText();
        paintCanvas = new Canvas(Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
        pc = paintCanvas.getGraphicsContext2D();
        //.setFill(colorPicker.getValue());
        pc.setFill(Color.WHITE);
        pc.fillRect(0, 0, Size.CANVAS_WIDTH, Size.CANVAS_HEIGHT);
        pc.restore();
        content.getChildren().add(paintCanvas);

        shapeDrawer.setCanvas(paintCanvas, Shape.color, false);
        paintCanvasWidth = (int) paintCanvas.getWidth();
        paintCanvasHeight = (int) paintCanvas.getHeight();
        listCanvas = new ArrayList<>();
        handlepaintCanvas();

        colorPicker.setOnAction(new EventHandler() {
            public void handle(Event t) {
                pc.setFill(colorPicker.getValue());
                label.setText(colorPicker.getValue().toString());
                label.setTextFill(colorPicker.getValue());
            }
        });
    }

        private void handlepaintCanvas() {
            paintCanvas.setOnMousePressed(event -> {
                Canvas c = new Canvas(paintCanvasWidth, paintCanvasHeight);
                pc = c.getGraphicsContext2D();

                c.setOnMousePressed(paintCanvas.getOnMousePressed());
                c.setOnMouseDragged(paintCanvas.getOnMouseDragged());
                c.setOnMouseReleased(paintCanvas.getOnMouseReleased());
                c.setOnMouseMoved(paintCanvas.getOnMouseMoved());
                c.setOnMouseExited(paintCanvas.getOnMouseExited());
                if (Shape.toolName.equals("OVAL") || Shape.toolName.equals("RECTANGLEZ") || Shape.toolName.equals("CIRCLE") || Shape.toolName.equals("TRI") ||Shape.toolName.equals("RECTANGLEY")) {
                    if (!Shape.lineSize.equals("填充")) {
                        pc.setLineWidth(Integer.valueOf(Shape.lineSize));
                        shapeDrawer.setCanvas(c, Shape.color, false);
                    } else if (Shape.lineSize.equals("填充")) {
                        shapeDrawer.setCanvas(c, Shape.color, true);
                    }
                }else if(Shape.toolName.equals("BARREL")){
                    shapeDrawer.setCanvas(c, Shape.color, true);
                }else{
                    pc.setLineWidth(Shape.rubberSize);
                    shapeDrawer.setCanvas(c, Shape.color, false);
                }

                if (Shape.toolName.equals("RUBBER"))
                    pc.setStroke(Color.WHITE);
                x1 = event.getX();
                y1 = event.getY();
                if(Shape.toolName.equals("TEXT")){
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
                if (Shape.toolName.equals("PEN") || Shape.toolName.equals("RUBBER")) {
                    pc.lineTo(event.getX(), event.getY());
                    pc.stroke();
                }
            });

            paintCanvas.setOnMouseReleased(event -> {
                x2 = event.getX();
                y2 = event.getY();
                double width = x2 - x1;
                double height = y2 - y1;
                if (Shape.toolName.equals("LINE")) {
                    shapeDrawer.drawLine(x1, y1, x2, y2);
                } else if (Shape.toolName.equals("OVAL")) {
                    shapeDrawer.drawOval(x1, y1, width, height);
                } else if (Shape.toolName.equals("RECTANGLEZ")) {
                    shapeDrawer.drawRectangle(x1, y1, width, height);
                } else if (Shape.toolName.equals("RECTANGLEY")) {
                    shapeDrawer.drawRoundRectangle(x1, y1, width, height);
                } else if (Shape.toolName.equals("BARREL")) {
                    shapeDrawer.drawFillCanvas(paintCanvasWidth, paintCanvasHeight);
                } else if (Shape.toolName.equals("CIRCLE")){
                    shapeDrawer.drawCircle(x1,y1,x2,y2);
                } else if (Shape.toolName.equals("TRI")){
                    shapeDrawer.drawTri(x1,y1,x2,y2);
                }
                pc.stroke();
            });
        }

    }
