package dev.brew.commands

import dev.brew.Coruscant
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * @author Brew
 */
class CopyInventoryCommand(private var instance : Coruscant) : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, commandLabel: String, args: Array<String>): Boolean {
        var player : Player = sender as Player

        if(!player.hasPermission(PERMISSION)){
            player.sendMessage("${ChatColor.RED}No permission.")
        }

        if(args.size != 1){
            player.sendMessage("${ChatColor.RED}Invalid Args.")
        }

        var target : Player = Bukkit.getPlayerExact(args[0])

        player.inventory.armorContents = target.inventory.armorContents
        player.inventory.contents = target.inventory.contents
        return false;
    }

    companion object{
        const val PERMISSION = "coruscant.copyinv"
    }
}