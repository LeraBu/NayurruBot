package lerabu.project.NayurruBot;

import lerabu.project.NayurruBot.config.BotConfig;
import lerabu.project.NayurruBot.controllers.BotController;
import lerabu.project.NayurruBot.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;


@SpringBootApplication
public class NayurruBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(NayurruBotApplication.class, args);

	}

}
