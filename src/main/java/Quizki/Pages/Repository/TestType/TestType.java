package Quizki.Pages.Repository.TestType;

import Quizki.Models.Card;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import static Quizki.Pages.Repository.Repository.changeScene.firstOption;

/**
 * Реализация функционального окна тестового варианта теста.
 * Пользователю позволяется выбрать только один из вариантов ответа,
 * которые берутся из карточек той же коллекции, что позволяет устранить
 * генерацию на основе ключевых слов.
 */

public class TestType {
    public static Pane test_type_p;
    public static Button b_back, b_continue;
    public static Label l_count, l_card;
    public static Card cur_card;
    public static ToggleGroup group;
    public static RadioButton rb_answer1, rb_answer2, rb_answer3, rb_answer4;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Repository.arr_cards = (ArrayList<Card>) Repository.cur_collect.getCard_set().clone();
            Collections.shuffle(Repository.arr_cards);
            Repository.arr_corr = new ArrayList<>();
            Repository.arr_wrong = new ArrayList<>();
            cur_card = Repository.arr_cards.getFirst();
            Repository.card_count = 1;

            printScene();
        }

        public static void printScene(){
            test_type_p = new Pane();

            l_card = new Label(Repository.arr_cards.getFirst().getFace());
            firstOption(test_type_p, l_card, 50, 50, true);

            l_count = new Label(Repository.card_count + " / " + Repository.arr_cards.size());
            firstOption(test_type_p, l_count, 25, 100, true);

            b_back = new Button("💀");
            firstOption(test_type_p, b_back, 0, 350, true);
            b_back.setOnAction(new Events.BackScene());

            ArrayList<String> arr_answer = createAnswer(cur_card);
            Collections.shuffle(arr_answer);

            group = new ToggleGroup();

            rb_answer1 = new RadioButton(arr_answer.getFirst());
            firstOption(test_type_p, rb_answer1, 10, 200, true);
            rb_answer1.setOnAction(new Events.CheckAnswer(rb_answer1));

            rb_answer2 = new RadioButton(arr_answer.get(1));
            firstOption(test_type_p, rb_answer2, 10, 240, true);
            rb_answer2.setOnAction(new Events.CheckAnswer(rb_answer2));

            rb_answer3 = new RadioButton(arr_answer.get(2));
            firstOption(test_type_p, rb_answer3, 10, 280, true);
            rb_answer3.setOnAction(new Events.CheckAnswer(rb_answer3));

            rb_answer4 = new RadioButton(arr_answer.get(3));
            firstOption(test_type_p, rb_answer4, 10, 320, true);
            rb_answer4.setOnAction(new Events.CheckAnswer(rb_answer4));

            rb_answer1.setToggleGroup(group);
            rb_answer2.setToggleGroup(group);
            rb_answer3.setToggleGroup(group);
            rb_answer4.setToggleGroup(group);

            b_continue = new Button("--->");
            firstOption(test_type_p, b_continue, 200, 350, true);
            b_continue.setDisable(true);
            b_continue.setOnAction(new Events.NextCard());

            Scene scene = new Scene(test_type_p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            Main.temp.setScene(scene);
        }

        public static ArrayList<String> createAnswer(Card card){
            ArrayList<Card> arr_temp_cards = (ArrayList<Card>) Repository.arr_cards.clone();

            ArrayList<String> arr_answer = new ArrayList<>();
            arr_answer.add(card.getBack());
            arr_temp_cards.remove(card);

            for (int i = 0; i < 3; i++){
                Random rand = new Random();
                int rand_number = rand.nextInt(arr_temp_cards.size());
                String temp = arr_temp_cards.get(rand_number).getBack();
                arr_answer.add(temp);
                arr_temp_cards.remove(arr_temp_cards.get(rand_number));
            }

            return arr_answer;
        }
    }
}