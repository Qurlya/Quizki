package Quizki.Models;

import Quizki.Pages.Create.Create;
import Quizki.Pages.Repository.Repository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.scene.layout.Pane;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Реализация чтения и записи коллекций тестов и карточек в JSON файл.
 * Для работы с JSON используется библиотека Jackson.
 */

public class JsonHandler {

    // Методы работы с карточками
    // Метод для сохранения коллекции карточек в JSON файл
    public static void saveToFile(Collect collect, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonNode = mapper.createObjectNode();
        ArrayNode array = mapper.valueToTree(collect.getCard_set());
        File file = new File(filePath);

        jsonNode.put("collect_name", collect.getName());
        jsonNode.put("collect_description", collect.getDescription());
        jsonNode.putArray("card_set").addAll(array);

        try {
            mapper.writeValue(file, jsonNode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Метод для загрузки коллекции карточек из JSON файла
    public static Collect loadCardFromFile(String filePath) {
        File file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Чтение имени и описания коллекции
        String collect_name = jsonNode.get("collect_name").asText();
        String collect_desc = jsonNode.get("collect_description").asText();

        // Чтение массива карт
        ArrayNode cardArray = (ArrayNode) jsonNode.get("card_set");
        ArrayList<Card> set = new ArrayList<>();

        // Проходим по массиву карт и добавляем их в коллекцию
        for (JsonNode cardNode : cardArray) {
            String face = cardNode.get("face").asText();
            String back = cardNode.get("back").asText();
            Card card = new Card(face, back);

            set.add(card);
        }

        // Создаем коллекцию и устанавливаем ее параметры
        Collect collect = new Collect();
        collect.setName(collect_name);
        collect.setDescription(collect_desc);
        collect.setCard_set(set);

        return collect;
    }

    // Методы работы с пользователем
    // Метод "регистрации пользователя" (создание файла с персональными данными)
    public static void createAccount(User user) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonNode = mapper.createObjectNode();
        File file = new File(Variables.card_filepath + Variables.user_file);
        jsonNode.put("user_login", user.getLogin());
        jsonNode.put("user_reg_date", user.getRegistr_date());
        jsonNode.put("user_rate", user.getRate());
        jsonNode.put("user_col_created", user.getCol_created());
        jsonNode.put("user_col_studied", user.getCol_studied());
        jsonNode.put("user_set_language", user.getLanguage());
        jsonNode.put("user_set_color", user.getColor());
        jsonNode.put("user_last_enter", user.getLast_enter_date());

        try {
            mapper.writeValue(file, jsonNode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Метод для выгрузки данных пользователя (для изменения) из JSON файла
    public static User loadAccountData(){
        File file = new File(Variables.card_filepath + Variables.user_file);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Чтение данных пользователя
        String user_login = jsonNode.get("user_login").asText();
        String user_date = jsonNode.get("user_reg_date").asText();
        String user_last_enter = jsonNode.get("user_last_enter").asText();
        String language = jsonNode.get("user_set_language").asText();
        String color = jsonNode.get("user_set_color").asText();
        int rate = Integer.parseInt(jsonNode.get("user_rate").asText());
        int user_col_created = Integer.parseInt(jsonNode.get("user_col_created").asText());
        int user_col_studied = Integer.parseInt(jsonNode.get("user_col_studied").asText());

        User user = new User(user_login);
        user.setCol_studied(user_col_studied);
        user.setCol_created(user_col_created);
        user.setRate(rate);
        user.setRegistr_date(user_date);
        user.setLast_enter_date(user_last_enter);
        user.setLanguage(language);
        user.setColor(color);

        return user;
    }

    // Метод инкремента количества созданных пользователем коллекций тестов
    public static void changeUserColsCreated(){
        User user = JsonHandler.loadAccountData();
        user.setCol_created(user.getCol_created() + 1);
        JsonHandler.createAccount(user);
    }

    // Метод инкремента количества пройденных пользователем коллекций тестов
    public static void changeUserColsStudied(){
        User user = JsonHandler.loadAccountData();
        user.setCol_studied(user.getCol_studied() + 1);
        JsonHandler.createAccount(user);
    }

    // Метод инкремента учета активности пользователя
    public static void changeUserRate(){
        User user = JsonHandler.loadAccountData();
        int conditionToIncrement;

        String[] strToday = stringToStringArr(new SimpleDateFormat(Variables.dataFormat).format(new Date()));
        String[] strLastEnter = stringToStringArr(user.getLast_enter_date());

        int thisDay = (strToday[0].equals("0")) ? Integer.parseInt(strToday[1]) : Integer.parseInt(strToday[0] + strToday[1]);
        int thisMonth = (strToday[3].equals("0")) ? Integer.parseInt(strToday[4]) : Integer.parseInt(strToday[3] + strToday[4]);
        int thisYear = Integer.parseInt(strToday[6] + strToday[7] + strToday[8] + strToday[9]);

        int lastDay = (strLastEnter[0].equals("0")) ? Integer.parseInt(strLastEnter[1]) : Integer.parseInt(strLastEnter[0] + strLastEnter[1]);
        int lastMonth = (strLastEnter[3].equals("0")) ? Integer.parseInt(strLastEnter[4]) : Integer.parseInt(strLastEnter[3] + strLastEnter[4]);
        int lastYear = Integer.parseInt(strLastEnter[6] + strLastEnter[7] + strLastEnter[8] + strLastEnter[9]);

        if(thisYear == lastYear){
            if(thisMonth == lastMonth) conditionToIncrement = thisDay - lastDay;
            else conditionToIncrement = 2;
        }else conditionToIncrement = 2;

        if (conditionToIncrement == 1){
            user.setRate(user.getRate() + 1);
        }else if (conditionToIncrement < 0){
            Create.alert.setContentText("Don't change your rate yourself!");
            Create.alert.showAndWait();
            user.setRate(0);
        } else if (conditionToIncrement != 0){
            user.setRate(0);
        }
        JsonHandler.createAccount(user);
    }

    // Преобразование строки в массив строк (посимвольно)
    public static String[] stringToStringArr(String str){
        char[] temp = str.toCharArray();
        String[] res = new String[temp.length];
        for(int i = 0; i < res.length; i++){
            res[i] = String.valueOf(temp[i]);
        }
        return res;
    }

    // Метод изменения языкового набор на определенный (автоматически)
    public static void changeLanguage(){
        User user = JsonHandler.loadAccountData();
        String language = user.getLanguage();

        switch (language) {
            case "rus" -> Variables.curLanguageList = Variables.rusList;
            case "eng" -> Variables.curLanguageList = Variables.engList;
            case "deu" -> Variables.curLanguageList = Variables.deuList;
            case "chn" -> Variables.curLanguageList = Variables.chnList;
            case "cat" -> Variables.curLanguageList = Variables.style_1List;
            default -> Variables.curLanguageList = Variables.style_2List;
        }

        user.setLanguage(language);
        JsonHandler.createAccount(user);
    }

    // Метод изменения языкового набор на определенный
    public static void changeLanguage(String language){
        User user = JsonHandler.loadAccountData();

        switch (language) {
            case "rus" -> Variables.curLanguageList = Variables.rusList;
            case "eng" -> Variables.curLanguageList = Variables.engList;
            case "deu" -> Variables.curLanguageList = Variables.deuList;
            case "chn" -> Variables.curLanguageList = Variables.chnList;
            case "cat" -> Variables.curLanguageList = Variables.style_1List;
            default -> Variables.curLanguageList = Variables.style_2List;
        }

        user.setLanguage(language);
        JsonHandler.createAccount(user);
    }

    // Метод изменения цветовой темы на определенной панели (с учетом существующей темы)
    public static void changeColor(Pane pane){
        User user = JsonHandler.loadAccountData();
        String color = user.getColor();
        switch (color){
            case "green" -> pane.getStyleClass().add("greenTheme");
            case "blue" -> pane.getStyleClass().add("blueTheme");
            case "yellow" -> pane.getStyleClass().add("yellowTheme");
            case "black" -> pane.getStyleClass().add("blackTheme");
            default -> pane.getStyleClass().add("whiteTheme");
        }
        user.setColor(color);
        JsonHandler.createAccount(user);
    }

    // Метод изменения цветовой темы пользователя на определенную (на определенной панели)
    public static void changeColor(Pane pane, String color){
        User user = JsonHandler.loadAccountData();
        switch (color){
            case "green" -> pane.getStyleClass().add("greenTheme");
            case "blue" -> pane.getStyleClass().add("blueTheme");
            case "yellow" -> pane.getStyleClass().add("yellowTheme");
            case "black" -> pane.getStyleClass().add("blackTheme");
            default -> pane.getStyleClass().add("whiteTheme");
        }
        user.setColor(color);
        JsonHandler.createAccount(user);
    }

    // Метод изменения последнего входа пользователя
    public static void changeLastEnter(){
        User user = JsonHandler.loadAccountData();
        user.setLast_enter_date(new SimpleDateFormat(Variables.dataFormat).format(new Date()));
        JsonHandler.createAccount(user);
    }

    // Метод изменения имени пользователя
    public static void changeLogin(String login){
        User user = JsonHandler.loadAccountData();
        user.setLogin(login);
        JsonHandler.createAccount(user);
    }
}

