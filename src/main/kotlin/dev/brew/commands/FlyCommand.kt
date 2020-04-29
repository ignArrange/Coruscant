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
class FlyCommand(private var instance : Coruscant) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if(!sender.hasPermission(PERMISSION)){
            sender.sendMessage("${ChatColor.RED}No permission.")
        }

        var player : Player = sender as Player

        if(player.allowFlight){
            player.allowFlight = false
            player.sendMessage("${ChatColor.GOLD}Flying ${ChatColor.WHITE}:FALSE")
        }

        player.sendMessage("${ChatColor.GOLD}Flying ${ChatColor.WHITE}:TRUE")
        player.allowFlight = true

        return false
    }

    companion object{
        const val PERMISSION = "coruscant.fly"
    }
}