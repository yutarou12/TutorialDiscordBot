package com.github.yutarou12.TutorialDiscordBot

import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.Commands
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData

class OnReadyListener() : ListenerAdapter() {
    override fun onReady(event: ReadyEvent) {
        val guild = event.jda.getGuildById(BotClient.GUILD_ID)!!
        val cmdList: Map<String, String> = mapOf(
            "neko" to "ねこおおおおお",
            "inu" to "いぬううううう",
            "pengin" to "ぺんぎんん",
            "チャンネル情報" to "チャンネル情報を取得するよ！！！"
        )
        val registCmd: MutableCollection<SlashCommandData> = mutableListOf()
        for ((key, value) in cmdList){
            val registerCommand : SlashCommandData
            if (key == "チャンネル情報"){
                registerCommand = Commands.slash(key, value)
                    .addOption(OptionType.CHANNEL, "チャンネル", "チャンネルを選択してね")
            } else {
                registerCommand = Commands.slash(key, value)
            }
            registCmd.add(registerCommand)
        }
        guild.updateCommands()
            .addCommands(registCmd)
            .queue()
        println("起動しました")
    }
}