package Quizki.Pages.Repository.CardType;

import Quizki.Models.JsonHandler;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Collections;

import static Quizki.Models.Variables.curLanguageList;
import static Quizki.Pages.Repository.Repository.changeScene.firstOption;

/**
 * Реализация функционального окна прохождения карточек (см. Models. Card).
 * Если пользователь ответил на некоторые карточки неправильно, то
 * у него будет возможность пройти отдельный тест карточек с исключительно
 * неправильными карточками.
 * Также, у пользователя есть возможность повторно пройти тест.
 */

public class CardType {
    public static Pane card_type_p;
    public static Button b_back, b_correct, b_mistake, b_card;
    public static Label l_count;

    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            card_type_p = new Pane();


            // Инициализация списков
            Repository.arr_cards = Repository.cur_collect.getCard_set();
            Repository.arr_corr = new ArrayList<>();
            Repository.arr_wrong = new ArrayList<>();
            Collections.shuffle(Repository.arr_cards); // Перемешивание списка карточек
            Repository.cur_card = Repository.arr_cards.getFirst();

            // Добавление элементов интерфейса (кнопки, текстовые поля, лейблы)
            b_card = new Button(Repository.cur_card.getFace());
            firstOption(card_type_p, b_card, 360, 150, true);
            b_card.setOnAction(new Events.FlipCard());
            b_card.setId("card");

            l_count = new Label(Repository.card_count + " / " + Repository.arr_cards.size());
            firstOption(card_type_p, l_count, 490, 475, true);

            b_back = new Button(curLanguageList.get("Back"));
            firstOption(card_type_p, b_back, 100, 700, true);
            b_back.setOnAction(new Events.BackScene());

            b_correct = new Button(curLanguageList.get("Test_Correct"));
            firstOption(card_type_p, b_correct, 560, 470, true);
            b_correct.setOnAction(new Events.CorrectAnswer());
            b_correct.getStyleClass().add("cards_answers");

            b_mistake = new Button(curLanguageList.get("Test_Wrong"));
            firstOption(card_type_p, b_mistake, 350, 470, true);
            b_mistake.setOnAction(new Events.WrongAnswer());
            b_mistake.getStyleClass().add("cards_answers");

            firstOption(card_type_p, Variables.copyright, 5, Variables.appHeight - 20, true);
            Variables.copyright.getStyleClass().add("copyright");

            Scene scene = new Scene(card_type_p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            JsonHandler.changeColor(scene);
            Main.temp.setScene(scene);
        }
    }
}
