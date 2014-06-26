package org.rts;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author rdriskill
 */
public class KraftyEventListener implements Listener
{
   private final JavaPlugin plugin;
   
   public KraftyEventListener(JavaPlugin plugin)
   {
      this.plugin = plugin;
   }
   
   public void register()
   {
      plugin.getServer().getPluginManager().registerEvents(this, plugin);
   }
   
   @EventHandler
   public void onPlayerJoin(PlayerJoinEvent event) 
   {
      Player player = event.getPlayer();
      
      PlayerActions.setInitialInventory(player);
      player.sendMessage("Welcome! Some items not owned have been added to your inventory to get you started!");
   }
}