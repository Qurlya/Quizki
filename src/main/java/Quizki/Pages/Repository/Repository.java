package Quizki.Pages.Repository;

import Quizki.Pages.Main_window.Main;
import Quizki.Models.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Реализация функционального окна персонального репозитория.
 * Репозиторий представляет структуру тестов, созданных конкретным пользователем.
 * В репозитории хранится информация о тестах: имя, описание и сам тест, доступный к прохождению.
 * К тестам должен быть предоставлен свободный доступ для каждого стороннего пользователя.
 */

public class Repository {
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Label l = new Label("Здесь будут храниться карточки");
            VBox p = new VBox(l);
            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("repository_style.css");
            Main.temp.setScene(scene);
        }
    }
}
