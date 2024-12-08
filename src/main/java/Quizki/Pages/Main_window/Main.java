package Quizki.Pages.Main_window;

import Quizki.Pages.About_us.About_us;
import Quizki.Pages.Account.Account;
import Quizki.Pages.Create.Create;
import Quizki.Pages.Materials.Materials;
import Quizki.Pages.Repository.Repository;
import Quizki.Pages.Settings.Settings;
import Quizki.Models.Variables;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Реализация неполного функционала тестовой сцены, где пользователю предложен выбор между
 * функциональными вкладками, реализующими полноту проекта.
 * На будущее:
 * - Перенести лейбл с кнопками для каждого функционального окна в top_center
 * - Уменьшить код в main, путем абстрагирования
 */

public class Main extends Application {
    static public Stage temp;
    static public Scene scene;
    static public Pane p;

    @Override
    public void start(Stage stage) throws IOException {
        temp = stage;
        Button b_about_as = new Button("О нас");
        b_about_as.setOnAction(new About_us.changeScene());

        Button b_materials = new Button("Materials");
        b_materials.setOnAction(new Materials.changeScene());

        Button b_create = new Button("Create");
        b_create.setOnAction(new Create.changeScene());

        Button b_repository = new Button("Repository");
        b_repository.setOnAction(new Repository.changeScene());

        Button b_account = new Button("Account");
        b_account.setOnAction(new Account.changeScene());

        Button b_settings = new Button("Settings");
        b_settings.setOnAction(new Settings.changeScene());

        HBox p = new HBox(b_about_as, b_materials, b_create, b_repository, b_account, b_settings);
        scene = new Scene(p, Variables.appWidth, Variables.appHeight);

        scene.getStylesheets().add("main_style.css");
        stage.setTitle(Variables.projectTitle);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
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
    public static void main(String[] args) {
        launch(args);
    }
}