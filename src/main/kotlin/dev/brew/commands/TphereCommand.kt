package dev.brew.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Entity
import org.bukkit.entity.Player

class TphereCommand : CommandExecutor {
    fun isDouble(s: String): Boolean {
        return try {
            s.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    override fun onCommand(sender: CommandSender, cmd: Command, commandLabel: String, args: Array<String>): Boolean {
        if (!cmd.name.equals("tphere", ignoreCase = true)) {
            return false
        }
        if (sender !is Player) {
            sender.sendMessage(ChatColor.RED.toString() + "No permission.")
            return true
        }
        if (!sender.hasPermission("coruscant.teleport") && !sender.hasPermission("*")) {
            sender.sendMessage("${ChatColor.RED}No permission/")
            return true
        }
        if (args.size != 1) {
            sender.sendMessage("§c/tphere <player>")
            return true
        }
        val p = sender
        val t = Bukkit.getPlayer(args[0])
        if (t == null) {
            sender.sendMessage("${ChatColor.RED}Offline player not found.")
            return true
        }
        t.teleport(p as Entity)
        p.sendMessage("§eYou have teleported §c" + t.name + " §eto your location.")
        t.sendMessage("§eYou have been teleported to §c" + p.name + "§e.")
        return true
    }
}