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
class SpeedCommand (private val instance: Coruscant) : CommandExecutor {

    val speed = HashSet<UUID>()
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (!sender.hasPermission(GamemodeCreativeCommand.PERMISSION)) {
            return false
        }
        var player: Player = sender as Player
        if (!this.speed.contains(player.uniqueId)) {
            speed.add(player.uniqueId)
            player.removePotionEffect(PotionEffectType.SPEED)
            player.sendMessage(instance.config.getString("speed.disabled"))

        } else {
            speed.remove(player.uniqueId)
            player.sendMessage(instance.config.getString("speed.enabled"))
            player.addPotionEffect(PotionEffect(PotionEffectType.SPEED, 10000000, 2))
            return false;
        }
        return false;
    }
    companion object {

        const val PERMISSION = "coruscant.speed"

    }
}