package com.github.yutarou12.TutorialDiscordBot

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class SlashCommandListener : ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {

        when (event.name) {
            "neko" -> {
                event.reply("にゃーん！").queue()
            }
            "inu" -> {
                event.reply("わん！").queue()
            }
            "pengin" -> {
                event.reply("僕はペンギンだよ！").queue()
            }
            "チャンネル情報" -> {
                if(event.options.size == 0){
                    return event.reply("チャンネルを指定してね！").setEphemeral(true).queue()
                }
                val repText = "・チャンネル名：" + event.options[0].asChannel.name + "\n・チャンネルID：" + event.options[0].asChannel.id +
                        "\n・チャンネル種類：" + event.options[0].asChannel.type.toString() + "\n"
                event.reply(repText).queue()
            }
        }
    }
}