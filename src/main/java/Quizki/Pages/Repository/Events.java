package Quizki.Pages.Repository;

import Quizki.Models.Variables;
import Quizki.Pages.Create.Create;
import Quizki.Pages.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.File;

import static Quizki.Models.Variables.curLanguageList;
import static Quizki.Pages.Repository.Repository.*;


/**
 * Реализация класса обработки событий для кнопок
 * функционального окна репозитория (см. Repository)
 */

public class Events {

    // Переход на предыдущий тест
    static class PrevCollection implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(l_count.getText());
            l_count.setText(String.valueOf(count - 1));
            cur_collect = arr_cols.get(count - 2);
            name.setText(curLanguageList.get("Test_Name") + ": " + cur_collect.getName());
            description.setText(curLanguageList.get("Test_Description") + ": " + cur_collect.getDescription());
            checkBorder();
        }
    }

    // Переход на следующий тест
    static class NextCollection implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(l_count.getText());
            l_count.setText(String.valueOf(count + 1));
            cur_collect = arr_cols.get(count);
            name.setText(curLanguageList.get("Test_Name") + ": " + cur_collect.getName());
            description.setText(curLanguageList.get("Test_Description") + ": " + cur_collect.getDescription());
            checkBorder();
        }
    }

    // Удаление текущей выбранной коллекции
    static class DeleteCollection implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            File file = new File(Variables.card_filepath + cur_collect.getName() + ".json");
            if (file.delete()) {
                Main.temp.setScene(Main.scene);
            } else {
                Create.alert.setContentText(curLanguageList.get("Alert_DeleteErr"));
                Create.alert.showAndWait();
            }
        }
    }

    // Проверка существования карточки
    private static void checkBorder() {
        int count = Integer.parseInt(Repository.l_count.getText());
        Repository.b_prev.setDisable(count <= 1);
        Repository.b_next.setDisable(count == Repository.arr_cols.size() || Repository.arr_cols.size() <= 1);
    }
}
