package LoPainter.stage;

import javafx.scene.control.Label;

public interface MyText {
    public static Label curLocation = new Label("");
    /**
     * 状态栏位置信息
     */
    public static void setText(String text){
        curLocation.setText(text);
    }
}
