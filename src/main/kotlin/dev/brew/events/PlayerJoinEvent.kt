package dev.brew.events

import dev.brew.Coruscant
import dev.brew.utils.ChatUtil
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

/**
 * @author Brew
 */
class PlayerJoinEvent(private val instance: Coruscant) : Listener {

    @EventHandler
    fun onJoin(event : PlayerJoinEvent){
        var player : Player = event.player

        event.joinMessage = null

        var world : World = player.world
        player.teleport(Location(world, Coruscant.instance.config.getDouble("spawn.x"), Coruscant.instance.config.getDouble("spawn.y"), Coruscant.instance.config.getDouble("spawn.z")))

        for (message : String in Coruscant.instance.config.getStringList("join-message")){
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message)
                    .replace("%line%", ChatUtil.translate("&7&m-----------------------------------------------------"))
                    .replace("%player%", player.name)
                    .replace("%doublearrow%", "»")
            )
        }
    }
}