package com.dis.bot.commands;

import com.dis.bot.service.ProgressService;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.dis.bot.tool.EventOptionNameGetter.getEventOption;
import static com.dis.bot.tool.MemberNameGetter.getUsername;

@Component
public class StartCommand implements SlashCommand {

    private final ProgressService progressService;

    public StartCommand(ProgressService progressService){
        this.progressService = progressService;
    }

    @Override
    public String getName() {
        return "start";
    }

    @Override
    public Mono<Void> handle(ChatInputInteractionEvent event) {
        String memberName = getUsername(event);
        String characterName = getEventOption(event, "name");

        return  event.reply()
            .withEphemeral(false)
            .withContent(String.format("Game Started"));
    }
}
