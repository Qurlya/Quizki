package Quizki.Models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Реализация чтения и записи коллекций тестов и карточек в JSON файл.
 * Для работы с JSON используется библиотека Jackson.
 */

public class JsonHandler {

    // Метод для сохранения коллекции карточек в JSON файл
    public static void saveToFile(Collect collect, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonNode = mapper.createObjectNode();
        ArrayNode array = mapper.valueToTree(collect.getCard_set());
        File file = new File(filePath);

        jsonNode.put("collect_name", collect.getName());
        jsonNode.put("collect_description", collect.getDescription());
        jsonNode.putArray("card_set").addAll(array);

        mapper.writeValue(file, jsonNode);
    }

    // Метод "регистрации пользователя" (создание файла с персональными данными)
    public static void createAccount(String login, Image image) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonNode = mapper.createObjectNode();
        File file = new File(Variables.card_filepath + "__user__.json");

        jsonNode.put("user_login", login);
        jsonNode.put("user_image", image.toString());

        mapper.writeValue(file, jsonNode);
    }

    // Метод для загрузки коллекции карточек из JSON файла
    public static Collect loadCardFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(file);

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

}

