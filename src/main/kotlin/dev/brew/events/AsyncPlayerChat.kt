package dev.brew.events

import dev.brew.Coruscant
import org.bukkit.ChatColor
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.AsyncPlayerChatEvent

/**
 * @author Brew
 */
class AsyncPlayerChat(private var instance : Coruscant) : Listener {

    @EventHandler
    fun playerchat(event : AsyncPlayerChatEvent) {
        var player: Player = event.player

        var lowercase = event.message.toLowerCase()

        if (lowercase.startsWith("//calc") || lowercase.startsWith("//eval") || lowercase.startsWith("//solve") || lowercase.startsWith("/bukkit:") || lowercase.startsWith("/me") || lowercase.startsWith("/bukkit:me") || lowercase.startsWith("/minecraft:") || lowercase.startsWith("/minecraft:me") || lowercase.startsWith("/pl")) {
        player.sendMessage("${ChatColor.RED}You cannot perform this command!")
        event.isCancelled = true

        }

        if(lowercase.contains("nigger") || lowercase.contains("swat")){
            player.sendMessage("${ChatColor.RED}That message contains inappropriate content!")
            event.isCancelled = true
        }
    }

}