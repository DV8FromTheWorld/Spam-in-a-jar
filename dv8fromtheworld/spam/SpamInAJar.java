package dv8fromtheworld.spam;


import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class SpamInAJar extends JavaPlugin {
    
    private PluginDescriptionFile info;
    private final Logger myLogger = Logger.getLogger("Minecraft");
    private FileConfiguration Config;
    public String motd;
    private File pluginPath = new File("plugins" + File.pathSeparator + "SpamInAjar");
    
    @Override
    public void onDisable() {
        logMessage("has been disabled");
    }
    
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new PlayerLoginListener(this), this);
        logMessage("version" + info.getVersion() + "has been successfully enabled.");
        if (!new File(pluginPath, "config.yml").isFile()) {
            this.saveDefaultConfig();
        }
        loadConfiguration();
    }

    private void loadConfiguration() {
        Config = this.getConfig();
        motd = Config.getString("MOTD", "This is the Default config");
    }
    
    private void logMessage(Level logLevel, String message) {
		myLogger.log(logLevel, "[" + info.getName() + "]: " + message);
	}
    public void logMessage(String message){
            logMessage(Level.INFO, message);
    }
    
}

