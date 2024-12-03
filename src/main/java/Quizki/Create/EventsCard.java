package Quizki.Create;

import Quizki.Main_window.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.util.NoSuchElementException;

public class EventsCard {
    static class ChangeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Main.scene);
        }
    }
    static class AddCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Create.b_del.setDisable(false);
            String back_text = Create.tf_back_card.getText();
            String face_text = Create.tf_face_card.getText();
            String name = Create.tf_face_card.getText();
            String description = Create.tf_face_card.getText();
            Card card = new Card(name, description, face_text, back_text);
            Create.arr_card.add(card);
            Create.b_count.setText(String.valueOf(Create.arr_card.size()));
            Create.l_card.setText(back_text + " // "+ face_text);
            checkBorder();
        }
    }
    static class PrevCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            Create.b_count.setText(String.valueOf(count-1));
            Create.l_card.setText(Create.arr_card.get(count-2).getFace() + " // " + Create.arr_card.get(count-2).getBack());
            checkBorder();
        }
    }
    static class NextCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            Create.b_count.setText(String.valueOf(count+1));
            Create.l_card.setText(Create.arr_card.get(count).getFace() + " // " + Create.arr_card.get(count).getBack());
            checkBorder();
        }
    }
    static class DelCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            Card key = Create.arr_card.get(count-1);
            Create.arr_card.remove(key);
            Create.b_count.setText(String.valueOf(Create.arr_card.size()));
            checkBorder();
        }
    }
    private static void checkBorder(){
        int count = Integer.parseInt(Create.b_count.getText());
        if (count <= 1){
            Create.b_prev.setDisable(true);
        } else {
            Create.b_prev.setDisable(false);
        }
        if (count != Create.arr_card.size() && Create.arr_card.size() > 1){
            Create.b_next.setDisable(false);
        } else {
            Create.b_next.setDisable(true);
        }
        System.out.println(count);
        if (Create.arr_card.size() == 0){
            Create.b_del.setDisable(true);
        } else {
            Create.b_del.setDisable(false);
        }
    }
}
