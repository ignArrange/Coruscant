package dev.brew.commands

import dev.brew.Coruscant
import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class AlertCommand (private val instance: Coruscant) : CommandExecutor {
    override fun onCommand(sender: CommandSender, cmd: Command, commandLabel: String, args: Array<String>): Boolean {
        if (!sender.hasPermission("coruscant.alert") && !sender.hasPermission("coruscant.*") && !sender.hasPermission("*")) {
            sender.sendMessage(ChatColor.RED.toString() + "No permission.")
            return true
        }
        if (args.size == 0) {
            sender.sendMessage("§cUsage: /alert <msg>")
            return true
        }
        val str = StringBuilder()
        for (i in args.indices) {
            str.append(args[i] + " ")
        }
        val msg = str.toString()
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4Alert&8]&r $msg"))
        return true
    }
}