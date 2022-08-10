package ru.tatar.ppgmu.telegram.model;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    public Bot() {
        super();
    }

    @Override
    public String getBotUsername() {
        return "cit_notifications_bot";
    }

    @Override
    public String getBotToken() {
        return "5484848223:AAEPg9jdZIN8yZcD7eAsNpJX5uTsGoYStyk";
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message = update.getMessage();
        Long chatId = message.getChatId();
        setAnswer(chatId, message.getText());
    }

    public void setAnswer(Long chatId, String text) {
        SendMessage answer = new SendMessage();
        answer.enableMarkdown(true);
        answer.setChatId(chatId.toString());
        answer.setText(text);
        try {
            execute(answer);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
