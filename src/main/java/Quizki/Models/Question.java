package Quizki.Models;

import java.util.HashSet;

/**
 * Вопрос - структура запросно-ответной системы, представляющей однозначное
 * соответствие определенной строки запроса к определенной последовательности
 * ответов.
 */

public class Question {
    private String query;
    private String answer;
    private HashSet<String> options;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public HashSet<String> getOptions() {
        return options;
    }

    public void setOptions(HashSet<String> options) {
        this.options = options;
    }
}
