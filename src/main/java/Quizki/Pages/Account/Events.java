package Quizki.Pages.Account;

import Quizki.Models.JsonHandler;
import Quizki.Models.User;
import Quizki.Pages.Create.Create;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import static Quizki.Models.Variables.curLanguageList;
import static Quizki.Pages.Account.Account.*;

/**
 *  Класс обработки событий функционального окна регистрации (см. Account).
 */

public class Events {
    // Регистрация пользователя (запись персональных данных в файл)
    static class Registration implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            // Условие не пустоты имени пользователя
            if (Account.tf_name.getText().isEmpty()) {
                Create.alert.setContentText(curLanguageList.get("Alert_EmptyUserName"));
                Create.alert.showAndWait();
            }else {
                // Сохранение данных пользователя
                User user1 = new User(tf_name.getText());

                JsonHandler.createAccount(user1);
                Create.showLoadingWindow();

                // Смена элементов окна, при регистрации пользователя
                tf_name.setVisible(false);
                l_info.setVisible(false);
                b_registration.setVisible(false);
                l_nickname.setText(l_nickname.getText() + user1.getLogin());
                l_data_of_create.setText(l_data_of_create.getText() + user1.getRegistr_date());
                l_rate.setText(l_rate.getText() + user1.getRate());
                l_collection_count.setText(l_collection_count.getText() + user1.getCol_created());
                l_collection_study.setText(l_collection_study.getText() + user1.getCol_studied());

                b_back.setVisible(true);
                l_nickname.setVisible(true);
                l_data_of_create.setVisible(true);
                l_rate.setVisible(true);
                l_collection_count.setVisible(true);
                l_collection_study.setVisible(true);
            }
        }
    }
}