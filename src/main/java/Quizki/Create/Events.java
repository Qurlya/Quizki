package Quizki.Create;

import Quizki.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.NoSuchElementException;

/**
 * Реализация событий, для кнопок функционального окна Create (см. Create).
 */
public class Events {

    // Изменение действующей сцены на главную страницу
    static class ChangeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Main.scene);
        }
    }

    // Изменение типа действующего тестового формата
    static class ChangeType implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Create.b_plus.setVisible(!Create.langsComboBox.getValue().equals("Card"));
        }
    }

    // Добавление полей вариантов ответа
    static class AddTf implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            TextField tf = new TextField();
            Create.tf_list.add(tf);
            Create.p.getChildren().add(Create.tf_list.getLast());
            //System.out.println(Create.tf_list.getLast());

        }
    }

    // Удаление полей вариантов ответа
    static class DelTf implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            // Исключение, если пользователь пытается удалить несуществующее поле ответа
            try {
                Create.p.getChildren().remove(Create.tf_list.getLast());
                Create.tf_list.remove(Create.tf_list.getLast());
            }catch(NoSuchElementException e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Quizki Alarm");
                alert.setContentText("NoSuchElementException: DON'T TRY TO DELETE NOTHING!");
                alert.showAndWait();
            }
        }
    }
}
