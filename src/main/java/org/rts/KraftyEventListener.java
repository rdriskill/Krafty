package org.rts;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * @author rdriskill
 */
public class KraftyEventListener implements Listener
{   
   @EventHandler
   public void onPlayerJoin(PlayerJoinEvent event) 
   {
      Player player = event.getPlayer();
      
      PlayerActions.setInitialInventory(player);
      player.sendMessage("Welcome! Some items not owned have been added to your inventory to get you started!");
      
      // X = Left or Right, Y = Height, Z = Forward or Backward      
      Location fireworksLocation = player.getLocation();
      fireworksLocation.setZ(fireworksLocation.getZ() + 10);
      WorldActions.createFireworks(player.getWorld(), fireworksLocation);
      WorldActions.createFireworks(player.getWorld(), fireworksLocation);
      WorldActions.createFireworks(player.getWorld(), fireworksLocation);
      
      Location lightningLocation = player.getLocation();
      lightningLocation.setZ(lightningLocation.getZ() + 10);
      WorldActions.createLightning(player.getWorld(), lightningLocation);
  }
}