package Quizki.Pages.Create;

import Quizki.Models.Card;
import Quizki.Models.JsonHandler;
import Quizki.Models.Test;
import Quizki.Pages.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Реализация событий для кнопок функционального окна Create (см. Create).
 */
public class Events {

    public static String test_filepath = "src/main/java/Quizki/Data/test.json";
    public static String card_filepath = "src/main/java/Quizki/Data/card.json";


    // Создание теста (запись в файл JSON)
    static class CreateTest implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Main.scene);
            Test test1 = new Test();
            test1.setName(Create.tf_name.getText());
            test1.setDescription(Create.tf_describe.getText());
            //test1.setQuery();
            //test1.setAnswer();
            //test1.setOptions();
            try {
                JsonHandler.saveToFile(test1, test_filepath);

                Test test = JsonHandler.loadTestFromFile(test_filepath);
                System.out.println(test.getName());
                System.out.println(test.getDescription());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // Создание теста (запись в файл JSON)
    static class CreateCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Main.temp.setScene(Main.scene);
            Card card1 = new Card();
            card1.setName(Create.tf_name.getText());
            card1.setDescription(Create.tf_describe.getText());
            //card1.setQuery();
            //card1.setAnswer();
            //card1.setOptions();
            try {
                JsonHandler.saveToFile(card1, card_filepath);

                Card card = JsonHandler.loadCardFromFile(card_filepath);
                System.out.println(card.getName());
                System.out.println(card.getDescription());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    // Изменение действующей сцены на главную страницу
    static class BackScene implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent){
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
