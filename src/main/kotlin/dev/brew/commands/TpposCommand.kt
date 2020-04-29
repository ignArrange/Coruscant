package dev.brew.commands

import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class TpposCommand : CommandExecutor {
    fun isDouble(s: String): Boolean {
        return try {
            s.toDouble()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    override fun onCommand(sender: CommandSender, cmd: Command, commandLabel: String, args: Array<String>): Boolean {
        if (!cmd.name.equals("tppos", ignoreCase = true)) {
            return false
        }
        if (sender !is Player) {
            sender.sendMessage(ChatColor.RED.toString() + "No permission.")
            return true
        }
        if (!sender.hasPermission("coruscant.teleport")  && !sender.hasPermission("*")) {
            sender.sendMessage("${ChatColor.RED}No permission.")
            return true
        }
        val p = sender
        if (args.size < 3 || args.size > 3) {
            sender.sendMessage("§c/tppos [x] [y] [z]")
            return true
        }
        if (!isDouble(args[0]) || !isDouble(args[1]) || !isDouble(args[2])) {
            sender.sendMessage("§c/tppos [x] [y] [z]")
            return true
        }
        val x = args[0].toDouble() + 0.5
        val y = args[1].toDouble() + 0.5
        val z = args[2].toDouble() + 0.5
        val loc = Location(p.world, x, y, z, p.location.yaw, p.location.pitch)
        p.teleport(loc)
        p.sendMessage("§eYou have been teleported to the coordinates §c$x§e, §c$y§e, §c$z§e.")
        return true
    }
}