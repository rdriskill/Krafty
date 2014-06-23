package org.rts;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author rdriskill
 */

public final class KraftyPlugin extends JavaPlugin
{
   @Override
   public void onDisable()
   {
      getLogger().info("onDisable has been invoked!");
   }

   @Override
   public void onEnable()
   {
      getLogger().info("onEnable has been invoked!");
   }
}
