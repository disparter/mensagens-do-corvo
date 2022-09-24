package com.dis.bot.mensagensdocorvo.interactions;

import com.dis.bot.mensagensdocorvo.commands.SlashCommand;
import com.dis.bot.mensagensdocorvo.scenes.StartScene;
import com.dis.bot.mensagensdocorvo.service.ProgressService;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import discord4j.core.event.domain.interaction.SelectMenuInteractionEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.dis.bot.mensagensdocorvo.tool.EventOptionNameGetter.getEventOption;
import static com.dis.bot.mensagensdocorvo.tool.MemberIdGetter.getMemberId;
import static com.dis.bot.mensagensdocorvo.tool.MemberNameGetter.getUsername;

@Component
public class StartMenuCommand implements MenuCommand {

    private final ProgressService progressService;
    private final StartScene startScene;

    public StartMenuCommand(ProgressService progressService,
                            StartScene startScene){

        this.progressService = progressService;
        this.startScene = startScene;
    }

    @Override
    public String getName() {
        return "firstEncounter";
    }

    @Override
    public Mono<Void> handle(SelectMenuInteractionEvent event) {
        return event.reply("Escolheu alguma coisa " + event.getValues().get(0));
    }


}
