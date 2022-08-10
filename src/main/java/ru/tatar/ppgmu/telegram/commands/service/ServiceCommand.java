package ru.tatar.ppgmu.telegram.commands.service;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Parent for all service commands
 *
 */
@Slf4j
public class ServiceCommand extends BotCommand {

    public ServiceCommand(String command, String description) {
        super(command, description);
    }

    /**
     * Sending answer to user
     *
     * @param absSender
     * @param chatId
     * @param commandName
     * @param userName
     * @param text
     */
    void sendAnswer(AbsSender absSender, Long chatId, String commandName, String userName, String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(text);
        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Error '{}'. Command: [{}]. User: [{}].", e.getMessage(), commandName, userName);
            e.printStackTrace();
        }
    }
}
