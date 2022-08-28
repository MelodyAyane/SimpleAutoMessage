package melodyayane;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class AutoMessageMain implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
    public static void AutoMessage(){
        Plugin config = melodyayane.simpleautomessage.getPlugin(melodyayane.simpleautomessage.class);
        int numbers = config.getConfig().getStringList("message-lists").size();
        Random ordergGenerater = new Random();
        int order = ordergGenerater.nextInt(numbers);
        String message = config.getConfig().getStringList("message-lists").get(order);
        String coloredMessage = ChatColor.translateAlternateColorCodes('&',message);
        for (Player player : Bukkit.getOnlinePlayers()) {
        player.sendMessage(coloredMessage);
        }
    }
}



