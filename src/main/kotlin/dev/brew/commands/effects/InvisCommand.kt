package dev.brew.commands.effects

import dev.brew.Coruscant
import dev.brew.commands.GamemodeCreativeCommand
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
        if (!sender.hasPermission(GamemodeCreativeCommand.PERMISSION)) {
            return false
        }
        var player: Player = sender as Player
        if (!this.fire.contains(player.uniqueId)) {
            fire.add(player.uniqueId)
            player.removePotionEffect(PotionEffectType.INVISIBILITY)
            player.sendMessage(instance.config.getString("invis.disabled"))

        } else {
            fire.remove(player.uniqueId)
            player.sendMessage(instance.config.getString("invis.enabled"))
            player.addPotionEffect(PotionEffect(PotionEffectType.INVISIBILITY, 10000000, 2))
            return false;
        }
        return false;
    }
    companion object {

        const val PERMISSION = "coruscant.invis"

    }
}