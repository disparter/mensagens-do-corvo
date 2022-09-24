package com.dis.bot.mensagensdocorvo.commands;

import com.dis.bot.mensagensdocorvo.scenes.StartScene;
import com.dis.bot.mensagensdocorvo.service.ProgressService;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import static com.dis.bot.mensagensdocorvo.tool.EventOptionNameGetter.getEventOption;
import static com.dis.bot.mensagensdocorvo.tool.MemberIdGetter.getMemberId;
import static com.dis.bot.mensagensdocorvo.tool.MemberNameGetter.getUsername;

@Component
public class StartCommand implements SlashCommand {

    private final ProgressService progressService;
    private final StartScene startScene;

    public StartCommand(ProgressService progressService,
                        StartScene startScene){

        this.progressService = progressService;
        this.startScene = startScene;
    }

    @Override
    public String getName() {
        return "start";
    }

    @Override
    public Mono<Void> handle(ChatInputInteractionEvent event) {
        String memberId = getMemberId(event);
        String memberNickName = getUsername(event);

        String playerName = getEventOption(event, "name");

        progressService.start(memberId, memberNickName, playerName);

        return  event.reply()
            .withComponents(startScene.getMenuForFirstEncounter())
            .withEphemeral(false)
            .withContent("Equanto caminhava pela estrada pode perceber um arrepio irradiando por todo seu corpo")
            .withContent(" o arrepio que começou dos pés a cabeça, escurece sua visão enquanto a sensação do seu mundo")
            .withContent(" se vai com todas a sua capacidade sensorial")
            .withContent(" após algum momento em escuridão total o arrepio desce da cabeça aos pés")
            .withContent(" e sua percepção retorna da mesma maneira lhe entregando a visão de um velho sujo em roupas rasgadas");

    }
}
