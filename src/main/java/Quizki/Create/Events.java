package Quizki.Create;

import Quizki.Main_window.Main;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
                Create.b_minus.setVisible(false);
            } else {
                Create.b_plus.setVisible(true);
                Create.b_minus.setVisible(true);
            }
        }
    }
    static class AddCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {

            String back_text = Create.tf_back_card.getText();
            String face_text = Create.tf_face_card.getText();
            Create.dict_card.put(face_text, back_text);
            Create.arr_card.add(face_text);
            Create.b_count.setText(String.valueOf(Create.dict_card.size()));
            Create.l_card.setText(back_text + " // "+ face_text);

            checkBorder();
        }
    }
    static class PrevCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            String key = Create.arr_card.get(count - 2);
            Create.b_count.setText(String.valueOf(count-1));
            Create.l_card.setText(key + " // " +Create.dict_card.get(key));
            checkBorder();
        }
    }
    static class NextCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            String key = Create.arr_card.get(count);
            Create.b_count.setText(String.valueOf(count+1));
            Create.l_card.setText(key + " // " +Create.dict_card.get(key));
            checkBorder();
        }
    }
    static class DelCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            String key = Create.arr_card.get(count-1);
            Create.arr_card.remove(key);
            Create.dict_card.remove(key);
            Create.b_count.setText(String.valueOf(Create.arr_card.size()));
            Create.l_card.setText(Create.arr_card.getLast() + " // " + Create.dict_card.get(Create.arr_card.getLast()));
            checkBorder();
        }
    }
    private static void checkBorder(){
        int count = Integer.parseInt(Create.b_count.getText());
        if (count == 1){
            Create.b_prev.setDisable(true);
        } else {
            Create.b_prev.setDisable(false);
        }
        if (count != Create.arr_card.size() && Create.arr_card.size() != 1){
            Create.b_next.setDisable(false);
        } else {
            Create.b_next.setDisable(true);
        }
    }
}
