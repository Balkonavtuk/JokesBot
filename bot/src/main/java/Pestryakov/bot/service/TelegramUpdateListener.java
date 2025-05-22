package Pestryakov.bot.service;

import Pestryakov.bot.model.JokeSaveDTO;
import Pestryakov.bot.model.Jokes;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TelegramUpdateListener implements UpdatesListener {

    private final JokesService jokesService;
    private final TelegramBot telegramBot;

    public TelegramUpdateListener(JokesService jokesService, TelegramBot telegramBot) {
        this.jokesService = jokesService;
        this.telegramBot = telegramBot;
    }

    @Override
    public int process(List<Update> list) {
        for (Update update : list) {
            if (update.message() != null && update.message().text() != null) {
                String messageText = update.message().text();
                Long chatId = update.message().chat().id();

                if (messageText.equals("/start")) {
                    telegramBot.execute(new SendMessage(chatId,
                            "Команды:\n/jokes - рандомная шутка"));
                }
                if (update.message().text().startsWith("/add")) {
                    String[] parts = update.message().text().split(" ", 3); // ограничиваем на 3 части

                    if (parts.length < 3) {
                        telegramBot.execute(new SendMessage(update.message().chat().id(), "Неправильный ввод"));
                        return UpdatesListener.CONFIRMED_UPDATES_ALL;
                    }

                    String command = parts[0];
                    String title = parts[1];
                    String content = parts[2];

                    JokeSaveDTO jokes = new JokeSaveDTO();
                    jokes.setTitle(title);
                    jokes.setContent(content);
                    jokesService.addJokes(jokes);
                    telegramBot.execute(new SendMessage(update.message().chat().id(), "Шутка добавлена!"));

                }
                if (update.message().text().equals("/jokes")) {
                    List<Jokes> jokes = jokesService.getAllJokes(null);

                    if (!jokes.isEmpty()) {
                        Jokes joke = jokes.get((int) (Math.random() * jokes.size()));
                        String text = '"'+ joke.getTitle() + '"' +'.'+ "\n" + joke.getContent();
                        telegramBot.execute(new SendMessage(update.message().chat().id(), text));
                    }
                }
            }
        }
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onReady() {
        telegramBot.setUpdatesListener(this);
    }
}
