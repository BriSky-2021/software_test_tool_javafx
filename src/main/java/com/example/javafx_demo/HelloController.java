package com.example.javafx_demo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController{

    //题目的文本
    @FXML
    private Label issueText;

    //左侧代码显示框
    @FXML
    private VBox Left;

    //用户名称
    @FXML
    private TextField UserName;


    @FXML
    private StackPane stackPane;

    private Parent display1;
    private Parent hello_view;


    /**
     *
     * @param path 代码路径
     * 根据代码路径，在左侧显示代码
     */
    private void displayCode(String path){

        Left.getChildren().clear();

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    path));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);

                Text newLabel=new Text();
                newLabel.setText(line);
                newLabel.getStyleClass().setAll("code");
                Left.getChildren().add(newLabel);

                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 按下选择代码的事件触发
     */
    @FXML
    protected void chooseCodeFile(){
        //创建文件选择器
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text Files", "*.txt"),
                new FileChooser.ExtensionFilter("C++ Files", "*.cpp", "*.c", "*.h"),
                new FileChooser.ExtensionFilter("java Files", "*.java"),
                new FileChooser.ExtensionFilter("All Files", "*.*"));
        //获取当前窗口
        Stage stage = (Stage) issueText.getScene().getWindow();

        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            System.out.println(selectedFile.getName());
        }
        //在左侧显示打开的文件代码，此处未判断文件类型与大小，如果文件过大，可能崩溃。
        if(true){
            displayCode(selectedFile.getPath());
        }


    }

    /**
     * TODO: 未完成
     * @param actionEvent
     * 选择文件获得测试用例文件
     */
    public void chooseTestCase(ActionEvent actionEvent) {
    }

    /**
     * TODO: 未完成
     * @param actionEvent
     * 开始测试
     */
    public void startTest(ActionEvent actionEvent) {
    }





}