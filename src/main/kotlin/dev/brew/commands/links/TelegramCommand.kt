package dev.brew.commands.links

import dev.brew.Coruscant
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

/**
 * @author Brew
 */
class TelegramCommand (private val instance: Coruscant) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        var player: Player = sender as Player

        player.sendMessage(instance.config.getString("telegram"))
        return false;
    }
}