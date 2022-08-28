package melodyayane.Command;

import melodyayane.simpleautomessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Reload implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
          if (command.getName().equalsIgnoreCase("reload")) {
                if (sender.hasPermission("simpleautomessage.reload")) {
                    sender.sendMessage("Reloading config.yml");
                    simpleautomessage config = simpleautomessage.getPlugin(simpleautomessage.class);
                    config.reloadConfig();
                    config.saveConfig();
                    simpleautomessage.getPlugin(simpleautomessage.class).getServer().getPluginManager().disablePlugin(config);
                    simpleautomessage.getPlugin(simpleautomessage.class).getServer().getPluginManager().enablePlugin(config);
                    sender.sendMessage("Config.yml reloaded");
                } else {
                    sender.sendMessage("You do not have permission to use this command");
                }
              return true;
            }



        return false;
    }
}
