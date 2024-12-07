package Quizki.Pages.Repository.TestType;

import Quizki.Models.Card;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Реализация класса обработки событий
 * прохождения тестового формата теста (см. TestType).
 */

public class Events {

    // Возвращение на выбор коллекции тестов и формата прохождения
    static class BackScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Repository.repos_p.getScene());
        }
    }

    // Проверка выбранного ответа. Ответ подсвечивается соответствующим цветом:
    // Зеленый - правильно, красный неправильно.
    static class CheckAnswer implements EventHandler<ActionEvent> {
        RadioButton rb;
        CheckAnswer(RadioButton rb) {
            this.rb = rb;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            if (rb.getText().equals(TestType.cur_card.getBack())) {
                rb.setStyle("-fx-text-fill: green");
                Repository.arr_corr.add(TestType.cur_card);
            } else {
                rb.setStyle("-fx-text-fill: red");
                Repository.arr_wrong.add(TestType.cur_card);
            }
            TestType.rb_answer1.setDisable(true);
            TestType.rb_answer2.setDisable(true);
            TestType.rb_answer3.setDisable(true);
            TestType.rb_answer4.setDisable(true);
            TestType.b_continue.setDisable(false);

            if (Repository.card_count == Repository.arr_cards.size()) {
                TestType.b_continue.setText("Закончить");
            }

        }
    }

    // Переход на следующий вопрос теста
    static class NextCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (TestType.b_continue.getText().equals("Закончить")) {
                Result.changeScene();
                if (Repository.arr_wrong.isEmpty()) {
                    Result.b_continue.setDisable(true);
                }
                return;
            }

            Repository.card_count++;
            TestType.l_count.setText(Repository.card_count + " / " + Repository.arr_cards.size());
            TestType.l_card.setText(Repository.arr_cards.get(Repository.card_count - 1).getFace());

            TestType.rb_answer1.setDisable(false);
            TestType.rb_answer2.setDisable(false);
            TestType.rb_answer3.setDisable(false);
            TestType.rb_answer4.setDisable(false);

            TestType.b_continue.setDisable(true);

            TestType.cur_card = Repository.arr_cards.get(Repository.card_count - 1);
            ArrayList<String> arr_answer = TestType.changeScene.createAnswer(TestType.cur_card);
            Collections.shuffle(arr_answer);

            TestType.rb_answer1.setDisable(false);
            TestType.rb_answer2.setDisable(false);
            TestType.rb_answer3.setDisable(false);
            TestType.rb_answer4.setDisable(false);

            TestType.rb_answer1.setStyle("-fx-text-fill: black");
            TestType.rb_answer2.setStyle("-fx-text-fill: black");
            TestType.rb_answer3.setStyle("-fx-text-fill: black");
            TestType.rb_answer4.setStyle("-fx-text-fill: black");

            TestType.rb_answer1.setText(arr_answer.get(0));
            TestType.rb_answer2.setText(arr_answer.get(1));
            TestType.rb_answer3.setText(arr_answer.get(2));
            TestType.rb_answer4.setText(arr_answer.get(3));

            TestType.rb_answer1.setSelected(false);
            TestType.rb_answer2.setSelected(false);
            TestType.rb_answer3.setSelected(false);
            TestType.rb_answer4.setSelected(false);
        }
    }

    // Пройти тест с неверно отвеченными вопросами
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
            TestType.cur_card = Repository.arr_cards.getFirst();
            Repository.card_count = 1;
            TestType.changeScene.printScene();
        }
    }

    // Повторное прохождение теста в тестовом формате
    static class AgainTest implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Result.b_continue.setDisable(false);
            Repository.arr_cards = (ArrayList<Card>) Repository.cur_collect.getCard_set().clone();
            Collections.shuffle(Repository.arr_cards);
            Repository.arr_corr = new ArrayList<>();
            Repository.arr_wrong = new ArrayList<>();
            TestType.cur_card = Repository.arr_cards.getFirst();
            Repository.card_count = 1;
            TestType.changeScene.printScene();
        }
    }
}