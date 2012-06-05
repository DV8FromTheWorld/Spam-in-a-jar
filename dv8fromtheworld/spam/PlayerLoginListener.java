
package dv8fromtheworld.spam;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;


public class PlayerLoginListener implements Listener{

    private SpamInAJar plugin;
    
        PlayerLoginListener(SpamInAJar instance){
            this.plugin = instance;
        }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(plugin.motd);
    }
    
    
}
