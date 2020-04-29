package dev.brew

import dev.brew.commands.GamemodeCreativeCommand
import dev.brew.commands.GamemodeSurvivalCommand
import dev.brew.commands.HelpCommand
import dev.brew.commands.effects.FireCommand
import dev.brew.commands.effects.InvisCommand
import dev.brew.commands.effects.SpeedCommand
import dev.brew.commands.links.DiscordCommand
import dev.brew.commands.links.TeamspeakCommand
import dev.brew.commands.links.TelegramCommand
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author Brew
 */
class Coruscant : JavaPlugin() {

    override fun onEnable() {
        instance = this

        this.saveDefaultConfig()

        this.server.consoleSender.sendMessage("[Coruscant] Registering Commands")
        registerCommands()
    }

    private fun registerCommands() {
        this.getCommand("gmc").executor = GamemodeCreativeCommand(this)
        this.getCommand("gms").executor = GamemodeSurvivalCommand(this)
        this.getCommand("help").executor = HelpCommand(this)
        this.getCommand("discord").executor = DiscordCommand(this)
        this.getCommand("teamspeak").executor = TeamspeakCommand(this)
        this.getCommand("telegram").executor = TelegramCommand(this)
        this.getCommand("speed").executor = SpeedCommand(this)
        this.getCommand("fire").executor = InvisCommand(this)
        this.getCommand("invis").executor = FireCommand(this)
    }

    companion object {
        lateinit var instance: Coruscant
    }
}