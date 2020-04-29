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
class ClearInventoryCommand(private var instance : Coruscant) : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, commandLabel: String, args: Array<String>): Boolean {
        var player : Player = sender as Player

        if (!player.hasPermission(PERMISSION)){
            player.sendMessage("${ChatColor.RED}No permission.")
        }


        player.inventory.clear()
        player.inventory.armorContents = null

        player.sendMessage("${ChatColor.GREEN}Inventory cleared")

    return false;
    }

    companion object{
        const val PERMISSION = "coruscant.clearinventory"
    }
}