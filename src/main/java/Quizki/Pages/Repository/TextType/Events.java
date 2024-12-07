package Quizki.Pages.Repository.TextType;

import Quizki.Models.Card;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.Collections;
/**
 * Реализация класса обработки событий
 * прохождения текстового формата теста (см. TextType).
 */

public class Events {
    static class BackScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Repository.p.getScene());
        }
    }

    static class ContinueCard implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (TextType.b_continue.getText() == "Проверить") {
                if (TextType.tf_answer.getText().toUpperCase().equals(TextType.cur_card.getBack().toUpperCase())) {
                    TextType.tf_answer.setStyle("-fx-text-fill: green");
                    TextType.arr_corr.add(TextType.cur_card);
                } else {
                    TextType.tf_answer.setStyle("-fx-text-fill: red");
                    TextType.arr_wrong.add(TextType.cur_card);
                }
                TextType.tf_answer.setDisable(true);
                TextType.b_continue.setText("-->");
                if (TextType.card_count == TextType.arr_cards.size()) {
                    TextType.b_continue.setText("Закончить");
                }
            } else if (TextType.b_continue.getText() == "-->") {
                TextType.card_count++;
                TextType.l_count.setText(TextType.card_count + " / " + TextType.arr_cards.size());
                TextType.l_card.setText(TextType.arr_cards.get(TextType.card_count - 1).getFace());

                TextType.b_continue.setDisable(false);

                TextType.cur_card = TextType.arr_cards.get(TextType.card_count - 1);

                TextType.tf_answer.setStyle("-fx-text-fill: black");
                TextType.tf_answer.setDisable(false);
                TextType.tf_answer.setText("");
                TextType.b_continue.setText("Проверить");

            } else {
                Result.changeScene();
                if (TextType.arr_wrong.isEmpty()) {
                    Result.b_continue.setDisable(true);
                }
            }
        }
    }

    static class ContinueStudy implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (TextType.arr_wrong.isEmpty()){
                Result.b_continue.setDisable(true);
                return;
            }
            TextType.arr_cards = TextType.arr_wrong;
            Collections.shuffle(TextType.arr_cards);
            TextType.arr_corr = new ArrayList<>();
            TextType.arr_wrong = new ArrayList<>();
            TextType.cur_card = TextType.arr_cards.getFirst();
            TextType.card_count = 1;
            TextType.changeScene.printScene();
        }
    }
    static class AgainCard implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Result.b_continue.setDisable(false);
            TextType.arr_cards = (ArrayList<Card>) Repository.cur_collect.getCard_set().clone();
            Collections.shuffle(TextType.arr_cards);
            TextType.arr_corr = new ArrayList<>();
            TextType.arr_wrong = new ArrayList<>();
            TextType.cur_card = TextType.arr_cards.getFirst();
            TextType.card_count = 1;
            TextType.changeScene.printScene();
        }
    }
}
