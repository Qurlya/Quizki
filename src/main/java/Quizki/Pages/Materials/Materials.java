package Quizki.Pages.Materials;

import Quizki.Pages.Main_window.Main;
import Quizki.Models.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Реализация окна информационных материалов, предоставляемых пользователям
 * на правах свободного доступа и владения информацией.
 * Материалы представляют совокупность информационных источников (литературу),
 * к которым пользователи могут свободно обращаться с целью просвещения.
 * В будущем:
 * - Реализовать ИИ для распознавания и создания соответствующего теста по выбранным
 *   контекстам материалов.
 */

public class Materials {
    public static Pane p;
    public static Button b_back;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            p = new Pane();
            Scene scene = new Scene(p, Variables.appWidth, Variables.appHeight);
            b_back = new Button("Назад");
            firstOption(b_back, 0, 500, true);
            b_back.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Main.temp.setScene(Main.scene);
                }

            });
            scene.getStylesheets().add("materials_style.css");
            Main.temp.setScene(scene);
        }
        private void firstOption(Button temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(TextField temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(Label temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
    }
}
