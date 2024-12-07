package Quizki.Pages.Repository;

import Quizki.Models.Variables;
import Quizki.Pages.Main_window.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.io.File;


/**
 * Реализация класса обработки событий для кнопок
 * функционального окна репозитория (см. Repository)
 */

public class Events {

    // Переход на предыдущий тест
    static class PrevCollection implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Repository.l_count.getText());
            Repository.l_count.setText(String.valueOf(count - 1));
            Repository.cur_collect = Repository.arr_cols.get(count - 2);
            Repository.name.setText("Название: " + Repository.cur_collect.getName());
            Repository.description.setText("Описание: " + Repository.cur_collect.getDescription());
            checkBorder();
        }
    }

    // Переход на следующий тест
    static class NextCollection implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            int count = Integer.parseInt(Repository.l_count.getText());
            Repository.l_count.setText(String.valueOf(count + 1));
            Repository.cur_collect = Repository.arr_cols.get(count);
            Repository.name.setText("Название: " + Repository.cur_collect.getName());
            Repository.description.setText("Описание: " + Repository.cur_collect.getDescription());
            checkBorder();
        }
    }

    // Изменение действующей сцены на главную страницу
    static class BackScene implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent){
            Main.temp.setScene(Main.scene);
        }
    }

    // Удаление текущей выбранной коллекции
    static class DeleteCollection implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            File file = new File("C:/Users/maksi/IdeaProjects/Quizki/" + Variables.card_filepath + Repository.cur_collect.getName() + ".json");
            System.out.println(file.getPath());
            if(file.delete()){

                Main.temp.setScene(Repository.repos_p.getScene());
            }else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Quizki Alarm");
                alert.setContentText("Ошибка удаления объекта! (Попробуйте еще раз)");
                alert.showAndWait();
            }
        }
    }

    // Проверка существования карточки
    private static void checkBorder(){
        int count = Integer.parseInt(Repository.l_count.getText());
        Repository.b_prev.setDisable(count <= 1);
        Repository.b_next.setDisable(count == Repository.arr_cols.size() || Repository.arr_cols.size() <= 1);
    }
}
