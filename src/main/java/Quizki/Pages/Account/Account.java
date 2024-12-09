package Quizki.Pages.Account;

import Quizki.Models.JsonHandler;
import Quizki.Models.User;
import Quizki.Pages.Main_window.Main;
import Quizki.Models.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    public static Button b_back, b_registration;
    public static TextField tf_name;
    public static Label l_nickname, l_data_of_create, l_rate, l_collection_count, l_collection_study, l_info;
    public static User user1;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            account_p = new Pane();
            Scene scene = new Scene(account_p, Variables.appWidth, Variables.appHeight);

            l_nickname = new Label(curLanguageList.get("Account_Name") + ": ");
            firstOption(account_p, l_nickname, 100, 100, Main.userExist);

            l_data_of_create = new Label(curLanguageList.get("Account_Date") + ": ");
            firstOption(account_p, l_data_of_create, 100, 150, Main.userExist);

            l_rate = new Label(curLanguageList.get("Account_Activity") + ": ");
            firstOption(account_p, l_rate, 100, 200, Main.userExist);

            l_collection_count = new Label(curLanguageList.get("Account_CollectionCount") + ": ");
            firstOption(account_p, l_collection_count, 100, 250, Main.userExist);

            l_collection_study = new Label(curLanguageList.get("Account_CollectionStudy") + ": ");
            firstOption(account_p, l_collection_study, 100, 300, Main.userExist);

            l_info = new Label("Тварь, мы знаем, где ты живешь и учишься, " +
                    "\nмы уже взломали твой пк и знаем всю информацию о тебе, " +
                    "\nесли ты сейчас не зарегистрируешься, то мы будем каждую минуту, " +
                    "\nпока ты тупишь, списывать по 1.000.000 с твоего счета, " +
                    "\nа потом мы введем тебя в долги. Делать это будем до тех пор, " +
                    "\nпока ты не нажнешь эту долбанную кнопку регистрации. " +
                    "\nА ЕСЛИ ТЫ УДАЛИШЬ ПРОГРАММУ, " +
                    "\nМЫ ЗАЛЕЗЕМ В ТВОЙ САЙТ ГУАПА И ОБНУЛИМ ВСЕ БАЛЛЫ ПО ВСЕМ ПРЕДМЕТАМИ " +
                    "\nИ ПРИГЛАСИМ ОТ ТВОЕГО ИМЕНИ НА СВИДАНИЕ ЕЛЕНУ МИХАЙЛОВКУ ИЛЬИНСКУЮ B " +
                    "\nИ ТЫ БУДЕШЬ СДАВАТЬ ЕЙ ЭКОНОМИКУ ДО КОНЦА ДНЕЙ СВОИХ" +
                    "\nError: Спасибо, что выбрали наше приложение, просим вас, уважаемый пользователь, зарегистрироваться, " +
                    "\nчтобы вы могли видеть свои достижения в процессе обучения" +
                    "\nС уважением, разработчики <3");
            firstOption(account_p, l_info, 100, 100, !Main.userExist);

            tf_name = new TextField();
            firstOption(account_p, tf_name, 100, 400, !Main.userExist);

            b_registration = new Button(curLanguageList.get("Account_Registration"));
            firstOption(account_p, b_registration, 100, 450, !Main.userExist);

            b_registration.setOnAction(new Events.Registration());

            b_back = new Button(curLanguageList.get("Back"));
            firstOption(account_p, b_back, 0, 500, Main.userExist);
            b_back.setOnAction(_ -> Main.temp.setScene(Main.scene));

            if (Main.userExist){
                user1 = JsonHandler.loadAccountData();
                Account.l_nickname.setText(Account.l_nickname.getText() + user1.getLogin());
                Account.l_data_of_create.setText(Account.l_data_of_create.getText() + user1.getRegistr_date());
                Account.l_rate.setText(Account.l_rate.getText() + user1.getRate());
                Account.l_collection_count.setText(Account.l_collection_count.getText() + user1.getCol_created());
                Account.l_collection_study.setText(Account.l_collection_study.getText() + user1.getCol_studied());
            }
            firstOption(account_p, Variables.copyright, 0, Variables.appHeight - 20, true);

            scene.getStylesheets().add("account_style.css");
            Main.temp.setScene(scene);
        }
    }
}