package Quizki.Pages.Repository.TextType;

import Quizki.Models.Card;
import Quizki.Models.JsonHandler;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
 * по однозначному соответствию.
 */

public class TextType {

    public static Pane txt_type_p;
    public static Button b_back, b_continue;
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
            firstOption(txt_type_p, l_card, 203, 125, true);
            l_card.setAlignment(Pos.BOTTOM_CENTER);
            l_card.setId("questions_text");

            l_count = new Label(Repository.card_count + " / " + Repository.arr_cards.size());
            firstOption(txt_type_p, l_count, 490, 375, true);

            b_back = new Button(Variables.curLanguageList.get("Back"));
            firstOption(txt_type_p, b_back, 100, 700, true);
            b_back.setOnAction(new Events.BackScene());

            tf_answer = new TextField();
            firstOption(txt_type_p, tf_answer, 200, 425, true);

            b_continue = new Button(Variables.curLanguageList.get("Test_Check"));
            firstOption(txt_type_p, b_continue, 410, 475, true);
            b_continue.setOnAction(new Events.NextCard());
            b_continue.setId("text_continue");

            firstOption(txt_type_p, Variables.copyright, 5, Variables.appHeight - 20, true);
            Variables.copyright.getStyleClass().add("copyright");

            Scene scene = new Scene(txt_type_p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            JsonHandler.changeColor(scene);
            Main.temp.setScene(scene);
        }
    }
}