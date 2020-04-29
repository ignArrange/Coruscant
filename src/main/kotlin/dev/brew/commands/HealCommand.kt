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
class HealCommand(private var instance : Coruscant) : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, commandLabel: String, args: Array<String>): Boolean {
    var player : Player = sender as Player

        if(!player.hasPermission(PERMISSION)){
            player.sendMessage("${ChatColor.RED}No permission.")
        }


        player.health = 20.0
        player.foodLevel = 20
        player.sendMessage("${ChatColor.GREEN}You have healed yourself!")


        return false
    }

    companion object{
        const val PERMISSION = "coruscant.heal"
    }
}