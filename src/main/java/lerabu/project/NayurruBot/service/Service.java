package lerabu.project.NayurruBot.service;


import lerabu.project.NayurruBot.controllers.BotController;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Component
public class Service {

    public static String start(String name){
        return "Hi, " + name + "! Nice to meet you!";
    }

    public static String notRecognized() {
        return "Sorry, command was not recognized";
    }
        
}



