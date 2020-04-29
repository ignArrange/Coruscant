package dev.brew

import dev.brew.commands.*
//import dev.brew.commands.GamemodeCreativeCommand
import dev.brew.commands.effects.FireCommand
import dev.brew.commands.effects.InvisCommand
import dev.brew.commands.effects.SpeedCommand
import dev.brew.commands.links.DiscordCommand
import dev.brew.commands.links.TeamspeakCommand
import dev.brew.commands.links.TelegramCommand
import dev.brew.events.AsyncPlayerChat
import dev.brew.events.PlayerJoinEvent
import org.bukkit.plugin.PluginManager
import org.bukkit.plugin.java.JavaPlugin

/**
 * @author Brew
 */
class Coruscant : JavaPlugin() {
//    lateinit var npcmanager : NPCManager
    override fun onEnable() {
        instance = this
        this.saveDefaultConfig()

        this.server.consoleSender.sendMessage("[Coruscant] Registering Commands")
        registerCommands()
        this.server.consoleSender.sendMessage("[Coruscant] Registering Events")
        registerEvents()
    }

    private fun registerEvents() {
        var pluginManager : PluginManager = this.server.pluginManager
        pluginManager.registerEvents(PlayerJoinEvent(this), this)
        pluginManager.registerEvents(AsyncPlayerChat(this), this)
    }

    private fun registerCommands() {
        this.getCommand("gmc").executor = GamemodeCreativeCommand(this)
        this.getCommand("gms").executor = GamemodeSurvivalCommand(this)
//        this.getCommand("help").executor = HelpCommand(this)
        this.getCommand("discord").executor = DiscordCommand(this)
        this.getCommand("teamspeak").executor = TeamspeakCommand(this)
        this.getCommand("telegram").executor = TelegramCommand(this)
        this.getCommand("speed").executor = SpeedCommand(this)
        this.getCommand("fire").executor = FireCommand(this)
        this.getCommand("invis").executor = InvisCommand(this)
        this.getCommand("alert").executor = AlertCommand(this)
        this.getCommand("tphere").executor = TphereCommand()
        this.getCommand("teleport").executor = TeleportCommand()
        this.getCommand("tppos").executor = TpposCommand()
        this.getCommand("eat").executor = EatCommand(this)
        this.getCommand("craft").executor = CraftCommand()
        this.getCommand("fly").executor = FlyCommand(this)
        this.getCommand("clearinventory").executor = ClearInventoryCommand(this)
        this.getCommand("copyinventory").executor = CopyInventoryCommand(this)
        this.getCommand("heal").executor = HealCommand(this)
    }

    companion object {
        lateinit var instance: Coruscant
    }
}