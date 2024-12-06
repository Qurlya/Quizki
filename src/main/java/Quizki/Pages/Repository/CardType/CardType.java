package Quizki.Pages.Repository.CardType;

import Quizki.Models.Card;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;

import java.util.ArrayList;

/**
 *  Реализация функционального окна прохождения карточек (см. Models. Card).
 *  Если пользователь ответил на некоторые карточки неправильно, то
 *  у него будет возможность пройти отдельный тест карточек с исключительно
 *  неправильными карточками.
 *  Также, у пользователя есть возможность повторно пройти тест.
 */

public class CardType {
    public static Pane p;
    public static Button b_back, b_correct, b_mistake, b_card;
    public static Label l_count;
    public static int card_count = 1;
    public static ArrayList<Card> arr_corr, arr_wrong, arr_cards;
    public static Card cur_card;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            p = new Pane();

            arr_cards = Repository.cur_collect.getCard_set();
            arr_corr = new ArrayList<>();
            arr_wrong = new ArrayList<>();
            cur_card = arr_cards.getFirst();

            b_card = new Button(arr_cards.getFirst().getFace());
            firstOption(b_card, 50, 50, true);
            b_card.setOnAction(new Events.FlipCard());

            l_count = new Label(card_count + " / " + arr_cards.size());
            firstOption(l_count, 25, 100, true);

            b_back = new Button("💀");
            firstOption(b_back, 0, 300, true);
            b_back.setOnAction(new Events.BackScene());

            b_correct = new Button("ヾ(≧▽≦*)o");
            firstOption(b_correct, 10, 200, true);
            b_correct.setOnAction(new Events.CorrectAnswer());

            b_mistake = new Button("(┬┬﹏┬┬)");
            firstOption(b_mistake, 150, 200, true);
            b_mistake.setOnAction(new Events.WrongAnswer());

            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            Main.temp.setScene(scene);
        }

        // Методы добавления функциональных и текстовых элементов на главной панели
        private void firstOption(javafx.scene.control.Button temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(javafx.scene.control.TextField temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(Label temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
    }
}
