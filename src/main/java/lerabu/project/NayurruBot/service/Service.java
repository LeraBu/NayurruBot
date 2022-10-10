package lerabu.project.NayurruBot.service;


import org.springframework.stereotype.Component;


@Component
public class Service {

    public static void startCommandReceive(long chatId, String name) {
        String answer = "Hi, " + name + "! Nice to meet you!";
        sendMessage(chatId, answer);
    }

}


