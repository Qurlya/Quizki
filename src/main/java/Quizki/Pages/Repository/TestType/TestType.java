package Quizki.Pages.Repository.TestType;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Реализация функционального окна тестового варианта теста.
 * Пользователю позволяется выбрать только один из вариантов ответа,
 * которые берутся из карточек той же коллекции, что позволяет устранить
 * генерацию на основе ключевых слов.
 */

public class TestType {
    public static class changeScene implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

        }
    }
}
