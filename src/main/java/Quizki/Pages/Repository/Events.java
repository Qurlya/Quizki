package Quizki.Pages.Repository;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


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
            Repository.cur_collect = Repository.arr_cols.get(count-2);
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

    // Проверка существования карточки
    private static void checkBorder(){
        int count = Integer.parseInt(Repository.l_count.getText());
        Repository.b_prev.setDisable(count <= 1);
        Repository.b_next.setDisable(count == Repository.arr_cols.size() || Repository.arr_cols.size() <= 1);
    }
}
