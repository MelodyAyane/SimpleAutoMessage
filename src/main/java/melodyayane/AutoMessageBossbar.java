package melodyayane;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

import static org.bukkit.boss.BarStyle.SOLID;

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
        BossBar bossBar = Bukkit.createBossBar(coloredMessage, BarColor.BLUE, SOLID);
        for (Player player : Bukkit.getOnlinePlayers()) {
            bossBar.addPlayer(player);
            new BukkitRunnable() {
                @Override
                public void run() {
                    bossBar.removePlayer(player);
                    cancel();
                }
            }.runTaskTimer(config,40,20*config.getConfig().getInt("bossbar-time"));
        }

}
}
