package Quizki.About_us;
import Quizki.Main_window.Main;
import Quizki.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * Реализация информационного окна.
 * Содержит информацию о проекте, его разрабокте, а также о самих разработчиках.
 */

public class About_us {
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Label l = new Label("Здесь будет описание разработчиков");
            VBox p = new VBox(l);
            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            Main.temp.setScene(scene);
        }
    }
}
