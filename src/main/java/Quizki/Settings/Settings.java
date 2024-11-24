package Quizki.Settings;

import Quizki.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Settings {
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Label l = new Label("Здесь будут настройки");
            VBox p = new VBox(l);
            Scene scene = new Scene(p, 500, 600);
            Main.temp.setScene(scene);
        }
    }
}
