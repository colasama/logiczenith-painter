package LoPainter.Handler;
import LoPainter.stage.Shape;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.util.*;

public class drawButtonHandler{
    private Button toolsPencil;
    private Button toolsEraser;
    private Button toolsUndo;
    private Button toolsRedo;
    private Button toolsLine;
    private List<Button> buttonList;
    private DetailHandler detailPanel;
    public drawButtonHandler(List<Button> buttonList,DetailHandler dp){
        this.detailPanel = dp;
        this.buttonList = buttonList;
        //this.toolsPencil = buttonList.get(0);
        //this.toolsEraser = buttonList.get(1);
        toolsHandler();
    }

    private void toolsHandler(){
        for(Button btn:buttonList){
            btn.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
                String name = ((Button) e.getSource()).getText();//获取它的名字
                System.out.println(name);
                Shape.resetToolName(name);
                if (name == "Text") {
                    detailPanel.setFont();
                }else if(name == "橡皮" || name == "Line" || name == "铅笔N"){
                    detailPanel.setRubber();

                }else if(name == "油漆"){
                    detailPanel.clear();
                }else if(name == "MFB"){
                    detailPanel.setIMG();
                }
                else{
                    detailPanel.setLine();
                }
                if (name == "Text"){
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
        /*toolsPencil.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent e) -> {
            String name = ((Button) e.getSource()).getText();//获取它的名字
            System.out.println(name);
            Shape.resetToolName("PENCIL");
        });*/
    }
}