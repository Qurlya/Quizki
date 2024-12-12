package Quizki.Pages.Account;

import Quizki.Models.JsonHandler;
import Quizki.Models.User;
import Quizki.Pages.Create.Create;
import Quizki.Pages.Main_window.Main;
import Quizki.Models.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import static Quizki.Models.Variables.curLanguageList;
import static Quizki.Pages.Repository.Repository.changeScene.firstOption;

/**
 * Реализация окна персонального доступа (личного кабинета).
 * Информация об аккаунте (см. User).
 */

public class Account {

    // Главная страница персонального доступа
    // Окно регистрации
    public static Pane account_p;
    public static Button b_back, b_registration, b_changeName;
    public static TextField tf_name, tf_changeName;
    public static Label l_nickname, l_data_of_create, l_rate, l_collection_count, l_collection_study, l_info, l_changeName;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            account_p = new Pane();
            Scene scene = new Scene(account_p, Variables.appWidth, Variables.appHeight);

            l_nickname = new Label(curLanguageList.get("Account_Name") + ": ");
            firstOption(account_p, l_nickname, 400, 200, Main.userExist);

            l_data_of_create = new Label(curLanguageList.get("Account_Date") + ": ");
            firstOption(account_p, l_data_of_create, 400, 250, Main.userExist);

            l_rate = new Label(curLanguageList.get("Account_Activity") + ": ");
            firstOption(account_p, l_rate, 400, 300, Main.userExist);

            l_collection_count = new Label(curLanguageList.get("Account_CollectionCount") + ": ");
            firstOption(account_p, l_collection_count, 400, 350, Main.userExist);

            l_collection_study = new Label(curLanguageList.get("Account_CollectionStudy") + ": ");
            firstOption(account_p, l_collection_study, 400, 400, Main.userExist);

            l_changeName = new Label(curLanguageList.get("Account_ChangeName"));
            firstOption(account_p, l_changeName, 7000, 25000, false);

            l_info = new Label("Спасибо, что выбрали наше приложение, " +
                    "\nпросим вас, уважаемый пользователь, зарегистрироваться, " +
                    "\nчтобы вы могли видеть свои достижения в процессе обучения" +
                    "\nС уважением, разработчики <3");
            firstOption(account_p, l_info, 0, 100, !Main.userExist);
            l_info.setAlignment(Pos.CENTER);
            l_info.setId("info");

            tf_name = new TextField();
            firstOption(account_p, tf_name, 380, 400, !Main.userExist);

            b_registration = new Button(curLanguageList.get("Account_Registration"));
            firstOption(account_p, b_registration, 450, 450, !Main.userExist);
            b_registration.setOnAction(new Events.Registration());

            b_changeName = new Button(curLanguageList.get("Account_ChangeName"));
            firstOption(account_p, b_changeName, 70, 194, Main.userExist);
            b_changeName.setOnAction(new Events.ChangeName());
            b_changeName.getStyleClass().add("change_name");

            tf_changeName = new TextField();
            firstOption(account_p, tf_changeName, 70, 250, false);
            tf_changeName.getStyleClass().add("change_name");

            b_back = new Button(curLanguageList.get("Back"));
            firstOption(account_p, b_back, 100, 700, Main.userExist);
            b_back.setOnAction(new Events.Back());

            if (Main.userExist){
                User user1 = JsonHandler.loadAccountData();

                l_nickname.setText(l_nickname.getText() + user1.getLogin());
                l_data_of_create.setText(l_data_of_create.getText() + user1.getRegistr_date());
                l_rate.setText(l_rate.getText() + user1.getRate());
                l_collection_count.setText(l_collection_count.getText() + user1.getCol_created());
                l_collection_study.setText(l_collection_study.getText() + user1.getCol_studied());
            }
            firstOption(account_p, Variables.copyright, 5, Variables.appHeight - 20, true);
            Variables.copyright.getStyleClass().add("copyright");

            scene.getStylesheets().add("account_style.css");
            JsonHandler.changeColor(scene);
            Main.temp.setScene(scene);
        }
    }
}