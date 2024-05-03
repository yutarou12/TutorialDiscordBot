package com.github.yutarou12.TutorialDiscordBot

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import kotlin.random.Random

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
            "オールマイティ" -> {
                if(event.options.size == 0){
                    return event.reply("オプションを指定してね！").setEphemeral(true).queue()
                }
                if (event.options.size == 3) {
                    val totalInt = event.options[0].asInt + event.options[1].asInt * event.options[2].asInt
                    val randomTextList = arrayOf("にゃーん", "わん", "ぎゃー", "くぅん", "ばいばい", "さようなら", "ねたい", "ねむたい", "かえりたい", "おなかすいた", "お風呂入りたい")
                    val randomValue = Random.nextInt(0, randomTextList.size)
                    return event.reply(randomTextList[randomValue]).queue()
                }
            }
        }
    }
}