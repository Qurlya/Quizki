package Quizki.Pages.Repository.TextType;

import Quizki.Models.Card;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;

import static Quizki.Pages.Repository.Repository.changeScene.firstOption;


/**
 * Реализация функционального окна прохождения текстового варианта теста.
 * Происходит сравнение ключевых слов ответа с ключевыми словами пользователя,
 * по однозначному соответствию. ДОЛЖЕН ИМЕТЬ ПАРСЕР!!!
 */

public class TextType {

    public static Pane txt_type_p;
    public static Button b_back, b_continue, b_check;
    public static Label l_count, l_card;
    public static Card cur_card;
    public static TextField tf_answer;

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

        public static void printScene() {
            txt_type_p = new Pane();

            // Добавление элементов интерфейса (кнопки, текстовые поля, лейблы)
            l_card = new Label(Repository.arr_cards.getFirst().getFace());
            firstOption(txt_type_p, l_card, 50, 50, true);

            l_count = new Label(Repository.card_count + " / " + Repository.arr_cards.size());
            firstOption(txt_type_p, l_count, 25, 100, true);

            b_back = new Button(Variables.curLanguageList.get("Back"));
            firstOption(txt_type_p, b_back, 0, 350, true);
            b_back.setOnAction(new Events.BackScene());

            tf_answer = new TextField();
            firstOption(txt_type_p, tf_answer, 10, 200, true);

            b_continue = new Button(Variables.curLanguageList.get("Test_Check"));
            firstOption(txt_type_p, b_continue, 200, 350, true);
            b_continue.setOnAction(new Events.NextCard());

            Scene scene = new Scene(txt_type_p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            Main.temp.setScene(scene);
        }
    }
}