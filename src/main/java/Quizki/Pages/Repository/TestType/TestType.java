package Quizki.Pages.Repository.TestType;

import Quizki.Models.Card;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
/**
 * Реализация функционального окна тестового варианта теста.
 * Пользователю позволяется выбрать только один из вариантов ответа,
 * которые берутся из карточек той же коллекции, что позволяет устранить
 * генерацию на основе ключевых слов.
 */

public class TestType {
    public static Pane p;
    public static Button b_back, b_continue;
    public static Label l_count, l_card;
    public static int card_count;
    public static ArrayList<Card> arr_corr, arr_wrong, arr_cards;
    public static Card cur_card;
    public static ToggleGroup group;
    public static RadioButton rb_answer1, rb_answer2, rb_answer3, rb_answer4;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            arr_cards = (ArrayList<Card>) Repository.cur_collect.getCard_set().clone();
            Collections.shuffle(arr_cards);
            arr_corr = new ArrayList<>();
            arr_wrong = new ArrayList<>();
            cur_card = arr_cards.getFirst();
            card_count = 1;

            printScene();

        }
        public static void printScene(){
            p = new Pane();


            l_card = new Label(arr_cards.getFirst().getFace());
            firstOption(l_card, 480, 200, true);


            l_count = new Label(card_count + " / " + arr_cards.size());
            firstOption(l_count, 497, 475, true);

            b_back = new Button("💀");
            firstOption(b_back, 100, 700, true);
            b_back.setOnAction(new Events.BackScene());


            ArrayList<String> arr_answer = createAnswer(cur_card);
            Collections.shuffle(arr_answer);

            group = new ToggleGroup();

            rb_answer1 = new RadioButton(arr_answer.get(0));
            firstOption(rb_answer1, 400, 245, true);
            rb_answer1.setOnAction(new Events.CheckAnswer(rb_answer1));

            rb_answer2 = new RadioButton(arr_answer.get(1));
            firstOption(rb_answer2, 400, 305, true);
            rb_answer2.setOnAction(new Events.CheckAnswer(rb_answer2));

            rb_answer3 = new RadioButton(arr_answer.get(2));
            firstOption(rb_answer3, 400, 365, true);
            rb_answer3.setOnAction(new Events.CheckAnswer(rb_answer3));

            rb_answer4 = new RadioButton(arr_answer.get(3));
            firstOption(rb_answer4, 400, 425, true);
            rb_answer4.setOnAction(new Events.CheckAnswer(rb_answer4));


            rb_answer1.setToggleGroup(group);
            rb_answer2.setToggleGroup(group);
            rb_answer3.setToggleGroup(group);
            rb_answer4.setToggleGroup(group);


            b_continue = new Button("--->");
            firstOption(b_continue, 600, 475, true);
            b_continue.setDisable(true);
            b_continue.setOnAction(new Events.continueCard());

            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            Main.temp.setScene(scene);
        }
        public static ArrayList<String> createAnswer(Card card){

            ArrayList<Card> arr_temp_cards = (ArrayList<Card>) Repository.cur_collect.getCard_set().clone();


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
        // Методы добавления функциональных и текстовых элементов на главной панели
        private static void firstOption(Button temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private static void firstOption(TextField temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private static void firstOption(Label temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private static void firstOption(RadioButton temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
    }
}
