package dev.brew.utils

import org.bukkit.ChatColor
import java.util.*

object ChatUtil {
    fun translate(input: String?): String {
        return ChatColor.translateAlternateColorCodes('&', input)
    }

    fun translateFromArray(text: List<String?>): List<String> {
        val messages: MutableList<String> = ArrayList()
        for (string in text) {
            messages.add(translate(string))
        }
        return messages
    }
}