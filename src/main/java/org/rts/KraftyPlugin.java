package org.rts;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author rdriskill
 */
public final class KraftyPlugin extends JavaPlugin
{
   private KraftyCommandExecutor kraftyCommandExecutor;
   private KraftyEventListener kraftyEventListener;
   
   public KraftyPlugin()
   {
      this.kraftyCommandExecutor = new KraftyCommandExecutor(this);
      this.kraftyEventListener = new KraftyEventListener(this);
   }
   
   @Override
   public void onEnable()
   {
      getLogger().info("onEnable has been invoked!");
      kraftyEventListener.register();
      kraftyCommandExecutor.register();
   }
   
   @Override
   public void onDisable()
   {
      getLogger().info("onDisable has been invoked!");
   }
}
