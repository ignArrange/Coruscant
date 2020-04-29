package dev.brew.commands

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class CraftCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage("This command is only executable in-game.")
            return true
        }
        val player = sender
        if (player.hasPermission("coruscant.craft")) {
            player.openWorkbench(player.location, true)
        } else {
            player.sendMessage(ChatColor.RED.toString() + "No permission.")
        }
        return false
    }
}