package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {

        return "ALLpeace";
    }

    @Override
    public String getBotToken() {

        return "5958980549:AAGiBYcLI5HP-HdEsA0bpHyPj7sNr4Nn0vQ";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var m = update.getMessage();
        var name = m.getFrom();
        var id = name.getId();
        sendText(id, m.getText());
    }

    public void sendText(Long var, String var2){
        SendMessage sm = SendMessage.builder()
                .chatId(var.toString())
                .text(var2).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}




