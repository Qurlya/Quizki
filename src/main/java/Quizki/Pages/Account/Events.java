package Quizki.Pages.Account;

import Quizki.Models.JsonHandler;
import Quizki.Models.User;
import Quizki.Models.Variables;
import Quizki.Pages.Create.Create;
import Quizki.Pages.Main_window.Main;
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
            }else if(tf_name.getText().length() > Variables.loginLimit){
                Create.alert.setContentText(curLanguageList.get("Alert_UserLimit"));
                Create.alert.showAndWait();
            }else {
                // Сохранение данных пользователя
                User user1 = new User(tf_name.getText());
                JsonHandler.createAccount(user1);

                // НАСТРОИТЬ НОРМАЛЬНОЕ СОЗДАНИЕ ПРИ ВЫХОДЕ В MAIN
                // Смена элементов окна, при регистрации пользователя
                tf_name.setVisible(false);
                l_info.setVisible(false);
                b_registration.setVisible(false);
                l_inputName.setVisible(false);

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

    static class ChangeName implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            if(tf_changeName.isVisible() && l_changeName.isVisible()){
                tf_changeName.setVisible(false);
                l_changeName.setVisible(false);
            }else{
                tf_changeName.setVisible(true);
                l_changeName.setVisible(true);
            }
        }
    }

    static class Back implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent actionEvent) {
            if(tf_changeName.isVisible() && l_changeName.isVisible()){
                if (tf_changeName.getText().isEmpty()){
                    Create.alert.setContentText(curLanguageList.get("Alert_EmptyUserName"));
                    Create.alert.showAndWait();
                }else{
                    JsonHandler.changeLogin(tf_changeName.getText());
                    Main.temp.setScene(Main.scene);
                }
            }else {
                Main.printScene();
                Main.temp.setScene(Main.scene);
            }
        }
    }
}