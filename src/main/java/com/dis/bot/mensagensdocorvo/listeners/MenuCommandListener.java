package com.dis.bot.mensagensdocorvo.listeners;

import com.dis.bot.mensagensdocorvo.exception.GenericException;
import com.dis.bot.mensagensdocorvo.exception.InvalidChoiceException;
import com.dis.bot.mensagensdocorvo.interactions.MenuCommand;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.interaction.SelectMenuInteractionEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

@Component
public class MenuCommandListener {

    private final Collection<MenuCommand> commands;
    private final GatewayDiscordClient client;

    public MenuCommandListener(List<MenuCommand> slashCommands, GatewayDiscordClient client) {
        commands = slashCommands;
        this.client = client;
        client.on(SelectMenuInteractionEvent.class, this::handle).subscribe();
    }

    public Mono<Void> handle(SelectMenuInteractionEvent event) {
        //Convert our list to a flux that we can iterate through
        return Flux.fromIterable(commands)
                //Filter out all commands that don't match the name this event is for
                .filter(command -> command.getName().equals(event.getCustomId()))
                //Get the first (and only) item in the flux that matches our filter
                .next()
                //Have our command class handle all logic related to its specific command.
                .flatMap(command -> {
                    try {
                        return command.handle(event);
                    }catch (InvalidChoiceException e){
                        return event.reply()
                                .withEphemeral(false)
                                .withContent(InvalidChoiceException.getFormattedMessage());
                    }catch (GenericException e){
                        return event.reply()
                                .withEphemeral(false)
                                .withContent(e.getLocalizedMessage());
                    }
                });
    }
}
