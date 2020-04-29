package dev.brew.commands

import dev.brew.Coruscant
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * @author Brew
 */
class EatCommand(private var instance : Coruscant) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        var player : Player = sender as Player

        if(!player.hasPermission(PERMISSION)){
            player.sendMessage("${ChatColor.RED}No permission.")
        }

        player.foodLevel = 20
        player.saturation = 20F
        player.exhaustion = 0F
        player.sendMessage("${ChatColor.GREEN}You have fed yourself!")

        return false
    }

    companion object{
        const val PERMISSION = "coruscant.eat"
    }
}