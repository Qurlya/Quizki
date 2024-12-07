package Quizki.Pages.Repository.CardType;

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

            Repository.arr_cards = Repository.cur_collect.getCard_set();
            Repository.arr_corr = new ArrayList<>();
            Repository.arr_wrong = new ArrayList<>();
            Repository.cur_card = Repository.arr_cards.getFirst();

            Collections.shuffle(Repository.arr_cards);

            b_card = new Button(Repository.arr_cards.getFirst().getFace());
            firstOption(card_type_p, b_card, 50, 50, true);
            b_card.setOnAction(new Events.FlipCard());

            l_count = new Label(Repository.card_count + " / " + Repository.arr_cards.size());
            firstOption(card_type_p, l_count, 25, 100, true);

            b_back = new Button("💀");
            firstOption(card_type_p, b_back, 0, 300, true);
            b_back.setOnAction(new Events.BackScene());

            b_correct = new Button("ヾ(≧▽≦*)o");
            firstOption(card_type_p, b_correct, 10, 200, true);
            b_correct.setOnAction(new Events.CorrectAnswer());

            b_mistake = new Button("(┬┬﹏┬┬)");
            firstOption(card_type_p, b_mistake, 150, 200, true);
            b_mistake.setOnAction(new Events.WrongAnswer());

            Scene scene = new Scene(card_type_p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            Main.temp.setScene(scene);
        }
    }
}
