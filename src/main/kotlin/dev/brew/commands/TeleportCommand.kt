package dev.brew.commands

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Entity
import org.bukkit.entity.Player
/**
 * @author Brew
 */
class TeleportCommand : CommandExecutor {
    fun isDouble(s: String): Boolean {
        return try {
            s.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
    // lol i love kotlin yay so CLEAN
    override fun onCommand(sender: CommandSender, cmd: Command, commandLabel: String, args: Array<String>): Boolean {
        if (!cmd.name.equals("teleport", ignoreCase = true)) {
            return true
        }
        if (sender !is Player) {
            sender.sendMessage(ChatColor.RED.toString() + "No permission.")
            return true
        }
        if (!sender.hasPermission("coruscant.teleport") && !sender.hasPermission("hcf.command.*") && !sender.hasPermission("*")) {
            sender.sendMessage(ChatColor.RED.toString() + "No permission.")
            return true
        }
        return if (args.size == 1) {
            val t = Bukkit.getPlayer(args[0])
            if (t == null) {
                sender.sendMessage(ChatColor.RED.toString() + "That player is currently offline")
                return true
            }
            sender.teleport(t as Entity)
            sender.sendMessage("§eYou have been teleported to §c" + t.name + "§e.")
            true
        } else {
            if (args.size != 2) {
                sender.sendMessage("§c/teleport <player> <player>")
                return true
            }
            if (!sender.hasPermission("coruscant.teleport.others") && !sender.hasPermission("*")) {
                sender.sendMessage(ChatColor.RED.toString() + "No permission.")
                return true
            }
            val p = Bukkit.getPlayer(args[0])
            val t = Bukkit.getPlayer(args[1])
            if (p == null) {
                sender.sendMessage("§cPlayer " + args[0] + " offline.")
                return true
            }
            if (t == null) {
                sender.sendMessage("§cPlayer " + args[1] + " offline.")
                return true
            }
            p.teleport(t as Entity)
            sender.sendMessage("§eYou have teleported §c" + p.name + " §eto §c" + t.name + "§e.")
            true
        }
    }
}