package org.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.text.Text;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label textNumber;
    @FXML
    private Spinner<Integer> number;
    @FXML
    protected void sendToServer(ActionEvent event) throws IOException {
        int num = number.getValue();
        System.out.println(num);
        ClientSocket.getInstance().getOut().writeInt(num);
        ClientSocket.getInstance().getOut().flush();
        String response = ClientSocket.getInstance().getIn().readUTF();
        System.out.println(response);
        textNumber.setText(response);
    }
}