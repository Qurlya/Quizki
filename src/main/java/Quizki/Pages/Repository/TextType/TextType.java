package Quizki.Pages.Repository.TextType;

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


/**
 * Реализация функционального окна прохождения текстового варианта теста.
 * Происходит сравнение ключевых слов ответа с ключевыми словами пользователя,
 * по однозначному соответствию. ДОЛЖЕН ИМЕТЬ ПАРСЕР!!!
 */

public class TextType {

    public static Pane p;
    public static Button b_back, b_continue, b_check;
    public static Label l_count, l_card;
    public static int card_count;
    public static ArrayList<Card> arr_corr, arr_wrong, arr_cards;
    public static Card cur_card;
    public static TextField tf_answer;
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
            firstOption(l_card, 470, 375, true);


            l_count = new Label(card_count + " / " + arr_cards.size());
            firstOption(l_count, 485, 425, true);



            b_back = new Button("💀");
            firstOption(b_back, 100, 700, true);
            b_back.setOnAction(new Quizki.Pages.Repository.TextType.Events.BackScene());



            tf_answer = new TextField();
            firstOption(tf_answer, 435, 475, true);

            b_continue = new Button("Проверить");
            firstOption(b_continue, 445, 525, true);
            b_continue.setOnAction(new Events.ContinueCard());

            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            Main.temp.setScene(scene);
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
    }
}
