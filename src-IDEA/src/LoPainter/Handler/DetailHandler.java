package LoPainter.Handler;

import LoPainter.assets.Size;
import LoPainter.stage.Shape;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class DetailHandler {
    private VBox content;
    private ComboBox<String> IMGBox;
    private ComboBox<Integer> fontSize;
    private ComboBox<String> fontFamily;
    private ComboBox<String> lineSize;
    private ComboBox<Integer> rubberSize;
    private ComboBox<Integer> zero1;
    private ComboBox<Integer> zero2;
    private ComboBox toolsSize;
    private ComboBox toolsType;
    private ObservableList<Integer> fontSizeItems = FXCollections.observableArrayList();
    private ObservableList<String> fontFamilyItems = FXCollections.observableArrayList();
    private ObservableList<String> lineSizeItems = FXCollections.observableArrayList();
    private ObservableList<Integer> rubberSizeItems = FXCollections.observableArrayList();
    private ObservableList<String> IMGBoxItems = FXCollections.observableArrayList();


    public DetailHandler(VBox content,ComboBox toolsSize, ComboBox toolsType) {
        this.content = content;
        this.toolsSize = toolsSize;
        this.toolsType = toolsType;
        //content = new VBox();
        //content.setAlignment(Pos.CENTER);
        // 初始化字号
        fontSize = new ComboBox<Integer>();
        fontSize.setStyle("-fx-base:#888888;-fx-background-color:#666666;");
        fontSize.setPrefWidth(Size.DETAIL_WIDTH);
        for (int i = 8; i <= 36; i += 2) {
            fontSizeItems.add(i);
        }
        fontSize.setItems(fontSizeItems);
        fontSize.getSelectionModel().select(0);
        fontSize.valueProperty().addListener((ov, oldv, newv) -> {
            Shape.resetFontSize(Integer.valueOf(newv));
        });
        // 初始化字体
        fontFamily = new ComboBox<String>();
        for (int i = 0; i < Font.getFamilies().size(); i++) {
            fontFamilyItems.add(Font.getFamilies().get(i));
        }
        fontFamily.setStyle("-fx-base:#888888;-fx-background-color:#666666;");
        fontFamily.setPrefWidth(Size.DETAIL_WIDTH);
        fontFamily.setItems(fontFamilyItems);
        fontFamily.getSelectionModel().select(0);
        fontFamily.valueProperty().addListener((ov, oldv, newv) -> {
            Shape.resetFontFamily(newv);
        });
        // 初始化线条
        lineSize = new ComboBox<String>();
        for (int i = 1; i < 14; i += 3) {
            lineSizeItems.add(Integer.toString(i));
        }
        lineSizeItems.add("填充");
        lineSize.setStyle("-fx-base:#888888;-fx-background-color:#666666;");
        lineSize.setPrefWidth(Size.DETAIL_WIDTH);
        lineSize.setItems(lineSizeItems);
        lineSize.getSelectionModel().select(0);
        lineSize.valueProperty().addListener((ov, oldv, newv) -> {
            Shape.resetLineSize(newv);
        });
        // 初始化橡皮擦
        rubberSize = new ComboBox<Integer>();
        for (int i = 1; i < 14; i += 3) {
            rubberSizeItems.add(i);
        }
        rubberSize.setStyle("-fx-base:#888888;-fx-background-color:#666666;");
        rubberSize.setPrefWidth(Size.DETAIL_WIDTH);
        rubberSize.setItems(rubberSizeItems);
        rubberSize.getSelectionModel().select(0);
        rubberSize.valueProperty().addListener((ov, oldv, newv) -> {
            Shape.resetRubberSize(Integer.valueOf(newv));
        });
        //初始化两个空的
        zero1 = new ComboBox<Integer>();
        zero1.setStyle("-fx-base:#888888;-fx-background-color:#666666;");
        zero1.setPrefWidth(Size.DETAIL_WIDTH);
        zero2 = new ComboBox<Integer>();
        zero2.setStyle("-fx-base:#888888;-fx-background-color:#666666;");
        zero2.setPrefWidth(Size.DETAIL_WIDTH);

        IMGBox = new ComboBox<String>();
        IMGBoxItems.add("野兽");
        IMGBoxItems.add("武术家");
        IMGBoxItems.add("恐怖换头怪");
        IMGBox.setStyle("-fx-base:#888888;-fx-background-color:#666666;");
        IMGBox.setPrefWidth(Size.DETAIL_WIDTH);
        IMGBox.setItems(IMGBoxItems);
        IMGBox.getSelectionModel().select(0);
        IMGBox.valueProperty().addListener((ov, oldv, newv) -> {
            Shape.resetIMG(newv);
        });
    }

    public ComboBox<String> getLine(){
        return lineSize;
    }
    public ComboBox<Integer> getFontSize(){
        return fontSize;
    }
    public ComboBox<Integer> getRubber(){
        return rubberSize;
    }
    public ComboBox<String> getFontFamily(){
        return fontFamily;
    }

    public void setLine() {
        content.getChildren().clear();
        toolsSize.setItems(lineSizeItems);
        toolsSize.getSelectionModel().select(0);
        Shape.resetLineSize("1");
        content.getChildren().add(toolsSize);
        content.getChildren().add(toolsType);
    }

    public void  setFont() {
        content.getChildren().clear();
        toolsSize.setItems(fontSizeItems);
        toolsType.setItems(fontFamilyItems);
        toolsType.getSelectionModel().select(0);
        toolsSize.getSelectionModel().select(0);
        Shape.resetFontFamily("AIGDT");
        Shape.resetFontSize(8);
        content.getChildren().add(toolsSize);
        content.getChildren().add(toolsType);
    }

    public void  setRubber() {
        content.getChildren().clear();
        toolsSize.setItems(rubberSizeItems);
        toolsSize.getSelectionModel().select(0);
        Shape.resetRubberSize(1);
        content.getChildren().add(toolsSize);
        content.getChildren().add(toolsType);
    }

    public void setIMG(){
        content.getChildren().clear();
        toolsSize.setItems(IMGBoxItems);
        IMGBox.getSelectionModel().select(0);
        Shape.resetIMG("野兽");
        content.getChildren().add(toolsSize);
        content.getChildren().add(toolsType);
    }

    public void clear() {
        content.getChildren().clear();
        content.getChildren().add(toolsSize);
        content.getChildren().add(toolsType);
    }
    public VBox getDetailPanel(){
        content.getChildren().add(toolsSize);
        content.getChildren().add(toolsType);
        return content;
    }
}