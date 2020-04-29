package dev.brew.commands.effects

import dev.brew.Coruscant
import dev.brew.utils.ChatUtil
import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import java.util.*

/**
 * @author Brew
 */
class InvisCommand (private val instance: Coruscant) : CommandExecutor {

    val fire = HashSet<UUID>()
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (!sender.hasPermission(InvisCommand.PERMISSION)) {
            return false
        }
        var player: Player = sender as Player
        if (!this.fire.contains(player.uniqueId)) {
            fire.add(player.uniqueId)
            player.removePotionEffect(PotionEffectType.INVISIBILITY)
            player.sendMessage("${ChatColor.LIGHT_PURPLE}Invisibility${ChatColor.RED} disabled")

        } else {
            fire.remove(player.uniqueId)
            player.sendMessage("${ChatColor.LIGHT_PURPLE}Invisibility${ChatColor.GREEN} enabled")
            player.addPotionEffect(PotionEffect(PotionEffectType.INVISIBILITY, 10000000, 2))
            return false;
        }
        return false;
    }
    companion object {

        const val PERMISSION = "coruscant.invis"

    }
}