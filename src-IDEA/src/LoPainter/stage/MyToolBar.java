package LoPainter.stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import LoPainter.assets.Path;
import LoPainter.assets.Size;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class MyToolBar {

    private TilePane tpToolBtn;
    private List<MyButton> toolButton = new ArrayList<MyButton>();

    private VBox content;
    private ColorPanel colorPanel;
    private DetailPanel detailPanel;

    public MyToolBar() {
        initToolPanel();
        initUI();
    }

    private void initUI() {
        content = new VBox();
        content.setAlignment(Pos.CENTER);
        content.setSpacing(10);

        content.getChildren().add(tpToolBtn);

        colorPanel = new ColorPanel();
        content.getChildren().add(colorPanel.getColorPanel());

        detailPanel = new DetailPanel();
        content.getChildren().add(detailPanel.getDetailPanel());
    }

    private ImageView getImageView(Image curImg) {
        ImageView curImgV = new ImageView(curImg);
        curImgV.setFitHeight(Size.TOOL_BUTTON_HEIGHT);
        curImgV.setFitWidth(Size.TOOL_BUTTON_WIDTH);
        return curImgV;
    }

    private void initToolPanel() {
        // 按钮区域
        tpToolBtn = new TilePane();
        tpToolBtn.setAlignment(Pos.CENTER);
        tpToolBtn.setPadding(new Insets(10,10,10,10));
        tpToolBtn.setPrefColumns(2);
        tpToolBtn.setHgap(5);
        tpToolBtn.setVgap(5);

        Image ImgPen = new Image(Path.PEN, false);
        MyButton penButton = new MyButton("PEN");
        penButton.setGraphic(getImageView(ImgPen));
        toolButton.add(penButton);

        Image ImgRubber = new Image(Path.RUBBER);
        MyButton rubberButton = new MyButton("RUBBER");
        rubberButton.setGraphic(getImageView(ImgRubber));
        toolButton.add(rubberButton);

        Image ImgBarrel = new Image(Path.BARREL);
        MyButton barrelButton = new MyButton("BARREL");
        barrelButton.setGraphic(getImageView(ImgBarrel));
        toolButton.add(barrelButton);

        Image ImgText = new Image(Path.TEXT);
        MyButton textButton = new MyButton("TEXT");
        textButton.setGraphic(getImageView(ImgText));
        toolButton.add(textButton);

        Image ImgLine = new Image(Path.LINE);
        MyButton lineButton = new MyButton("LINE");
        lineButton.setGraphic(getImageView(ImgLine));
        toolButton.add(lineButton);

        Image ImgRectangleZ = new Image(Path.RECTANGLEZ);
        MyButton zButton = new MyButton("RECTANGLEZ");
        zButton.setGraphic(getImageView(ImgRectangleZ));
        toolButton.add(zButton);

        Image ImgRectangleY = new Image(Path.RECTANGLEY);
        MyButton yButton = new MyButton("RECTANGLEY");
        yButton.setGraphic(getImageView(ImgRectangleY));
        toolButton.add(yButton);

        Image ImgOval = new Image(Path.OVAL);
        MyButton ovalButton = new MyButton("OVAL");
        ovalButton.setGraphic(getImageView(ImgOval));
        toolButton.add(ovalButton);

        Image Circle = new Image(Path.CIRCLE);
        MyButton CirButton = new MyButton("CIRCLE");
        CirButton.setGraphic(getImageView(Circle));
        toolButton.add(CirButton);

        Image TriCursor = new Image(Path.TRIANGLE);
        MyButton TriButton = new MyButton("TRI");
        TriButton.setGraphic(getImageView(TriCursor));
        toolButton.add(TriButton);

        Image ShapeCursor = new Image(Path.SHAPE_CURSOR);
        MyButton SCButton = new MyButton("SC");
        SCButton.setGraphic(getImageView(ShapeCursor));
        toolButton.add(SCButton);

        Image MFB = new Image(Path.MFB);
        MyButton MFButton = new MyButton("MFB");
        MFButton.setGraphic(getImageView(MFB));
        toolButton.add(MFButton);

        DropShadow shadow = new DropShadow();
        for (Button curBt : toolButton) {
            curBt.setStyle("-fx-base:#aaaaaa;");
            curBt.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
                curBt.setEffect(shadow);
            });

            curBt.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
                curBt.setEffect(null);
            });

            curBt.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
                String name = ((MyButton) e.getSource()).getName();
                Shape.resetToolName(name);
                if (name == "TEXT") {
                    detailPanel.setFont();
                }else if(name == "RUBBER" || name == "LINE" || name == "PEN"){
                    detailPanel.setRubber();

                }else if(name == "BARREL"){
                    detailPanel.clear();
                }else if(name == "MFB"){
                    detailPanel.setIMG();
                }
                else{
                    detailPanel.setLine();
                }
                if (name == "TEXT"){
                    TextInputDialog dialog = new TextInputDialog("");
                    dialog.setTitle("文本输入框");
                    dialog.setContentText("请输入");
                    dialog.setHeaderText("修改字体后，直接在画布点击");
                    Optional<String> result = dialog.showAndWait();
                    if (result.isPresent()){
                        Shape.resetText(result.get());
                    }
                }
            });
        }
        tpToolBtn.getChildren().addAll(toolButton);
    }

    public VBox getToolBar() {
        return content;
    }
}

