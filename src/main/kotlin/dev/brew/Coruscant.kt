package dev.brew

import dev.brew.commands.GamemodeCreativeCommand
import dev.brew.commands.GamemodeSurvivalCommand
import dev.brew.commands.HelpCommand
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
    }

    companion object {
        lateinit var instance: Coruscant
    }
}