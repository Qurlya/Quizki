package Quizki.Pages.Account;

import Quizki.Pages.Main_window.Main;
import Quizki.Models.Variables;
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
 * - Изменение дизайна приложения;
 * - Актуальный рейтинг в локальной системе учета активности;
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
            scene.getStylesheets().add("account_style.css");
            Main.temp.setScene(scene);
        }
    }
}
