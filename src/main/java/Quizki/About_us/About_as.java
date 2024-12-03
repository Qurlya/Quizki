package Quizki.About_us;
import Quizki.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class About_as {
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Label l = new Label("Здесь будет описание разработчиков");
            VBox p = new VBox(l);
            Scene scene = new Scene(p, 500, 600);
            scene.getStylesheets().add("about_us_style.css");
            Main.temp.setScene(scene);
        }
    }
}
