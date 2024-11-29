package Quizki.Pages.Account;

import Quizki.Pages.Main_window.Main;
import Quizki.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Реализация окна персонального доступа (личного кабинета).
 * Информация об аккаунте:
 * - Логин;
 * - Пароль;
 * - Изменения дизайна приложения;
 * - Актуальный рейтинг в глобальной системе;
 * - Информация о созданных тестах.
 */

public class Account {

    // Главная страница персонального доступа
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Label l = new Label("Здесь будет информация, связанная с аккаунтом");
            VBox p = new VBox(l);
            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            Main.temp.setScene(scene);
        }
    }
}
