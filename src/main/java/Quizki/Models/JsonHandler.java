package Quizki.Models;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

/**
 * Реализация чтения и записи коллекций тестов и карточек в JSON файл.
 * Для работы с JSON используется библиотека Jackson.
 */

public class JsonHandler{

    // Метод для сохранения коллекции тестов в JSON файл
    public static void saveToFile(Test test, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonNode = mapper.createObjectNode();
        File file = new File(filePath);

        jsonNode.put("test_name", test.getName());
        jsonNode.put("test_description", test.getDescription());
        // put every query and answers
        mapper.writeValue(file, jsonNode);

    }

    // Метод для сохранения коллекции карточек в JSON файл
    public static void saveToFile(Card card, String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode jsonNode = mapper.createObjectNode();
        File file = new File(filePath);

        jsonNode.put("card_name", card.getName());
        jsonNode.put("card_description", card.getDescription());
        // put every query and answers
        mapper.writeValue(file, jsonNode);

    }


    // Метод для загрузки коллекции тестов из JSON файла
    public static Test loadTestFromFile(String filePath) throws IOException{
        File file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(file);
        String test_name = jsonNode.get("test_name").asText();
        String test_desc = jsonNode.get("test_description").asText();
        // put every query and answers

        Test test = new Test();
        test.setName(test_name);
        test.setDescription(test_desc);

        return test;
    }

    // Метод для загрузки коллекции карточек из JSON файла
    public static Card loadCardFromFile(String filePath) throws IOException{
        File file = new File(filePath);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(file);
        String test_name = jsonNode.get("test_name").asText();
        String test_desc = jsonNode.get("test_description").asText();
        // put every query and answers

        Card card = new Card();
        card.setName(test_name);
        card.setDescription(test_desc);

        return card;
    }
}

