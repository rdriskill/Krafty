package org.rts;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author rdriskill
 */
public final class KraftyPlugin extends JavaPlugin
{
   @Override
   public void onEnable()
   {
      getLogger().info("onEnable has been invoked!");
      getServer().getPluginManager().registerEvents(new KraftyEventListener(), this);
   }
   
   @Override
   public void onDisable()
   {
      getLogger().info("onDisable has been invoked!");
      
   }
}
