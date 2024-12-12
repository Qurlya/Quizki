package Quizki.Pages.Repository.TextType;

import Quizki.Models.Card;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.Collections;

import static Quizki.Models.Variables.curLanguageList;

/**
 * Реализация класса обработки событий
 * прохождения текстового формата теста (см. TextType).
 */

public class Events {

    // Переход на сцену репозитория
    static class BackScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Repository.repos_p.getScene());
        }
    }

    // Переход на следующий вопрос
    static class NextCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (TextType.b_continue.getText().equals(curLanguageList.get("Test_Check"))) {
                if (TextType.tf_answer.getText().trim().equalsIgnoreCase(TextType.cur_card.getBack())) {
                    TextType.tf_answer.setStyle("-fx-text-fill: green");
                    Repository.arr_corr.add(TextType.cur_card);
                } else {
                    TextType.tf_answer.setStyle("-fx-text-fill: red");
                    Repository.arr_wrong.add(TextType.cur_card);
                }
                TextType.tf_answer.setDisable(true);
                TextType.b_continue.setText("-->");
                if (Repository.card_count == Repository.arr_cards.size()) {
                    TextType.b_continue.setText(curLanguageList.get("Test_End"));
                }
            } else if (TextType.b_continue.getText().equals("-->")) {
                Repository.card_count++;
                TextType.l_count.setText(Repository.card_count + " / " + Repository.arr_cards.size());
                TextType.l_card.setText(Repository.arr_cards.get(Repository.card_count - 1).getFace());

                TextType.b_continue.setDisable(false);

                TextType.cur_card = Repository.arr_cards.get(Repository.card_count - 1);

                TextType.tf_answer.setStyle("-fx-text-fill: black");
                TextType.tf_answer.setDisable(false);
                TextType.tf_answer.setText("");
                TextType.b_continue.setText(curLanguageList.get("Test_Check"));

            } else {
                Result.changeScene();
                if (Repository.arr_wrong.isEmpty()) {
                    Result.b_continue.setDisable(true);
                }
            }
        }
    }

    // Прохождение теста с неверно отвеченными вопросами
    static class ContinueTest implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (Repository.arr_wrong.isEmpty()) {
                Result.b_continue.setDisable(true);
                return;
            }
            Repository.arr_cards = Repository.arr_wrong;
            Collections.shuffle(Repository.arr_cards);
            Repository.arr_corr = new ArrayList<>();
            Repository.arr_wrong = new ArrayList<>();
            TextType.cur_card = Repository.arr_cards.getFirst();
            Repository.card_count = 1;
            TextType.changeScene.printScene();
        }
    }

    // Повторное прохождение теста в текстовом формате
    static class AgainTest implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Result.b_continue.setDisable(false);
            Repository.arr_cards = (ArrayList<Card>) Repository.arr_cards.clone();
            Collections.shuffle(Repository.arr_cards);
            Repository.arr_corr = new ArrayList<>();
            Repository.arr_wrong = new ArrayList<>();
            TextType.cur_card = Repository.arr_cards.getFirst();
            Repository.card_count = 1;
            TextType.changeScene.printScene();
        }
    }
}