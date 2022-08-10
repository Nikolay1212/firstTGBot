package ru.tatar.ppgmu.telegram.commands.service;

import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

/**
 * Start command
 */
@Slf4j
public class StartCommand extends ServiceCommand {

    public StartCommand(String command, String description) {
        super(command, description);
    }
}
