package Quizki.Pages.Create;

import Quizki.Models.Card;
import Quizki.Models.Collect;
import Quizki.Models.JsonHandler;
import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.IOException;

import static Quizki.Pages.Create.Create.changeScene.showLoadingWindow;

/**
 * Реализация событий для кнопок функционального окна Create (см. Create).
 */
public class Events {

    // Создание теста (запись в файл JSON)
    static class CreateCollect implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            showLoadingWindow();

            Main.temp.setScene(Main.scene);
            Collect collect = new Collect(Create.tf_name.getText(), Create.tf_describe.getText());
            collect.setCard_set(Create.arr_card);
            String path = Variables.card_filepath + Create.tf_name.getText() + ".json";
            try {
                JsonHandler.saveToFile(collect, path);
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

    // Добавление карточки в коллекцию
    static class AddCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            Create.b_del.setDisable(false);
            String back_text = Create.tf_back_card.getText();
            String face_text = Create.tf_face_card.getText();
            Card card = new Card(face_text, back_text);
            Create.arr_card.add(card);
            Create.b_count.setText(String.valueOf(Create.arr_card.size()));
            Create.l_card.setText(face_text + " // "+ back_text);
            checkBorder();
        }
    }

    // Переход на предыдущую созданную карточку
    static class PrevCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            Create.b_count.setText(String.valueOf(count - 1));
            int prev = count - 2;
            Create.l_card.setText(Create.arr_card.get(prev).getFace() + " // " + Create.arr_card.get(prev).getBack());
            checkBorder();
        }
    }

    // Переход на следующую карточку (если такая есть)
    static class NextCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            Create.b_count.setText(String.valueOf(count + 1));
            Create.l_card.setText(Create.arr_card.get(count).getFace() + " // " + Create.arr_card.get(count).getBack());
            checkBorder();
        }
    }

    // Удаление карточки из коллекции (если такая есть)
    static class DelCard implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Create.b_count.getText());
            Card key = Create.arr_card.get(count - 1);
            Create.arr_card.remove(key);
            Create.b_count.setText(String.valueOf(Create.arr_card.size()));
            checkBorder();
        }
    }

    // Проверка существования карточки
    private static void checkBorder(){
        int count = Integer.parseInt(Create.b_count.getText());
        Create.b_prev.setDisable(count <= 1);
        Create.b_next.setDisable(count == Create.arr_card.size() || Create.arr_card.size() <= 1);
        Create.b_del.setDisable(Create.arr_card.isEmpty());
    }
}
