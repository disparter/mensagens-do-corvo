package com.dis.bot.mensagensdocorvo.scenes;

import discord4j.core.object.component.ActionRow;
import discord4j.core.object.component.SelectMenu;
import org.springframework.stereotype.Component;

@Component
public class StartScene {

    public static final String FIRST_ENCOUNTER = "firstEncounter";

    public ActionRow getMenuForFirstEncounter(){
        return ActionRow.of(SelectMenu.of(FIRST_ENCOUNTER,
                SelectMenu.Option.of("Ignorar o velho", "ignorarCena1"),
                SelectMenu.Option.of("Ajudar o velho", "aceitarCena1"),
                SelectMenu.Option.of("Atacar o velho", "rejeitarCena1")
        ).withMaxValues(1).withMinValues(1));
    }

}
