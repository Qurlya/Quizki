package Quizki.Pages.Account;

import Quizki.Models.JsonHandler;
import Quizki.Models.Variables;
import Quizki.Pages.Create.Create;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
                Create.alert.setContentText(Variables.curLanguageList.get("Alert_EmptyUserName"));
                Create.alert.showAndWait();
            }else {
                // Сохранение данных пользователя
                //User user1 = new User(Account.tf_name.getText());
                JsonHandler.createAccount(Account.user1);
                Account.b_registration.setDisable(Account.tf_name.getText().isEmpty());

                Create.showLoadingWindow();

                // Смена элементов окна, при регистрации пользователя
                Account.tf_name.setVisible(false);
                Account.l_info.setVisible(false);
                Account.b_registration.setVisible(false);

                Account.l_nickname.setText(Account.l_nickname.getText() + Account.user1.getLogin());
                Account.l_data_of_create.setText(Account.l_data_of_create.getText() + Account.user1.getRegistr_date());
                Account.l_rate.setText(Account.l_rate.getText() + Account.user1.getRate());
                Account.l_collection_count.setText(Account.l_collection_count.getText() + Account.user1.getCol_created());
                Account.l_collection_study.setText(Account.l_collection_study.getText() + Account.user1.getCol_studied());

                Account.b_back.setVisible(true);
                Account.l_nickname.setVisible(true);
                Account.l_data_of_create.setVisible(true);
                Account.l_rate.setVisible(true);
                Account.l_collection_count.setVisible(true);
                Account.l_collection_study.setVisible(true);
            }
        }
    }
}