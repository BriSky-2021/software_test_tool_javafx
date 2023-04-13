package com.example.javafx_demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BaseController implements Initializable {

    @FXML
    private StackPane stackPane;

    private Parent display1;
    private Parent hello_view;

    /**
     * 初始化页面到stackPane中
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            //URL logUrl = getClass().getResource("history.fxml");
            String logUrl="history.fxml";
            display1 =getParent(logUrl);
            //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("history.fxml"));
            //display1=fxmlLoader.load();

            //URL homeUrl = getClass().getResource("hello-view.fxml");
            String homeUrl="hello-view.fxml";
            hello_view =getParent(homeUrl);

            //stackPane.getChildren().addAll(display1);
            stackPane.getChildren().addAll(display1,hello_view);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private Parent getParent(String url) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(url));
        return loader.load();
    }

    @FXML
    protected void gotoHome(ActionEvent actionEvent){

        hello_view.toFront();

    }

    @FXML
    public void gotoLog(ActionEvent actionEvent) {
        display1.toFront();
    }

}
