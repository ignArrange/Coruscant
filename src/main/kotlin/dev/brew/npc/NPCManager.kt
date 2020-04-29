//package dev.brew.npc
//
//import net.minecraft.server.v1_7_R4.*
//import net.minecraft.util.com.mojang.authlib.GameProfile
//import org.bukkit.Bukkit
//import org.bukkit.Location
//import org.bukkit.craftbukkit.v1_7_R4.CraftServer
//import org.bukkit.craftbukkit.v1_7_R4.CraftWorld
//import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer
//import org.bukkit.entity.Player
//import java.util.*
//
//class NPCManager {
//    fun createNPC(player: Player, npcName: String) {
//        val location: Location = player.getLocation()
//        val nmsServer: MinecraftServer = (Bukkit.getServer() as CraftServer).getServer()
//        val nmsWorld: WorldServer = (player.getWorld() as CraftWorld).getHandle()
//        val gameProfile = GameProfile(UUID.randomUUID(), "§a§l$npcName")
//        val npc = EntityPlayer(nmsServer, nmsWorld, gameProfile, PlayerInteractManager(nmsWorld))
//        val npcPlayer: Player = npc.getBukkitEntity().getPlayer()
//        npcPlayer.setPlayerListName("")
//        npc.setLocation(location.getX(), location.getY(), location.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch())
//        val connection: PlayerConnection = (player as CraftPlayer).getHandle().playerConnection
//        connection.sendPacket(PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.addPlayer(), npc))
//        connection.sendPacket(PacketPlayOutNamedEntitySpawn(npc))
//        connection.sendPacket(PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.REMOVE_PLAYER, npc))
//    }
//}