package Quizki.Pages.Repository.CardType;

import Quizki.Pages.Main_window.Main;
import Quizki.Pages.Repository.Repository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *  Реализация класса обработки событий функционального
 *  окна прохождения карточек (см. CardType)
 */

public class Events {

    // Переход на окно репозитория
    static class BackScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Repository.p.getScene());
        }
    }

    // Засчитать ответ, как неправильный
    static class CorrectAnswer implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            CardType.arr_corr.add(CardType.cur_card);
            CardType.card_count++;
            if (CardType.card_count == CardType.arr_cards.size() + 1){
                Result.changeScene();
                Main.temp.setScene(Result.scene);
                Result.b_continue.setDisable(CardType.arr_cards.equals(CardType.arr_corr));
            }else{
                CardType.cur_card = CardType.arr_cards.get(CardType.card_count - 1);
                CardType.b_card.setText(CardType.cur_card.getFace());
                CardType.l_count.setText(CardType.card_count + " /" + CardType.arr_cards.size());
            }
        }
    }

    // Засчитать ответ, как неправильный
    static class WrongAnswer implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            CardType.arr_wrong.add(CardType.cur_card);
            CardType.card_count++;
            if (CardType.card_count == CardType.arr_cards.size() + 1){
                Result.changeScene();
                Main.temp.setScene(Result.scene);
            }else {
                CardType.cur_card = CardType.arr_cards.get(CardType.card_count - 1);
                CardType.b_card.setText(CardType.cur_card.getFace());
                CardType.l_count.setText(CardType.card_count + " /" + CardType.arr_cards.size());
            }
        }
    }

    // "Перевернуть" карточку (посмотреть ответ)
    static class FlipCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            if (CardType.b_card.getText().equals(CardType.cur_card.getFace())) CardType.b_card.setText(CardType.cur_card.getBack());
            else CardType.b_card.setText(CardType.cur_card.getFace());
        }
    }

    // Начать прохождение теста с неправильными ответами
    static class Continue implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            CardType.arr_cards = CardType.arr_wrong;

            CardType.arr_wrong = new ArrayList<>();
            CardType.arr_corr = new ArrayList<>();
            CardType.card_count = 1;
            CardType.l_count.setText(CardType.card_count + " / " + CardType.arr_cards.size());
            CardType.cur_card = CardType.arr_cards.getFirst();
            CardType.b_card.setText(CardType.cur_card.getFace());
            Main.temp.setScene(CardType.p.getScene());
        }
    }

    // Начать прохождение теста заново
    static class Reset implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            CardType.arr_cards = Repository.cur_collect.getCard_set();
            Collections.shuffle(CardType.arr_cards);
            CardType.arr_wrong = new ArrayList<>();
            CardType.arr_corr = new ArrayList<>();
            CardType.card_count = 1;
            CardType.l_count.setText(CardType.card_count + " / " + CardType.arr_cards.size());
            CardType.cur_card = CardType.arr_cards.getFirst();
            CardType.b_card.setText(CardType.cur_card.getFace());
            Main.temp.setScene(CardType.p.getScene());
        }
    }

}
