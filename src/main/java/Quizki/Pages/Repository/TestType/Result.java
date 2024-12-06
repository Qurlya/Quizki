package Quizki.Pages.Repository.TestType;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Реализация окна результатов прохождения текстового формата теста.
 * Отображаются соответствия между ответами пользователя и ответами теста.
 * Пользователь имеет доступ к повторному прохождению теста,
 * или прохождению специального теста, состоящего исключительно из вопросов,
 * на которые пользователь ответил неправильно (см. TestType).
 */

public class Result {
    public static class changeScene implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

        }
    }
}
