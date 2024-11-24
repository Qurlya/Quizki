package Quizki.Create;

import Quizki.Main_window.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Events {
    static class ChangeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Main.scene);
        }
    }
    static class ChangeType implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (Create.langsComboBox.getValue() == "Card"){
                Create.b_plus.setVisible(false);
            } else {
                Create.b_plus.setVisible(true);
            }
        }
    }
    static class AddTf implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            TextField tf = new TextField();
            Create.tf_list.add(tf);
            Create.p.getChildren().add(Create.tf_list.getLast());
            System.out.println(Create.tf_list.getLast());

        }
    }
    static class DelTf implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Create.p.getChildren().remove(Create.tf_list.getLast());
            Create.tf_list.remove(Create.tf_list.getLast());
        }
    }
}
