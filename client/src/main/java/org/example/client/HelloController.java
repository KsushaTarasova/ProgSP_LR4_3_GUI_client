package org.example.client;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.text.TextFlow;

public class HelloController {
    @FXML
    private TextFlow textNumber;
    @FXML
    private Spinner<Integer> number;
    @FXML
    protected void sendToServer(){
        int num = number.getValue();

    }
}