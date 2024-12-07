package Quizki.Pages.Repository.TestType;

import Quizki.Models.Card;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Реализация класса обработки событий
 * прохождения тестового формата теста (см. TestType).
 */

public class Events {
    static class BackScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Repository.p.getScene());
        }
    }

    static class CheckAnswer implements EventHandler<ActionEvent> {
        RadioButton rb;

        CheckAnswer(RadioButton rb) {
            this.rb = rb;
        }

        @Override
        public void handle(ActionEvent actionEvent) {
            if (rb.getText().equals(TestType.cur_card.getBack())) {
                rb.setStyle("-fx-text-fill: green");
                TestType.arr_corr.add(TestType.cur_card);
            } else {
                rb.setStyle("-fx-text-fill: red");
                TestType.arr_wrong.add(TestType.cur_card);
            }
            TestType.rb_answer1.setDisable(true);
            TestType.rb_answer2.setDisable(true);
            TestType.rb_answer3.setDisable(true);
            TestType.rb_answer4.setDisable(true);
            TestType.b_continue.setDisable(false);

            if (TestType.card_count == TestType.arr_cards.size()) {
                TestType.b_continue.setText("Закончить");
            }

        }
    }

    static class continueCard implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (TestType.b_continue.getText() == "Закончить") {
                Result.changeScene();
                if (TestType.arr_wrong.isEmpty()){
                    Result.b_continue.setDisable(true);
                }
                return;
            }

            TestType.card_count++;
            TestType.l_count.setText(TestType.card_count + " / " + TestType.arr_cards.size());
            TestType.l_card.setText(TestType.arr_cards.get(TestType.card_count - 1).getFace());

            TestType.rb_answer1.setDisable(false);
            TestType.rb_answer2.setDisable(false);
            TestType.rb_answer3.setDisable(false);
            TestType.rb_answer4.setDisable(false);

            TestType.b_continue.setDisable(true);

            TestType.cur_card = TestType.arr_cards.get(TestType.card_count - 1);
            ArrayList<String> arr_answer = createAnswer(TestType.cur_card);
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

        private static ArrayList<String> createAnswer(Card card) {
            ArrayList<Card> arr_temp_cards = (ArrayList<Card>) Repository.cur_collect.getCard_set().clone();

            ArrayList<String> arr_answer = new ArrayList<>();
            arr_answer.add(card.getBack());
            arr_temp_cards.remove(card);
            for (int i = 0; i < 3; i++) {
                Random rand = new Random();
                int rand_number = rand.nextInt(arr_temp_cards.size());
                String temp = arr_temp_cards.get(rand_number).getBack();
                arr_answer.add(temp);
                arr_temp_cards.remove(arr_temp_cards.get(rand_number));
            }
            return arr_answer;
        }
    }

    static class continueStudy implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (TestType.arr_wrong.isEmpty()){
                Result.b_continue.setDisable(true);
                return;
            }
            TestType.arr_cards = TestType.arr_wrong;
            Collections.shuffle(TestType.arr_cards);
            TestType.arr_corr = new ArrayList<>();
            TestType.arr_wrong = new ArrayList<>();
            TestType.cur_card = TestType.arr_cards.getFirst();
            TestType.card_count = 1;
            TestType.changeScene.printScene();
        }
    }
    static class AgainCard implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Result.b_continue.setDisable(false);
            TestType.arr_cards = (ArrayList<Card>) Repository.cur_collect.getCard_set().clone();
            Collections.shuffle(TestType.arr_cards);
            TestType.arr_corr = new ArrayList<>();
            TestType.arr_wrong = new ArrayList<>();
            TestType.cur_card = TestType.arr_cards.getFirst();
            TestType.card_count = 1;
            TestType.changeScene.printScene();
        }
    }
}