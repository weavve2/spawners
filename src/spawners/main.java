package spawners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {
	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		Listener listener = new spawners(this);
		pm.registerEvents(listener, this);
		Bukkit.getLogger().info("[Spawner Silk has been Enabled]");
	}
}