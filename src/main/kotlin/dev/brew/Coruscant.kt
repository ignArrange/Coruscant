package dev.brew

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

    }

    companion object {
        lateinit var instance: Coruscant
    }
}