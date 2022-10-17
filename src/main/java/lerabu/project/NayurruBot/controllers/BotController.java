package lerabu.project.NayurruBot.controllers;

import lerabu.project.NayurruBot.config.BotConfig;
import lerabu.project.NayurruBot.service.Service;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class BotController extends TelegramLongPollingBot {

    final BotConfig config;

    public BotController(BotConfig config) {
        this.config = config;
    }


    @Override
    public String getBotUsername() {
        return config.getBotName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();
            System.out.println(messageText + " " + update.getMessage().getChat().getFirstName().toString()
                    + " " + update.getMessage().getChat().getLastName().toString());

            switch (messageText) {
                case "/start":
                    sendAnswerMessage(chatId, Service.start(update.getMessage().getChat().getFirstName()));
                    break;
                default:
                    sendAnswerMessage(chatId, Service.notRecognized());
            }
        }
    }

    public void sendAnswerMessage(long chatId, String textToSend) {
        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);

        try {
            execute(message);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}