package dev.brew.commands

import dev.brew.Coruscant
import org.bukkit.ChatColor
import org.bukkit.GameMode
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * @author Brew
 */
class GamemodeCreativeCommand(private val instance: Coruscant) : CommandExecutor{
    override fun onCommand(sender: CommandSender,command: Command,label: String,args: Array<out String>): Boolean {

        if (!sender.hasPermission(PERMISSION) || !sender.hasPermission("$PERMISSION.others")) {
            return false
        }
        var player : Player = sender as Player

        player.gameMode = GameMode.CREATIVE
        player.sendMessage(Coruscant.instance.config.getString(ChatColor.translateAlternateColorCodes('&', "gamemode.creative")))
        return true
    }

    companion object {

        const val PERMISSION = "coruscant.gamemode"

    }
}