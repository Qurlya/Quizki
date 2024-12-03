package Quizki.Materials;

import Quizki.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Materials {
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Label l = new Label("Здесь будут учебные пособия");
            VBox p = new VBox(l);
            Scene scene = new Scene(p, 500, 600);
            scene.getStylesheets().add("material_style.css");
            Main.temp.setScene(scene);
        }
    }
}
