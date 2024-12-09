package Quizki.Models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
        jsonNode.put("user_col_created", user.getCol_created());
        jsonNode.put("user_col_studied", user.getCol_studied());
        jsonNode.put("user_set_language", user.getLanguage());
        jsonNode.put("user_set_color", user.getColor());

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
        String language = jsonNode.get("user_set_language").asText();
        String color = jsonNode.get("user_set_color").asText();
        int user_col_created = Integer.parseInt(jsonNode.get("user_col_created").asText());
        int user_col_studied = Integer.parseInt(jsonNode.get("user_col_studied").asText());

        User user = new User(user_login);
        user.setCol_studied(user_col_studied);
        user.setCol_created(user_col_created);
        user.setRegistr_date(user_date);
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

    // Метод изменения учета активности пользователя
    public static void changeUserRate(int plusRate){
        User user = JsonHandler.loadAccountData();
        user.setRate(user.getRate() + plusRate);
        JsonHandler.createAccount(user);
    }

    // Метод изменения языкового набора
    public static void changeUserLanguage(String language){
        User user = JsonHandler.loadAccountData();
        user.setLanguage(language);
        JsonHandler.createAccount(user);
    }

    // Метод изменения цветовой темы
    public static void changeUserColor(String color){
        User user = JsonHandler.loadAccountData();
        user.setColor(color);
        JsonHandler.createAccount(user);
    }
}

