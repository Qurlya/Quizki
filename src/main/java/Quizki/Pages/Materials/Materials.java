package Quizki.Pages.Materials;

import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Реализация окна информационных материалов, предоставляемых пользователям
 * на правах свободного доступа и владения информацией.
 * Материалы представляют совокупность информационных источников (литературу),
 * к которым пользователи могут свободно обращаться с целью просвещения.
 * В будущем:
 * - Реализовать ИИ для распознавания и создания соответствующего теста по выбранным
 * контекстам материалов.
 */

public class Materials {
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Label l = new Label("Здесь будут учебные пособия");
            VBox p = new VBox(l);
            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            scene.getStylesheets().add("materials_style.css");
            Main.temp.setScene(scene);
        }
    }
}
