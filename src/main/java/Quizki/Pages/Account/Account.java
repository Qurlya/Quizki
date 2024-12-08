package Quizki.Pages.Account;

import Quizki.Pages.Main_window.Main;
import Quizki.Models.Variables;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * Реализация окна персонального доступа (личного кабинета).
 * Информация об аккаунте:
 * - Логин;
 * - Пароль;
 * - Изменение дизайна приложения;
 * - Актуальный рейтинг в локальной системе учета активности;
 * - Информация о созданных тестах.
 */

public class Account {

    // Главная страница персонального доступа
    public static Pane p;
    public static Button b_back, b_registration;
    public static TextField tf_name;
    public static Label l_nickname, l_data_of_create, l_rate, l_collection_count, l_collection_study, l_info;
    public static class changeScene implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent actionEvent) {
            p = new Pane();
            Scene scene = new Scene(p, Variables.appWidth+300, Variables.appHeight);

            l_nickname = new Label("Имя: ");
            firstOption(l_nickname, 100, 100, false);

            l_data_of_create = new Label("Дата создания: ");
            firstOption(l_data_of_create, 100, 150, false);

            l_rate = new Label("Ударный режим: ");
            firstOption(l_rate, 100, 200, false);

            l_collection_count = new Label("Коллекций создано: ");
            firstOption(l_collection_count, 100, 250, false);

            l_collection_study = new Label("Коллекций пройдено: ");
            firstOption(l_collection_study, 100, 300, false);

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
                    "\nчтобы вы могли видеть свои достяжения в процессе обучения" +
                    "\nС уважением, разработчики <3");

            firstOption(l_info, 100, 100, true);

            tf_name = new TextField();
            firstOption(tf_name, 100, 400, true);

            b_registration = new Button("Регистрация");
            firstOption(b_registration, 100, 450, true);

            b_registration.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    tf_name.setVisible(false);
                    l_info.setVisible(false);
                    b_registration.setVisible(false);
                    b_back.setVisible(true);
                    l_nickname.setVisible(true);
                    l_data_of_create.setVisible(true);
                    l_rate.setVisible(true);
                    l_collection_count.setVisible(true);
                    l_collection_study.setVisible(true);
                }
            });




            b_back = new Button("Назад");
            firstOption(b_back, 0, 500, false);
            b_back.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    Main.temp.setScene(Main.scene);
                }

            });
            scene.getStylesheets().add("account_style.css");
            Main.temp.setScene(scene);
        }
        private void firstOption(Button temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(TextField temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
        private void firstOption(Label temp, int x, int y, boolean flag) {
            temp.setLayoutX(x);
            temp.setLayoutY(y);
            temp.setVisible(flag);
            p.getChildren().add(temp);
        }
    }

}
