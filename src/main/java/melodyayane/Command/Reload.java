package melodyayane.Command;

import melodyayane.simpleautomessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.KeyedBossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Iterator;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
          if (command.getName().equalsIgnoreCase("samreload")) {
                if (sender.hasPermission("simpleautomessage.reload")) {
                    sender.sendMessage(ChatColor.GREEN + "SimpleAutoMessage reloading!");
                    simpleautomessage config = simpleautomessage.getPlugin(simpleautomessage.class);
                    config.reloadConfig();
                    config.saveConfig();
                    simpleautomessage.getPlugin(simpleautomessage.class).getServer().getPluginManager().disablePlugin(config);
                    simpleautomessage.getPlugin(simpleautomessage.class).getServer().getPluginManager().enablePlugin(config);
                    sender.sendMessage(ChatColor.GREEN + "SimpleAutoMessage reloaded!");
                    KeyedBossBar bossbar = Bukkit.getBossBar(new NamespacedKey(simpleautomessage.getPlugin(simpleautomessage.class), "simpleautomessage"));
                    Player player = Bukkit.getOnlinePlayers().iterator().next();
                    bossbar.removePlayer(player);
                } else {
                    sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
                }
              return true;
            }



        return false;
    }
}
