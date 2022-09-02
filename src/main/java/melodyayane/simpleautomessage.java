package melodyayane;

import melodyayane.Command.Reload;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.util.Random;

public final class simpleautomessage extends JavaPlugin {

    @Override
    public void onEnable() {



        getCommand("samreload").setExecutor(new Reload());
        getLogger().info("SimpleAutoMessage enabled");
        if (!(new File(getDataFolder() + File.separator + "config.yml").exists())) {
            saveDefaultConfig();
        }
        new BukkitRunnable() {
            @Override
            public void run() {
                AutoMessageMain.AutoMessage();

            }
        }.runTaskTimerAsynchronously(this, 0, 20 * getConfig().getInt("Time"));

        new BukkitRunnable() {
            @Override
            public void run() {
                AutoMessageBossbar.AutoMessagebossbar();
            }
        }.runTaskTimerAsynchronously(this, 0, 20 * getConfig().getInt("Bossbar-Time"));






    }








        // Plugin startup logic



    @Override
    public void onDisable() {
        getLogger().info("SimpleAutoMessage disabled");
        // Plugin shutdown logic
    }
}
