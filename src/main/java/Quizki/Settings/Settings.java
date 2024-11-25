package Quizki.Settings;

import Quizki.Main_window.Main;
import Quizki.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Реализация функционала настроечного окна.
 * С помощью настроек каждый пользователь будет иметь доступ к
 * персональному уточнению интерфейса (язык, цвет и т.д.)
 */

public class Settings {
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Label l = new Label("Здесь будут настройки");
            VBox p = new VBox(l);
            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            Main.temp.setScene(scene);
        }
    }
}
