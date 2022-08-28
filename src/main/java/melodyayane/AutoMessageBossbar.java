package melodyayane;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.Random;

public class AutoMessageBossbar implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    public static void AutoMessagebossbar(){
        Plugin config = melodyayane.simpleautomessage.getPlugin(melodyayane.simpleautomessage.class);
        int numbers = config.getConfig().getStringList("bossbar").size();
        Random ordergGenerater = new Random();
        int order = ordergGenerater.nextInt(numbers);
        String message = config.getConfig().getStringList("bossbar").get(order);
        String coloredMessage = ChatColor.translateAlternateColorCodes('&',message);
        for (Player player : Bukkit.getOnlinePlayers()) {
            Bukkit.createBossBar(coloredMessage, BarColor.BLUE, BarStyle.SEGMENTED_10).addPlayer(player);
        }
    }
}
