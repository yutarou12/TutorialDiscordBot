package com.github.yutarou12.TutorialDiscordBot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.events.message.MessageReceivedEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter
import net.dv8tion.jda.api.requests.GatewayIntent

class BotClient : ListenerAdapter(){
    private lateinit var jda: JDA
    companion object {
        const val GUILD_ID = "1235779569198436352"
    }

    fun main(token: String) {
        jda = JDABuilder.createLight(token,
            GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
            .addEventListeners(this)
            .addEventListeners(SlashCommandListener())
            .addEventListeners(OnReadyListener())
            .build()
    }

    override fun onMessageReceived(event : MessageReceivedEvent) {
        if(event.message.contentDisplay == "/neko"){
            event.channel.sendMessageFormat("にゃーん").queue()
        }
    }
}























fun main() {
    val bot = BotClient()
    bot.main("MTIzNTc4NTQ0NDMyNzY4NjIwNg.GwwhMO.GbZbITAZbPIjHOA_MwAGKBRw2oMf_a9dDYz-TQ")
}